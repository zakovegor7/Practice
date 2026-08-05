
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MtsMainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By paymentBlockTitle = By.xpath("//*[contains(text(), 'Онлайн пополнение')]");
    private final By selectButton = By.cssSelector(".select__header");
    private final By selectList = By.cssSelector(".select__list");
    private final By formInputs = By.cssSelector(".pay__form input, .pay__wrapper input");
    private final By submitButton = By.xpath("//*[@id='pay-connection']/button");

    public MtsMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private List<WebElement> getVisibleInputs() {
        return driver.findElements(formInputs).stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
    }

    private WebElement getFirstVisibleInput() {
        return getVisibleInputs().get(0);
    }

    private WebElement getSumVisibleInput() {
        return getVisibleInputs().get(1);
    }

    private WebElement getEmailVisibleInput() {
        return getVisibleInputs().get(2);
    }

    @Step("Открыть главную страницу mts.by")
    public MtsMainPage openPage() {
        driver.get("https://mts.by");
        return this;
    }

    @Step("Принять cookies")
    public MtsMainPage acceptCookies() {
        ((JavascriptExecutor) driver).executeScript(
                "var cookies = document.querySelector('.cookie__wrapper, #btn-cookie-accept, [class*=\"cookie\"], .cookie'); if(cookies) cookies.remove();");
        sleep(500);
        return this;
    }

    @Step("Проскроллить к блоку онлайн-пополнения")
    public MtsMainPage scrollToPaymentBlock() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentBlockTitle));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", title);
        sleep(1000);
        return this;
    }

    @Step("Выбрать услугу: {serviceName}")
    public MtsMainPage selectService(String serviceName) {
        wait.until(ExpectedConditions.elementToBeClickable(selectButton)).click();
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(selectList));
        WebElement option = list.findElement(By.xpath(".//*[contains(text(), '" + serviceName + "')]"));
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
        sleep(2000);
        return this;
    }

    @Step("Проверить плейсхолдер первого поля: {expectedPlaceholder}")
    public MtsMainPage checkFirstFieldPlaceholder(String expectedPlaceholder) {
        assertEquals(expectedPlaceholder, getFirstVisibleInput().getAttribute("placeholder"));
        return this;
    }

    @Step("Проверить плейсхолдер поля суммы: {expectedPlaceholder}")
    public MtsMainPage checkSumFieldPlaceholder(String expectedPlaceholder) {
        assertEquals(expectedPlaceholder, getSumVisibleInput().getAttribute("placeholder"));
        return this;
    }

    @Step("Проверить плейсхолдер поля email: {expectedPlaceholder}")
    public MtsMainPage checkEmailFieldPlaceholder(String expectedPlaceholder) {
        assertEquals(expectedPlaceholder, getEmailVisibleInput().getAttribute("placeholder"));
        return this;
    }

    @Step("Заполнить форму (телефон: {phone}, сумма: {sum}, email: {email}) и отправить")
    public PaymentPopupPage fillFormAndSubmit(String phone, String sum, String email) {
        getFirstVisibleInput().sendKeys(phone);
        getSumVisibleInput().sendKeys(sum);
        getEmailVisibleInput().sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        sleep(5000);
        return new PaymentPopupPage(driver);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}