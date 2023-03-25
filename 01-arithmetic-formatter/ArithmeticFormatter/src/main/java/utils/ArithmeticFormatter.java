package utils;

public class ArithmeticFormatter {
    public static String arithmeticArranger(String[] problems, boolean showResults){

//        check if the problems are more then 5
        if (problems.length > 5){
            return "Error: Too many problems.";
        }

        
//        check if are passed only addiction or subtraction
        for (String problem :
                problems) {
            String[] splitProblem = problem.split(" ");
            //        check if are passed only addiction or subtraction and if number are made of only digits
            if (!(splitProblem[1].equals("+") || splitProblem[1].equals("-"))){
                return "Error: Operator must be '+' or '-'.";
            } else if (!splitProblem[0].matches("\\d+") || !splitProblem[2].matches("\\d+")) {
                return "Error: Numbers must only contain digits.";
            } else if (splitProblem[0].length() > 4 || splitProblem[2].length() > 4) {
                return "Error: Numbers cannot be more than four digits.";
            }

        }

//        check if the operands are made of only digits
        return "test";
    }

    public static String arithmeticArranger(String[] problems) {
        return arithmeticArranger(problems, false);
    }

}
