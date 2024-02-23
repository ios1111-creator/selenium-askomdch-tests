package org.selenium.pom.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void startDriver() {
//        WebDriverManager.chromedriver().setup();
//        driver.get("https://askomdch.com");
        driver = new DriverManager().initializeDriver();
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
