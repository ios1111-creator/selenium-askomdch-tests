package org.selenium;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends BaseTest {
    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com");

        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.navigateToStoreUsingMenu();
        //mamy dostep do StoryPage na tym obiekcie   storePage.enterTextInSearchFld("Blue").
//        storePage.enterTextInSearchFld("Blue").clickSearchBtn();
        storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCardBtn("Blue Shoes");
        Thread.sleep(5000);
        CartPage cardPage = storePage.clickViewCart();
        Assert.assertEquals(cardPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cardPage.clickCheckoutPage();
        checkoutPage.
                enterFirstName("user").
                enterLastName("user").
                enterAddressLineOne("San Francisko").
                enterBillingCity("San Francisko").
                enterBillingPostcode("94188").
                enterbillingEmail("aaaa@gma.com");
        Thread.sleep(5000);
        checkoutPage.clickPlaceOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getSuccessNotice(), "Thank you. Your order has been received.");
        driver.quit();
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com");
        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.navigateToStoreUsingMenu();
        storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCardBtn("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.clickCheckoutPage();
        checkoutPage.clickShowLogin();
        Thread.sleep(3000);
        checkoutPage.enterUserName("demouser2");
        checkoutPage.enterPassword("demopwd");

        checkoutPage.clickLogin();
        Thread.sleep(3000);

        checkoutPage.clickPlaceOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getSuccessNotice(), "Thank you. Your order has been received.");
        driver.quit();
    }
}
