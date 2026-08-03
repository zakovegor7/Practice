import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentTest {

    @Test
    public void testBlockTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.mts.by/");

            checkPaymentLogos(driver);

        } finally {
            driver.quit();
        }
    }

    private void checkPaymentLogos(WebDriver driver) {

        WebElement payBlock = driver.findElement(By.className("pay"));

        List<WebElement> logos = payBlock.findElements(By.tagName("img"));

        System.out.println(" Найдено изображений в блоке: " + logos.size());

        assertThat(logos)
                .as("В блоке должны быть логотипы платежных систем")
                .isNotEmpty();

        System.out.println(" Логотипы платежных систем найдены");
    }
}