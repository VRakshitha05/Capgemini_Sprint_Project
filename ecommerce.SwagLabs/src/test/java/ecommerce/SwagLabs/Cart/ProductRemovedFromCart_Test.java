package ecommerce.SwagLabs.Cart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.HomePage;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class ProductRemovedFromCart_Test extends BaseClass {

    @Test(groups = {"Functional", "Positive"})
    public void productRemovedFromCart_Test() throws Exception {

        LoginPage lp = new LoginPage(driver);

        lp.login("standard_user", "secret_sauce");

        String productName = "Sauce Labs Backpack";

        driver.findElement(
                By.xpath("//div[text()='" + productName +
                "']/ancestor::div[@class='inventory_item_description']//button")
        ).click();

        HomePage hp = new HomePage(driver);
        hp.getCart().click();
        Thread.sleep(3000);
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        Assert.assertTrue(
                driver.findElements(By.className("cart_item")).isEmpty()
        );

        Reporter.log("Product removed from cart successfully", true);
    }
}