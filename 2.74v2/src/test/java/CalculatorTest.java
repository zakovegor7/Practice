
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    @DataProvider(name = "additionData")
    public Object[][] additionData() {
        return new Object[][] {
                {2, 3, 5},
                {-1, 1, 0},
                {0, 0, 0},
                {-5, -3, -8}
        };
    }

    @Test(dataProvider = "additionData")
    public void testAdd(int a, int b, int expected) {
        assertEquals(Calculator.add(a, b), expected);
    }

    @DataProvider(name = "subtractionData")
    public Object[][] subtractionData() {
        return new Object[][] {
                {5, 3, 2},
                {1, 1, 0},
                {-5, -3, -2},
                {10, 7, 3}
        };
    }

    @Test(dataProvider = "subtractionData")
    public void testSubtract(int a, int b, int expected) {
        assertEquals(Calculator.subtract(a, b), expected);
    }

    @DataProvider(name = "multiplicationData")
    public Object[][] multiplicationData() {
        return new Object[][] {
                {4, 3, 12},
                {-2, 3, -6},
                {0, 5, 0},
                {-4, -3, 12}
        };
    }

    @Test(dataProvider = "multiplicationData")
    public void testMultiply(int a, int b, int expected) {
        assertEquals(Calculator.multiply(a, b), expected);
    }

    @DataProvider(name = "divisionData")
    public Object[][] divisionData() {
        return new Object[][] {
                {10, 2, 5.0},
                {7, 2, 3.5},
                {-6, 3, -2.0},
                {15, 4, 3.75}
        };
    }

    @Test(dataProvider = "divisionData")
    public void testDivide(int a, int b, double expected) {
        assertEquals(Calculator.divide(a, b), expected, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        Calculator.divide(5, 0);
    }
}
