package org.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys(Keys.ENTER);
//        driver.findElement(By.cssSelector("button[value='Search']")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title"))
                .getText(), "Search results: “Blue”");

        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(), "Blue Shoes");

        driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("San");
        driver.findElement(By.id("billing_city")).sendKeys("San");
        driver.findElement(By.id("billing_postcode")).sendKeys("12-123");
        driver.findElement(By.id("billing_email")).sendKeys("demo@gmail.com");
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received"))
                .getText(), "Thank you. Your order has been received.");
        driver.close();
    }

}
