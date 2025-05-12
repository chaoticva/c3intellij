package org.c3lang.intellij.rewrite.fix

import com.intellij.codeInspection.IntentionAndQuickFixAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import org.c3lang.intellij.rewrite.psi.C3Parameter
import org.c3lang.intellij.rewrite.psi.C3Types

class RemoveUnusedParameterFix(private val parameter: C3Parameter) : IntentionAndQuickFixAction()
{
    override fun getName() = "Remove unused parameter `${parameter.name}`."

    override fun getFamilyName() = "Unused"

    override fun applyFix(project: Project, file: PsiFile, editor: Editor?)
    {
        val next = PsiTreeUtil.nextVisibleLeaf(parameter)

        if (next != null && next.elementType == C3Types.COMMA)
        {
            next.delete()
        }

        parameter.delete()
    }
}