package org.c3lang.intellij.settings

import com.intellij.lang.Language
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider
import org.c3lang.intellij.C3Language

class C3LanguageCodeStyleSettingsProvider : LanguageCodeStyleSettingsProvider()
{
    override fun getLanguage(): Language
    {
        return C3Language.INSTANCE
    }

    override fun customizeSettings(consumer: CodeStyleSettingsCustomizable, settingsType: SettingsType)
    {
        if (settingsType == SettingsType.SPACING_SETTINGS)
        {
            consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS")
            consumer.renameStandardOption("SPACE_AROUND_ASSIGNMENT_OPERATORS", "Operator")
        } else if (settingsType == SettingsType.BLANK_LINES_SETTINGS)
        {
            consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE")
        }
    }

    override fun getCodeSample(settingsType: SettingsType): String
    {
        return """
module example;

import std::io;

enum TokenType
{
    IDENTIFIER,
    NUMBER
}

struct Token
{
    TokenType type;
    String    value;
}

fn int main(String[] args)
{
    String name = "World";
    
    io::printfn("Hello, %s!", name);
    return 0;
}
"""
    }
}