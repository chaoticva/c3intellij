package org.c3lang.intellij.rewrite.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import org.c3lang.intellij.rewrite.psi.C3Attribute

object AttributeAnnotator
{
    fun annotateC3Attribute(attribute: C3Attribute, holder: AnnotationHolder)
    {
        holder
            .newSilentAnnotation(HighlightSeverity.INFORMATION)
            .textAttributes(DefaultLanguageHighlighterColors.CLASS_REFERENCE)
            .create()
    }
}