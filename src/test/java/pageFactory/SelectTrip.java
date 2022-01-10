package pageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseclass.LibGlobal;

public class SelectTrip extends LibGlobal {

	public SelectTrip() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()=' Trip type ']/following-sibling::input")
	WebElement tripType;

	@FindBy(xpath = "//span[contains(text(),'One way')]")
	WebElement oneway;

	@FindBy(xpath = "//div[contains(text(), 'Chat')]")
	WebElement chat;
	
	@FindBy(xpath = "(//div[@data-visualcompletion='ignore'])[2]SS")
	WebElement popupText;
	
	@FindBy(xpath = "//div[@id='fb-root']//iframe[@name='f588be75dc9acc']")
	WebElement framesswitch;
	
	@FindBy(tagName = "iframe")
	List<WebElement> iframeCount;

	public void tripType() throws InterruptedException {
		scrollDown(tripType);
		JavaScriptClick(tripType);
		oneway.click();
		Thread.sleep(5000);
	}

public void frames() throws InterruptedException {
	
	Thread.sleep(10000);
	driver.switchTo().frame(framesswitch);
}
	
	
	public void loginClose() throws InterruptedException {

		
		
		
//		WebDriverWait wait2 = new WebDriverWait(driver, 1000);
//		wait2.until(ExpectedConditions.visibilityOf(popupText));
		
		frames();
		Thread.sleep(4000);
		if (!popupText.isDisplayed()) {
			tripType();
		} else {
			tripType();
			JavaScriptClick(chat);
		}

	}
}
