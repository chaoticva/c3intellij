package org.c3lang.intellij.rewrite

import com.intellij.lang.Commenter

class C3Commenter : Commenter
{
    override fun getLineCommentPrefix() = "// "

    override fun getBlockCommentPrefix() = null

    override fun getBlockCommentSuffix() = null

    override fun getCommentedBlockCommentPrefix() = null

    override fun getCommentedBlockCommentSuffix() = null
}