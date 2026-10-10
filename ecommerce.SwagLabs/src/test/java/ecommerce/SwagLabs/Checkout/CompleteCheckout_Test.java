package ecommerce.SwagLabs.Checkout;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class CompleteCheckout_Test extends BaseClass {

    @Test(groups = {"E2E", "Positive", "System"})
    public void completeCheckout_Test() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        LoginPage lp = new LoginPage(driver);

        // 1. Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("user-name"))).sendKeys("standard_user");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("password"))).sendKeys("secret_sauce");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("login-button"))).click();

        Thread.sleep(1000);

        // 2. Verify Products page
        wait.until(ExpectedConditions.urlContains("inventory.html"));

        Reporter.log("Login successful", true);

        // 3. Add Sauce Labs Backpack
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("add-to-cart-sauce-labs-backpack"))).click();

        Thread.sleep(1000);

        Reporter.log("Sauce Labs Backpack added to cart", true);

        // 4. Open cart
        wait.until(ExpectedConditions.elementToBeClickable(
                By.className("shopping_cart_link"))).click();

        Thread.sleep(1000);

        // 5. Verify Cart page
        wait.until(ExpectedConditions.urlContains("cart.html"));

        Reporter.log("Cart page opened", true);

        // 6. Click Checkout
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("checkout"))).click();

        Thread.sleep(1000);

        // 7. Enter checkout information
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("first-name"))).sendKeys("Rakshitha");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("last-name"))).sendKeys("Test");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("postal-code"))).sendKeys("560001");

        Thread.sleep(1000);

        // 8. Click Continue
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("continue"))).click();

        Thread.sleep(1000);

        // 9. Verify Overview page
        wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));

        Reporter.log("Checkout Overview page displayed", true);

        // 10. Click Finish
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("finish"))).click();

        Thread.sleep(1500);

        // 11. Verify successful order
        String confirmation = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("complete-header")))
                .getText();

        Assert.assertEquals(
                confirmation,
                "Thank you for your order!",
                "Order confirmation message is incorrect");

        Reporter.log("Order completed successfully", true);
    }
}