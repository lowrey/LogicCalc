package me.lowrey.parsing;

import java.util.ArrayList;

/**
 * Created by lowreybr on 1/14/2015.
 */
public abstract class Operator extends Token {
    protected Token token1;
    protected Token token2;

    public void setOperatees(Token t1, Token t2) {
        token1 = t1;
        token2 = t2;
    }

    @Override
    public abstract boolean eval();

    public void setOperatees(Token token) {
        token1 = token;
    }
}
