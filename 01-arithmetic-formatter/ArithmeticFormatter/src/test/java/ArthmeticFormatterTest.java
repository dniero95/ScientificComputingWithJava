import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static utils.ArithmeticFormatter.arithmeticArranger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArthmeticFormatterTest {


    @Test
    public void testNumberOfProblems() {
        String[] problems = {"32 - 698", "3801 - 8002", "45 + 43", "123 + 49", "13 + 49", "123 + 4"};
        String output = arithmeticArranger(problems);
        assertEquals("Error: Too many problems.", output, "Was expecting:\nError: Too many problems.");
    }

    @Test
    public void testOperator() {
        String[] problems = {"32 * 698", "3801 - 8002"};
        String output = arithmeticArranger(problems);
        assertEquals("Error: Operator must be '+' or '-'.", output, "Was expecting an error");
    }


    @Test
    public void testNumbersLength() {
        String[] problems = {"3801 - 8000002"};
        String output = arithmeticArranger(problems);
        assertEquals("Error: Numbers cannot be more than four digits.", output, "Was expecting an error");
    }

    @Test
    public void testTwoProblems1() {
        String[] problems = {"3801 - 2", "123 + 49"};
        String output = arithmeticArranger(problems);
        String expected = """
                  3801      123\n
                -    2    +  49\n
                ------    -----
                """;
        assertEquals(expected, output, "Was expecting");
    }

    @Test
    public void testTwoProblems2() {
        String[] problems = {"1 + 2", "1 - 9380"};
        String output = arithmeticArranger(problems);
        String expected = """
                  3801      123\n
                -    2    +  49\n
                ------    -----
                """;
        assertEquals(expected, output, "Was expecting");
    }

    @Test
    public void testFourProblems() {
        String[] problems = {"3 + 855", "3801 - 2", "45 + 43", "123 + 49"};
        String output = arithmeticArranger(problems);
        String expected = """
                    3      3801      45      123\n
                + 855    -    2    + 43    +  49\n
                -----    ------    ----    -----
                """;
        assertEquals(expected, output, "Expected different output when calling \"arithmeticArranger()\" with [\"3 + 855\", \"3801 - 2\", \"45 + 43\", \"123 + 49\"]");
    }

    @Test
    public void testFiveProblems() {
        String[] problems = {"11 + 4", "3801 - 2999", "1 + 2", "123 + 49", "1 - 9380"};
        String output = arithmeticArranger(problems);
        String expected = """
                  11      3801      1      123         1\n
                +  4    - 2999    + 2    +  49    - 9380\n
                ----    ------    ---    -----    ------
                """;
        assertEquals(expected, output, "Expected different output when calling \"arithmeticArranger()\" with [\"11 + 4\", \"3801 - 2999\", \"1 + 2\", \"123 + 49\", \"1 - 9380\"]");
    }

    @Test
    public void testTooManyProblems() {
        String[] problems = {"44 + 815", "909 - 2", "45 + 43", "123 + 49",
                "888 + 40", "653 + 87"};
        String output = arithmeticArranger(problems);
        String expected = "Error: Too many problems.";
        assertEquals(expected, output, "Expected calling \"arithmeticArranger()\" with more than five problems to return \"Error: Too many problems.\"");
    }

    @Test
    public void testIncorrectOperator() {
        String[] problems = {"3 / 855", "3801 - 2", "45 + 43", "123 + 49"};
        String output = arithmeticArranger(problems);
        String expected = "Error: Operator must be \"+\" or \"-\".";
        assertEquals(expected, output, "Expected calling \"arithmeticArranger()\" with a problem that uses the \"/\" operator to return \"Error: Operator must be '+' or '-'.\"");
    }

    @Test
    public void testTooManyDigits() {
        String[] problems = {"24 + 85215", "3801 - 2", "45 + 43", "123 + 49"};
        String output = arithmeticArranger(problems);
        String expected = "Error: Numbers cannot be more than four digits.";
        assertEquals(expected, output, " Expected calling \"arithmeticArranger()\" with a problem that has a number over 4 digits long to return \"Error: Numbers cannot be more than four digits.\"");
    }
    @Test
    public void testOnlyDigits() {
        String[] problems = {"98 + 3g5", "3801 - 2", "45 + 43", "123 + 49"};
        String output = arithmeticArranger(problems);
        String expected = "Error: Numbers must only contain digits.";
        assertEquals(expected, output, "Expected calling \"arithmeticArranger()\" with a problem that contains a letter character in the number to return \"Error: Numbers must only contain digits.\"");
    }

    @Test
    public void testTwoProblemsWithSolutions() {
        String[] problems = {"3 + 855", "988 + 40"};
        String output = arithmeticArranger(problems, true);
        String expected = """
                            3      988\n
                        + 855    +  40\n
                        -----    -----\n
                          858     1028""";
        assertEquals(expected, output, "Expected solutions to be correctly displayed in output when calling \"arithmetic_arranger()\" with [\"3 + 855\", \"988 + 40\"] and a second argument of true.");
    }

    @Test
    public void testFiveProblemsWithSolutions() {
        String[] problems = {"32 - 698", "1 - 3801", "45 + 43", "123 + 49", "988 + 40"};
        String output = arithmeticArranger(problems, true);
        String expected = """
                   32         1      45      123      988\n
                - 698    - 3801    + 43    +  49    +  40\n
                -----    ------    ----    -----    -----\n
                 -666     -3800      88      172     1028""";
        assertEquals(expected, output, "Expected solutions to be correctly displayed in output when calling \"arithmetic_arranger()\" with five arithmetic problems and a second argument of `True`.");
    }
}
