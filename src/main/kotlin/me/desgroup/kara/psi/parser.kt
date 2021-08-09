package me.desgroup.kara.psi

import me.desgroup.kara.KaraLanguage
import com.intellij.psi.tree.IElementType

class KaraToken(name: String) : IElementType(name, KaraLanguage) {
    override fun toString() = "KaraToken." + super.toString()
}

class KaraElement(name: String) : IElementType(name, KaraLanguage)