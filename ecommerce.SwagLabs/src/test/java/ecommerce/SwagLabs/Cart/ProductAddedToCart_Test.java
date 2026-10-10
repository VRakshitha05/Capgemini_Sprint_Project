package ecommerce.SwagLabs.Cart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class ProductAddedToCart_Test extends BaseClass {

    @Test(groups = {"Functional", "Positive"})
    public void productAddedToCart_Test() {

        LoginPage lp = new LoginPage(driver);

        lp.login("standard_user", "secret_sauce");

        String productName = "Sauce Labs Backpack";

        driver.findElement(
                By.xpath("//div[text()='" + productName +
                "']/ancestor::div[@class='inventory_item_description']//button")
        ).click();

        Assert.assertEquals(
                driver.findElement(By.className("shopping_cart_badge")).getText(),
                "1"
        );

        Reporter.log("Product added to cart successfully", true);
    }
}