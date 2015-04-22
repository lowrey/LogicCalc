package me.lowrey.parsing;

import java.util.ArrayList;

/**
 * Created by lowreybr on 1/14/2015.
 */
public class OrOperator extends Operator {
    @Override
    public boolean eval() {
        return token1.eval() || token2.eval();
    }

    public String toString() {
        return "OR";
    }
}
