package org.c3lang.intellij.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.patterns.PlatformPatterns.not
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.StandardPatterns.and
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext
import org.c3lang.intellij.C3ParserDefinition

object FieldCompletionContributor : CompletionProvider<CompletionParameters>()
{
    val pattern = and(
        psiElement().afterLeaf("."),
        not(psiElement().inside(psiElement().withElementType(C3ParserDefinition.DOC_COMMENT)))
    )

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet)
    {
        if (!(pattern.accepts(parameters.position) || pattern.accepts(parameters.originalPosition)))
        {
            return
        }

        val prev = parameters.position.text

        println(prev)
    }
}