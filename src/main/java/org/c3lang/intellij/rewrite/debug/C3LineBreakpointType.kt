package org.c3lang.intellij.rewrite.debug

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.xdebugger.breakpoints.XLineBreakpointType
import org.c3lang.intellij.rewrite.file.C3FileType
import org.c3lang.intellij.rewrite.psi.C3Types


class C3LineBreakpointType : XLineBreakpointType<C3BreakpointProperties>("c3", "C3 Breakpoint")
{
    override fun createBreakpointProperties(file: VirtualFile, line: Int) = C3BreakpointProperties()

    override fun createProperties() = C3BreakpointProperties()

    // TODO; figure out all breakable elements
    override fun canPutAt(file: VirtualFile, line: Int, project: Project): Boolean
    {
        if (file.fileType !is C3FileType) return false

        val psiFile = PsiManager.getInstance(project).findFile(file) ?: return false
        val document = PsiDocumentManager.getInstance(project).getDocument(psiFile) ?: return false

        if (line < 0 || line >= document.lineCount) return false

        val startOffset = document.getLineStartOffset(line)

        var element = psiFile.findElementAt(startOffset)
        if (element is PsiWhiteSpace)
        {
            val next = PsiTreeUtil.nextVisibleLeaf(element)

            if (next != null && document.getLineNumber(element.textRange.startOffset) == document.getLineNumber(next.textRange.startOffset))
            {
                element = next
            }
        }

        if (element.elementType in listOf(
                C3Types.KW_FN,
                C3Types.KW_MACRO,
                C3Types.IDENTIFIER
            )
        ) return true

        return false
    }
}