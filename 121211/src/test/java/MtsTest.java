import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MtsTest {
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
            driver.quit();
        }
    }

    @Test
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
                .fillFormAndSubmit("297777777", "30", "test@test.by")
                .verifyPopupData("375297777777", "30.00");
    }
}