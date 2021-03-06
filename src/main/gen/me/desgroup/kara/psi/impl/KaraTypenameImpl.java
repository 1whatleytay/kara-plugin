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

public class KaraTypenameImpl extends ASTWrapperPsiElement implements KaraTypename {

  public KaraTypenameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KaraVisitor visitor) {
    visitor.visitTypename(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KaraVisitor) accept((KaraVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KaraTypenameArray getTypenameArray() {
    return findChildByClass(KaraTypenameArray.class);
  }

  @Override
  @Nullable
  public KaraTypenameFunction getTypenameFunction() {
    return findChildByClass(KaraTypenameFunction.class);
  }

  @Override
  @Nullable
  public KaraTypenameNamed getTypenameNamed() {
    return findChildByClass(KaraTypenameNamed.class);
  }

  @Override
  @Nullable
  public KaraTypenameOptional getTypenameOptional() {
    return findChildByClass(KaraTypenameOptional.class);
  }

  @Override
  @Nullable
  public KaraTypenamePrimitive getTypenamePrimitive() {
    return findChildByClass(KaraTypenamePrimitive.class);
  }

  @Override
  @Nullable
  public KaraTypenameReference getTypenameReference() {
    return findChildByClass(KaraTypenameReference.class);
  }

}
