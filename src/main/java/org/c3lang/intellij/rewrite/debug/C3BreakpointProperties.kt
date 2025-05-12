package org.c3lang.intellij.rewrite.debug

import com.intellij.util.xmlb.XmlSerializerUtil
import com.intellij.xdebugger.breakpoints.XBreakpointProperties
import java.util.Objects

class C3BreakpointProperties : XBreakpointProperties<C3BreakpointProperties>()
{
    private var condition: String? = ""
    private var suspendPolicy = true

    override fun getState() = this

    override fun loadState(state: C3BreakpointProperties)
    {
        XmlSerializerUtil.copyBean(state, this);
    }

    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        other as C3BreakpointProperties

        return suspendPolicy == other.suspendPolicy && Objects.equals(condition, other.condition)
    }

    override fun hashCode() = Objects.hash(condition, suspendPolicy)
}