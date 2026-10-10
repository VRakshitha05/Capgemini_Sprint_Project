package ecommerce.SwagLabs.Login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class UserLoginWithBlankPassword_Test extends BaseClass {

    @Test(groups = {"Functional", "Negative"})
    public void userLoginWithBlankPassword_Test() {

        LoginPage lp = new LoginPage(driver);

        lp.login("standard_user", "");

        Assert.assertTrue(
                driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed()
        );

        Reporter.log("Blank password validation displayed successfully", true);
    }
}