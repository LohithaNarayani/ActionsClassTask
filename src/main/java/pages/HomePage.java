package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import drivers.WebDriverUtils;
import utilities.WebElementActions;

public class HomePage {

	WebDriver driver;
	WebElementActions webele;

	@FindBy(how = How.XPATH, using ="//h5[text()='Interactions']")
	public WebElement interactionsLink;
	
	@FindBy(how = How.CLASS_NAME, using ="header-wrapper")
	public WebElement element;
	
	public HomePage() {

		webele = new WebElementActions();

		WebDriverUtils wd = new WebDriverUtils();
		String browser = System.getProperty("browser");
		System.out.println("Browser: "+browser);
		driver = wd.getDriver(browser);

		PageFactory.initElements(driver, this);
	}

	public void launchHomePage() {

		driver.get("https://demoqa.com/");
	}

	public String getPageTitle() {

		String pageTitle = driver.getTitle();

		return pageTitle;
	}

	public void launchInteractions() {

		webele.click(driver, interactionsLink);		
	}
	

	public void moveToElementTest() {
		webele.moveToElement(element, driver);
		
	}
	

}
