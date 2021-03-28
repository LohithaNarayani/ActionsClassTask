package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import drivers.WebDriverUtils;
import utilities.WebElementActions;

public class FramesPage {
	WebDriver driver;
	WebElementActions webele;
	
	@FindBy(how = How.XPATH, using ="frame2Wrapper") public WebElement element;

	public FramesPage() {

		webele = new WebElementActions();

		WebDriverUtils wd = new WebDriverUtils();
		String browser = System.getProperty("browser");
		System.out.println("Browser: "+browser);
		driver = wd.getDriver(browser);

		PageFactory.initElements(driver, this);
	}


	public void launchFramesPage() {
		driver.get("https://demoqa.com/frames");
		
	}
	
	public void iframeElement()  {
		webele.iFrameElement(driver,element );	
	}
	

}
