package org.c3lang.intellij.rewrite.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import org.c3lang.intellij.rewrite.psi.C3Struct
import org.c3lang.intellij.rewrite.psi.C3Types
import org.c3lang.intellij.rewrite.util.C3ErrorMessages
import org.c3lang.intellij.rewrite.util.C3RegexUtil

object StructAnnotator
{
    fun annotateC3Struct(struct: C3Struct, holder: AnnotationHolder)
    {
        annotateName(struct, holder)
        annotateEmptyBody(struct, holder)
    }

    private fun annotateEmptyBody(struct: C3Struct, holder: AnnotationHolder)
    {
        if (struct.structBody.unionList.isEmpty() && struct.structBody.parameterList.isEmpty())
        {
            holder
                .newAnnotation(HighlightSeverity.ERROR, C3ErrorMessages.STRUCT_3)
                .range(struct.structBody.firstChild)
                .create()
        }
    }

    private fun annotateName(struct: C3Struct, holder: AnnotationHolder)
    {
        val nameEl = struct.node.findChildByType(C3Types.IDENTIFIER)!!

        if (struct.name.first().isLowerCase())
        {
            holder
                .newAnnotation(HighlightSeverity.ERROR, C3ErrorMessages.STRUCT_1)
                .range(nameEl)
                .create()
        }

        if (struct.name.matches(C3RegexUtil.structName))
        {
            holder
                .newAnnotation(HighlightSeverity.ERROR, C3ErrorMessages.STRUCT_2)
                .range(nameEl)
                .create()
        }
    }
}