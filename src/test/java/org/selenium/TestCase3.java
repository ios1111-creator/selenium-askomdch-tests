package org.selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestCase3 {
    @Test
    public void EbaySearchResultPriceValidation() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.pl/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.id("gh-ac")).sendKeys("One plus 6t");
        driver.findElement(By.id("gh-ac")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,300)");
        Assert.assertEquals(driver.findElement(By.cssSelector("li[id='item59c8c7b8ec'] span[class='s-item__price'] span[class='ITALIC']"))
                .getText(), "1 722,97 zł");
        try {
            driver.findElement(By.name("fake")).click();
        } catch (NoSuchElementException e) {
            System.out.println("element is not found");
            System.out.println("hello");
        }
        System.out.println("Hello");

        driver.close();
    }

    @Test
    public void testAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions act = new Actions(driver);
        driver.get("https://only-testing-blog.blogspot.com/");
        WebElement btnElement = driver.findElement(By.cssSelector("button[ondblclick='myFunction()']"));
        act.doubleClick(btnElement).perform();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(driver.switchTo().alert().getText(), "Press 'OK' or 'Cancel' button!");
        System.out.println(alertMessage);
        Thread.sleep(3000);
        alert.accept();
        driver.close();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        WebElement SourceElement = driver.findElement(By.id("draggable"));
        WebElement TargetElement = driver.findElement(By.id("droppable"));
        Actions act = new Actions(driver);
        Thread.sleep(3000);
        act.dragAndDrop(SourceElement, TargetElement).build().perform();
//        act.clickAndHold(SourceElement).moveToElement(TargetElement).release().build().perform();
        Thread.sleep(3000);

        driver.quit();
    }

}
