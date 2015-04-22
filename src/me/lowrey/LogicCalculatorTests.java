package me.lowrey;

import java.text.ParseException;

/**
 * Created by lowreybr on 1/14/2015.
 */
public class LogicCalculatorTests {
    private final LogicCalculator logicCalc;

    public LogicCalculatorTests(){
        this.logicCalc = new LogicCalculator();
    }

    public void RunAll() throws Exception {
        singleFalseTest();
        singleTrueTest();
        emptyStatementTest();
        periodOnlyTest();
        orTest();
        andTest();
        notTest();
        multiTest();
        parensTest();
    }

    private void parensTest() throws Exception {
        if(logicCalc.eval("(FALSE OR FALSE).") != false){
            throw new Exception("Test failed");
        }
        if(logicCalc.eval("(((FALSE OR FALSE))).") != false){
            throw new Exception("Test failed");
        }
        if(logicCalc.eval("(NOT FALSE) OR FALSE.") != true){
            throw new Exception("Test failed");
        }
        if(logicCalc.eval("(FALSE OR FALSE) OR (TRUE OR FALSE).") != true){
            throw new Exception("Test failed");
        }
        if(logicCalc.eval("FALSE OR (TRUE AND FALSE) OR NOT TRUE.") != false){
            throw new Exception("Test failed");
        }
    }

    private void multiTest() throws Exception {
        if(logicCalc.eval("FALSE OR TRUE AND FALSE OR NOT TRUE.") != false){
            throw new Exception("Test failed");
        }
        if(logicCalc.eval("FALSE AND TRUE OR TRUE AND TRUE OR NOT TRUE.") != true){
            throw new Exception("Test failed");
        }
    }

    private void notTest() throws Exception {
        if(logicCalc.eval("NOT TRUE.") != false){
            throw new Exception("Test failed");
        }
    }

    private void andTest() throws Exception {
        if(logicCalc.eval("TRUE AND FALSE.") != false){
            throw new Exception("Test failed");
        }
    }

    private void orTest() throws Exception {
        if(logicCalc.eval("TRUE OR FALSE.") != true){
            throw new Exception("Test failed");
        }
    }

    private void singleFalseTest() throws Exception {
        if(logicCalc.eval("FALSE.") != false){
            throw new Exception("Test failed");
        }
    }

    private void singleTrueTest() throws Exception {
        if(logicCalc.eval("TRUE.") != true){
            throw new Exception("Test failed");
        }
    }

    private void emptyStatementTest() throws ParseException {
        try {
            logicCalc.eval("");
        }
        catch (ParseException e){  }
    }

    private void periodOnlyTest() throws ParseException {
        try {
            logicCalc.eval(".");
        }
        catch (ParseException e){  }
    }
}
