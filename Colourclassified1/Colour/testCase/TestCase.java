package testCase;

import java.io.IOException;

//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadPropertities;
import generalUtilities.ReadXl;
import pageObject.ColourClassifiedPage;

public class TestCase
{
	WebDriver driver = new FirefoxDriver();
	
	ApplicationUtilities utils= new ApplicationUtilities(driver); 
	ReadPropertities prop=new ReadPropertities("E:\\Java Programs\\Kasturi1\\TestData.Propertities");
	  ReadXl myXl=new ReadXl("execelpath");
	 ColourClassifiedPage colour=new ColourClassifiedPage(driver);
	
	@Test
	public void launch()
	{
	      colour.launch();
	}

	
	 public void Register()
	 {
		 launch();
		 colour.Register();
	 }
	 @Test
	 public void Login() throws IOException, InterruptedException 
	 {
		
		launch();
	    colour.Login();
	 }
	
	 public void PostNewAds() throws InterruptedException, IOException 
	 {	
		 Login();
		 colour.PostNewAdswithimage();
		 
	 }
	 
	 public void PostNewaddwithVideo() throws InterruptedException, IOException
	 { 
		 Login();
		 colour.PostNewaddwithVideo();
	 }
	
	 public void editDescription() throws InterruptedException, IOException
	 {
		 Login();
		 colour.EditDescription();
	 }
	
	 public void addtofavorites() throws InterruptedException, IOException
	 {
		 Login();
		 colour.addtofavorites();
	 }
}
