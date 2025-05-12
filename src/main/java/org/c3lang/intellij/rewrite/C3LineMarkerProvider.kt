package org.c3lang.intellij.rewrite

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import org.c3lang.intellij.rewrite.psi.C3Fn

class C3LineMarkerProvider : LineMarkerProvider
{
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>?
    {
        if (element is C3Fn)
        {
            if (element.fqName.text == "main") return mainFn(element)
            if (element.attributeList.find { it.name == "@test" } != null) return testFn(element)
            return null
        }

        return null
    }

    private fun testFn(element: C3Fn): LineMarkerInfo<*>
    {
        return LineMarkerInfo(
            element,
            element.textRange,
            AllIcons.Actions.Execute,
            { "Run test" },
            { _, _ -> TODO("elt.project") },
            GutterIconRenderer.Alignment.RIGHT,
            { "Click to open context menu" }
        )
    }

    private fun mainFn(element: C3Fn): LineMarkerInfo<*>?
    {
        val type = element.type.text
        val name = element.fqName.text

        if (name != "main") return null
        if (type !in listOf("int", "void")) return null

        return LineMarkerInfo(
            element,
            element.textRange,
            AllIcons.Actions.Execute,
            { "Run main" },
            { _, _ -> TODO("elt.project") },
            GutterIconRenderer.Alignment.RIGHT,
            { "Click to open context menu" }
        )
    }

//    private fun createAndRunCustomConfig(project: Project)
//    {
//        val runManager = RunManager.getInstance(project)
//        val configType = ConfigurationTypeUtil.findConfigurationType(C3BuildRunConfigurationType::class.java)
//        val factory = configType.configurationFactories.first()
//        val uniqueName = "main"
//        val settings = runManager.createConfiguration(uniqueName, factory)
//        val config = settings.configuration as C3BuildRunConfiguration
//
//        config.workingDirectory = project.basePath
//        config.args = ""
//
//        runManager.addConfiguration(settings)
//        runManager.selectedConfiguration = settings
//
//        val executor = DefaultRunExecutor.getRunExecutorInstance()
//        val environment = ExecutionEnvironmentBuilder.create(executor, settings).build()
//
//        environment.runner.execute(environment)
//    }
}