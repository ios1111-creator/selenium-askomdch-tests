package org.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.pom.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends BaseTest {
    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com");
        driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(
                ".woocommerce-products-header__title.page-title")).getText(), "Search results: “Blue”");
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(), "Blue Shoes");
        driver.findElement(By.cssSelector(".checkout-button")).click();
        driver.findElement(By.id("billing_first_name")).sendKeys("user");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisko");
        driver.findElement(By.id("billing_city")).sendKeys("San Francisko");

        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_email")).sendKeys("aaaa@gma.com");
        Thread.sleep(5000);
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(5000);
        Assert.assertEquals(
                driver.findElement(
                        By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received"))
                        .getText(), "Thank you. Your order has been received.");
        driver.quit();
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com");
        driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(
                ".woocommerce-products-header__title.page-title")).getText(), "Search results: “Blue”");
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(), "Blue Shoes");
        driver.findElement(By.cssSelector(".checkout-button")).click();
        driver.findElement(By.cssSelector(".showlogin")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("demouser2");
        driver.findElement(By.id("password")).sendKeys("demopwd");
        driver.findElement(By.name("login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(5000);
        Assert.assertEquals(
                driver.findElement(
                        By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received"))
                        .getText(), "Thank you. Your order has been received.");
        driver.quit();
    }
}
