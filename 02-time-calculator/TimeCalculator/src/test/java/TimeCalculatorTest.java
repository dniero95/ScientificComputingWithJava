import org.junit.jupiter.api.Test;

import static utils.TimeCalculator.addTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeCalculatorTest {


    @Test
    public void testSamePeriod() {
        String actual = addTime("3:30 PM", "2:12");
        String expected = "5:42 PM";
        String message = "Expected calling \"add_time()\" with \"3:30 PM\", \"2:12\" to return \"5:42 PM\"";
        assertEquals(actual, expected, message);
    }

    @Test
    public void testDifferentPeriod() {
        String actual = addTime("11:55 AM", "3:12");
        String expected = "3:07 PM";
        String message = "Expected calling \"add_time()\" with \"11:55 AM\", \"3:12\" to return \"3:07 PM";
        assertEquals(actual, expected, message);
    }

    @Test
    public void testNextDay() {
        String actual = addTime("9:15 PM", "5:30");
        String expected = "2:45 AM (next day)";
        String message = "Expected time to end with \"(next day)\" when it is the next day.";
        assertEquals(actual, expected, message);
    }

}

    @Test
    public void testPeriodChangeAtTwelve() {
        String actual = addTime("11:40 AM", "0:25");
        String expected = "12:05 PM";
        String message = "Expected period to change from AM to PM at 12:00";
        assertEquals(actual, expected, message);
    }

    @Test
    public void testTwentyFour() {

        String actual = addTime("2:59 AM", "24:00");
        String expected = "2:59 AM (next day)";
        String message = "Expected calling \"add_time()\" with \"2:59 AM\", \"24:00\" to return \"2:59 AM\"";
        assertEquals(actual, expected, message);
    }

    @Test
    public void testTwoDaysLater() {
        String actual = addTime("11:59 PM", "24:05");
        String expected = "12:04 AM (2 days later)";
        String message = "Expected calling \"add_time()\" with \"2:59 AM\", \"24:00\" to return \"2:59 AM\"";
        assertEquals(actual, expected, message);
    }

}
