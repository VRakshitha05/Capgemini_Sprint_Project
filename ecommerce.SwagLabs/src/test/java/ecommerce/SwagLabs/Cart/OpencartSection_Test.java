package ecommerce.SwagLabs.Cart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class OpencartSection_Test extends BaseClass {

    @Test(groups = {"FT", "Pos"})
    public void openCartSection_Test() {

        // Step 1: Login
        LoginPage lp = new LoginPage(driver);

        lp.login("standard_user", "secret_sauce");

        Reporter.log("User logged in successfully", true);

        // Step 2: Click Cart icon
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        Reporter.log("Cart section opened successfully", true);

        // Step 3: Verify Cart page
        Assert.assertTrue(
                driver.getCurrentUrl().contains("cart.html"),
                "Cart page was not opened"
        );

        Reporter.log("Cart page verified successfully", true);
    }
}