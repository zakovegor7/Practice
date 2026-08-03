import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class SubmitTest {

    @Test
    public void testCommunicationService() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.get("https://www.mts.by/");
            driver.manage().window().maximize();

            try {
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(), 'Принять')]")
                )).click();
                System.out.println(" Кнопка 'Принять' нажата");
            } catch (Exception e) {

            }

            // Вводим номер
            WebElement phoneInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone"))
            );
            phoneInput.clear();
            phoneInput.sendKeys("297777777");
            System.out.println("Введен номер: 297777777");

            Thread.sleep(1000);


            WebElement sumInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("connection-sum"))
            );
            sumInput.clear();
            sumInput.sendKeys("29");
            System.out.println("Введена сумма: 29");


            WebElement emailInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("connection-email"))
            );
            emailInput.clear();
            emailInput.sendKeys("zakovegor7@gmail.com");
            System.out.println("Введен email: zakovegor7@gmail.com");

            WebElement continueButton = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector("#pay-connection button[type='submit']")
                    )
            );

            Thread.sleep(500);

            Actions actions = new Actions(driver);
            actions.moveToElement(continueButton).click().perform();
            System.out.println("Кнопка 'ПРОДОЛЖИТЬ' нажата");

            Thread.sleep(1500);
            System.out.println("ТЕСТ ПРОЙДЕН!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
