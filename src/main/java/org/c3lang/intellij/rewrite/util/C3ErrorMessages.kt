package org.c3lang.intellij.rewrite.util

object C3ErrorMessages
{
    const val STRUCT_1 = "Names of structs must start with an uppercase letter."
    const val STRUCT_2 = "Names of structs cannot be all uppercase."
    const val STRUCT_3 = "Zero sized structs are not permitted."

    const val ARGUMENTS_1 = "1 more argument was expected after this one, did you forget it?"
    const val ARGUMENTS_2 = "%s more arguments were expected after this one, did you forget them?"
    const val ARGUMENTS_3 = "This argument would exceed the number of parameters, did you add too many arguments?"

    const val UNUSED_1 = "Parameter `%s` is unused."
}