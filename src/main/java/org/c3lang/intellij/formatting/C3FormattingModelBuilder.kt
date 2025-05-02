package org.c3lang.intellij.formatting

import com.intellij.formatting.Alignment
import com.intellij.formatting.FormattingContext
import com.intellij.formatting.FormattingModel
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.formatting.FormattingModelProvider
import com.intellij.formatting.Indent
import com.intellij.formatting.SpacingBuilder
import com.intellij.formatting.Wrap
import com.intellij.formatting.WrapType
import com.intellij.psi.codeStyle.CodeStyleSettings
import org.c3lang.intellij.C3Language
import org.c3lang.intellij.C3TokenSets
import org.c3lang.intellij.psi.C3Types

class C3FormattingModelBuilder : FormattingModelBuilder
{
    private fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder
    {
        return SpacingBuilder(settings, C3Language.INSTANCE)
            .before(C3Types.LB).spacing(0, 0, 1, true, 0)

            .after(C3Types.KW_MODULE).spaces(1)
            .after(C3Types.KW_IMPORT).spaces(1)
            .after(C3Types.KW_ENUM).spaces(1)
            .after(C3Types.KW_STRUCT).spaces(1)
            .after(C3Types.KW_FN).spaces(1)

            .between(C3Types.IDENT, C3Types.IDENT).spaces(1)

            .around(C3TokenSets.OPERATORS).spaces(1)

            .after(C3Types.COMMA).spaces(1)
            .before(C3Types.COMMA).spaces(0)

            .beforeInside(C3Types.STRUCT_BODY, C3Types.STRUCT_MEMBER_DECLARATION).spaces(4)

            .between(C3Types.IDENT, C3Types.LBT).spaces(0)
            .between(C3Types.LBT, C3Types.RBT).spaces(0)
            .between(C3Types.RBT, C3Types.IDENT).spaces(1)
    }

    override fun createModel(formattingContext: FormattingContext): FormattingModel
    {
        val codeStyleSettings = formattingContext.codeStyleSettings
        val spacingBuilder = createSpaceBuilder(codeStyleSettings)

        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            C3Block(
                formattingContext.node,
                Wrap.createWrap(WrapType.NONE, false),
                Alignment.createAlignment(),
                spacingBuilder,
                Indent.getNoneIndent(),
                codeStyleSettings
            ),
            codeStyleSettings
        )
    }
}