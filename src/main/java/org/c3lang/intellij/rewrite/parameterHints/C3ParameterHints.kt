package org.c3lang.intellij.rewrite.parameterHints

import com.intellij.codeInsight.hints.InlayInfo
import com.intellij.codeInsight.hints.InlayParameterHintsProvider
import com.intellij.psi.PsiElement
import org.c3lang.intellij.rewrite.parameterHints.CallHints.callHints
import org.c3lang.intellij.rewrite.psi.C3Call

class C3ParameterHints : InlayParameterHintsProvider
{
    override fun getParameterHints(element: PsiElement): MutableList<InlayInfo>
    {
        if (element is C3Call) return callHints(element)

        return mutableListOf()
    }

    override fun getDefaultBlackList() = emptySet<String>()
}