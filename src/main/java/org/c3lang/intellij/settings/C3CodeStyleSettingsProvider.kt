package org.c3lang.intellij.settings

import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleConfigurable
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider
import org.c3lang.intellij.C3Language

class C3CodeStyleSettingsProvider : CodeStyleSettingsProvider()
{
    override fun createCustomSettings(settings: CodeStyleSettings) = C3CodeStyleSettings(settings)

    override fun getConfigurableDisplayName() = "C3"

    override fun createConfigurable(settings: CodeStyleSettings, modelSettings: CodeStyleSettings): CodeStyleConfigurable
    {
        return object : CodeStyleAbstractConfigurable(settings, modelSettings, configurableDisplayName)
        {
            override fun createPanel(p0: CodeStyleSettings): CodeStyleAbstractPanel
            {
                return C3CodeStyleMainPanel(currentSettings, settings)
            }
        }
    }

    private class C3CodeStyleMainPanel(currentSettings: CodeStyleSettings, settings: CodeStyleSettings) : TabbedLanguageCodeStylePanel(C3Language.INSTANCE, currentSettings, settings)
}