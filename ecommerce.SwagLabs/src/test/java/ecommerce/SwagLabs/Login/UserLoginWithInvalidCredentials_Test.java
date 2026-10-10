package ecommerce.SwagLabs.Login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class UserLoginWithInvalidCredentials_Test extends BaseClass {

    @Test(groups = {"Functional", "Negative"})
    public void userLoginWithInvalidCredentials_Test() {

        LoginPage lp = new LoginPage(driver);

        lp.login("wrong_user", "wrong_password");

        Assert.assertTrue(
                driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed()
        );

        Reporter.log("Invalid username and password rejected successfully", true);
    }
}