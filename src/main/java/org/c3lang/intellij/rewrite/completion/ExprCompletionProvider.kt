package org.c3lang.intellij.rewrite.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import org.c3lang.intellij.rewrite.psi.C3Fn
import org.c3lang.intellij.rewrite.psi.C3Statement
import org.c3lang.intellij.rewrite.psi.C3Types

class ExprCompletionProvider : CompletionProvider<CompletionParameters>()
{
    private val pattern = psiElement().inside(psiElement().withElementType(C3Types.EXPR))

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet)
    {
        if (!pattern.accepts(parameters.position) && !pattern.accepts(parameters.originalPosition))
        {
            return
        }

        addFnParameters(parameters, result)
        addFns(parameters, result)
        addConsts(parameters, result)
        addEnums(parameters, result)
    }

    private fun addEnums(parameters: CompletionParameters, result: CompletionResultSet)
    {
        val file = parameters.position.containingFile

        file.children.filterIsInstance<C3Statement>().forEach { statement ->
            statement.enum?.let { enum ->
                result.addElement(PrioritizedLookupElement.withPriority(enum.lookupElement, 9.7))
            }
        }
    }

    private fun addConsts(parameters: CompletionParameters, result: CompletionResultSet)
    {
        val file = parameters.position.containingFile

        file.children.filterIsInstance<C3Statement>().forEach { statement ->
            statement.const?.let { const ->
                result.addElement(PrioritizedLookupElement.withPriority(const.lookupElement, 9.9))
            }
        }
    }

    private fun addFns(parameters: CompletionParameters, result: CompletionResultSet)
    {
        val file = parameters.position.containingFile

        file.children.filterIsInstance<C3Statement>().forEach { statement ->
            statement.fn?.let { fn ->
                result.addElement(PrioritizedLookupElement.withPriority(fn.lookupElement, 9.8))
            }
        }
    }

    private fun addFnParameters(parameters: CompletionParameters, result: CompletionResultSet)
    {
        val fn = PsiTreeUtil.getParentOfType(parameters.position, C3Fn::class.java) ?: return

        fn.parameters.parameterList.forEach { parameter ->
            result.addElement(PrioritizedLookupElement.withPriority(parameter.lookupElement, 10.0))
        }
    }
}