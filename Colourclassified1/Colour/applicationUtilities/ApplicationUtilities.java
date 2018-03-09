package applicationUtilities;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.sun.jna.platform.FileUtils;

public class ApplicationUtilities
{
	WebDriver driver;
	WebElement myElement;
	List<WebElement> myElements;
	
	
	public ApplicationUtilities(WebDriver driver)
	{
		this.driver= driver;
	}
	public WebElement returnWebElement(String propType, String propValue)
	{
		if(propType.trim().equals("id"))
			myElement =driver.findElement(By.id(propValue));
			else if (propType.trim().equals("name"))
			myElement =driver.findElement(By.name(propValue));
			else if (propType.trim().equals("className"))
			myElement =driver.findElement(By.className(propValue));	
			else if (propType.trim().equals("cssSelector"))
			myElement =driver.findElement(By.cssSelector(propValue));
			else if (propType.trim().equals("linktext"))
			myElement =driver.findElement(By.linkText(propValue));
			else if (propType.trim().equals("partialLinkText"))
			myElement =driver.findElement(By.partialLinkText(propValue));
			else if (propType.trim().equals("tagName"))
			myElement =driver.findElement(By.tagName(propValue));
			else if (propType.trim().equals("xpath"))
			myElement =driver.findElement(By.xpath(propValue));

		if(myElement.isEnabled())
		return myElement;
		else 
		return null;					
		}
	
	public WebElement returnWebElementFromCollection(String propType, String propValue, String attributeType, String attributeValue)
	{
		myElements =returnWebElements(propType, propValue);
		for(int i=0; i<myElements.size();i++)
		{
			if(myElements.get(i).getAttribute(attributeType).trim().equals(attributeValue))
			{
				myElement = myElements.get(i);
				break;
			}
		}
		return myElement;
		
		
		
	}
	private List<WebElement> returnWebElements(String propType, String propValue) 
	{
		if(propType.trim().equals("id"))
			myElements =driver.findElements(By.id(propValue));
			else if (propType.trim().equals("name"))
			myElements =driver.findElements(By.name(propValue));
			else if (propType.trim().equals("className"))
			myElements =driver.findElements(By.className(propValue));	
			else if (propType.trim().equals("cssSelector"))
			myElements =driver.findElements(By.cssSelector(propValue));
			else if (propType.trim().equals("linktext"))
			myElements =driver.findElements(By.linkText(propValue));
			else if (propType.trim().equals("partialLinkText"))
			myElements =driver.findElements(By.partialLinkText(propValue));
			else if (propType.trim().equals("tagName"))
			myElements =driver.findElements(By.tagName(propValue));
			else if (propType.trim().equals("xpath"))
			myElements =driver.findElements(By.xpath(propValue));

			return myElements;
	}
	public void selectAnElementFromDropDown(String propType,String propValue,int index)
	{
		new Select(returnWebElement(propType,propValue)).selectByIndex(index);
	}
	public void selectAnElementFromDropDown(String propType,String propValue,String text)
	{
		new Select(returnWebElement(propType,propValue)).selectByVisibleText(text);
	
	}


/* public static void captureScreenShot(WebDriver ldriver)
 {
 
  // Take screenshot and store as a file format
  File src= ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
try {
  // now copy the  screenshot to desired location using copyFile method
 
FileUtils.copyFile(src, new File(""));
       }
 
catch (IOException e)
 
{
 
System.out.println(e.getMessage());
 
    }
 
}
		
}
	/*public void grabscreenshot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File(""));
		FileUtils.copyDirectory(src, new File(""));
		
		*/
	}
	


