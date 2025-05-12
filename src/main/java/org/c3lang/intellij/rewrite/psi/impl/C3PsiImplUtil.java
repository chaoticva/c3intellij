package org.c3lang.intellij.rewrite.psi.impl;

import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.apache.commons.lang3.Validate;
import org.c3lang.intellij.rewrite.psi.*;
import org.c3lang.intellij.rewrite.util.C3Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class C3PsiImplUtil
{
    /**
     * @param fn The {@link C3Fn}
     * @return true if the function is marked as extern
     */
    public static boolean isExtern(@NotNull C3Fn fn)
    {
        ASTNode externElement = fn.getNode().findChildByType(C3Types.KW_EXTERN);
        return externElement != null;
    }

    /**
     * @param parameter the {@link C3Parameter}
     * @return the name string
     */
    public static @NotNull String getName(@NotNull C3Parameter parameter)
    {
        ASTNode nameElement = parameter.getNode().findChildByType(C3Types.IDENTIFIER);
        Validate.notNull(nameElement, "Name element may not be null");
        return nameElement.getText();
    }

    /**
     * @param attribute the {@link C3Attribute}
     * @return the name string
     */
    public static @NotNull String getName(@NotNull C3Attribute attribute)
    {
        ASTNode nameElement = attribute.getNode().findChildByType(C3Types.ATTRIBUTE_NAME);
        Validate.notNull(nameElement, "Name element may not be null");
        return nameElement.getText();
    }

    /**
     * @param c3Enum the {@link C3Enum}
     * @return the name string
     */
    public static @NotNull String getName(@NotNull C3Enum c3Enum)
    {
        ASTNode nameElement = c3Enum.getNode().findChildByType(C3Types.IDENTIFIER);
        Validate.notNull(nameElement, "Name element may not be null");
        return nameElement.getText();
    }

    /**
     * @param struct the {@link C3Struct}
     * @return the name string
     */
    public static @NotNull String getName(@NotNull C3Struct struct)
    {
        ASTNode nameElement = struct.getNode().findChildByType(C3Types.IDENTIFIER);
        Validate.notNull(nameElement, "Name element may not be null");
        return nameElement.getText();
    }

    /**
     * @param union the {@link C3Union}
     * @return the name string
     */
    public static @Nullable String getName(@NotNull C3Union union)
    {
        ASTNode nameElement = union.getNode().findChildByType(C3Types.IDENTIFIER);
        if (nameElement == null) return null;
        return nameElement.getText();
    }

    /**
     * @param type the {@link C3Type}
     * @return the formatted text
     */
    public static @NotNull String getString(@NotNull C3Type type)
    {
        return type.getText().replaceAll("\\s", "");
    }

    /**
     * @param parameters the {@link C3Parameters}
     * @return the formatted text
     */
    public static @NotNull String getString(@NotNull C3Parameters parameters)
    {
        return parameters.getText()
                .replaceAll("\\s*,\\s*", ", ")
                .replaceAll("\\s+", " ");
    }

    /**
     * @param c3Const the {@link C3Const}
     * @return the name string
     */
    public static @NotNull String getName(@NotNull C3Const c3Const)
    {
        ASTNode nameElement = c3Const.getNode().findChildByType(C3Types.IDENTIFIER);
        Validate.notNull(nameElement, "Name element may not be null");
        return nameElement.getText();
    }

    /**
     * @param enumValue the {@link C3EnumValue}
     * @return the name string
     */
    public static @NotNull String getName(@NotNull C3EnumValue enumValue)
    {
        ASTNode nameElement = enumValue.getNode().findChildByType(C3Types.IDENTIFIER);
        Validate.notNull(nameElement, "Name element may not be null");
        return nameElement.getText();
    }

    /**
     * @param parameter the {@link C3Parameter}
     * @return the lookup element for completions
     */
    public static LookupElementBuilder getLookupElement(@NotNull C3Parameter parameter)
    {
        LookupElementBuilder builder = LookupElementBuilder
                .create(parameter.getName())
                .withIcon(AllIcons.Nodes.Parameter);

        if (parameter.getType() != null)
        {
            builder = builder.withTypeText(parameter.getType().getString());
        }

        return builder;
    }

    /**
     * @param fn the {@link C3Fn}
     * @return the lookup element for completions
     */
    public static @NotNull LookupElementBuilder getLookupElement(@NotNull C3Fn fn)
    {
        return LookupElementBuilder
                .create(fn.getFqName().getText())
                .withIcon(AllIcons.Nodes.Function)
                .withTypeText(fn.getType().getString())
                .withTailText(fn.getParameters().getString());
    }

    /**
     * @param c3Const the {@link C3Const}
     * @return the lookup element for completions
     */
    public static LookupElementBuilder getLookupElement(@NotNull C3Const c3Const)
    {
        LookupElementBuilder builder = LookupElementBuilder
                .create(c3Const.getName())
                .withIcon(AllIcons.Nodes.Constant);

        if (c3Const.getType() != null)
        {
            builder = builder.withTypeText(c3Const.getType().getString());
        }

        return builder;
    }

    /**
     * @param c3Enum the {@link C3Enum}
     * @return the lookup element for completions
     */
    public static @NotNull LookupElementBuilder getLookupElement(@NotNull C3Enum c3Enum)
    {
        return LookupElementBuilder
                .create(c3Enum.getName())
                .withIcon(AllIcons.Nodes.Enum);
    }

    /**
     * @param assignment the {@link C3Assignment}
     * @return the name string
     */
    public static String getName(C3Assignment assignment)
    {
        ASTNode nameElement = assignment.getNode().findChildByType(C3Types.IDENTIFIER);
        Validate.notNull(nameElement, "Name element may not be null");
        return nameElement.getText();
    }

    public static C3Fn getFnDefinition(C3Call call)
    {
        String name = call.getCallName().getText();
        if (name.contains("::"))
        {
            // TODO: module fn
        } else if (name.contains("."))
        {
            // TODO: field fn
        } else
        {
            C3Module module = call.getModule();

            for (C3Statement statement : module.getStatementList())
            {
                if (statement.getFn() != null && statement.getFn().getFqName().getText().equals(call.getCallName().getText()))
                {
                    return statement.getFn();
                }
            }
        }
        return null;
    }

    public static C3Macro getMacroDefinition(C3Call call)
    {
        return null;
    }

    public static C3Module getModule(C3Call call)
    {
        return PsiTreeUtil.getParentOfType(call.getParent(), C3Module.class);
    }

    public static C3Module getModule(C3Statement statement)
    {
        return PsiTreeUtil.getParentOfType(statement.getParent(), C3Module.class);
    }

    public static C3Fn getContainingFn(C3Parameter parameter)
    {
        return PsiTreeUtil.getParentOfType(parameter, C3Fn.class);
    }

    public static C3Macro getContainingMacro(C3Parameter parameter)
    {
        return PsiTreeUtil.getParentOfType(parameter, C3Macro.class);
    }

    public static boolean isBorrowed(C3Parameter parameter)
    {
        ASTNode borrowElement = parameter.getNode().findChildByType(C3Types.AMPERSAND);
        return borrowElement != null;
    }

    public static boolean isUsed(C3Parameter parameter)
    {
        ArrayList<C3Expr> expressions = new ArrayList<>();

        if (parameter.getContainingFn() != null)
        {
            C3Util.INSTANCE.getExprChildren(parameter.getContainingFn(), expressions);
        }

        for (C3Expr expr : expressions)
        {
            if (expr.getText().equals(parameter.getName())) return true;
            if (expr.getTermList().isEmpty()) return false;
            if (expr.getTermList().get(0).getField() != null)
            {
                if (expr.getTermList().get(0).getField().getFirstChild().getText().equals(parameter.getName())) return true;
            }
            if (expr.getTermList().get(0).getCall() != null)
            {
                if (expr.getTermList().get(0).getCall().getCallName().getFirstChild().getText().equals(parameter.getName())) return true;
            }
        }

        return false;
    }

    public static PsiElement setName(C3Fn fn, String name)
    {
        return null; // TODO: return factory create new element
    }

    public static PsiElement getNameIdentifier(C3Fn fn)
    {
        return fn.getFqName();
    }

    // TODO: search all project expressions for call
    // check if function is module or struct fn and look for appropriate calls
//    public static List<C3Call> getUsages()
}
