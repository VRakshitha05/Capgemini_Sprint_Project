package ecommerce.SwagLabs.Inventory;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class VerifyProductsDisplayed_Test extends BaseClass {

    @Test(groups = {"Functional", "Positive"})
    public void verifyProductsDisplayed_Test() {

        LoginPage lp = new LoginPage(driver);

        lp.login("standard_user", "secret_sauce");

        int productCount =
                driver.findElements(By.className("inventory_item")).size();

        Assert.assertTrue(productCount > 0);

        Reporter.log("Products are displayed successfully", true);
    }
}