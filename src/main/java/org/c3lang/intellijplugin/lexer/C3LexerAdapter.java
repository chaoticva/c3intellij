package org.c3lang.intellijplugin.lexer;

import com.intellij.lexer.FlexAdapter;

public class C3LexerAdapter extends FlexAdapter
{
    public C3LexerAdapter()
    {
        super(new C3Lexer(null));
    }
}
