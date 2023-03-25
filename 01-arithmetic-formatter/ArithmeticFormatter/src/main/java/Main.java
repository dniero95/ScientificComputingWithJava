
import static utils.ArithmeticFormatter.arithmeticArranger;

public class Main {
    public static void main(String[] args) {

        String[] problems = {"32 - 698", "3801 - 8002", "45 + 43", "123 + 49"};

//        this show the result
        System.out.println(arithmeticArranger(problems, true));

//        this one doesn't
        System.out.println(arithmeticArranger(problems));
    }
}
