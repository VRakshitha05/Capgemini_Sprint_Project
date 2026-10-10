
package ecommerce.SwagLabs.Cart;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.HomePage;
import ecommerce.SwagLabs.objRepo.LoginPage;
import ecommerce.SwagLabs.objRepo.CartPage;

public class ContinueShopping_Test extends BaseClass {

    @Test(groups = {"Functional", "Positive"})
    public void continueShopping_Test() {

        LoginPage lp = new LoginPage(driver);

        lp.login("standard_user", "secret_sauce");

        HomePage hp = new HomePage(driver);
        hp.getCart().click();

        CartPage cp = new CartPage(driver);
        cp.getContinueS().click();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory")
        );

        Reporter.log("Continue Shopping navigated to inventory successfully", true);
    }
}