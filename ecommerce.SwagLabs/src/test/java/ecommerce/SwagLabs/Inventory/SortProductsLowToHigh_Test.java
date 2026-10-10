package ecommerce.SwagLabs.Inventory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.LoginPage;
import ecommerce.SwagLabs.objRepo.ProductPage;

public class SortProductsLowToHigh_Test extends BaseClass {

    @Test(groups = {"Functional", "Positive"})
    public void sortProductsLowToHigh_Test() {

        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");

        ProductPage pp = new ProductPage(driver);

        pp.selectingSorting("Price (low to high)");

        Reporter.log("Products sorted by price low to high successfully", true);
    }
}