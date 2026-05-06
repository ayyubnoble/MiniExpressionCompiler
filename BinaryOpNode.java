package ast;

import lexer.Token;

public class BinaryOpNode extends ASTNode {

    public ASTNode left;
    public Token operator;
    public ASTNode right;

    public BinaryOpNode(ASTNode left,
                        Token operator,
                        ASTNode right) {

        this.left = left;
        this.operator = operator;
        this.right = right;
    }
}