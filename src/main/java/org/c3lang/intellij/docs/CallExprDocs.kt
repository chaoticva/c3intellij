package org.c3lang.intellij.docs

import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.openapi.project.Project
import com.intellij.psi.presentation.java.SymbolPresentationUtil
import org.c3lang.intellij.C3Util.findC3ModulesStartingWith
import org.c3lang.intellij.C3Util.findDeclarationInModule
import org.c3lang.intellij.psi.C3CallExpr
import org.c3lang.intellij.psi.C3FuncDefinition
import org.c3lang.intellij.psi.C3MacroDefinition
import org.eclipse.lsp4j.jsonrpc.messages.Either

internal fun generateCallExprDoc(element: C3CallExpr): String?
{
    val callName = if (element.expr.text.contains("::"))
    {
        element.expr.text.split("::").last()
    } else
    {
        element.expr.text
    }
    val callModule = if (element.expr.text.contains("::"))
    {
        element.expr.text.split("::").first()
    } else
    {
        element.moduleDefinition.moduleName?.value ?: ""
    }

    // grab all imports
    val imports = arrayListOf<String>()
    element.moduleDefinition.importDeclarations.forEach { it.importPaths.importPathList.map { list -> imports.add(list.moduleName?.value!!) } }

    val result = mutableSetOf<String>()

    imports.forEach { import ->
        result.addAll(findC3ModulesStartingWith(element.project, import))
    }

    // loop over to find by name
    var declaration: Either<C3MacroDefinition, C3FuncDefinition>? = null

    if (callModule == element.moduleDefinition.moduleName?.value)
    {
        declaration = findDeclarationInModule(element.project, callModule, callName)
    } else
    {
        result.forEach {
            if (it.endsWith(callModule))
            {
                declaration = findDeclarationInModule(element.project, it, callName)

                println(declaration)

                if (declaration != null) return@forEach
            }
        }
    }

    if (declaration == null)
    {
        return null
    }

    return renderFullDoc(declaration!!, element.project)
}

private fun renderFullDoc(declaration: Either<C3MacroDefinition, C3FuncDefinition>, project: Project): String
{
    val docs = if (declaration.isLeft)
    {
        findDocumentationCommentByDeclaration(declaration.left)
    } else
    {
        findDocumentationCommentByDeclaration(declaration.right)
    }

    val builder = StringBuilder()
    if (declaration.isLeft)
    {
        val macro = declaration.left
        val type = macro.returnType?.value?.let { "$it " }
        val name = macro.fqName.name
        val argsString = macro.macroParams.parameterList?.text?.replace(Regex("\\s+"), " ") ?: ""
        appendDefinition("macro $type$name($argsString)", project, builder)
    } else
    {
        val function = declaration.right
        val type = function.funcDef.returnType?.value!!
        val name = function.funcDef.fqName.name
        val argsString = function.funcDef.fnParameterList.parameterList?.text?.replace(Regex("\\s+"), " ") ?: ""
        appendDefinition("fn $type $name($argsString)", project, builder)
    }
    val args = if (declaration.isLeft)
    {
        declaration.left.macroParams.parameterList?.paramDeclList?.map { it.parameter.name!! } ?: listOf()
    } else
    {
        declaration.right.funcDef.fnParameterList.parameterList?.paramDeclList?.map { it.parameter.name!! } ?: listOf()
    }

    builder.append(DocumentationMarkup.SECTIONS_START)
    builder.appendLine(extractDescriptionTextFromDoc(docs))
    appendParamsSection(docs, builder, args)
    appendReturnSection(docs, builder)
    if (declaration.isLeft)
    {
        val file = SymbolPresentationUtil.getFilePathPresentation(declaration.left.containingFile)
        appendFileSection(file, builder)
    } else
    {
        val file = SymbolPresentationUtil.getFilePathPresentation(declaration.right.containingFile)
        appendFileSection(file, builder)
    }
    builder.append(DocumentationMarkup.SECTIONS_END)

    return builder.toString()
}