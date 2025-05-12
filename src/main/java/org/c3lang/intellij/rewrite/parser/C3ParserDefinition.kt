package org.c3lang.intellij.rewrite.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.c3lang.intellij.C3Language
import org.c3lang.intellij.C3TokenSets
import org.c3lang.intellij.psi.C3File
import org.c3lang.intellij.rewrite.lexer.C3LexerAdapter
import org.c3lang.intellij.rewrite.psi.C3Types

class C3ParserDefinition : ParserDefinition
{
    val file = IFileElementType(C3Language.INSTANCE)

    override fun createLexer(project: Project) = C3LexerAdapter()

    override fun createParser(project: Project) = C3Parser()

    override fun getFileNodeType(): IFileElementType = file

    override fun getCommentTokens(): TokenSet = C3TokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = C3TokenSets.STRINGS

    override fun createElement(node: ASTNode): PsiElement = C3Types.Factory.createElement(node)

    override fun createFile(fileViewProvider: FileViewProvider) = C3File(fileViewProvider)
}