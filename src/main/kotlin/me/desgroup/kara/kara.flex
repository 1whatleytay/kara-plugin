package me.desgroup.kara;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

import me.desgroup.kara.psi.KaraTypes;

import java.util.Stack;

%%

%{
Stack<Integer> states = new Stack<>();

void pushState(int state) {
  states.push(yystate());
  yybegin(state);
}

void popState() {
  yybegin(states.pop());
}

char quote = ' ';
%}

%class KaraLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%state SINGLE_STRING
%state DOUBLE_STRING

HARD = [\s\:\;\,\.\{\}\+\-\=\/\\\@\#\$\%\^\&\|\*\(\)\!\?\<\>\~\[\]\"\'(<<EOF>>)]+

%%

<YYINITIAL> {
      "//" ~\R { return KaraTypes.COMMENT; }
      "/*" (!"*/")* "*/" { return KaraTypes.COMMENT; }

      "type" / {HARD} { return KaraTypes.TYPE_DECL; }
      "func" / {HARD} { return KaraTypes.FUNC_DECL; }
      "block" / {HARD} { return KaraTypes.BLOCK_DECL; }
      "exit" / {HARD} { return KaraTypes.EXIT_DECL; }
      "return" / {HARD} { return KaraTypes.RETURN_DECL; }
      "continue" / {HARD} { return KaraTypes.CONTINUE_DECL; }
      "break" / {HARD} { return KaraTypes.BREAK_DECL; }
      "import" / {HARD} { return KaraTypes.IMPORT_DECL; }
      "as" / {HARD} { return KaraTypes.AS_DECL; }
      "if" / {HARD} { return KaraTypes.IF_DECL; }
      "for" / {HARD} { return KaraTypes.FOR_DECL; }
      "let" / {HARD} { return KaraTypes.LET_DECL; }
      "var" / {HARD} { return KaraTypes.VAR_DECL; }

      "true" / {HARD} { return KaraTypes.TRUE; }
      "false" / {HARD} { return KaraTypes.FALSE; }

      "shared" / {HARD} { return KaraTypes.HINT_SHARED; }

      ":" { return KaraTypes.COLON; }
      "," { return KaraTypes.COMMA; }
      "=" { return KaraTypes.OP_EQUALS; }
      "," { return KaraTypes.COMMA; }
      "&" { return KaraTypes.OP_AND; }
      "@" { return KaraTypes.OP_AT; }
      "{" { return KaraTypes.OPEN_BODY; }
      "}" { return KaraTypes.CLOSE_BODY; }
      "(" { return KaraTypes.OPEN_BRACE; }
      ")" { return KaraTypes.CLOSE_BRACE; }
      "[" { return KaraTypes.OPEN_SQUARE; }
      "]" { return KaraTypes.CLOSE_SQUARE; }
      "." { return KaraTypes.DOT; }
      "=>" { return KaraTypes.FUNC_DASH; }

      "+" { return KaraTypes.OP_ADD; }
      "-" { return KaraTypes.OP_SUB; }
      "*" { return KaraTypes.OP_MUL; }
      "/" { return KaraTypes.OP_DIV; }
      "%" { return KaraTypes.OP_MOD; }
      "==" { return KaraTypes.OP_COMPARE; }
      "!=" { return KaraTypes.OP_NCOMPARE; }
      ">=" { return KaraTypes.OP_GE; }
      "<=" { return KaraTypes.OP_LE; }
      ">" { return KaraTypes.OP_GREATER; }
      "<" { return KaraTypes.OP_LESSER; }
      "!" { return KaraTypes.OP_EXCLAM; }
      "??" { return KaraTypes.OP_FALLBACK; }
      "?" { return KaraTypes.OP_QUESTION; }
      "&&" { return KaraTypes.OP_ANDAND; }
      "||" { return KaraTypes.OP_OROR; }

      "=" { return KaraTypes.OP_EQUALS; }
      "+=" { return KaraTypes.OP_ADD_EQUALS; }
      "-=" { return KaraTypes.OP_SUB_EQUALS; }
      "*=" { return KaraTypes.OP_MUL_EQUALS; }
      "/=" { return KaraTypes.OP_DIV_EQUALS; }
      "%=" { return KaraTypes.OP_MOD_EQUALS; }
      "\\" { return KaraTypes.BACKSLASH; }

      "external" { return KaraTypes.EXTERNAL; }
      "varargs" { return KaraTypes.VARARGS; }

      "\'" { pushState(SINGLE_STRING); return KaraTypes.QUOTE; }
      "\"" { pushState(DOUBLE_STRING); return KaraTypes.QUOTE; }

      [\+\-]? [0-9]+ (\. [0-9]+)? / {HARD} { return KaraTypes.NUMBER; }

      "byte" / {HARD}  { return KaraTypes.PRIMITIVE; }
      "short" / {HARD}  { return KaraTypes.PRIMITIVE; }
      "int" / {HARD}  { return KaraTypes.PRIMITIVE; }
      "long" / {HARD}  { return KaraTypes.PRIMITIVE; }
      "ubyte" / {HARD}  { return KaraTypes.PRIMITIVE; }
      "ushort" / {HARD}  { return KaraTypes.PRIMITIVE; }
      "uint" / {HARD}  { return KaraTypes.PRIMITIVE; }
      "ulong" / {HARD}  { return KaraTypes.PRIMITIVE; }
      "float" / {HARD}  { return KaraTypes.PRIMITIVE; }
      "double" / {HARD} { return KaraTypes.PRIMITIVE; }

      "any" / {HARD} { return KaraTypes.ANY; }
      "nothing" / {HARD} { return KaraTypes.NOTHING; }
      "null" / {HARD} { return KaraTypes.NULL; }

      [:jletterdigit:]+ / {HARD} { return KaraTypes.NAME; }

      \s+ { return TokenType.WHITE_SPACE; }
}

<SINGLE_STRING, DOUBLE_STRING> {
    <SINGLE_STRING> {
        \' { popState(); return KaraTypes.QUOTE; }
    }
    <DOUBLE_STRING> {
        \" { popState(); return KaraTypes.QUOTE; }
    }

    \\ . { return KaraTypes.STRING_ESCAPE; }

    [^] { return KaraTypes.STRING_PART; }
}

[^] { return TokenType.BAD_CHARACTER; }
