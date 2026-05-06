package utils;

import ast.*;

public class TreePrinter {

    public static void print(ASTNode node, String indent) {

        if (node instanceof NumberNode) {
            System.out.println(indent + ((NumberNode) node).value);
            return;
        }

        if (node instanceof UnaryOpNode) {
            UnaryOpNode unary = (UnaryOpNode) node;
            System.out.println(indent + unary.operator.value);
            print(unary.expr, indent + "  ");
            return;
        }

        BinaryOpNode bin = (BinaryOpNode) node;

        System.out.println(indent + bin.operator.value);
        print(bin.left, indent + "  ");
        print(bin.right, indent + "  ");
    }
}