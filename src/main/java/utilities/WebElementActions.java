package utilities;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementActions {

	public void click(WebDriver driver, WebElement element) {

		scrollElementIntoView(driver, element);
		waitForElement(driver, element, 5);
		element.click();
	}

	public void waitForElement(WebDriver driver, WebElement element, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void scrollElementIntoView(WebDriver driver, WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void moveToElement(WebElement element, WebDriver driver) {
		scrollElementIntoView(driver, element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		scrollElementIntoView(driver,source);
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
	}

	public void mouseHover(WebDriver driver, WebElement element) {
		scrollElementIntoView(driver, element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void doubleClick(WebElement element, WebDriver driver) throws InterruptedException {
		scrollElementIntoView(driver, element);
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public void contextClick(WebElement rightclick, WebDriver driver) throws InterruptedException {
		scrollElementIntoView(driver, rightclick);
		Actions action = new Actions(driver);
		action.contextClick(rightclick).build().perform();
	}

	public void sendInputText(WebDriver driver, WebElement element, String username) throws InterruptedException {
		scrollElementIntoView(driver, element);
		element.clear();
		element.sendKeys(username);
	}

	public void switchToTab(WebDriver driver, WebElement element) throws InterruptedException {
		element.click();
	}

	public void switchChildWindow(WebDriver driver, WebElement element1) {

		String ParentHandle = driver.getWindowHandle();
		System.out.println("Parent Window:-" + ParentHandle);
		element1.click();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(ParentHandle)) {
				driver.switchTo().window(handle);
				System.out.println(driver.switchTo().window(handle).getTitle());
			}
		}
	}


	public void iFrameElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
}