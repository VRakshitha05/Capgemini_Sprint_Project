package ecommerce.SwagLabs.Login;


import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.SwagLabs.baseClass.BaseClass;
import ecommerce.SwagLabs.objRepo.HomePage;
import ecommerce.SwagLabs.objRepo.LoginPage;

public class UserLoginLogout_Test extends BaseClass {
	@Test(groups = {"SysT","Pos"})
	public void userLoginLogout_Test() throws Exception {
		LoginPage lp = new LoginPage(driver);

		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		String un = wb.getSheet("Sheet1").getRow(1).getCell(1).toString();
		String pwd = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();
		
		lp.login(un, pwd);

		/*lp.getUn().clear();
		lp.getUn().sendKeys(un);
		lp.getPwd().clear();
		lp.getPwd().sendKeys(pwd);
		lp.getLoginB().click();*/

		//Assert.assertEquals(driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).isDisplayed(), true);
		Assert.assertEquals(driver.getCurrentUrl().contains("inventory"), true);
		Reporter.log("User logged in successfully with valid credentials", true);

		HomePage hp = new HomePage(driver);
		hp.getHamburger().click();
		hp.getLogout().click();

		Assert.assertEquals(driver.findElement(By.id("login-button")).isDisplayed(), true);
		Reporter.log("User logged out successfully", true);
	}
}
