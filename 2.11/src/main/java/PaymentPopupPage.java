import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PaymentPopupPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By paymentIframe = By.xpath("//iframe[contains(@class, 'bepaid') or contains(@src, 'checkout')]");

    public PaymentPopupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Step("Проверить данные в попапе оплаты (телефон: {expectedPhone}, сумма: {expectedSum})")
    public PaymentPopupPage verifyPopupData(String expectedPhone, String expectedSum) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentIframe));
        driver.switchTo().frame(driver.findElement(paymentIframe));

        // Ждём, пока контент внутри iframe реально прогрузится (не только сам iframe станет видимым)
        wait.until(d -> !d.findElement(By.tagName("body")).getText().trim().isEmpty());

        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println("=== Содержимое попапа оплаты ===");
        System.out.println(bodyText);
        System.out.println("=================================");

        assertTrue("Всплывающее окно не содержит сумму: " + expectedSum + ". Реальный текст попапа выведен в консоль выше.",
                bodyText.contains(expectedSum));
        assertTrue("Всплывающее окно не содержит номер телефона: " + expectedPhone,
                bodyText.contains(expectedPhone));

        driver.switchTo().defaultContent();
        return this;
    }
}