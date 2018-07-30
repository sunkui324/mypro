package com.wolab.javaParser;

import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.modules.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.*;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.Visitable;

public class PrintVisitor implements GenericVisitor<Boolean, Visitable> {
    @Override
    public Boolean visit(CompilationUnit n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(PackageDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(TypeParameter n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(LineComment n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(BlockComment n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ClassOrInterfaceDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(EnumDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(EnumConstantDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(AnnotationDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(AnnotationMemberDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(FieldDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(VariableDeclarator n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ConstructorDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(MethodDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(Parameter n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(InitializerDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(JavadocComment n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ClassOrInterfaceType n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(PrimitiveType n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ArrayType n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ArrayCreationLevel n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(IntersectionType n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(UnionType n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(VoidType n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(WildcardType n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(UnknownType n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ArrayAccessExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ArrayCreationExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ArrayInitializerExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(AssignExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(BinaryExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(CastExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ClassExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ConditionalExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(EnclosedExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(FieldAccessExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(InstanceOfExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(StringLiteralExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(IntegerLiteralExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(LongLiteralExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(CharLiteralExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(DoubleLiteralExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(BooleanLiteralExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(NullLiteralExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(MethodCallExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(NameExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ObjectCreationExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ThisExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(SuperExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(UnaryExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(VariableDeclarationExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(MarkerAnnotationExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(SingleMemberAnnotationExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(NormalAnnotationExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(MemberValuePair n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ExplicitConstructorInvocationStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(LocalClassDeclarationStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(AssertStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(BlockStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(LabeledStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(EmptyStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ExpressionStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(SwitchStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(SwitchEntryStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(BreakStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ReturnStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(IfStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(WhileStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ContinueStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(DoStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ForeachStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ForStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ThrowStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(SynchronizedStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(TryStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(CatchClause n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(LambdaExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(MethodReferenceExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(TypeExpr n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(NodeList n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(Name n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(SimpleName n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ImportDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ModuleDeclaration n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ModuleRequiresStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ModuleExportsStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ModuleProvidesStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ModuleUsesStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ModuleOpensStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(UnparsableStmt n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(ReceiverParameter n, Visitable arg) {
        return null;
    }

    @Override
    public Boolean visit(VarType n, Visitable arg) {
        return null;
    }
}
