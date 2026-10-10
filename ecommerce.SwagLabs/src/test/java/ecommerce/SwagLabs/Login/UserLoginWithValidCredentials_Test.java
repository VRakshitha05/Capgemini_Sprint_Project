package ecommerce.SwagLabs.Login;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.genericutility.ExcelUtility;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class UserLoginWithValidCredentials_Test extends BaseClass {

    @Test(groups = {"Smoke", "Positive"})
    public void userLoginWithValidCredentials_Test() throws Exception {

        ExcelUtility eu = new ExcelUtility();

        // Excel: Sheet1
        // Column A = TestCase
        // Column B = Username
        // Column C = Password

        String username = eu.readDataFromExcel("Sheet1", 1, 1);
        String password = eu.readDataFromExcel("Sheet1", 1, 2);

        LoginPage lp = new LoginPage(driver);

        lp.login(username, password);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Valid login failed"
        );

        Reporter.log("Valid login successful", true);
    }
}