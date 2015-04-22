package me.lowrey.parsing;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by lowreybr on 1/14/2015.
 */
public class Expression {

    private final ArrayList<Token> tokens;

    public Expression(String statement) throws ParseException {
        String[] splitStatement = statement.trim().split("\\s+");
        ArrayList<Token> tokens = new ArrayList<Token>();
        for (String s : splitStatement) {
            tokens.add(parseToken(s));
        }
        this.tokens = tokens;
    }

    public Token eval() {
        evalNotTokens();
        evalAndTokens();
        evalOrTokens();
        return tokens.get(0);
    }

    private ArrayList<Token> evalAndTokens() {
        for (int i = 0; i < tokens.size(); i++) {
            Token t = tokens.get(i);
            if (t instanceof AndOperator) {
                ((Operator) t).setOperatees(tokens.get(i - 1), tokens.get(i + 1));
                Token result = t.eval() ? new Keyword("TRUE") : new Keyword("FALSE");
                tokens.set(i - 1, result);
                tokens.remove(i + 1);
                tokens.remove(i);
                i--;
            }
        }
        return tokens;
    }

    private ArrayList<Token> evalOrTokens() {
        for (int i = 0; i < tokens.size(); i++) {
            Token t = tokens.get(i);
            if (t instanceof OrOperator) {
                ((Operator) t).setOperatees(tokens.get(i - 1), tokens.get(i + 1));
                Token result = t.eval() ? new Keyword("TRUE") : new Keyword("FALSE");
                tokens.set(i - 1, result);
                tokens.remove(i + 1);
                tokens.remove(i);
                i--;
            }
        }
        return tokens;
    }

    private ArrayList<Token> evalNotTokens() {
        for (int i = 0; i < tokens.size(); i++) {
            Token t = tokens.get(i);
            if (t instanceof NotOperator) {
                ((NotOperator) t).setOperatees(tokens.get(i + 1));
                Token result = t.eval() ? new Keyword("TRUE") : new Keyword("FALSE");
                tokens.set(i, result);
                tokens.remove(i + 1);
            }
        }
        return tokens;
    }

    private Token parseToken(String token) throws ParseException {
        if (token.equals("TRUE") || token.equals("FALSE")) {
            return new Keyword(token);
        } else if (token.equals("OR")) {
            return new OrOperator();
        } else if (token.equals("AND")) {
            return new AndOperator();
        } else if (token.equals("NOT")) {
            return new NotOperator();
        }
        throw new ParseException("Encountered unknown token", -1);
    }
}
