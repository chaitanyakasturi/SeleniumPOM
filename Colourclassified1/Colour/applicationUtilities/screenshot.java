package applicationUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshot {
	
	
	/*public screenshot(String filepath)
	{
		this.grabscreenshot("E://selenium.png");
	}*/
	
	public static void grabscreenshot(WebDriver driver,String Screenshotname)
	{
		TakesScreenshot t=(TakesScreenshot)driver;
	File src= t.getScreenshotAs(OutputType.FILE);	
	try 
	{
		FileUtils.copyFile(src, new File("./Screenshot/"+Screenshotname+".png"));
	}
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
