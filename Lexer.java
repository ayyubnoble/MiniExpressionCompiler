package lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private String input;
    private int pos = 0;

    public Lexer(String input) {
        this.input = input;
    }

    public List<Token> tokenize() {

        List<Token> tokens = new ArrayList<>();

        while (pos < input.length()) {

            char current = input.charAt(pos);

            if (Character.isWhitespace(current)) {
                pos++;
            }

            else if (Character.isDigit(current)) {
                tokens.add(number());
            }

            else {

                switch (current) {

                    case '+':
                        tokens.add(new Token(TokenType.PLUS, "+"));
                        break;

                    case '-':
                        tokens.add(new Token(TokenType.MINUS, "-"));
                        break;

                    case '*':
                        tokens.add(new Token(TokenType.MULTIPLY, "*"));
                        break;

                    case '/':
                        tokens.add(new Token(TokenType.DIVIDE, "/"));
                        break;

                    case '(':
                        tokens.add(new Token(TokenType.LPAREN, "("));
                        break;

                    case ')':
                        tokens.add(new Token(TokenType.RPAREN, ")"));
                        break;

                    default:
                        throw new RuntimeException(
                                "Invalid character: " + current);
                }

                pos++;
            }
        }

        tokens.add(new Token(TokenType.EOF, "EOF"));

        return tokens;
    }

    private Token number() {

        StringBuilder sb = new StringBuilder();

        while (pos < input.length()
                && Character.isDigit(input.charAt(pos))) {

            sb.append(input.charAt(pos));
            pos++;
        }

        return new Token(TokenType.NUMBER, sb.toString());
    }
}