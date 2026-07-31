package test;
import main.Comparator;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.*;

public class ComparatorTest {

    @DataProvider(name = "comparisonData")
    public Object[][] comparisonData() {
        return new Object[][] {
                {5, 3, 1},
                {3, 5, -1},
                {4, 4, 0},
                {-5, -3, -1},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "comparisonData")
    public void testCompare(int a, int b, int expected) {
        assertEquals(Comparator.compare(a, b), expected);
    }

    @Test
    public void testFirstGreater() {
        assertEquals(Comparator.compare(10, 5), 1);
    }

    @Test
    public void testFirstLess() {
        assertEquals(Comparator.compare(5, 10), -1);
    }

    @Test
    public void testEqual() {
        assertEquals(Comparator.compare(7, 7), 0);
    }
}
