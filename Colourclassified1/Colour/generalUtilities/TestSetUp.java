package generalUtilities;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestSetUp 
{
	static WebDriver driver;
	public static String env = ReadPropertities.readValue("Environment");
	public static WebDriver bringMyDriver()
	{
		if(ReadPropertities.readValue("executionType").equals("local"))
		{
			driver = bringMyLocalDriver();
			
		}
		else if (ReadPropertities.readValue("executionType").equals("remote"))
		{
			driver= bringMyRemoteDriver();
		}
		else
		{
			driver= bringMyLocalDriver();
			
		}
		return driver;
		
	}
	public static WebDriver bringMyLocalDriver()
	{
		if(ReadPropertities.readValue("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\Java Programs\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		else if(ReadPropertities.readValue("browser").equals("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette","E:\\Java Programs\\Firefoxdriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.firefox.marionette","E:\\Java Programs\\Firefoxdriver.exe");
			driver = new FirefoxDriver();
		
		}
		return driver;
		
	}
	
	public static WebDriver bringMyRemoteDriver()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("name", ReadPropertities.readValue("ApplicationName"));
		capabilities.setCapability(CapabilityType.BROWSER_NAME, ReadPropertities.readValue("browser"));
		capabilities.setCapability(CapabilityType.VERSION, ReadPropertities.readValue("BrowserVersion"));
		capabilities.setCapability(CapabilityType.PLATFORM, ReadPropertities.readValue("Platform"));
		capabilities.setCapability("screen resolution", ReadPropertities.readValue("Resolution"));
		capabilities.setCapability("username", ReadPropertities.readValue("saucelabs Username"));
		capabilities.setCapability("access key", ReadPropertities.readValue("saucelabs Access key"));
		
		try {
			driver =new RemoteWebDriver(new URL (ReadPropertities.readValue("saucelabsURL")),capabilities);
		}
		catch (Exception e) 
		{
				e.printStackTrace();
		}
		return driver;
	}
	
	

}
