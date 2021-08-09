package me.desgroup.kara

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

val descriptors = arrayOf(
    AttributesDescriptor("Keyword", KaraHighlighterKeys.keyword),
    AttributesDescriptor("Operator", KaraHighlighterKeys.operator),
    AttributesDescriptor("Brackets", KaraHighlighterKeys.brackets),
    AttributesDescriptor("Names", KaraHighlighterKeys.name),
    AttributesDescriptor("Bad characters", KaraHighlighterKeys.badCharacter)
)

class KaraColorSettingsPage : ColorSettingsPage {
    override fun getAttributeDescriptors() = descriptors

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = "Kara"
    override fun getIcon() = KaraIcons.icon
    override fun getHighlighter() = KaraSyntaxHighlighter()

    override fun getDemoText() = "# You are reading the \".properties\" entry.\n" +
            "! The exclamation mark can also mark text as comments.\n" +
            "website = https://en.wikipedia.org/\n" +
            "language = English\n" +
            "# The backslash below tells the application to continue reading\n" +
            "# the value onto the next line.\n" +
            "message = Welcome to \\\n" +
            "          Wikipedia!\n" +
            "# Add spaces to the key\n" +
            "key\\ with\\ spaces = This is the value that could be looked up with the key \"key with spaces\".\n" +
            "# Unicode\n" +
            "tab : \\u0009"

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? = null
}