import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {

    @ParameterizedTest
    @CsvSource({
            "5, 3, 1",
            "3, 5, -1",
            "4, 4, 0",
            "-5, -3, -1",
            "0, 0, 0"
    })
    @DisplayName("Test compare method with various inputs")
    public void testCompare(int a, int b, int expected) {
        assertEquals(expected, Comparator.compare(a, b));
    }

    @Test
    @DisplayName("Test when first number is greater")
    public void testFirstGreater() {
        assertEquals(1, Comparator.compare(10, 5));
    }

    @Test
    @DisplayName("Test when first number is less")
    public void testFirstLess() {
        assertEquals(-1, Comparator.compare(5, 10));
    }

    @Test
    @DisplayName("Test when numbers are equal")
    public void testEqual() {
        assertEquals(0, Comparator.compare(7, 7));
    }
}