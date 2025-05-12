package org.c3lang.intellij.rewrite.parameterHints

import com.intellij.codeInsight.hints.InlayInfo
import com.intellij.psi.util.startOffset
import org.c3lang.intellij.rewrite.psi.C3Call

object CallHints
{
    fun callHints(call: C3Call): ArrayList<InlayInfo>
    {
        val hints = arrayListOf<InlayInfo>()

        if (call.fnDefinition != null)
        {
            call.fnDefinition.parameters.parameterList.forEachIndexed { idx, parameter ->
                if (call.arguments.exprList.size <= idx) return@forEachIndexed

                hints.add(
                    InlayInfo(
                        parameter.name,
                        call.arguments.exprList[idx].startOffset
                    )
                )
            }
        }

        return hints
    }
}