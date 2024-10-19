

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    public void destroy() {
        stringCalculator = null;
    }

    @Test
    @DisplayName("Testing only one number")
    public void testOnlyOneNumber() {
        assertEquals(9, stringCalculator.add("9"));
    }

    @Test
    @DisplayName("Test with empty string")
    public void testWithEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    @DisplayName("Testing with Negative & Positive mixed Number")
    public void testingWithNegativeAndPostiveNumber() {
        try {
            stringCalculator.add("-3,9");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negative numbers are not allowed -3");
        }
        try {
            stringCalculator.add("1,-8,-4,7");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negative numbers are not allowed -8,-4");
        }
    }

    @Test
    @DisplayName("Testing with  Multiple Numbers")
    public void testAddingMultipleNum() {
        assertEquals(13, stringCalculator.add("5,8"));
    }

    @Test
    @DisplayName("Testing with Other Delimiter")
    public void testingWithOtherDelimiter() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    @DisplayName("Testing With  Over Thousand")
    public void testWithOverThousand() {
        assertEquals(10, stringCalculator.add("1000,10"));
    }

    @Test
    @DisplayName("Testing with New Line")
    public void testingWithNewLine() {
        assertEquals(16, stringCalculator.add("8\n1,5\n2"));
    }
}
