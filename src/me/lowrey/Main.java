package me.lowrey;

public class Main {

    public static void main(String[] args) throws Exception {
        //new LogicCalculatorTests().RunAll();
        try {
            boolean result = new LogicCalculator().eval(args[0]);
            if (result) {
                System.out.println("TRUE");
            } else {
                System.out.println("FALSE");
            }
        }
        catch (Exception e){
            
        }
    }
}
