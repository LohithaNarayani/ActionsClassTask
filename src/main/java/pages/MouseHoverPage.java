package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import drivers.WebDriverUtils;
import utilities.WebElementActions;

public class MouseHoverPage {
	
	WebDriver driver;
	WebElementActions webele;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"nav\"]/li[2]/a") public WebElement element;

	public MouseHoverPage() {

		webele = new WebElementActions();

		WebDriverUtils wd = new WebDriverUtils();
		String browser = System.getProperty("browser");
		System.out.println("Browser: "+browser);
		driver = wd.getDriver(browser);

		PageFactory.initElements(driver, this);
	}


	public void launchMouseHoverPage() {
		driver.get("https://demoqa.com/menu");
		
	}
	
	public void mouseHoverElement()  {
		webele.mouseHover(driver,element );	
	}
	
}
