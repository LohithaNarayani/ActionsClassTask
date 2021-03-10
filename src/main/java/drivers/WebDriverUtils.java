package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverUtils {
	
		WebDriver driver = null;

		public WebDriver getDriver(String browser) {

			if(browser.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			else {
				System.out.println("Unsupported Browser !!!");
			}

			driver.manage().window().maximize();

			return driver;
		}
		
	}

