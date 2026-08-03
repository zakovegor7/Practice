import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkTest {

    @Test
    public void testMoreDetailsLink() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        try {

            driver.get("https://www.mts.by/");
            driver.manage().window().maximize();

            try {
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(), 'Принять')]")
                )).click();
                System.out.println("Кнопка 'Принять' нажата");
            } catch (Exception e) {
            }

            WebElement payBlock = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("pay"))
            );


            WebElement moreLink = payBlock.findElement(
                    By.xpath(".//a[contains(text(), 'Подробнее о сервисе')]")
            );

            String linkUrl = moreLink.getAttribute("href");
            System.out.println(" Ссылка: " + linkUrl);
            assertThat(linkUrl).isNotEmpty();

            String currentUrl = driver.getCurrentUrl();

            moreLink.click();
            System.out.println("Клик выполнен");

            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));

            String newUrl = driver.getCurrentUrl();
            System.out.println(" Новый URL: " + newUrl);
            assertThat(newUrl).isNotEqualTo(currentUrl);

            System.out.println(" Ссылка 'Подробнее о сервисе' работает!");

        } finally {
            driver.quit();
        }
    }
}