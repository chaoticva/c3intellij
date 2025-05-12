package org.c3lang.intellij.rewrite.formatting

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
import org.c3lang.intellij.rewrite.psi.C3TokenSets
import org.c3lang.intellij.rewrite.psi.C3Types
import org.c3lang.intellij.rewrite.util.C3Util

class C3FormattingModelBuilder : FormattingModelBuilder
{
    private fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder
    {
        return SpacingBuilder(settings, C3Language.INSTANCE)
            .after(C3Types.TYPE)
            .spaces(1)
            .afterInside(C3Types.IDENTIFIER, C3Types.TYPE)
            .spaces(0)
            .afterInside(C3Types.LBRACKET, C3Types.TYPE)
            .spaces(0)
            .beforeInside(C3Types.RBRACKET, C3Types.TYPE)
            .spaces(0)
            .afterInside(C3Types.AMPERSAND, C3Types.PARAMETER)
            .spaces(0)
            .after(C3Types.PATH_SEPARATOR)
            .spaces(0)
            .before(C3Types.PATH_SEPARATOR)
            .spaces(0)
            .after(C3TokenSets.keywords)
            .spaces(1)
            .afterInside(C3Types.TYPE, C3Types.FN)
            .spaces(0)
            .after(C3Types.CALL_NAME)
            .spaces(0)
            .afterInside(C3Types.LPAREN, C3Types.ARGUMENTS)
            .spaces(0)
            .beforeInside(C3Types.RPAREN, C3Types.ARGUMENTS)
            .spaces(0)
            .after(C3Types.ARGUMENTS)
            .spaces(0)
            .afterInside(C3Types.BANG, C3Types.CALL)
            .spaces(0)
            .afterInside(C3Types.PANIC, C3Types.CALL)
            .spaces(0)
            .before(C3Types.SEMICOLON)
            .spaces(0)
            .afterInside(C3Types.LPAREN, C3Types.PARAMETERS)
            .spaces(0)
            .beforeInside(C3Types.RPAREN, C3Types.PARAMETERS)
            .spaces(0)
            .before(C3Types.PARAMETERS)
            .spaces(0)
            .before(C3Types.ATTRIBUTE)
            .spaces(1)
            .before(C3Types.LPAREN)
            .spaces(0)
            .betweenInside(C3Types.COMMA, C3Types.EXPR, C3Types.ARGUMENTS)
            .spaces(1)
            .betweenInside(C3Types.EXPR, C3Types.COMMA, C3Types.ARGUMENTS)
            .spaces(0)
            .betweenInside(C3Types.ENUM_VALUE, C3Types.COMMA, C3Types.ENUM_BODY)
            .spaces(0)
            .betweenInside(C3Types.IDENTIFIER, C3Types.EQUALS, C3Types.ENUM_VALUE)
            .spaces(1)
            .betweenInside(C3Types.EQUALS, C3Types.EXPR, C3Types.ENUM_VALUE)
            .spaces(1)
            .betweenInside(C3Types.EXPR, C3Types.COMMA, C3Types.ENUM_VALUE)
            .spaces(0)
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