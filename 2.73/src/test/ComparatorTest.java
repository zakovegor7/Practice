package test;

 import main.Comparator;
 import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {

    @Test
    void firstNumberShouldBeGreater() {
        assertEquals(1, Comparator.compare(10, 5));
    }

    @Test
    void firstNumberShouldBeLess() {
        assertEquals(-1, Comparator.compare(5, 10));
    }

    @Test
    void numbersShouldBeEqual() {
        assertEquals(0, Comparator.compare(5, 5));
    }
}