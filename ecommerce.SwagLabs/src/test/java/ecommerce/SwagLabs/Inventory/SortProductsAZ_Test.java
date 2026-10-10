
package ecommerce.SwagLabs.Inventory;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.LoginPage;
import ecommerce.SwagLabs.objRepo.ProductPage;

public class SortProductsAZ_Test extends BaseClass {

    @Test(groups = {"Functional", "Positive"})
    public void sortProductsAZ_Test() {

        // Open SauceDemo login page
        driver.get("https://www.saucedemo.com/");

        // Login with valid credentials
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");

        // Verify login
        Assert.assertTrue(
            driver.getCurrentUrl().contains("inventory.html"),
            "Login failed"
        );

        // Sort products from A to Z
        ProductPage pp = new ProductPage(driver);
        pp.selectingSorting("Name (A to Z)");

        // Verify sorting option
        String selectedValue = driver.findElement(
            By.className("product_sort_container")
        ).getAttribute("value");

        Assert.assertEquals(
            selectedValue,
            "az",
            "A to Z sorting was not selected"
        );

        Reporter.log("Products sorted from A to Z successfully", true);
    }
}
