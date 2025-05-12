package org.c3lang.intellij.rewrite

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import org.c3lang.intellij.rewrite.psi.C3Call
import org.c3lang.intellij.rewrite.psi.C3CallName

// TODO: if file is outside of project get as VirtualFile
// TODO: FileEditorManager.getInstance(element.containingFile.project).openFile(<file>, true);
class C3GotoDeclarationHandler : GotoDeclarationHandler
{
    override fun getGotoDeclarationTargets(element: PsiElement?, p1: Int, editor: Editor): Array<PsiElement>?
    {
        if (element == null) return null

        if (element.parent != null && element.parent is C3CallName)
        {
            val fn = element.parent.parent as C3Call

            if (fn.fnDefinition != null) return arrayOf(fn.fnDefinition.fqName)
            if (fn.macroDefinition != null) return arrayOf(fn.macroDefinition.fqName)
        }

        return null
    }
}