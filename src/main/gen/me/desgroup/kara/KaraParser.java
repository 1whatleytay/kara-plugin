// This is a generated file. Not intended for manual editing.
package me.desgroup.kara;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static me.desgroup.kara.psi.KaraTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class KaraParser implements PsiParser, LightPsiParser {

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
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // AS_DECL typename
  public static boolean as(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "as")) return false;
    if (!nextTokenIs(b, AS_DECL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS_DECL);
    r = r && typename(b, l + 1);
    exit_section_(b, m, AS, r);
    return r;
  }

  /* ********************************************************** */
  // OP_ADD | OP_SUB | OP_MUL | OP_DIV | OP_MOD | OP_COMPARE | OP_NCOMPARE | OP_GE | OP_LE | OP_GREATER | OP_LESSER | OP_ANDAND | OP_OROR
  public static boolean binary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY, "<binary>");
    r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_SUB);
    if (!r) r = consumeToken(b, OP_MUL);
    if (!r) r = consumeToken(b, OP_DIV);
    if (!r) r = consumeToken(b, OP_MOD);
    if (!r) r = consumeToken(b, OP_COMPARE);
    if (!r) r = consumeToken(b, OP_NCOMPARE);
    if (!r) r = consumeToken(b, OP_GE);
    if (!r) r = consumeToken(b, OP_LE);
    if (!r) r = consumeToken(b, OP_GREATER);
    if (!r) r = consumeToken(b, OP_LESSER);
    if (!r) r = consumeToken(b, OP_ANDAND);
    if (!r) r = consumeToken(b, OP_OROR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (body-line COMMA?)*
  public static boolean body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body")) return false;
    Marker m = enter_section_(b, l, _NONE_, BODY, "<body>");
    while (true) {
      int c = current_position_(b);
      if (!body_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // body-line COMMA?
  private static boolean body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = body_line(b, l + 1);
    r = r && body_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean body_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // expression body-assign-op expression
  public static boolean body_assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_assign")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY_ASSIGN, "<body assign>");
    r = expression(b, l + 1);
    r = r && body_assign_op(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_EQUALS
  //     | OP_ADD_EQUALS
  //     | OP_SUB_EQUALS
  //     | OP_MUL_EQUALS
  //     | OP_DIV_EQUALS
  //     | OP_MOD_EQUALS
  public static boolean body_assign_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_assign_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY_ASSIGN_OP, "<body assign op>");
    r = consumeToken(b, OP_EQUALS);
    if (!r) r = consumeToken(b, OP_ADD_EQUALS);
    if (!r) r = consumeToken(b, OP_SUB_EQUALS);
    if (!r) r = consumeToken(b, OP_MUL_EQUALS);
    if (!r) r = consumeToken(b, OP_DIV_EQUALS);
    if (!r) r = consumeToken(b, OP_MOD_EQUALS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (BLOCK_DECL | EXIT_DECL) OPEN_BODY body CLOSE_BODY
  public static boolean body_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_block")) return false;
    if (!nextTokenIs(b, "<body block>", BLOCK_DECL, EXIT_DECL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY_BLOCK, "<body block>");
    r = body_block_0(b, l + 1);
    r = r && consumeToken(b, OPEN_BODY);
    r = r && body(b, l + 1);
    r = r && consumeToken(b, CLOSE_BODY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BLOCK_DECL | EXIT_DECL
  private static boolean body_block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_block_0")) return false;
    boolean r;
    r = consumeToken(b, BLOCK_DECL);
    if (!r) r = consumeToken(b, EXIT_DECL);
    return r;
  }

  /* ********************************************************** */
  // FOR_DECL expression? OPEN_BODY body CLOSE_BODY
  public static boolean body_for(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_for")) return false;
    if (!nextTokenIs(b, FOR_DECL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR_DECL);
    r = r && body_for_1(b, l + 1);
    r = r && consumeToken(b, OPEN_BODY);
    r = r && body(b, l + 1);
    r = r && consumeToken(b, CLOSE_BODY);
    exit_section_(b, m, BODY_FOR, r);
    return r;
  }

  // expression?
  private static boolean body_for_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_for_1")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IF_DECL expression OPEN_BODY body CLOSE_BODY
  public static boolean body_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_if")) return false;
    if (!nextTokenIs(b, IF_DECL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF_DECL);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, OPEN_BODY);
    r = r && body(b, l + 1);
    r = r && consumeToken(b, CLOSE_BODY);
    exit_section_(b, m, BODY_IF, r);
    return r;
  }

  /* ********************************************************** */
  // body-if
  //     | body-for
  //     | body-block
  //     | body-statement
  //     | variable-strict
  //     | body-assign
  //     | expression
  //     | function-strict
  //     | COMMENT
  public static boolean body_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_line")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY_LINE, "<body line>");
    r = body_if(b, l + 1);
    if (!r) r = body_for(b, l + 1);
    if (!r) r = body_block(b, l + 1);
    if (!r) r = body_statement(b, l + 1);
    if (!r) r = variable_strict(b, l + 1);
    if (!r) r = body_assign(b, l + 1);
    if (!r) r = expression(b, l + 1);
    if (!r) r = function_strict(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (RETURN_DECL expression) | BREAK_DECL | CONTINUE_DECL
  public static boolean body_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY_STATEMENT, "<body statement>");
    r = body_statement_0(b, l + 1);
    if (!r) r = consumeToken(b, BREAK_DECL);
    if (!r) r = consumeToken(b, CONTINUE_DECL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RETURN_DECL expression
  private static boolean body_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN_DECL);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression-part (binary expression-part)? expression-end?
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expression_part(b, l + 1);
    r = r && expression_1(b, l + 1);
    r = r && expression_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (binary expression-part)?
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    expression_1_0(b, l + 1);
    return true;
  }

  // binary expression-part
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binary(b, l + 1);
    r = r && expression_part(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression-end?
  private static boolean expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_2")) return false;
    expression_end(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ternary | as
  public static boolean expression_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_end")) return false;
    if (!nextTokenIs(b, "<expression end>", AS_DECL, OP_QUESTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_END, "<expression end>");
    r = ternary(b, l + 1);
    if (!r) r = as(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // unary* literal modifier*
  public static boolean expression_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_PART, "<expression part>");
    r = expression_part_0(b, l + 1);
    r = r && literal(b, l + 1);
    r = r && expression_part_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // unary*
  private static boolean expression_part_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unary(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_part_0", c)) break;
    }
    return true;
  }

  // modifier*
  private static boolean expression_part_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_part_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!modifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_part_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NAME function-parameters? typename? function-body
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    r = r && function_1(b, l + 1);
    r = r && function_2(b, l + 1);
    r = r && function_body(b, l + 1);
    exit_section_(b, m, FUNCTION, r);
    return r;
  }

  // function-parameters?
  private static boolean function_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_1")) return false;
    function_parameters(b, l + 1);
    return true;
  }

  // typename?
  private static boolean function_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_2")) return false;
    typename(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // function-value-body | function-declaration-body
  public static boolean function_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_body")) return false;
    if (!nextTokenIs(b, "<function body>", FUNC_DASH, OPEN_BODY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_BODY, "<function body>");
    r = function_value_body(b, l + 1);
    if (!r) r = function_declaration_body(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OPEN_BODY body CLOSE_BODY
  public static boolean function_declaration_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration_body")) return false;
    if (!nextTokenIs(b, OPEN_BODY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BODY);
    r = r && body(b, l + 1);
    r = r && consumeToken(b, CLOSE_BODY);
    exit_section_(b, m, FUNCTION_DECLARATION_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // FUNC_DECL? function
  public static boolean function_loose(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_loose")) return false;
    if (!nextTokenIs(b, "<function loose>", FUNC_DECL, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_LOOSE, "<function loose>");
    r = function_loose_0(b, l + 1);
    r = r && function(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FUNC_DECL?
  private static boolean function_loose_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_loose_0")) return false;
    consumeToken(b, FUNC_DECL);
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACE (variable-loose COMMA?)* CLOSE_BRACE
  public static boolean function_parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameters")) return false;
    if (!nextTokenIs(b, OPEN_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACE);
    r = r && function_parameters_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACE);
    exit_section_(b, m, FUNCTION_PARAMETERS, r);
    return r;
  }

  // (variable-loose COMMA?)*
  private static boolean function_parameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameters_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_parameters_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_parameters_1", c)) break;
    }
    return true;
  }

  // variable-loose COMMA?
  private static boolean function_parameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_loose(b, l + 1);
    r = r && function_parameters_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean function_parameters_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameters_1_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // FUNC_DECL function
  public static boolean function_strict(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_strict")) return false;
    if (!nextTokenIs(b, FUNC_DECL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNC_DECL);
    r = r && function(b, l + 1);
    exit_section_(b, m, FUNCTION_STRICT, r);
    return r;
  }

  /* ********************************************************** */
  // FUNC_DASH expression
  public static boolean function_value_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_value_body")) return false;
    if (!nextTokenIs(b, FUNC_DASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNC_DASH);
    r = r && expression(b, l + 1);
    exit_section_(b, m, FUNCTION_VALUE_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT_DECL (OPEN_BRACE NAME CLOSE_BRACE)? literal-string
  public static boolean import_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_$")) return false;
    if (!nextTokenIs(b, IMPORT_DECL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT_DECL);
    r = r && import_1(b, l + 1);
    r = r && literal_string(b, l + 1);
    exit_section_(b, m, IMPORT, r);
    return r;
  }

  // (OPEN_BRACE NAME CLOSE_BRACE)?
  private static boolean import_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_1")) return false;
    import_1_0(b, l + 1);
    return true;
  }

  // OPEN_BRACE NAME CLOSE_BRACE
  private static boolean import_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OPEN_BRACE, NAME, CLOSE_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // literal-parens
  //     | literal-array
  //     | literal-string
  //     | literal-special
  //     | literal-bool
  //     | literal-number
  //     | literal-new
  //     | literal-reference
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = literal_parens(b, l + 1);
    if (!r) r = literal_array(b, l + 1);
    if (!r) r = literal_string(b, l + 1);
    if (!r) r = literal_special(b, l + 1);
    if (!r) r = literal_bool(b, l + 1);
    if (!r) r = literal_number(b, l + 1);
    if (!r) r = literal_new(b, l + 1);
    if (!r) r = literal_reference(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OPEN_SQUARE (expression COMMA?)* CLOSE_SQUARE
  public static boolean literal_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_array")) return false;
    if (!nextTokenIs(b, OPEN_SQUARE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_SQUARE);
    r = r && literal_array_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_SQUARE);
    exit_section_(b, m, LITERAL_ARRAY, r);
    return r;
  }

  // (expression COMMA?)*
  private static boolean literal_array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_array_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!literal_array_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "literal_array_1", c)) break;
    }
    return true;
  }

  // expression COMMA?
  private static boolean literal_array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_array_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && literal_array_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean literal_array_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_array_1_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // TRUE | FALSE
  public static boolean literal_bool(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_bool")) return false;
    if (!nextTokenIs(b, "<literal bool>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_BOOL, "<literal bool>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_MUL typename
  public static boolean literal_new(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_new")) return false;
    if (!nextTokenIs(b, OP_MUL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_MUL);
    r = r && typename(b, l + 1);
    exit_section_(b, m, LITERAL_NEW, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER
  public static boolean literal_number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_number")) return false;
    if (!nextTokenIs(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    exit_section_(b, m, LITERAL_NUMBER, r);
    return r;
  }

  /* ********************************************************** */
  // OPEN_BRACE expression CLOSE_BRACE
  public static boolean literal_parens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_parens")) return false;
    if (!nextTokenIs(b, OPEN_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACE);
    exit_section_(b, m, LITERAL_PARENS, r);
    return r;
  }

  /* ********************************************************** */
  // NAME
  public static boolean literal_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_reference")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    exit_section_(b, m, LITERAL_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // ANY | NOTHING | NULL
  public static boolean literal_special(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_special")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_SPECIAL, "<literal special>");
    r = consumeToken(b, ANY);
    if (!r) r = consumeToken(b, NOTHING);
    if (!r) r = consumeToken(b, NULL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // QUOTE (STRING_PART | STRING_ESCAPE | STRING_INSERT)* QUOTE
  public static boolean literal_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_string")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && literal_string_1(b, l + 1);
    r = r && consumeToken(b, QUOTE);
    exit_section_(b, m, LITERAL_STRING, r);
    return r;
  }

  // (STRING_PART | STRING_ESCAPE | STRING_INSERT)*
  private static boolean literal_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_string_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!literal_string_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "literal_string_1", c)) break;
    }
    return true;
  }

  // STRING_PART | STRING_ESCAPE | STRING_INSERT
  private static boolean literal_string_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_string_1_0")) return false;
    boolean r;
    r = consumeToken(b, STRING_PART);
    if (!r) r = consumeToken(b, STRING_ESCAPE);
    if (!r) r = consumeToken(b, STRING_INSERT);
    return r;
  }

  /* ********************************************************** */
  // modifier-call | modifier-index | modifier-dot
  public static boolean modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFIER, "<modifier>");
    r = modifier_call(b, l + 1);
    if (!r) r = modifier_index(b, l + 1);
    if (!r) r = modifier_dot(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OPEN_BRACE (modifier-call-part COMMA?)* CLOSE_BRACE
  public static boolean modifier_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_call")) return false;
    if (!nextTokenIs(b, OPEN_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACE);
    r = r && modifier_call_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACE);
    exit_section_(b, m, MODIFIER_CALL, r);
    return r;
  }

  // (modifier-call-part COMMA?)*
  private static boolean modifier_call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_call_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!modifier_call_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modifier_call_1", c)) break;
    }
    return true;
  }

  // modifier-call-part COMMA?
  private static boolean modifier_call_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_call_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modifier_call_part(b, l + 1);
    r = r && modifier_call_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean modifier_call_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_call_1_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // (NAME COLON)? expression
  public static boolean modifier_call_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_call_part")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFIER_CALL_PART, "<modifier call part>");
    r = modifier_call_part_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (NAME COLON)?
  private static boolean modifier_call_part_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_call_part_0")) return false;
    modifier_call_part_0_0(b, l + 1);
    return true;
  }

  // NAME COLON
  private static boolean modifier_call_part_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_call_part_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NAME, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOT NAME
  public static boolean modifier_dot(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_dot")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, NAME);
    exit_section_(b, m, MODIFIER_DOT, r);
    return r;
  }

  /* ********************************************************** */
  // OPEN_SQUARE expression CLOSE_SQUARE
  public static boolean modifier_index(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_index")) return false;
    if (!nextTokenIs(b, OPEN_SQUARE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_SQUARE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, CLOSE_SQUARE);
    exit_section_(b, m, MODIFIER_INDEX, r);
    return r;
  }

  /* ********************************************************** */
  // (import|type|variable-strict|function-loose|COMMENT)*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!root_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  // import|type|variable-strict|function-loose|COMMENT
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    boolean r;
    r = import_$(b, l + 1);
    if (!r) r = type(b, l + 1);
    if (!r) r = variable_strict(b, l + 1);
    if (!r) r = function_loose(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // OP_QUESTION expression COLON expression
  public static boolean ternary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternary")) return false;
    if (!nextTokenIs(b, OP_QUESTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_QUESTION);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, TERNARY, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE_DECL NAME type-body
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    if (!nextTokenIs(b, TYPE_DECL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TYPE_DECL, NAME);
    r = r && type_body(b, l + 1);
    exit_section_(b, m, TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // OP_EQUALS typename
  public static boolean type_alias_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_alias_body")) return false;
    if (!nextTokenIs(b, OP_EQUALS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_EQUALS);
    r = r && typename(b, l + 1);
    exit_section_(b, m, TYPE_ALIAS_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // type-alias-body | type-declaration-body
  public static boolean type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_body")) return false;
    if (!nextTokenIs(b, "<type body>", OPEN_BODY, OP_EQUALS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_BODY, "<type body>");
    r = type_alias_body(b, l + 1);
    if (!r) r = type_declaration_body(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OPEN_BODY (variable-loose COMMA?)* CLOSE_BODY
  public static boolean type_declaration_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_declaration_body")) return false;
    if (!nextTokenIs(b, OPEN_BODY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BODY);
    r = r && type_declaration_body_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_BODY);
    exit_section_(b, m, TYPE_DECLARATION_BODY, r);
    return r;
  }

  // (variable-loose COMMA?)*
  private static boolean type_declaration_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_declaration_body_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_declaration_body_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_declaration_body_1", c)) break;
    }
    return true;
  }

  // variable-loose COMMA?
  private static boolean type_declaration_body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_declaration_body_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_loose(b, l + 1);
    r = r && type_declaration_body_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean type_declaration_body_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_declaration_body_1_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // typename-reference
  //     | typename-optional
  //     | typename-array
  //     | typename-primitive
  //     | typename-named
  public static boolean typename(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPENAME, "<typename>");
    r = typename_reference(b, l + 1);
    if (!r) r = typename_optional(b, l + 1);
    if (!r) r = typename_array(b, l + 1);
    if (!r) r = typename_primitive(b, l + 1);
    if (!r) r = typename_named(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OPEN_SQUARE typename typename-array-spec? CLOSE_SQUARE
  public static boolean typename_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_array")) return false;
    if (!nextTokenIs(b, OPEN_SQUARE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_SQUARE);
    r = r && typename(b, l + 1);
    r = r && typename_array_2(b, l + 1);
    r = r && consumeToken(b, CLOSE_SQUARE);
    exit_section_(b, m, TYPENAME_ARRAY, r);
    return r;
  }

  // typename-array-spec?
  private static boolean typename_array_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_array_2")) return false;
    typename_array_spec(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // typename-array-spec-fixed
  //     | typename-array-spec-unbounded
  //     | typename-array-spec-enumerable
  public static boolean typename_array_spec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_array_spec")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typename_array_spec_fixed(b, l + 1);
    if (!r) r = typename_array_spec_unbounded(b, l + 1);
    if (!r) r = typename_array_spec_enumerable(b, l + 1);
    exit_section_(b, m, TYPENAME_ARRAY_SPEC, r);
    return r;
  }

  /* ********************************************************** */
  // COLON COLON
  public static boolean typename_array_spec_enumerable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_array_spec_enumerable")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, COLON);
    exit_section_(b, m, TYPENAME_ARRAY_SPEC_ENUMERABLE, r);
    return r;
  }

  /* ********************************************************** */
  // COLON NUMBER
  public static boolean typename_array_spec_fixed(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_array_spec_fixed")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, NUMBER);
    exit_section_(b, m, TYPENAME_ARRAY_SPEC_FIXED, r);
    return r;
  }

  /* ********************************************************** */
  // COLON
  public static boolean typename_array_spec_unbounded(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_array_spec_unbounded")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    exit_section_(b, m, TYPENAME_ARRAY_SPEC_UNBOUNDED, r);
    return r;
  }

  /* ********************************************************** */
  // NAME
  public static boolean typename_named(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_named")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    exit_section_(b, m, TYPENAME_NAMED, r);
    return r;
  }

  /* ********************************************************** */
  // (OP_QUESTION | OP_EXCLAM) typename
  public static boolean typename_optional(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_optional")) return false;
    if (!nextTokenIs(b, "<typename optional>", OP_EXCLAM, OP_QUESTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPENAME_OPTIONAL, "<typename optional>");
    r = typename_optional_0(b, l + 1);
    r = r && typename(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_QUESTION | OP_EXCLAM
  private static boolean typename_optional_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_optional_0")) return false;
    boolean r;
    r = consumeToken(b, OP_QUESTION);
    if (!r) r = consumeToken(b, OP_EXCLAM);
    return r;
  }

  /* ********************************************************** */
  // PRIMITIVE | ANY | NOTHING | NULL
  public static boolean typename_primitive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_primitive")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPENAME_PRIMITIVE, "<typename primitive>");
    r = consumeToken(b, PRIMITIVE);
    if (!r) r = consumeToken(b, ANY);
    if (!r) r = consumeToken(b, NOTHING);
    if (!r) r = consumeToken(b, NULL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (OP_AND | (OP_MUL HINT_SHARED?)) (LET_DECL | VAR_DECL)? typename
  public static boolean typename_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_reference")) return false;
    if (!nextTokenIs(b, "<typename reference>", OP_AND, OP_MUL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPENAME_REFERENCE, "<typename reference>");
    r = typename_reference_0(b, l + 1);
    r = r && typename_reference_1(b, l + 1);
    r = r && typename(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_AND | (OP_MUL HINT_SHARED?)
  private static boolean typename_reference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_reference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_AND);
    if (!r) r = typename_reference_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_MUL HINT_SHARED?
  private static boolean typename_reference_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_reference_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_MUL);
    r = r && typename_reference_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // HINT_SHARED?
  private static boolean typename_reference_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_reference_0_1_1")) return false;
    consumeToken(b, HINT_SHARED);
    return true;
  }

  // (LET_DECL | VAR_DECL)?
  private static boolean typename_reference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_reference_1")) return false;
    typename_reference_1_0(b, l + 1);
    return true;
  }

  // LET_DECL | VAR_DECL
  private static boolean typename_reference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename_reference_1_0")) return false;
    boolean r;
    r = consumeToken(b, LET_DECL);
    if (!r) r = consumeToken(b, VAR_DECL);
    return r;
  }

  /* ********************************************************** */
  // OP_EXCLAM | OP_SUB | OP_AND | OP_AT
  public static boolean unary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY, "<unary>");
    r = consumeToken(b, OP_EXCLAM);
    if (!r) r = consumeToken(b, OP_SUB);
    if (!r) r = consumeToken(b, OP_AND);
    if (!r) r = consumeToken(b, OP_AT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NAME ((typename? OP_EQUALS expression) | typename)
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME);
    r = r && variable_1(b, l + 1);
    exit_section_(b, m, VARIABLE, r);
    return r;
  }

  // (typename? OP_EQUALS expression) | typename
  private static boolean variable_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_1_0(b, l + 1);
    if (!r) r = typename(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typename? OP_EQUALS expression
  private static boolean variable_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_1_0_0(b, l + 1);
    r = r && consumeToken(b, OP_EQUALS);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typename?
  private static boolean variable_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_1_0_0")) return false;
    typename(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (LET_DECL | VAR_DECL)? variable
  public static boolean variable_loose(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_loose")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_LOOSE, "<variable loose>");
    r = variable_loose_0(b, l + 1);
    r = r && variable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LET_DECL | VAR_DECL)?
  private static boolean variable_loose_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_loose_0")) return false;
    variable_loose_0_0(b, l + 1);
    return true;
  }

  // LET_DECL | VAR_DECL
  private static boolean variable_loose_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_loose_0_0")) return false;
    boolean r;
    r = consumeToken(b, LET_DECL);
    if (!r) r = consumeToken(b, VAR_DECL);
    return r;
  }

  /* ********************************************************** */
  // (LET_DECL | VAR_DECL) variable
  public static boolean variable_strict(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_strict")) return false;
    if (!nextTokenIs(b, "<variable strict>", LET_DECL, VAR_DECL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_STRICT, "<variable strict>");
    r = variable_strict_0(b, l + 1);
    r = r && variable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LET_DECL | VAR_DECL
  private static boolean variable_strict_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_strict_0")) return false;
    boolean r;
    r = consumeToken(b, LET_DECL);
    if (!r) r = consumeToken(b, VAR_DECL);
    return r;
  }

}