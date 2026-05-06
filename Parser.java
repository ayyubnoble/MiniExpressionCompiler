package parser;

import lexer.*;
import ast.*;

import java.util.List;

public class Parser {

    private List<Token> tokens;
    private int pos = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    private Token currentToken() {
        return tokens.get(pos);
    }

    private void eat(TokenType type) {
        if (currentToken().type == type) {
            pos++;
        } else {
            throw new RuntimeException("Unexpected token: " + currentToken().value);
        }
    }

    public ASTNode parse() {
        ASTNode node = expr();

        if (currentToken().type != TokenType.EOF) {
            throw new RuntimeException("Unexpected token after expression: " + currentToken().value);
        }

        return node;
    }

    private ASTNode expr() {
        ASTNode node = term();

        while (currentToken().type == TokenType.PLUS ||
               currentToken().type == TokenType.MINUS) {

            Token op = currentToken();

            if (op.type == TokenType.PLUS) {
                eat(TokenType.PLUS);
            } else {
                eat(TokenType.MINUS);
            }

            node = new BinaryOpNode(node, op, term());
        }

        return node;
    }

    private ASTNode term() {
        ASTNode node = factor();

        while (currentToken().type == TokenType.MULTIPLY ||
               currentToken().type == TokenType.DIVIDE) {

            Token op = currentToken();

            if (op.type == TokenType.MULTIPLY) {
                eat(TokenType.MULTIPLY);
            } else {
                eat(TokenType.DIVIDE);
            }

            node = new BinaryOpNode(node, op, factor());
        }

        return node;
    }

    private ASTNode factor() {
        Token token = currentToken();

        if (token.type == TokenType.NUMBER) {
            eat(TokenType.NUMBER);
            return new NumberNode(Integer.parseInt(token.value));
        }

        if (token.type == TokenType.MINUS) {
            eat(TokenType.MINUS);
            return new UnaryOpNode(token, factor());
        }

        if (token.type == TokenType.LPAREN) {
            eat(TokenType.LPAREN);
            ASTNode node = expr();
            eat(TokenType.RPAREN);
            return node;
        }

        throw new RuntimeException("Invalid syntax near: " + token.value);
    }
}