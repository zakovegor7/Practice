import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;

@Epic("MTS.by")
@Feature("Онлайн пополнение")
public class MtsHomeworkTest {
    private WebDriver driver;
    private MtsMainPage mainPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        mainPage = new MtsMainPage(driver);
        mainPage.openPage()
                .acceptCookies();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            attachScreenshot();
            driver.quit();
        }
    }

    private void attachScreenshot() {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Финальный скриншот теста", new ByteArrayInputStream(screenshot));
    }

    @Test
    @Story("Проверка плейсхолдеров и оплаты услуг связи")
    public void testMtsHomework() {
        mainPage.scrollToPaymentBlock();
        mainPage.checkFirstFieldPlaceholder("Номер телефона")
                .checkSumFieldPlaceholder("Сумма")
                .checkEmailFieldPlaceholder("E-mail для отправки чека");
        mainPage.selectService("Домашний интернет")
                .checkFirstFieldPlaceholder("Номер абонента")
                .checkSumFieldPlaceholder("Сумма")
                .checkEmailFieldPlaceholder("E-mail для отправки чека");
        mainPage.selectService("Рассрочка")
                .checkFirstFieldPlaceholder("Номер счета на 44")
                .checkSumFieldPlaceholder("Сумма")
                .checkEmailFieldPlaceholder("E-mail для отправки чека");
        mainPage.selectService("Задолженность")
                .checkFirstFieldPlaceholder("Номер счета на 2073")
                .checkSumFieldPlaceholder("Сумма")
                .checkEmailFieldPlaceholder("E-mail для отправки чека");
        mainPage.selectService("Услуги связи")
                .fillFormAndSubmit("297777777", "12.22", "zakovegor7@gmail.com")
                .verifyPopupData("375297777777", "12.22");
    }
}