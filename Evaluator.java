package evaluator;

import ast.*;

public class Evaluator {

    public int evaluate(ASTNode node) {

        if (node instanceof NumberNode) {
            return ((NumberNode) node).value;
        }

        if (node instanceof UnaryOpNode) {
            UnaryOpNode unary = (UnaryOpNode) node;
            return -evaluate(unary.expr);
        }

        BinaryOpNode bin = (BinaryOpNode) node;

        int left = evaluate(bin.left);
        int right = evaluate(bin.right);

        switch (bin.operator.type) {
            case PLUS:
                return left + right;
            case MINUS:
                return left - right;
            case MULTIPLY:
                return left * right;
            case DIVIDE:
                return left / right;
            default:
                throw new RuntimeException("Unknown operator");
        }
    }
}