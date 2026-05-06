import lexer.*;
import parser.Parser;
import ast.ASTNode;
import evaluator.Evaluator;
import utils.TreePrinter;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter expression: ");

        String expression = scanner.nextLine();

        try {

            Lexer lexer = new Lexer(expression);

            List<Token> tokens = lexer.tokenize();

            System.out.println("\nTokens:");
            System.out.println(tokens);

            Parser parser = new Parser(tokens);

            ASTNode tree = parser.parse();

            System.out.println("\nParse Successful");

            System.out.println("\nExpression Tree:");

            TreePrinter.print(tree, "");

            Evaluator evaluator = new Evaluator();

            int result = evaluator.evaluate(tree);

            System.out.println("\nEvaluation Result: " + result);

        }

        catch (Exception e) {

            System.out.println("\nError: " + e.getMessage());
        }
    }
}