package org.c3lang.intellij.rewrite.lexer

import com.intellij.lexer.FlexAdapter

class C3LexerAdapter : FlexAdapter(C3Lexer(null))
{
}