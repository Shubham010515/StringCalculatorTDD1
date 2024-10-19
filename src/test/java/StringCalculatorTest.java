

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
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    @DisplayName("Test with empty string")
    public void testWithEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }
}
