package org.example;

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

    public PaymentPopupPage verifyPopupData(String expectedPhone, String expectedSum) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentIframe));
        driver.switchTo().frame(driver.findElement(paymentIframe));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertTrue("Всплывающее окно не содержит сумму: " + expectedSum, bodyText.contains(expectedSum));
        assertTrue("Всплывающее окно не содержит номер телефона: " + expectedPhone, bodyText.contains(expectedPhone));
        driver.switchTo().defaultContent();
        return this;
    }
}