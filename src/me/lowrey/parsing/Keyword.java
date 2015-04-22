package me.lowrey.parsing;

/**
 * Created by lowreybr on 1/14/2015.
 */
public class Keyword extends Token{
    private final String token;

    public Keyword(String token) {
        this.token = token;
    }

    @Override
    public boolean eval() {
        if (token.equals("TRUE")) {
            return true;
        }
        return false;
    }

    public String toString() {
        return token;
    }
}
