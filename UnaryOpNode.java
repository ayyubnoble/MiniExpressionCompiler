package ast;

import lexer.Token;

public class UnaryOpNode extends ASTNode {

    public Token operator;
    public ASTNode expr;

    public UnaryOpNode(Token operator,
                       ASTNode expr) {

        this.operator = operator;
        this.expr = expr;
    }
}