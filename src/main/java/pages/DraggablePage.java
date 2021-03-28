package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import drivers.WebDriverUtils;
import utilities.ExtentReportUtil;
import utilities.WebElementActions;

public class DraggablePage {
	
	WebDriver driver;
	WebElementActions webele;
	ExtentReportUtil extreport;
	
	@FindBy(how = How.ID, using ="draggable") public WebElement source;
	@FindBy(how = How.ID, using ="droppable") public WebElement target;

	public DraggablePage() {

		webele = new WebElementActions();

		WebDriverUtils wd = new WebDriverUtils();
		String browser = System.getProperty("browser");
		System.out.println("Browser: "+browser);
		driver = wd.getDriver(browser);

		PageFactory.initElements(driver, this);
	}

	public void launchDraggablePage() {
		driver.get("https://demoqa.com/droppable");
	}
	
	
	public void dragElement()  {
		webele.dragAndDrop(driver,source, target);
		
	}
}