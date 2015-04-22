package me.lowrey;

import me.lowrey.parsing.Expression;
import me.lowrey.parsing.Keyword;
import me.lowrey.parsing.Token;

import java.text.ParseException;

/**
 * Created by lowreybr on 1/14/2015.
 */
public class LogicCalculator {

    public static String chomp(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, s.length() - 1);
    }

    public static int findClosingParen(String s, int openPos) {
        char[] text = s.toCharArray();
        int closePos = openPos;
        int i = 1;
        while (i > 0) {
            char c = text[++closePos];
            if (c == '(') {
                i++;
            } else if (c == ')') {
                i--;
            }
        }
        return closePos;
    }

    public static Token evalParens(String statement) throws ParseException {
        int pos = statement.indexOf('(');
        if (pos >= 0) {
            int closingPos = findClosingParen(statement, pos);
            String child = statement.substring(pos + 1, closingPos);
            String result = evalParens(child).toString();
            String rest = statement.substring(closingPos + 1);
            String restResult = evalParens(result + rest).toString();
            String before = statement.substring(0, pos);
            return new Expression(before + restResult).eval();
        } else {
            return new Expression(statement).eval();
        }
    }

    public boolean eval(String statement) throws ParseException {
        char lastChar = statement.length() != 0 ? statement.charAt(statement.length() - 1) : '\0';
        if (lastChar != '.') {
            throw new ParseException("Statement improperly terminated", statement.length() - 1);
        }
        statement = chomp(statement);
        return evalParens(statement).eval();
    }
}
