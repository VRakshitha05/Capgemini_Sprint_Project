package ecommerce.SwagLabs.objRepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "continue-shopping")
	private WebElement continueS;
	
	@FindBy(id = "checkout")
	private WebElement checkout;

	public WebElement getContinueS() {
		return continueS;
	}

	public WebElement getCheckout() {
		return checkout;
	}
}
