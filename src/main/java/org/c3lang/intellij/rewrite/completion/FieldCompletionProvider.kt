package org.c3lang.intellij.rewrite.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.patterns.PlatformPatterns.and
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.util.ProcessingContext
import org.apache.commons.lang3.Validate
import org.c3lang.intellij.rewrite.psi.C3Field
import org.c3lang.intellij.rewrite.psi.C3Statement
import org.c3lang.intellij.rewrite.psi.C3Types

class FieldCompletionProvider : CompletionProvider<CompletionParameters>()
{
    private val pattern = and(
        psiElement().inside(psiElement().withElementType(C3Types.FIELD)),
        psiElement().afterLeaf(psiElement().withElementType(C3Types.PERIOD))
    )

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet)
    {
        if (!pattern.accepts(parameters.position) && !pattern.accepts(parameters.originalPosition))
        {
            return
        }

        addEnumEntries(parameters, result)
    }

    private fun addEnumEntries(parameters: CompletionParameters, result: CompletionResultSet)
    {
        val identifier = getPrevIdentifier(parameters.position) ?: return

        val field = PsiTreeUtil.getParentOfType(parameters.position, C3Field::class.java)
        Validate.notNull(field, "Containing field may not be null")

        if (!field!!.text.startsWith(identifier.text)) return

        val file = parameters.position.containingFile

        file.children.filterIsInstance<C3Statement>().forEach { statement ->
            statement.enum?.let { enum ->
                if (enum.name != identifier.text) return@let

                enum.enumBody.enumValueList.forEach { enumValue ->

                    val lookupElement = LookupElementBuilder
                        .create(enumValue.name)
                        .withIcon(AllIcons.Nodes.Field)

                    result.addElement(lookupElement)
                }
            }
        }
    }

    private fun getPrevIdentifier(element: PsiElement): PsiElement?
    {
        var prev = element.prevSibling

        while (prev is PsiWhiteSpace) prev = prev.prevSibling

        if (prev.elementType != C3Types.PERIOD) return null

        prev = prev.prevSibling

        while (prev is PsiWhiteSpace) prev = prev.prevSibling

        return prev
    }
}