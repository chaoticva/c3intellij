package org.c3lang.intellij.rewrite.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns.psiElement

class C3CompletionContributor : CompletionContributor()
{
    init
    {
        extend(CompletionType.BASIC, psiElement(), ExprCompletionProvider())
        extend(CompletionType.BASIC, psiElement(), FieldCompletionProvider())
    }
}