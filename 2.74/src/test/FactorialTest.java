package test;

import main.Factorial;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testFactorialZero() {
        assertEquals(Factorial.calculate(0), 1);
    }

    @Test
    public void testFactorialOne() {
        assertEquals(Factorial.calculate(1), 1);
    }

    @Test
    public void testFactorialFive() {
        assertEquals(Factorial.calculate(5), 120);
    }

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][] {
                {2, 2L},
                {3, 6L},
                {4, 24L},
                {6, 720L},
                {7, 5040L}
        };
    }

    @Test(dataProvider = "factorialData")
    public void testFactorialParameterized(int input, long expected) {
        assertEquals(Factorial.calculate(input), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Factorial.calculate(-5);
    }
}