// This is a generated file. Not intended for manual editing.
package me.desgroup.kara.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KaraLiteral extends PsiElement {

  @Nullable
  KaraLiteralArray getLiteralArray();

  @Nullable
  KaraLiteralBool getLiteralBool();

  @Nullable
  KaraLiteralNew getLiteralNew();

  @Nullable
  KaraLiteralNumber getLiteralNumber();

  @Nullable
  KaraLiteralParens getLiteralParens();

  @Nullable
  KaraLiteralReference getLiteralReference();

  @Nullable
  KaraLiteralSpecial getLiteralSpecial();

  @Nullable
  KaraLiteralString getLiteralString();

}
