package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import drivers.WebDriverUtils;
import utilities.WebElementActions;

public class SendInputTextPage {
	WebDriver driver;
	WebElementActions webele;
	
	@FindBy(how = How.ID, using ="userName") public WebElement element;

	public SendInputTextPage() {

		webele = new WebElementActions();

		WebDriverUtils wd = new WebDriverUtils();
		String browser = System.getProperty("browser");
		System.out.println("Browser: "+browser);
		driver = wd.getDriver(browser);

		PageFactory.initElements(driver, this);
	}

	public void launchSendInputPage() {

		driver.get("https://demoqa.com/text-box");
	}
	
	public void sendInputElement() throws InterruptedException  {
		webele.sendInputText(driver,element,"LohithaNarayani");
		
	}

}
