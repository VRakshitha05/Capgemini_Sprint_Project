package ecommerce.SwagLabs.Login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class UserLoginWithInvalidUsername_Test extends BaseClass {

    @Test(groups = {"Functional", "Negative"})
    public void userLoginWithInvalidUsername_Test() {

        LoginPage lp = new LoginPage(driver);

        lp.login("invalid_user", "secret_sauce");

        Assert.assertTrue(
                driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed()
        );

        Reporter.log("Invalid username rejected successfully", true);
    }
}