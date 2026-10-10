package ecommerce.SwagLabs.objRepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement sort;
	
	public WebElement getSort() {
		return sort;
	}
	
	public void selectingSorting(String sortVText) {
		Select sel = new Select(sort);
		sel.selectByVisibleText(sortVText);
	}
}
