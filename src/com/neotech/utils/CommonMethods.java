package com.neotech.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class CommonMethods extends BaseClass {

	// ALERTS

	/**
		 * This method switches the focus of the driver to an Alert and accepts it if
		 * found. If not found, the NoAlertPresentException is handled.
		 * 
		 */
		public static void acceptAlert() {
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}


	/**
		 * This method switches the focus of the driver to an Alert and dismisses it if
		 * found. If not found, the NoAlertPresentException is handled.
		 * 
		 */
		public static void dismissAlert() {
			try {
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}

		/**
		 * This method will switch the focus of the driver to an alert and return its
		 * text. If alert is not found, the NoAlertPresentException is handled.
		 * 
		 * @return
		 */
		public static String getAlertText() {
			String alertText = null;
			try {
				Alert alert = driver.switchTo().alert();
				alertText = alert.getText();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}

			return alertText;
		}

		/**
		 * This method will switch the focus of the driver to an alert and send text to
		 * it. If alert is not found, the NoAlertPresentException is handled.
		 * 
		 * @param text
		 */
		public static void sendAlertText(String text) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.sendKeys(text);
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	// CALENDAR 
		
		/**
		 * This method will select a date on a calendar whose element provided 
		 * as first parameter and select date that is the second parameter
		 * @param elements
		 * @param date
		 */
		
		public static void selectCalendarDate(List<WebElement> elements, String date)
		{
			for(WebElement day : elements)
			{
				
				if (day.getText().equals(date))
				{
					if(day.isEnabled())
					{
						click(day);
						break;
					}
					else
					{
						System.out.println("This day is not enabled!!!");
						break;
					}
				}
			}
		}
		
		
		 


		
	// CLICK
		
		
		

	/**
		 * This method will wait for clickability and then click on the passed element.
		 * 
		 * @param element
		 */
		public static void click(WebElement element)
		{
			waitForClickability(element);
			element.click();
		}
		

  
		
	/**
		 * This method checks if the radio/checkbox is enabled, and then clicks on the
		 * element that have the attribute value as selectValue.
		 * 
		 * @param elementList
		 * @param selectValue
		 */


	public static void clickRadioOrCheckbox(List<WebElement> elementList, String selectValue) {
			for (WebElement el : elementList) {
				String elementValue = el.getAttribute("value").trim();

				if (elementValue.equals(selectValue) && el.isEnabled()) {
					el.click();
					break;
				}
			}
		}


	//DROP DOWN




	/**
		 * This method selects a drop down element based on visible text.
		 * 
		 * @param element
		 * @param visibleText
		 */
		public static void selectDropdown(WebElement element, String visibleText) {
			try {

				Select sl = new Select(element);
				sl.selectByVisibleText(visibleText);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}



	/**
		 * This method selects a drop down element based on index.
		 * 
		 * 
		 * @param element
		 * @param index
		 */
		public static void selectDropdown(WebElement element, int index) {
			try {
				Select sl = new Select(element);
				sl.selectByIndex(index);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}



	// FRAME 



		/**
		 * 
		 * This method switches to a frame using its name or id.
		 * 
		 * @param nameOrId
		 */
		public static void switchToFrame(String nameOrId) {
			try {
				driver.switchTo().frame(nameOrId);
			} catch (NoSuchFrameException e) {
				e.printStackTrace();
			}
		}

		/**
		 * 
		 * This method switches to a frame using its index.
		 * 
		 * @param nameOrId
		 */
		public static void switchToFrame(int index) {
			try {
				driver.switchTo().frame(index);
			} catch (NoSuchFrameException e) {
				e.printStackTrace();
			}
		}

		/**
		 * This method switches to a frame using a WebElement.
		 * 
		 * @param element
		 */
		public static void switchToFrame(WebElement element) {
			try {
				driver.switchTo().frame(element);
			} catch (NoSuchFrameException e) {
				e.printStackTrace();
			}
		}

	
		// JAVA SCRIPT EXECUTOR
		
		
		
		/**
		   * This method will cath the driver to a JavascriptExecutor object and return it
		   * @return
		   */
				public static JavascriptExecutor getJSObject()
				{
					return (JavascriptExecutor) driver;
				}
				
			/**
			 * This method will click on an element using JavascriptExecutor
			 * @param element
			 */
				
				public static void jsClick(WebElement element)
				{
					getJSObject().executeScript("arguments[0].click()", element);
				}
				
				
				
				
		/**
		 * This method will scrolls the page until a specific element is in the view	
		 * @param element
		 */
				
				public static void scrollToElement (WebElement element)
				{
					getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);
					
				}
				
				
				
				/**
				 * This method will scrolls the page down depending using the pixcels parameter	
				 * @param pixels
				 */
				public static void scrollDown (int pixels)
			
				{
					getJSObject().executeScript("window.scrollBy(0, " + pixels + ")");
				}
				
				
				/**
				 * This method will scrolls the page Up depending using the pixcels parameter	
				 * @param pixels
				 */
				public static void scrollUp (int pixels)
			
				{
					getJSObject().executeScript("window.scrollBy(0, -" + pixels + ")");
				}
				
				
				
			
				
				

		// SEND TEXT
		
		

		/**
			 * This method clears a text box and send the text parameter to it.
			 * 
			 * @param element
			 * @param text
			 */
			public static void sendText(WebElement element, String text) {
				element.clear();
				element.sendKeys(text);
			}
			





	//WAIT 


	/**
		 * This method pauses the execution for a certain amount of seconds.
		 * 
		 * 
		 * @param seconds
		 */
		public static void wait(int seconds) {
			try {
				Thread.sleep(seconds * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


	/**
		 * This method creates a wait object based on the driver and the EXPLICIT_WAIT_TIME.
		 * 
		 * @return
		 */
		public static WebDriverWait getWaitObject()
		{
			return new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
		}

		
		/**
		 * This method creates a wait object based on the driver and the given amount of time.
		 * 
		 * @return
		 */
		public static WebDriverWait getWaitObject(int secondsToWait)
		{
			return new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
		}

		
		
		/**
		 * This method will wait for the element to be visible.
		 * 
		 * @param element
		 */
		public static WebElement waitForVisibility(WebElement element)
		{
			return getWaitObject().until(ExpectedConditions.visibilityOf(element));
		}
		
		
		/**
		 * This method will wait for the element to be clickable.
		 * 
		 * @param element
		 */
		public static WebElement waitForClickability(WebElement element)
		{
			return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
		}

	
		/**
		 * This method will take Webelement and taka screenshot
		 * 
		 * @param element
		 */
	public static void TakeScreenShot (WebElement element)
	{
		TakesScreenshot ts =  (TakesScreenshot)element;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String ssName = (new Date()).toString();
		
		File destination = new File("screenshots/homework/" + ssName + ".png");
		
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			System.out.println("Couldn't save the screenshot!");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will take driver and take full screenshot
	 * @param element
	 */
	
	public static void TakeFullScreenShot (WebElement element)
	{
		TakesScreenshot ts =  (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String ssName = (new Date()).toString();
		
		File destination = new File("screenshots/homework/" + ssName + ".png");
		
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			System.out.println("Couldn't save the screenshot!");
			e.printStackTrace();
		}
		
	}
	
	
	
}