package test;
import main.Triangle;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.*;

public class TriangleTest {

    @Test
    public void testAreaValid() {
        assertEquals(Triangle.calculate(5, 3), 7.5, 0.001);
    }

    @DataProvider(name = "areaData")
    public Object[][] areaData() {
        return new Object[][] {
                {4.0, 6.0, 12.0},
                {7.0, 2.0, 7.0},
                {3.5, 4.0, 7.0},
                {10.0, 5.0, 25.0}
        };
    }

    @Test(dataProvider = "areaData")
    public void testAreaParameterized(double base, double height, double expected) {
        assertEquals(Triangle.calculate(base, height), expected, 0.001);
    }

    @DataProvider(name = "invalidData")
    public Object[][] invalidData() {
        return new Object[][] {
                {0.0, 5.0},
                {5.0, 0.0},
                {-1.0, 5.0},
                {5.0, -3.0}
        };
    }

    @Test(dataProvider = "invalidData", expectedExceptions = IllegalArgumentException.class)
    public void testInvalidParameters(double base, double height) {
        Triangle.calculate(base, height);
    }
}