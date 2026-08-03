import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    @Test
    public void testBlockTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.mts.by/");

            try {
                driver.findElement(By.xpath("//button[contains(text(), 'Принять')]")).click();
                Thread.sleep(3000);
            } catch (Exception ignored) {}

            // Проверяем HTML всей страницы (регистронезависимо)
            String pageSource = driver.getPageSource().toLowerCase();

            assertThat(pageSource)
                    .as("Страница должна содержать 'онлайн пополнение'")
                    .contains("онлайн пополнение");

            System.out.println(" Текст 'онлайн пополнение' найден на странице");

        } finally {
            driver.quit();
        }
    }
}