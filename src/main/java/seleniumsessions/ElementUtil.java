package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
public By getBy(String LocatorType, String LocatorValue) {
		
		By locator = null;
		switch (LocatorType.toLowerCase()) {
		case "id":
			locator = By.id(LocatorValue);
			break;
		case "name":
			locator = By.name(LocatorValue);
			break;
		case "classname":
			locator = By.className(LocatorValue);
			break;
		case "xpath":
			locator = By.xpath(LocatorValue);
			break;
		case "cssselector":
			locator = By.cssSelector(LocatorValue);
			break;
		case "linktext":
			locator = By.linkText(LocatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(LocatorValue);
			break;
		case "tagName":
			locator = By.tagName(LocatorValue);
			break;
		default:
			break;
		}
		return locator;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public boolean isElementPresent(By Locator) {
		if (getElements(Locator).size() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}
	
	public List<String> getLinksTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String text = e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
		
	}
	//************** Drop Down Utilities ******************** //
	
	public void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public void doSelectByVisibleIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public void doSelectByValue(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByValue(text);
	}
	
	public List<String> doGetDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> OptionsList = select.getOptions();
		List<String> OptionValList = new ArrayList<String>();
		for(WebElement e: OptionsList) {
			String text = e.getText();
			OptionValList.add(text);
		}
		
		return OptionValList;
	}
	
	public void doSelectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	
	}
	
	//*********************** Actions Utilities  *****************************
	
	public void selectSubMenu(By parentMenu, By childMenu) throws InterruptedException {
		//getElement(parentMenu);
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).build().perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}
	
	public void selectSubMenu(By parentMenu, By childMenu, By subChildMenu) throws InterruptedException {
		//getElement(parentMenu);
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu)).build().perform();
		Thread.sleep(2000);
		getElement(subChildMenu).click();
	}

	public void selectSubMenu(By parentMenu, By childMenu1, By childMenu2, By childMenu3) throws InterruptedException {
		//getElement(parentMenu);
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu1)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu2)).build().perform();
		Thread.sleep(2000);
		getElement(childMenu3).click();
	}
	
	public void doContextClick(By locator) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(locator)).perform();
	}
	
	public int getRightClickOptionsCount(By rightClick, By rightClickOptions) {
		return getRightClickOptionsList(rightClick, rightClickOptions).size();
	}

	public List<String> getRightClickOptionsList(By rightClick, By rightClickOptions) {

//		WebElement rightClickEle = getElement(rightClick);
		List<WebElement> rightClickItemList = getElements(rightClickOptions);
		List<String> rightClickItems = new ArrayList<String>();
//		Actions act = new Actions(driver);
//		act.contextClick(rightClickEle).perform();
		doContextClick(rightClick);

		for (WebElement e : rightClickItemList) {
			String text = e.getText();
			//System.out.println(text);
			rightClickItems.add(text);
		}
		return rightClickItems;
	}

	public void selectRightClickMenu(By rightClick, By rightClickOptions, String value) {
//		WebElement rightClickEle = getElement(rightClick);
//		Actions act = new Actions(driver);
//		act.contextClick(rightClickEle).perform();
		doContextClick(rightClick);
		List<WebElement> itemsList = getElements(rightClickOptions);
		System.out.println(itemsList.size());
		for (WebElement e : itemsList) {
			String text = e.getText();
			//System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}
	
	/*
	 * Clicks in the middle of the given element. Equivalent to: Actions.moveToElement(onElement).click()
	 * @param locator
	 */
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();	
	}
	
	
	/*
	 * Equivalent to calling: Actions.click(element).sendKeys(keysToSend).
	 * @param locator
	 * @param value
	 */
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	
	//*********************** Wait utils ****************************************************
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * polling time = 500 ms(default)
	 * @return WebElement
	 */
	public WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed 
	 * but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * polling time = 500 ms(default)
	 * @return WebElement
	 */
	public WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @param pollingTime
	 * @return WebElement
	 */
	public WebElement waitForElementPresent(By locator, int timeOut, long pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed 
	 * but also has a height and width that is greater than 0.

	 * @param locator
	 * @param timeOut
	 * @param pollingTime
	 * @return WebElement
	 */
	public WebElement waitForElementToBeVisible(By locator, int timeOut, long pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	

	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	public void getAlertText(int timeOut) {
		waitForAlert(timeOut).getText();
	}
	
	/**
	 * An expectation for the URL of the current page to contain specific text.
	 * @param timeOut
	 * @param urlFraction
	 * @return currentUrl
	 */
	public String waitForUrl(int timeOut, String urlFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
			return null;
	}
	
	/**
	 * An expectation for the URL of the current page to be a specific url.
	 * @param timeOut
	 * @param urlValue
	 * @return currentUrl
	 */
	public String waitForUrlToBe(int timeOut, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlToBe(urlValue))) {
			return driver.getCurrentUrl();
		}
			return null;
	}
	
	/**
	* Wait for URL ****
	** waitForURL-pass the fraction of URL
	** waitForURLToBe- pass the whole URL
	/**
	 * An expectation for checking that the title contains a case-sensitive substring
	 * @param timeOut
	 * @param titleFraction
	 * @return title
	 */
	public String waitForTitleContains(int timeOut, String titleFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
		return null;
	}
	
	/**
	 * An expectation for checking the title of a page.
	 * @param timeOut
	 * @param titleValue
	 * @return Title
	 */
	public String waitForTitleIs(int timeOut, String titleValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.titleIs(titleValue))) {
			return driver.getTitle();
		}
		return null;
	}
	
	
	public WebDriver waitForFrameByLocator(int timeOut, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public WebDriver waitForFrameByIndex(int timeOut, int frameIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public WebDriver waitForFrameByString(int timeOut, String frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public WebDriver waitForFrameByElement(int timeOut, WebElement frameElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param locator
	 * @param timeOut
	 */
	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param locator
	 * @param timeOut
	 */
	public void clickElementWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(getElement(locator))).click();
	}
	
	
	public void printAllElementsText(By locator, int timeOut) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeOut);
		for(WebElement e : eleList) {
			System.out.println(e.getText());
		}
	}
	
	public List<String> getElementsTextListWithWait(By locator, int timeOut) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeOut);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String text = e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}
	
	public List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}




