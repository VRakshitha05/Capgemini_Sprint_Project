package ecommerce.SwagLabs.baseClass;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void launchBrowser(@Optional("chrome") String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);

            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else {
            throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}
