package ecommerce.SwagLabs.Login;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class PasswordMasking_Test extends BaseClass {

    @Test(groups = {"Functional", "Positive"})
    public void passwordMasking_Test() {

        LoginPage lp = new LoginPage(driver);

        lp.getPwd().sendKeys("secret_sauce");

        String type = lp.getPwd().getAttribute("type");

        Assert.assertEquals(type, "password");

        Reporter.log("Password is masked successfully", true);
    }
}