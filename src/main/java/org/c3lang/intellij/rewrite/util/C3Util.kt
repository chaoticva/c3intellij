package org.c3lang.intellij.rewrite.util

import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.codeStyle.CodeStyleSettings
import org.c3lang.intellij.rewrite.psi.C3Expr

object C3Util
{
    fun getExprChildren(el: PsiElement, list: ArrayList<C3Expr>)
    {
        el.children.forEach {
            if (it is C3Expr)
            {
                list.add(it)
            } else
            {
                getExprChildren(it, list)
            }
        }
    }

    fun fnSpacing(builder: SpacingBuilder, settings: CodeStyleSettings)
    {

    }
}