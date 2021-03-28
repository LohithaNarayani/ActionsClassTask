package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import drivers.WebDriverUtils;
import utilities.WebElementActions;

public class SwitchTabPage {
	WebDriver driver;
	WebElementActions webele;
	
	@FindBy(how = How.ID, using ="tabButton") public WebElement element;
	@FindBy(how = How.ID, using ="windowButton") public WebElement element1;

	public SwitchTabPage() {

		webele = new WebElementActions();

		WebDriverUtils wd = new WebDriverUtils();
		String browser = System.getProperty("browser");
		System.out.println("Browser: "+browser);
		driver = wd.getDriver(browser);

		PageFactory.initElements(driver, this);
	}

	public void launchSwitchTabPage() {

		driver.get("https://demoqa.com/browser-windows");
	}
	
	public void switchTab() throws InterruptedException  {
		webele.switchToTab(driver,element);
		
	}
	
	public void switchWindow() throws InterruptedException  {
		webele.switchChildWindow(driver,element1);	
	}

}
