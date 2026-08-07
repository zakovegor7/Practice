
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void additionShouldWorkCorrectly() {
        assertEquals(8, Calculator.add(5, 3));
    }

    @Test
    void subtractionShouldWorkCorrectly() {
        assertEquals(2, Calculator.subtract(5, 3));
    }

    @Test
    void multiplicationShouldWorkCorrectly() {
        assertEquals(15, Calculator.multiply(5, 3));
    }

    @Test
    void divisionShouldWorkCorrectly() {
        assertEquals(2, Calculator.divide(6, 3));
    }

    @Test
    void divisionByZeroShouldThrowException() {
        assertThrows(
                ArithmeticException.class,
                () -> Calculator.divide(10, 0)
        );
    }
}
