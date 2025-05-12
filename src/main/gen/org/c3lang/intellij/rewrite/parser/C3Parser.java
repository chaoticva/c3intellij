// This is a generated file. Not intended for manual editing.
package org.c3lang.intellij.rewrite.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.c3lang.intellij.rewrite.psi.C3Types.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class C3Parser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // LPAREN (expr (COMMA expr)*)? RPAREN
  public static boolean arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && arguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ARGUMENTS, r);
    return r;
  }

  // (expr (COMMA expr)*)?
  private static boolean arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1")) return false;
    arguments_1_0(b, l + 1);
    return true;
  }

  // expr (COMMA expr)*
  private static boolean arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && arguments_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expr)*
  private static boolean arguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arguments_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA expr
  private static boolean arguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type IDENTIFIER (EQUALS expr)? SEMICOLON
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, null);
    r = type(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && assignment_2(b, l + 1);
    p = r; // pin = 3
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (EQUALS expr)?
  private static boolean assignment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_2")) return false;
    assignment_2_0(b, l + 1);
    return true;
  }

  // EQUALS expr
  private static boolean assignment_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ATTRIBUTE_NAME (LPAREN (expr (COMMA expr)*)? RPAREN)?
  public static boolean attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute")) return false;
    if (!nextTokenIs(b, ATTRIBUTE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATTRIBUTE_NAME);
    r = r && attribute_1(b, l + 1);
    exit_section_(b, m, ATTRIBUTE, r);
    return r;
  }

  // (LPAREN (expr (COMMA expr)*)? RPAREN)?
  private static boolean attribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_1")) return false;
    attribute_1_0(b, l + 1);
    return true;
  }

  // LPAREN (expr (COMMA expr)*)? RPAREN
  private static boolean attribute_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && attribute_1_0_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expr (COMMA expr)*)?
  private static boolean attribute_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_1_0_1")) return false;
    attribute_1_0_1_0(b, l + 1);
    return true;
  }

  // expr (COMMA expr)*
  private static boolean attribute_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && attribute_1_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expr)*
  private static boolean attribute_1_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_1_0_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_1_0_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attribute_1_0_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA expr
  private static boolean attribute_1_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_1_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // call_name arguments (BANG | PANIC)?
  public static boolean call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_name(b, l + 1);
    r = r && arguments(b, l + 1);
    r = r && call_2(b, l + 1);
    exit_section_(b, m, CALL, r);
    return r;
  }

  // (BANG | PANIC)?
  private static boolean call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_2")) return false;
    call_2_0(b, l + 1);
    return true;
  }

  // BANG | PANIC
  private static boolean call_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_2_0")) return false;
    boolean r;
    r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, PANIC);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ((PATH_SEPARATOR | PERIOD) IDENTIFIER)*
  public static boolean call_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CALL_NAME, null);
    r = consumeToken(b, IDENTIFIER);
    p = r; // pin = 1
    r = r && call_name_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ((PATH_SEPARATOR | PERIOD) IDENTIFIER)*
  private static boolean call_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_name_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!call_name_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "call_name_1", c)) break;
    }
    return true;
  }

  // (PATH_SEPARATOR | PERIOD) IDENTIFIER
  private static boolean call_name_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_name_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_name_1_0_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // PATH_SEPARATOR | PERIOD
  private static boolean call_name_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_name_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, PATH_SEPARATOR);
    if (!r) r = consumeToken(b, PERIOD);
    return r;
  }

  /* ********************************************************** */
  // LPAREN type RPAREN
  public static boolean cast(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cast")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CAST, r);
    return r;
  }

  /* ********************************************************** */
  // KW_CONST (type IDENTIFIER | IDENTIFIER) EQUALS expr SEMICOLON
  public static boolean const_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_$")) return false;
    if (!nextTokenIs(b, KW_CONST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CONST);
    r = r && const_1(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, CONST, r);
    return r;
  }

  // type IDENTIFIER | IDENTIFIER
  private static boolean const_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = const_1_0(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // type IDENTIFIER
  private static boolean const_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // param_contract | return_contract | deprecated_contract | require_contract | ensure_contract | pure_contract
  public static boolean contract(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contract")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTRACT, "<contract>");
    r = param_contract(b, l + 1);
    if (!r) r = return_contract(b, l + 1);
    if (!r) r = deprecated_contract(b, l + 1);
    if (!r) r = require_contract(b, l + 1);
    if (!r) r = ensure_contract(b, l + 1);
    if (!r) r = pure_contract(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_DOC_DEPRECATED STRING?
  public static boolean deprecated_contract(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deprecated_contract")) return false;
    if (!nextTokenIs(b, KW_DOC_DEPRECATED)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_DOC_DEPRECATED);
    r = r && deprecated_contract_1(b, l + 1);
    exit_section_(b, m, DEPRECATED_CONTRACT, r);
    return r;
  }

  // STRING?
  private static boolean deprecated_contract_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deprecated_contract_1")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // DOC_START (IDENTIFIER | contract)* DOC_END
  public static boolean doc_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_comment")) return false;
    if (!nextTokenIs(b, DOC_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOC_START);
    r = r && doc_comment_1(b, l + 1);
    r = r && consumeToken(b, DOC_END);
    exit_section_(b, m, DOC_COMMENT, r);
    return r;
  }

  // (IDENTIFIER | contract)*
  private static boolean doc_comment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_comment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!doc_comment_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "doc_comment_1", c)) break;
    }
    return true;
  }

  // IDENTIFIER | contract
  private static boolean doc_comment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_comment_1_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = contract(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_DOC_ENSURE expr (COMMA expr)* (COLON STRING)?
  public static boolean ensure_contract(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ensure_contract")) return false;
    if (!nextTokenIs(b, KW_DOC_ENSURE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_DOC_ENSURE);
    r = r && expr(b, l + 1);
    r = r && ensure_contract_2(b, l + 1);
    r = r && ensure_contract_3(b, l + 1);
    exit_section_(b, m, ENSURE_CONTRACT, r);
    return r;
  }

  // (COMMA expr)*
  private static boolean ensure_contract_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ensure_contract_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ensure_contract_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ensure_contract_2", c)) break;
    }
    return true;
  }

  // COMMA expr
  private static boolean ensure_contract_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ensure_contract_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON STRING)?
  private static boolean ensure_contract_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ensure_contract_3")) return false;
    ensure_contract_3_0(b, l + 1);
    return true;
  }

  // COLON STRING
  private static boolean ensure_contract_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ensure_contract_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_ENUM IDENTIFIER (COLON (parameters | (KW_INLINE IDENTIFIER)))? enum_body
  public static boolean enum_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_$")) return false;
    if (!nextTokenIs(b, KW_ENUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_ENUM, IDENTIFIER);
    r = r && enum_2(b, l + 1);
    r = r && enum_body(b, l + 1);
    exit_section_(b, m, ENUM, r);
    return r;
  }

  // (COLON (parameters | (KW_INLINE IDENTIFIER)))?
  private static boolean enum_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_2")) return false;
    enum_2_0(b, l + 1);
    return true;
  }

  // COLON (parameters | (KW_INLINE IDENTIFIER))
  private static boolean enum_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && enum_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // parameters | (KW_INLINE IDENTIFIER)
  private static boolean enum_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameters(b, l + 1);
    if (!r) r = enum_2_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_INLINE IDENTIFIER
  private static boolean enum_2_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_2_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_INLINE, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE (enum_value (COMMA enum_value)*)? RBRACE
  public static boolean enum_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_body")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && enum_body_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, ENUM_BODY, r);
    return r;
  }

  // (enum_value (COMMA enum_value)*)?
  private static boolean enum_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_body_1")) return false;
    enum_body_1_0(b, l + 1);
    return true;
  }

  // enum_value (COMMA enum_value)*
  private static boolean enum_body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_body_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_value(b, l + 1);
    r = r && enum_body_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA enum_value)*
  private static boolean enum_body_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_body_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_body_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_body_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA enum_value
  private static boolean enum_body_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_body_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enum_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (EQUALS expr)?
  public static boolean enum_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && enum_value_1(b, l + 1);
    exit_section_(b, m, ENUM_VALUE, r);
    return r;
  }

  // (EQUALS expr)?
  private static boolean enum_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value_1")) return false;
    enum_value_1_0(b, l + 1);
    return true;
  }

  // EQUALS expr
  private static boolean enum_value_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_value_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // term (operator term)*
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = term(b, l + 1);
    r = r && expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (operator term)*
  private static boolean expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_1", c)) break;
    }
    return true;
  }

  // operator term
  private static boolean expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = operator(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (PERIOD IDENTIFIER)*
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FIELD, null);
    r = consumeToken(b, IDENTIFIER);
    p = r; // pin = 1
    r = r && field_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (PERIOD IDENTIFIER)*
  private static boolean field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_1", c)) break;
    }
    return true;
  }

  // PERIOD IDENTIFIER
  private static boolean field_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PERIOD, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (module | statement)*
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    while (true) {
      int c = current_position_(b);
      if (!file_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file", c)) break;
    }
    return true;
  }

  // module | statement
  private static boolean file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0")) return false;
    boolean r;
    r = module(b, l + 1);
    if (!r) r = statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // doc_comment? KW_EXTERN? KW_FN type fq_name parameters attribute* (lambda? SEMICOLON | fn_body)
  public static boolean fn(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FN, "<fn>");
    r = fn_0(b, l + 1);
    r = r && fn_1(b, l + 1);
    r = r && consumeToken(b, KW_FN);
    r = r && type(b, l + 1);
    r = r && fq_name(b, l + 1);
    r = r && parameters(b, l + 1);
    r = r && fn_6(b, l + 1);
    r = r && fn_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_comment?
  private static boolean fn_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_0")) return false;
    doc_comment(b, l + 1);
    return true;
  }

  // KW_EXTERN?
  private static boolean fn_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_1")) return false;
    consumeToken(b, KW_EXTERN);
    return true;
  }

  // attribute*
  private static boolean fn_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fn_6", c)) break;
    }
    return true;
  }

  // lambda? SEMICOLON | fn_body
  private static boolean fn_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fn_7_0(b, l + 1);
    if (!r) r = fn_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // lambda? SEMICOLON
  private static boolean fn_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fn_7_0_0(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // lambda?
  private static boolean fn_7_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_7_0_0")) return false;
    lambda(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LBRACE fn_statement* RBRACE
  public static boolean fn_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_body")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && fn_body_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, FN_BODY, r);
    return r;
  }

  // fn_statement*
  private static boolean fn_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_body_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fn_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fn_body_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LINE_COMMENT | return | (call SEMICOLON) | assignment
  public static boolean fn_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FN_STATEMENT, "<fn statement>");
    r = consumeToken(b, LINE_COMMENT);
    if (!r) r = return_$(b, l + 1);
    if (!r) r = fn_statement_2(b, l + 1);
    if (!r) r = assignment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // call SEMICOLON
  private static boolean fn_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (PERIOD IDENTIFIER)?
  public static boolean fq_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fq_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && fq_name_1(b, l + 1);
    exit_section_(b, m, FQ_NAME, r);
    return r;
  }

  // (PERIOD IDENTIFIER)?
  private static boolean fq_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fq_name_1")) return false;
    fq_name_1_0(b, l + 1);
    return true;
  }

  // PERIOD IDENTIFIER
  private static boolean fq_name_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fq_name_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PERIOD, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_IMPORT path (COMMA path)* SEMICOLON
  public static boolean import_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_$")) return false;
    if (!nextTokenIs(b, KW_IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_IMPORT);
    r = r && path(b, l + 1);
    r = r && import_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, IMPORT, r);
    return r;
  }

  // (COMMA path)*
  private static boolean import_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_2", c)) break;
    }
    return true;
  }

  // COMMA path
  private static boolean import_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && path(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE (init_value (COMMA init_value)*)? RBRACE
  public static boolean init(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && init_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, INIT, r);
    return r;
  }

  // (init_value (COMMA init_value)*)?
  private static boolean init_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_1")) return false;
    init_1_0(b, l + 1);
    return true;
  }

  // init_value (COMMA init_value)*
  private static boolean init_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = init_value(b, l + 1);
    r = r && init_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA init_value)*
  private static boolean init_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!init_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "init_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA init_value
  private static boolean init_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && init_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (PERIOD IDENTIFIER EQUALS)? expr
  public static boolean init_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INIT_VALUE, "<init value>");
    r = init_value_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (PERIOD IDENTIFIER EQUALS)?
  private static boolean init_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_value_0")) return false;
    init_value_0_0(b, l + 1);
    return true;
  }

  // PERIOD IDENTIFIER EQUALS
  private static boolean init_value_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "init_value_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PERIOD, IDENTIFIER, EQUALS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ARROW expr
  public static boolean lambda(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda")) return false;
    if (!nextTokenIs(b, ARROW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW);
    r = r && expr(b, l + 1);
    exit_section_(b, m, LAMBDA, r);
    return r;
  }

  /* ********************************************************** */
  // KW_MACRO type? fq_name parameters attribute* (lambda SEMICOLON | fn_body)
  public static boolean macro(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro")) return false;
    if (!nextTokenIs(b, KW_MACRO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_MACRO);
    r = r && macro_1(b, l + 1);
    r = r && fq_name(b, l + 1);
    r = r && parameters(b, l + 1);
    r = r && macro_4(b, l + 1);
    r = r && macro_5(b, l + 1);
    exit_section_(b, m, MACRO, r);
    return r;
  }

  // type?
  private static boolean macro_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_1")) return false;
    type(b, l + 1);
    return true;
  }

  // attribute*
  private static boolean macro_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "macro_4", c)) break;
    }
    return true;
  }

  // lambda SEMICOLON | fn_body
  private static boolean macro_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = macro_5_0(b, l + 1);
    if (!r) r = fn_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // lambda SEMICOLON
  private static boolean macro_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lambda(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_MODULE path SEMICOLON statement*
  public static boolean module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module")) return false;
    if (!nextTokenIs(b, KW_MODULE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_MODULE);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && module_3(b, l + 1);
    exit_section_(b, m, MODULE, r);
    return r;
  }

  // statement*
  private static boolean module_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LTE | GTE | LT | GT | IS_EQUAL | NOT_EQUAL
  public static boolean operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATOR, "<operator>");
    r = consumeToken(b, LTE);
    if (!r) r = consumeToken(b, GTE);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, IS_EQUAL);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_DOC_PARAM ref? IDENTIFIER (COLON STRING)?
  public static boolean param_contract(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_contract")) return false;
    if (!nextTokenIs(b, KW_DOC_PARAM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_DOC_PARAM);
    r = r && param_contract_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && param_contract_3(b, l + 1);
    exit_section_(b, m, PARAM_CONTRACT, r);
    return r;
  }

  // ref?
  private static boolean param_contract_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_contract_1")) return false;
    ref(b, l + 1);
    return true;
  }

  // (COLON STRING)?
  private static boolean param_contract_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_contract_3")) return false;
    param_contract_3_0(b, l + 1);
    return true;
  }

  // COLON STRING
  private static boolean param_contract_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_contract_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type AMPERSAND? IDENTIFIER | AMPERSAND? IDENTIFIER
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    if (!nextTokenIs(b, "<parameter>", AMPERSAND, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER, "<parameter>");
    r = parameter_0(b, l + 1);
    if (!r) r = parameter_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type AMPERSAND? IDENTIFIER
  private static boolean parameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && parameter_0_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // AMPERSAND?
  private static boolean parameter_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_0_1")) return false;
    consumeToken(b, AMPERSAND);
    return true;
  }

  // AMPERSAND? IDENTIFIER
  private static boolean parameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_1_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // AMPERSAND?
  private static boolean parameter_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_1_0")) return false;
    consumeToken(b, AMPERSAND);
    return true;
  }

  /* ********************************************************** */
  // LPAREN (parameter (COMMA parameter)*)? RPAREN
  public static boolean parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && parameters_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, PARAMETERS, r);
    return r;
  }

  // (parameter (COMMA parameter)*)?
  private static boolean parameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_1")) return false;
    parameters_1_0(b, l + 1);
    return true;
  }

  // parameter (COMMA parameter)*
  private static boolean parameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && parameters_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA parameter)*
  private static boolean parameters_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameters_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameters_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA parameter
  private static boolean parameters_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameters_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (PATH_SEPARATOR IDENTIFIER)*
  public static boolean path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && path_1(b, l + 1);
    exit_section_(b, m, PATH, r);
    return r;
  }

  // (PATH_SEPARATOR IDENTIFIER)*
  private static boolean path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_1", c)) break;
    }
    return true;
  }

  // PATH_SEPARATOR IDENTIFIER
  private static boolean path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PATH_SEPARATOR, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_DOC_PURE
  public static boolean pure_contract(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pure_contract")) return false;
    if (!nextTokenIs(b, KW_DOC_PURE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_DOC_PURE);
    exit_section_(b, m, PURE_CONTRACT, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET AMPERSAND? ("in" | "out" | "inout") RBRACKET
  public static boolean ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ref")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && ref_1(b, l + 1);
    r = r && ref_2(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, REF, r);
    return r;
  }

  // AMPERSAND?
  private static boolean ref_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ref_1")) return false;
    consumeToken(b, AMPERSAND);
    return true;
  }

  // "in" | "out" | "inout"
  private static boolean ref_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ref_2")) return false;
    boolean r;
    r = consumeToken(b, "in");
    if (!r) r = consumeToken(b, "out");
    if (!r) r = consumeToken(b, "inout");
    return r;
  }

  /* ********************************************************** */
  // KW_DOC_REQUIRE expr (COMMA expr)* (COLON STRING)?
  public static boolean require_contract(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_contract")) return false;
    if (!nextTokenIs(b, KW_DOC_REQUIRE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_DOC_REQUIRE);
    r = r && expr(b, l + 1);
    r = r && require_contract_2(b, l + 1);
    r = r && require_contract_3(b, l + 1);
    exit_section_(b, m, REQUIRE_CONTRACT, r);
    return r;
  }

  // (COMMA expr)*
  private static boolean require_contract_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_contract_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!require_contract_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "require_contract_2", c)) break;
    }
    return true;
  }

  // COMMA expr
  private static boolean require_contract_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_contract_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON STRING)?
  private static boolean require_contract_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_contract_3")) return false;
    require_contract_3_0(b, l + 1);
    return true;
  }

  // COLON STRING
  private static boolean require_contract_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_contract_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_RETURN expr? SEMICOLON
  public static boolean return_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_$")) return false;
    if (!nextTokenIs(b, KW_RETURN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RETURN, null);
    r = consumeToken(b, KW_RETURN);
    p = r; // pin = 1
    r = r && report_error_(b, return_1(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // expr?
  private static boolean return_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_1")) return false;
    expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_DOC_RETURN BANG? STRING?
  public static boolean return_contract(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_contract")) return false;
    if (!nextTokenIs(b, KW_DOC_RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_DOC_RETURN);
    r = r && return_contract_1(b, l + 1);
    r = r && return_contract_2(b, l + 1);
    exit_section_(b, m, RETURN_CONTRACT, r);
    return r;
  }

  // BANG?
  private static boolean return_contract_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_contract_1")) return false;
    consumeToken(b, BANG);
    return true;
  }

  // STRING?
  private static boolean return_contract_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_contract_2")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // LINE_COMMENT | import | fn | macro | const | enum | struct | union
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = consumeToken(b, LINE_COMMENT);
    if (!r) r = import_$(b, l + 1);
    if (!r) r = fn(b, l + 1);
    if (!r) r = macro(b, l + 1);
    if (!r) r = const_$(b, l + 1);
    if (!r) r = enum_$(b, l + 1);
    if (!r) r = struct(b, l + 1);
    if (!r) r = union(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_STRUCT IDENTIFIER struct_body
  public static boolean struct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct")) return false;
    if (!nextTokenIs(b, KW_STRUCT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_STRUCT, IDENTIFIER);
    r = r && struct_body(b, l + 1);
    exit_section_(b, m, STRUCT, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE ((parameter SEMICOLON) | union)* RBRACE
  public static boolean struct_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_body")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && struct_body_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, STRUCT_BODY, r);
    return r;
  }

  // ((parameter SEMICOLON) | union)*
  private static boolean struct_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_body_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!struct_body_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "struct_body_1", c)) break;
    }
    return true;
  }

  // (parameter SEMICOLON) | union
  private static boolean struct_body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_body_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = struct_body_1_0_0(b, l + 1);
    if (!r) r = union(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // parameter SEMICOLON
  private static boolean struct_body_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_body_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // cast? (INTEGER | DOUBLE | FLOAT | STRING | CHAR | init | call | field | (LPAREN expr RPAREN))
  public static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
    r = term_0(b, l + 1);
    r = r && term_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // cast?
  private static boolean term_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_0")) return false;
    cast(b, l + 1);
    return true;
  }

  // INTEGER | DOUBLE | FLOAT | STRING | CHAR | init | call | field | (LPAREN expr RPAREN)
  private static boolean term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = init(b, l + 1);
    if (!r) r = call(b, l + 1);
    if (!r) r = field(b, l + 1);
    if (!r) r = term_1_8(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN expr RPAREN
  private static boolean term_1_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_1_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (LBRACKET INTEGER? RBRACKET)?
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && type_1(b, l + 1);
    exit_section_(b, m, TYPE, r);
    return r;
  }

  // (LBRACKET INTEGER? RBRACKET)?
  private static boolean type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1")) return false;
    type_1_0(b, l + 1);
    return true;
  }

  // LBRACKET INTEGER? RBRACKET
  private static boolean type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && type_1_0_1(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // INTEGER?
  private static boolean type_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1_0_1")) return false;
    consumeToken(b, INTEGER);
    return true;
  }

  /* ********************************************************** */
  // KW_UNION IDENTIFIER? struct_body
  public static boolean union(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union")) return false;
    if (!nextTokenIs(b, KW_UNION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_UNION);
    r = r && union_1(b, l + 1);
    r = r && struct_body(b, l + 1);
    exit_section_(b, m, UNION, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean union_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_1")) return false;
    consumeToken(b, IDENTIFIER);
    return true;
  }

}
