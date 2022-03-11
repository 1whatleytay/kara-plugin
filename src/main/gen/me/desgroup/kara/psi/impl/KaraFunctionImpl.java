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

public class KaraFunctionImpl extends ASTWrapperPsiElement implements KaraFunction {

  public KaraFunctionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KaraVisitor visitor) {
    visitor.visitFunction(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KaraVisitor) accept((KaraVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KaraFunctionBody getFunctionBody() {
    return findChildByClass(KaraFunctionBody.class);
  }

  @Override
  @Nullable
  public KaraFunctionParameters getFunctionParameters() {
    return findChildByClass(KaraFunctionParameters.class);
  }

  @Override
  @Nullable
  public KaraTypename getTypename() {
    return findChildByClass(KaraTypename.class);
  }

}
