package org.c3lang.intellij.rewrite

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.c3lang.intellij.rewrite.lexer.C3LexerAdapter
import org.c3lang.intellij.rewrite.psi.C3Types.CHAR
import org.c3lang.intellij.rewrite.psi.C3Types.IDENTIFIER
import org.c3lang.intellij.rewrite.psi.C3Types.INTEGER
import org.c3lang.intellij.rewrite.psi.C3Types.KW_CONST
import org.c3lang.intellij.rewrite.psi.C3Types.KW_ENUM
import org.c3lang.intellij.rewrite.psi.C3Types.KW_EXTERN
import org.c3lang.intellij.rewrite.psi.C3Types.KW_FN
import org.c3lang.intellij.rewrite.psi.C3Types.KW_IMPORT
import org.c3lang.intellij.rewrite.psi.C3Types.KW_INLINE
import org.c3lang.intellij.rewrite.psi.C3Types.KW_MACRO
import org.c3lang.intellij.rewrite.psi.C3Types.KW_MODULE
import org.c3lang.intellij.rewrite.psi.C3Types.KW_RETURN
import org.c3lang.intellij.rewrite.psi.C3Types.KW_STRUCT
import org.c3lang.intellij.rewrite.psi.C3Types.KW_UNION
import org.c3lang.intellij.rewrite.psi.C3Types.LINE_COMMENT
import org.c3lang.intellij.rewrite.psi.C3Types.STRING

class C3SyntaxHighlighter : SyntaxHighlighterBase()
{
    private val identifier = TextAttributesKey.createTextAttributesKey("C3_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
    private val keyword = TextAttributesKey.createTextAttributesKey("C3_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    private val string = TextAttributesKey.createTextAttributesKey("C3_STRING", DefaultLanguageHighlighterColors.STRING)
    private val number = TextAttributesKey.createTextAttributesKey("C3_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
    private val lineComment = TextAttributesKey.createTextAttributesKey("C3_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    private val blockComment = TextAttributesKey.createTextAttributesKey("C3_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
    private val badCharacter = TextAttributesKey.createTextAttributesKey("C3_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

    override fun getHighlightingLexer(): Lexer
    {
        return C3LexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey>
    {
        when (tokenType)
        {
            IDENTIFIER              -> return arrayOf(identifier)
            KW_MODULE,
            KW_IMPORT,
            KW_EXTERN,
            KW_FN,
            KW_RETURN,
            KW_MACRO,
            KW_ENUM,
            KW_INLINE,
            KW_STRUCT,
            KW_UNION,
            KW_CONST                -> return arrayOf(keyword)

            STRING,
            CHAR                    -> return arrayOf(string)

            INTEGER                 -> return arrayOf(number)
            LINE_COMMENT            -> return arrayOf(lineComment)
//            BLOCK_COMMENT                 -> return arrayOf(blockComment)

            TokenType.BAD_CHARACTER -> return arrayOf(badCharacter)
        }

        return arrayOf()
    }
}