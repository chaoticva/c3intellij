package org.c3lang.intellij.rewrite.psi

import com.intellij.psi.tree.TokenSet

object C3TokenSets
{
    val literals = TokenSet.create(
            C3Types.STRING,
            C3Types.CHAR,
            C3Types.INTEGER,
            C3Types.FLOAT,
            C3Types.DOUBLE,
        )

    val comments = TokenSet.create(
            C3Types.LINE_COMMENT
        )

    val keywords = TokenSet.create(
            C3Types.KW_ENUM,
            C3Types.KW_FN,
            C3Types.KW_IMPORT,
            C3Types.KW_MODULE,
            C3Types.KW_STRUCT,
            C3Types.KW_EXTERN,
            C3Types.KW_CONST,
            C3Types.KW_INLINE,
            C3Types.KW_MACRO,
            C3Types.KW_RETURN,
            C3Types.KW_UNION
        )
}