// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.c3lang.intellij.rewrite.psi.impl.*;

public interface C3Types {

  IElementType ARGUMENTS = new C3ElementType("ARGUMENTS");
  IElementType ASSIGNMENT = new C3ElementType("ASSIGNMENT");
  IElementType ATTRIBUTE = new C3ElementType("ATTRIBUTE");
  IElementType CALL = new C3ElementType("CALL");
  IElementType CALL_NAME = new C3ElementType("CALL_NAME");
  IElementType CAST = new C3ElementType("CAST");
  IElementType COMP_ELSE = new C3ElementType("COMP_ELSE");
  IElementType COMP_ENDIF = new C3ElementType("COMP_ENDIF");
  IElementType COMP_IF = new C3ElementType("COMP_IF");
  IElementType CONST = new C3ElementType("CONST");
  IElementType CONTRACT = new C3ElementType("CONTRACT");
  IElementType DEFAULT = new C3ElementType("DEFAULT");
  IElementType DEPRECATED_CONTRACT = new C3ElementType("DEPRECATED_CONTRACT");
  IElementType DESCRIPTION = new C3ElementType("DESCRIPTION");
  IElementType DOC_COMMENT = new C3ElementType("DOC_COMMENT");
  IElementType ENSURE_CONTRACT = new C3ElementType("ENSURE_CONTRACT");
  IElementType ENUM = new C3ElementType("ENUM");
  IElementType ENUM_BODY = new C3ElementType("ENUM_BODY");
  IElementType ENUM_VALUE = new C3ElementType("ENUM_VALUE");
  IElementType EXPR = new C3ElementType("EXPR");
  IElementType FAULTDEF = new C3ElementType("FAULTDEF");
  IElementType FIELD = new C3ElementType("FIELD");
  IElementType FN = new C3ElementType("FN");
  IElementType FN_BODY = new C3ElementType("FN_BODY");
  IElementType FN_STATEMENT = new C3ElementType("FN_STATEMENT");
  IElementType FQ_NAME = new C3ElementType("FQ_NAME");
  IElementType IMPORT = new C3ElementType("IMPORT");
  IElementType INIT = new C3ElementType("INIT");
  IElementType INIT_VALUE = new C3ElementType("INIT_VALUE");
  IElementType LAMBDA = new C3ElementType("LAMBDA");
  IElementType MACRO = new C3ElementType("MACRO");
  IElementType MODULE = new C3ElementType("MODULE");
  IElementType OPERATOR = new C3ElementType("OPERATOR");
  IElementType PARAMETER = new C3ElementType("PARAMETER");
  IElementType PARAMETERS = new C3ElementType("PARAMETERS");
  IElementType PARAM_CONTRACT = new C3ElementType("PARAM_CONTRACT");
  IElementType PATH = new C3ElementType("PATH");
  IElementType PURE_CONTRACT = new C3ElementType("PURE_CONTRACT");
  IElementType REF = new C3ElementType("REF");
  IElementType REQUIRE_CONTRACT = new C3ElementType("REQUIRE_CONTRACT");
  IElementType RETURN = new C3ElementType("RETURN");
  IElementType RETURN_CONTRACT = new C3ElementType("RETURN_CONTRACT");
  IElementType STATEMENT = new C3ElementType("STATEMENT");
  IElementType STRUCT = new C3ElementType("STRUCT");
  IElementType STRUCT_BODY = new C3ElementType("STRUCT_BODY");
  IElementType TERM = new C3ElementType("TERM");
  IElementType TYPE = new C3ElementType("TYPE");
  IElementType UNION = new C3ElementType("UNION");

  IElementType AMPERSAND = new C3TokenType("AMPERSAND");
  IElementType ARROW = new C3TokenType("ARROW");
  IElementType ATTRIBUTE_NAME = new C3TokenType("ATTRIBUTE_NAME");
  IElementType BANG = new C3TokenType("BANG");
  IElementType CHAR = new C3TokenType("CHAR");
  IElementType COLON = new C3TokenType("COLON");
  IElementType COMMA = new C3TokenType("COMMA");
  IElementType DOC_END = new C3TokenType("DOC_END");
  IElementType DOC_START = new C3TokenType("DOC_START");
  IElementType DOUBLE = new C3TokenType("DOUBLE");
  IElementType EQUALS = new C3TokenType("EQUALS");
  IElementType FAULT = new C3TokenType("FAULT");
  IElementType FLOAT = new C3TokenType("FLOAT");
  IElementType GT = new C3TokenType("GT");
  IElementType GTE = new C3TokenType("GTE");
  IElementType IDENTIFIER = new C3TokenType("IDENTIFIER");
  IElementType INTEGER = new C3TokenType("INTEGER");
  IElementType IS_EQUAL = new C3TokenType("IS_EQUAL");
  IElementType KW_COMP_ELSE = new C3TokenType("KW_COMP_ELSE");
  IElementType KW_COMP_ENDIF = new C3TokenType("KW_COMP_ENDIF");
  IElementType KW_COMP_IF = new C3TokenType("KW_COMP_IF");
  IElementType KW_CONST = new C3TokenType("KW_CONST");
  IElementType KW_DOC_DEPRECATED = new C3TokenType("KW_DOC_DEPRECATED");
  IElementType KW_DOC_ENSURE = new C3TokenType("KW_DOC_ENSURE");
  IElementType KW_DOC_PARAM = new C3TokenType("KW_DOC_PARAM");
  IElementType KW_DOC_PURE = new C3TokenType("KW_DOC_PURE");
  IElementType KW_DOC_REQUIRE = new C3TokenType("KW_DOC_REQUIRE");
  IElementType KW_DOC_RETURN = new C3TokenType("KW_DOC_RETURN");
  IElementType KW_ENUM = new C3TokenType("KW_ENUM");
  IElementType KW_EXTERN = new C3TokenType("KW_EXTERN");
  IElementType KW_FAULTDEF = new C3TokenType("KW_FAULTDEF");
  IElementType KW_FN = new C3TokenType("KW_FN");
  IElementType KW_IMPORT = new C3TokenType("KW_IMPORT");
  IElementType KW_INLINE = new C3TokenType("KW_INLINE");
  IElementType KW_MACRO = new C3TokenType("KW_MACRO");
  IElementType KW_MODULE = new C3TokenType("KW_MODULE");
  IElementType KW_RETURN = new C3TokenType("KW_RETURN");
  IElementType KW_STRUCT = new C3TokenType("KW_STRUCT");
  IElementType KW_UNION = new C3TokenType("KW_UNION");
  IElementType LBRACE = new C3TokenType("LBRACE");
  IElementType LBRACKET = new C3TokenType("LBRACKET");
  IElementType LINE_COMMENT = new C3TokenType("LINE_COMMENT");
  IElementType LPAREN = new C3TokenType("LPAREN");
  IElementType LT = new C3TokenType("LT");
  IElementType LTE = new C3TokenType("LTE");
  IElementType NOT_EQUAL = new C3TokenType("NOT_EQUAL");
  IElementType PANIC = new C3TokenType("PANIC");
  IElementType PATH_SEPARATOR = new C3TokenType("PATH_SEPARATOR");
  IElementType PERIOD = new C3TokenType("PERIOD");
  IElementType RBRACE = new C3TokenType("RBRACE");
  IElementType RBRACKET = new C3TokenType("RBRACKET");
  IElementType RPAREN = new C3TokenType("RPAREN");
  IElementType SEMICOLON = new C3TokenType("SEMICOLON");
  IElementType STRING = new C3TokenType("STRING");
  IElementType TEXT = new C3TokenType("TEXT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENTS) {
        return new C3ArgumentsImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new C3AssignmentImpl(node);
      }
      else if (type == ATTRIBUTE) {
        return new C3AttributeImpl(node);
      }
      else if (type == CALL) {
        return new C3CallImpl(node);
      }
      else if (type == CALL_NAME) {
        return new C3CallNameImpl(node);
      }
      else if (type == CAST) {
        return new C3CastImpl(node);
      }
      else if (type == COMP_ELSE) {
        return new C3CompElseImpl(node);
      }
      else if (type == COMP_ENDIF) {
        return new C3CompEndifImpl(node);
      }
      else if (type == COMP_IF) {
        return new C3CompIfImpl(node);
      }
      else if (type == CONST) {
        return new C3ConstImpl(node);
      }
      else if (type == CONTRACT) {
        return new C3ContractImpl(node);
      }
      else if (type == DEFAULT) {
        return new C3DefaultImpl(node);
      }
      else if (type == DEPRECATED_CONTRACT) {
        return new C3DeprecatedContractImpl(node);
      }
      else if (type == DESCRIPTION) {
        return new C3DescriptionImpl(node);
      }
      else if (type == DOC_COMMENT) {
        return new C3DocCommentImpl(node);
      }
      else if (type == ENSURE_CONTRACT) {
        return new C3EnsureContractImpl(node);
      }
      else if (type == ENUM) {
        return new C3EnumImpl(node);
      }
      else if (type == ENUM_BODY) {
        return new C3EnumBodyImpl(node);
      }
      else if (type == ENUM_VALUE) {
        return new C3EnumValueImpl(node);
      }
      else if (type == EXPR) {
        return new C3ExprImpl(node);
      }
      else if (type == FAULTDEF) {
        return new C3FaultdefImpl(node);
      }
      else if (type == FIELD) {
        return new C3FieldImpl(node);
      }
      else if (type == FN) {
        return new C3FnImpl(node);
      }
      else if (type == FN_BODY) {
        return new C3FnBodyImpl(node);
      }
      else if (type == FN_STATEMENT) {
        return new C3FnStatementImpl(node);
      }
      else if (type == FQ_NAME) {
        return new C3FqNameImpl(node);
      }
      else if (type == IMPORT) {
        return new C3ImportImpl(node);
      }
      else if (type == INIT) {
        return new C3InitImpl(node);
      }
      else if (type == INIT_VALUE) {
        return new C3InitValueImpl(node);
      }
      else if (type == LAMBDA) {
        return new C3LambdaImpl(node);
      }
      else if (type == MACRO) {
        return new C3MacroImpl(node);
      }
      else if (type == MODULE) {
        return new C3ModuleImpl(node);
      }
      else if (type == OPERATOR) {
        return new C3OperatorImpl(node);
      }
      else if (type == PARAMETER) {
        return new C3ParameterImpl(node);
      }
      else if (type == PARAMETERS) {
        return new C3ParametersImpl(node);
      }
      else if (type == PARAM_CONTRACT) {
        return new C3ParamContractImpl(node);
      }
      else if (type == PATH) {
        return new C3PathImpl(node);
      }
      else if (type == PURE_CONTRACT) {
        return new C3PureContractImpl(node);
      }
      else if (type == REF) {
        return new C3RefImpl(node);
      }
      else if (type == REQUIRE_CONTRACT) {
        return new C3RequireContractImpl(node);
      }
      else if (type == RETURN) {
        return new C3ReturnImpl(node);
      }
      else if (type == RETURN_CONTRACT) {
        return new C3ReturnContractImpl(node);
      }
      else if (type == STATEMENT) {
        return new C3StatementImpl(node);
      }
      else if (type == STRUCT) {
        return new C3StructImpl(node);
      }
      else if (type == STRUCT_BODY) {
        return new C3StructBodyImpl(node);
      }
      else if (type == TERM) {
        return new C3TermImpl(node);
      }
      else if (type == TYPE) {
        return new C3TypeImpl(node);
      }
      else if (type == UNION) {
        return new C3UnionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
