package me.lowrey.parsing;

/**
 * Created by lowreybr on 1/14/2015.
 */
public class NotOperator extends Operator {
    @Override
    public boolean eval() {
        return !token1.eval();
    }

    public String toString() {
        return "NOT";
    }
}
