package me.desgroup.kara

import com.intellij.lang.Language
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.fileTypes.LanguageFileType

// https://plugins.jetbrains.com/docs/intellij/custom-language-support-tutorial.html

object KaraLanguage : Language("Kara")

object KaraIcons {
    val icon = IconLoader.getIcon("/kara.png", KaraLanguage.javaClass)
}

object KaraFileType : LanguageFileType(KaraLanguage) {
    override fun getName() = "Kara File"
    override fun getDescription() = "Kara language file."
    override fun getDefaultExtension() = "kara"
    override fun getIcon() = KaraIcons.icon
}