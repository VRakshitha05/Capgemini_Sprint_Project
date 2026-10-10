package ecommerce.SwagLabs.Login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class UserLoginWithBlankUsername_Test extends BaseClass {

    @Test(groups = {"Functional", "Negative"})
    public void userLoginWithBlankUsername_Test() {

        LoginPage lp = new LoginPage(driver);

        lp.login("", "secret_sauce");

        Assert.assertTrue(
                driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed()
        );

        Reporter.log("Blank username validation displayed successfully", true);
    }
}