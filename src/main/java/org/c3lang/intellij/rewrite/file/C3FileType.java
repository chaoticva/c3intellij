package org.c3lang.intellij.rewrite.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.c3lang.intellij.C3Icons;
import org.c3lang.intellij.C3Language;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class C3FileType extends LanguageFileType
{
    public static final C3FileType INSTANCE = new C3FileType();

    public C3FileType()
    {
        super(C3Language.INSTANCE);
    }

    @Override
    public @NotNull String getName()
    {
        return "C3 File";
    }

    @Override
    public @NotNull String getDescription()
    {
        return "C3 file";
    }

    @Override
    public @NotNull String getDefaultExtension()
    {
        return "c3";
    }

    @Override
    public Icon getIcon()
    {
        return C3Icons.FILE;
    }
}
