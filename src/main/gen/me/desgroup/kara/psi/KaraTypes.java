// This is a generated file. Not intended for manual editing.
package me.desgroup.kara.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import me.desgroup.kara.psi.impl.*;

public interface KaraTypes {

  IElementType AS = new KaraElement("AS");
  IElementType BINARY = new KaraElement("BINARY");
  IElementType BODY = new KaraElement("BODY");
  IElementType BODY_ASSIGN = new KaraElement("BODY_ASSIGN");
  IElementType BODY_ASSIGN_OP = new KaraElement("BODY_ASSIGN_OP");
  IElementType BODY_BLOCK = new KaraElement("BODY_BLOCK");
  IElementType BODY_FOR = new KaraElement("BODY_FOR");
  IElementType BODY_IF = new KaraElement("BODY_IF");
  IElementType BODY_LINE = new KaraElement("BODY_LINE");
  IElementType BODY_STATEMENT = new KaraElement("BODY_STATEMENT");
  IElementType CODE = new KaraElement("CODE");
  IElementType EXPRESSION = new KaraElement("EXPRESSION");
  IElementType EXPRESSION_GROUPING = new KaraElement("EXPRESSION_GROUPING");
  IElementType EXPRESSION_PART = new KaraElement("EXPRESSION_PART");
  IElementType FUNCTION = new KaraElement("FUNCTION");
  IElementType FUNCTION_BODY = new KaraElement("FUNCTION_BODY");
  IElementType FUNCTION_DECLARATION_BODY = new KaraElement("FUNCTION_DECLARATION_BODY");
  IElementType FUNCTION_LOOSE = new KaraElement("FUNCTION_LOOSE");
  IElementType FUNCTION_PARAMETERS = new KaraElement("FUNCTION_PARAMETERS");
  IElementType FUNCTION_STRICT = new KaraElement("FUNCTION_STRICT");
  IElementType FUNCTION_VALUE_BODY = new KaraElement("FUNCTION_VALUE_BODY");
  IElementType IMPORT = new KaraElement("IMPORT");
  IElementType LITERAL = new KaraElement("LITERAL");
  IElementType LITERAL_ARRAY = new KaraElement("LITERAL_ARRAY");
  IElementType LITERAL_BOOL = new KaraElement("LITERAL_BOOL");
  IElementType LITERAL_NEW = new KaraElement("LITERAL_NEW");
  IElementType LITERAL_NUMBER = new KaraElement("LITERAL_NUMBER");
  IElementType LITERAL_PARENS = new KaraElement("LITERAL_PARENS");
  IElementType LITERAL_REFERENCE = new KaraElement("LITERAL_REFERENCE");
  IElementType LITERAL_SPECIAL = new KaraElement("LITERAL_SPECIAL");
  IElementType LITERAL_STRING = new KaraElement("LITERAL_STRING");
  IElementType MODIFIER = new KaraElement("MODIFIER");
  IElementType MODIFIER_CALL = new KaraElement("MODIFIER_CALL");
  IElementType MODIFIER_CALL_PART = new KaraElement("MODIFIER_CALL_PART");
  IElementType MODIFIER_DOT = new KaraElement("MODIFIER_DOT");
  IElementType MODIFIER_INDEX = new KaraElement("MODIFIER_INDEX");
  IElementType SLASH = new KaraElement("SLASH");
  IElementType TERNARY = new KaraElement("TERNARY");
  IElementType TYPE = new KaraElement("TYPE");
  IElementType TYPENAME = new KaraElement("TYPENAME");
  IElementType TYPENAME_ARRAY = new KaraElement("TYPENAME_ARRAY");
  IElementType TYPENAME_ARRAY_SPEC = new KaraElement("TYPENAME_ARRAY_SPEC");
  IElementType TYPENAME_ARRAY_SPEC_ENUMERABLE = new KaraElement("TYPENAME_ARRAY_SPEC_ENUMERABLE");
  IElementType TYPENAME_ARRAY_SPEC_FIXED = new KaraElement("TYPENAME_ARRAY_SPEC_FIXED");
  IElementType TYPENAME_ARRAY_SPEC_UNBOUNDED = new KaraElement("TYPENAME_ARRAY_SPEC_UNBOUNDED");
  IElementType TYPENAME_ARRAY_SPEC_UNBOUNDED_SIZED = new KaraElement("TYPENAME_ARRAY_SPEC_UNBOUNDED_SIZED");
  IElementType TYPENAME_NAMED = new KaraElement("TYPENAME_NAMED");
  IElementType TYPENAME_OPTIONAL = new KaraElement("TYPENAME_OPTIONAL");
  IElementType TYPENAME_PRIMITIVE = new KaraElement("TYPENAME_PRIMITIVE");
  IElementType TYPENAME_REFERENCE = new KaraElement("TYPENAME_REFERENCE");
  IElementType TYPE_ALIAS_BODY = new KaraElement("TYPE_ALIAS_BODY");
  IElementType TYPE_BODY = new KaraElement("TYPE_BODY");
  IElementType TYPE_DECLARATION_BODY = new KaraElement("TYPE_DECLARATION_BODY");
  IElementType UNARY = new KaraElement("UNARY");
  IElementType VARIABLE = new KaraElement("VARIABLE");
  IElementType VARIABLE_LOOSE = new KaraElement("VARIABLE_LOOSE");
  IElementType VARIABLE_STRICT = new KaraElement("VARIABLE_STRICT");

  IElementType ANY = new KaraToken("ANY");
  IElementType AS_DECL = new KaraToken("AS_DECL");
  IElementType BACKSLASH = new KaraToken("BACKSLASH");
  IElementType BLOCK_DECL = new KaraToken("BLOCK_DECL");
  IElementType BREAK_DECL = new KaraToken("BREAK_DECL");
  IElementType CLOSE_BODY = new KaraToken("CLOSE_BODY");
  IElementType CLOSE_BRACE = new KaraToken("CLOSE_BRACE");
  IElementType CLOSE_SQUARE = new KaraToken("CLOSE_SQUARE");
  IElementType COLON = new KaraToken("COLON");
  IElementType COMMA = new KaraToken("COMMA");
  IElementType COMMENT = new KaraToken("COMMENT");
  IElementType CONTINUE_DECL = new KaraToken("CONTINUE_DECL");
  IElementType DOT = new KaraToken("DOT");
  IElementType EXIT_DECL = new KaraToken("EXIT_DECL");
  IElementType EXTERNAL = new KaraToken("EXTERNAL");
  IElementType FALSE = new KaraToken("FALSE");
  IElementType FOR_DECL = new KaraToken("FOR_DECL");
  IElementType FUNC_DASH = new KaraToken("FUNC_DASH");
  IElementType FUNC_DECL = new KaraToken("FUNC_DECL");
  IElementType HINT_SHARED = new KaraToken("HINT_SHARED");
  IElementType IF_DECL = new KaraToken("IF_DECL");
  IElementType IMPORT_DECL = new KaraToken("IMPORT_DECL");
  IElementType LET_DECL = new KaraToken("LET_DECL");
  IElementType NAME = new KaraToken("NAME");
  IElementType NOTHING = new KaraToken("NOTHING");
  IElementType NULL = new KaraToken("NULL");
  IElementType NUMBER = new KaraToken("NUMBER");
  IElementType OPEN_BODY = new KaraToken("OPEN_BODY");
  IElementType OPEN_BRACE = new KaraToken("OPEN_BRACE");
  IElementType OPEN_SQUARE = new KaraToken("OPEN_SQUARE");
  IElementType OP_ADD = new KaraToken("OP_ADD");
  IElementType OP_ADD_EQUALS = new KaraToken("OP_ADD_EQUALS");
  IElementType OP_AND = new KaraToken("OP_AND");
  IElementType OP_ANDAND = new KaraToken("OP_ANDAND");
  IElementType OP_AT = new KaraToken("OP_AT");
  IElementType OP_COMPARE = new KaraToken("OP_COMPARE");
  IElementType OP_DIV = new KaraToken("OP_DIV");
  IElementType OP_DIV_EQUALS = new KaraToken("OP_DIV_EQUALS");
  IElementType OP_EQUALS = new KaraToken("OP_EQUALS");
  IElementType OP_EXCLAM = new KaraToken("OP_EXCLAM");
  IElementType OP_FALLBACK = new KaraToken("OP_FALLBACK");
  IElementType OP_GE = new KaraToken("OP_GE");
  IElementType OP_GREATER = new KaraToken("OP_GREATER");
  IElementType OP_LE = new KaraToken("OP_LE");
  IElementType OP_LESSER = new KaraToken("OP_LESSER");
  IElementType OP_MOD = new KaraToken("OP_MOD");
  IElementType OP_MOD_EQUALS = new KaraToken("OP_MOD_EQUALS");
  IElementType OP_MUL = new KaraToken("OP_MUL");
  IElementType OP_MUL_EQUALS = new KaraToken("OP_MUL_EQUALS");
  IElementType OP_NCOMPARE = new KaraToken("OP_NCOMPARE");
  IElementType OP_OROR = new KaraToken("OP_OROR");
  IElementType OP_QUESTION = new KaraToken("OP_QUESTION");
  IElementType OP_SUB = new KaraToken("OP_SUB");
  IElementType OP_SUB_EQUALS = new KaraToken("OP_SUB_EQUALS");
  IElementType PRIMITIVE = new KaraToken("PRIMITIVE");
  IElementType QUOTE = new KaraToken("QUOTE");
  IElementType RETURN_DECL = new KaraToken("RETURN_DECL");
  IElementType STRING_ESCAPE = new KaraToken("STRING_ESCAPE");
  IElementType STRING_INSERT = new KaraToken("STRING_INSERT");
  IElementType STRING_PART = new KaraToken("STRING_PART");
  IElementType TRUE = new KaraToken("TRUE");
  IElementType TYPE_DECL = new KaraToken("TYPE_DECL");
  IElementType VARARGS = new KaraToken("VARARGS");
  IElementType VAR_DECL = new KaraToken("VAR_DECL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AS) {
        return new KaraAsImpl(node);
      }
      else if (type == BINARY) {
        return new KaraBinaryImpl(node);
      }
      else if (type == BODY) {
        return new KaraBodyImpl(node);
      }
      else if (type == BODY_ASSIGN) {
        return new KaraBodyAssignImpl(node);
      }
      else if (type == BODY_ASSIGN_OP) {
        return new KaraBodyAssignOpImpl(node);
      }
      else if (type == BODY_BLOCK) {
        return new KaraBodyBlockImpl(node);
      }
      else if (type == BODY_FOR) {
        return new KaraBodyForImpl(node);
      }
      else if (type == BODY_IF) {
        return new KaraBodyIfImpl(node);
      }
      else if (type == BODY_LINE) {
        return new KaraBodyLineImpl(node);
      }
      else if (type == BODY_STATEMENT) {
        return new KaraBodyStatementImpl(node);
      }
      else if (type == CODE) {
        return new KaraCodeImpl(node);
      }
      else if (type == EXPRESSION) {
        return new KaraExpressionImpl(node);
      }
      else if (type == EXPRESSION_GROUPING) {
        return new KaraExpressionGroupingImpl(node);
      }
      else if (type == EXPRESSION_PART) {
        return new KaraExpressionPartImpl(node);
      }
      else if (type == FUNCTION) {
        return new KaraFunctionImpl(node);
      }
      else if (type == FUNCTION_BODY) {
        return new KaraFunctionBodyImpl(node);
      }
      else if (type == FUNCTION_DECLARATION_BODY) {
        return new KaraFunctionDeclarationBodyImpl(node);
      }
      else if (type == FUNCTION_LOOSE) {
        return new KaraFunctionLooseImpl(node);
      }
      else if (type == FUNCTION_PARAMETERS) {
        return new KaraFunctionParametersImpl(node);
      }
      else if (type == FUNCTION_STRICT) {
        return new KaraFunctionStrictImpl(node);
      }
      else if (type == FUNCTION_VALUE_BODY) {
        return new KaraFunctionValueBodyImpl(node);
      }
      else if (type == IMPORT) {
        return new KaraImportImpl(node);
      }
      else if (type == LITERAL) {
        return new KaraLiteralImpl(node);
      }
      else if (type == LITERAL_ARRAY) {
        return new KaraLiteralArrayImpl(node);
      }
      else if (type == LITERAL_BOOL) {
        return new KaraLiteralBoolImpl(node);
      }
      else if (type == LITERAL_NEW) {
        return new KaraLiteralNewImpl(node);
      }
      else if (type == LITERAL_NUMBER) {
        return new KaraLiteralNumberImpl(node);
      }
      else if (type == LITERAL_PARENS) {
        return new KaraLiteralParensImpl(node);
      }
      else if (type == LITERAL_REFERENCE) {
        return new KaraLiteralReferenceImpl(node);
      }
      else if (type == LITERAL_SPECIAL) {
        return new KaraLiteralSpecialImpl(node);
      }
      else if (type == LITERAL_STRING) {
        return new KaraLiteralStringImpl(node);
      }
      else if (type == MODIFIER) {
        return new KaraModifierImpl(node);
      }
      else if (type == MODIFIER_CALL) {
        return new KaraModifierCallImpl(node);
      }
      else if (type == MODIFIER_CALL_PART) {
        return new KaraModifierCallPartImpl(node);
      }
      else if (type == MODIFIER_DOT) {
        return new KaraModifierDotImpl(node);
      }
      else if (type == MODIFIER_INDEX) {
        return new KaraModifierIndexImpl(node);
      }
      else if (type == SLASH) {
        return new KaraSlashImpl(node);
      }
      else if (type == TERNARY) {
        return new KaraTernaryImpl(node);
      }
      else if (type == TYPE) {
        return new KaraTypeImpl(node);
      }
      else if (type == TYPENAME) {
        return new KaraTypenameImpl(node);
      }
      else if (type == TYPENAME_ARRAY) {
        return new KaraTypenameArrayImpl(node);
      }
      else if (type == TYPENAME_ARRAY_SPEC) {
        return new KaraTypenameArraySpecImpl(node);
      }
      else if (type == TYPENAME_ARRAY_SPEC_ENUMERABLE) {
        return new KaraTypenameArraySpecEnumerableImpl(node);
      }
      else if (type == TYPENAME_ARRAY_SPEC_FIXED) {
        return new KaraTypenameArraySpecFixedImpl(node);
      }
      else if (type == TYPENAME_ARRAY_SPEC_UNBOUNDED) {
        return new KaraTypenameArraySpecUnboundedImpl(node);
      }
      else if (type == TYPENAME_ARRAY_SPEC_UNBOUNDED_SIZED) {
        return new KaraTypenameArraySpecUnboundedSizedImpl(node);
      }
      else if (type == TYPENAME_NAMED) {
        return new KaraTypenameNamedImpl(node);
      }
      else if (type == TYPENAME_OPTIONAL) {
        return new KaraTypenameOptionalImpl(node);
      }
      else if (type == TYPENAME_PRIMITIVE) {
        return new KaraTypenamePrimitiveImpl(node);
      }
      else if (type == TYPENAME_REFERENCE) {
        return new KaraTypenameReferenceImpl(node);
      }
      else if (type == TYPE_ALIAS_BODY) {
        return new KaraTypeAliasBodyImpl(node);
      }
      else if (type == TYPE_BODY) {
        return new KaraTypeBodyImpl(node);
      }
      else if (type == TYPE_DECLARATION_BODY) {
        return new KaraTypeDeclarationBodyImpl(node);
      }
      else if (type == UNARY) {
        return new KaraUnaryImpl(node);
      }
      else if (type == VARIABLE) {
        return new KaraVariableImpl(node);
      }
      else if (type == VARIABLE_LOOSE) {
        return new KaraVariableLooseImpl(node);
      }
      else if (type == VARIABLE_STRICT) {
        return new KaraVariableStrictImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
