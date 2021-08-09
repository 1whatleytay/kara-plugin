// This is a generated file. Not intended for manual editing.
package me.desgroup.kara.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static me.desgroup.kara.psi.KaraTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import me.desgroup.kara.psi.*;

public class KaraLiteralImpl extends ASTWrapperPsiElement implements KaraLiteral {

  public KaraLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KaraVisitor visitor) {
    visitor.visitLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KaraVisitor) accept((KaraVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KaraLiteralArray getLiteralArray() {
    return findChildByClass(KaraLiteralArray.class);
  }

  @Override
  @Nullable
  public KaraLiteralBool getLiteralBool() {
    return findChildByClass(KaraLiteralBool.class);
  }

  @Override
  @Nullable
  public KaraLiteralNew getLiteralNew() {
    return findChildByClass(KaraLiteralNew.class);
  }

  @Override
  @Nullable
  public KaraLiteralNumber getLiteralNumber() {
    return findChildByClass(KaraLiteralNumber.class);
  }

  @Override
  @Nullable
  public KaraLiteralParens getLiteralParens() {
    return findChildByClass(KaraLiteralParens.class);
  }

  @Override
  @Nullable
  public KaraLiteralReference getLiteralReference() {
    return findChildByClass(KaraLiteralReference.class);
  }

  @Override
  @Nullable
  public KaraLiteralSpecial getLiteralSpecial() {
    return findChildByClass(KaraLiteralSpecial.class);
  }

  @Override
  @Nullable
  public KaraLiteralString getLiteralString() {
    return findChildByClass(KaraLiteralString.class);
  }

}
