package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import drivers.WebDriverUtils;
import utilities.ExtentReportUtil;
import utilities.WebElementActions;

public class ButtonsPage {
	WebDriver driver;
	WebElementActions webele;
	ExtentReportUtil extreport;
	
	@FindBy(how = How.ID, using ="doubleClickBtn") public WebElement element;
	@FindBy(how = How.ID, using ="rightClickBtn") public WebElement rightclick;
	
	public ButtonsPage() {

		webele = new WebElementActions();
		
		//ExtentReportUtil extreport= new ExtentReportUtil();
		WebDriverUtils wd = new WebDriverUtils();
		String browser = System.getProperty("browser");
		System.out.println("Browser: "+browser);
		driver = wd.getDriver(browser);
		
		
		PageFactory.initElements(driver, this);
	}

	public void launchButtonsPage() {

		driver.get("https://demoqa.com/buttons");
	}
	
	public void doubleClickElement() throws InterruptedException  {
		webele.doubleClick(element,driver);
		
	}
	
	public void contextClickElement() throws InterruptedException  {
		webele.contextClick(rightclick,driver);
		
	}
}
