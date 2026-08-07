import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void areaShouldBeCalculatedCorrectly() {
        assertEquals(10.0, Triangle.calculate(5, 4));
    }

    @Test
    void areaWithDecimalValuesShouldBeCalculatedCorrectly() {
        assertEquals(7.5, Triangle.calculate(3, 5));
    }

    @Test
    void zeroBaseShouldThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Triangle.calculate(0, 5)
        );
    }

    @Test
    void negativeHeightShouldThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Triangle.calculate(5, -2)
        );
    }
}