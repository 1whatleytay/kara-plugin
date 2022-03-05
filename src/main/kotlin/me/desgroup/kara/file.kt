package me.desgroup.kara

import com.intellij.lexer.FlexAdapter
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class KaraLexerAdapter : FlexAdapter(KaraLexer(null))

class KaraFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, KaraLanguage) {
    override fun getFileType() = KaraFileType
    override fun toString() = "Kara File"
}

