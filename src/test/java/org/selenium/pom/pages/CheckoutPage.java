package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CheckoutPage extends BasePage {
    private final By firstNameFld = By.id("billing_first_name");
    private final By lastNameFld = By.id("billing_last_name");
    private final By addressLineOneFld = By.id("billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By billingPostcodeFld = By.id("billing_postcode");
    private final By billingEmailFld = By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");

    private final By showLogin = By.cssSelector(".showlogin");
    private final By userNameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("login");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstName) {
        driver.findElement(firstNameFld).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddressLineOne(String addressLineOne) {
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity) {
        driver.findElement(billingCityFld).sendKeys(billingCity);
        return this;
    }

    public CheckoutPage enterBillingPostcode(String billingPostcode) {
        driver.findElement(billingPostcodeFld).sendKeys(billingPostcode);
        return this;
    }

    public CheckoutPage enterbillingEmail(String billingEmail) {
        driver.findElement(billingEmailFld).sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage clickPlaceOrder() {
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getSuccessNotice() {
        return driver.findElement(successNotice).getText();
    }

    public CheckoutPage clickShowLogin() {
        driver.findElement(showLogin).click();
        return this;
    }

    public CheckoutPage enterUserName(String userName) {
        driver.findElement(userNameFld).sendKeys(userName);
        return this;
    }

    public CheckoutPage enterPassword(String password) {
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }

    public CheckoutPage clickLogin() {
        driver.findElement(loginBtn).click();
        return this;
    }
}
