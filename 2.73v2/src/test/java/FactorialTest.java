
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void factorialOfZeroShouldBeOne() {
        assertEquals(1, Factorial.calculate(0));
    }

    @Test
    void factorialOfFiveShouldBe120() {
        assertEquals(120, Factorial.calculate(5));
    }

    @Test
    void factorialOfTenShouldBe3628800() {
        assertEquals(3628800, Factorial.calculate(10));
    }

    @Test
    void negativeNumberShouldThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Factorial.calculate(-1)
        );
    }
}