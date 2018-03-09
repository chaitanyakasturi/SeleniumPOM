package pageObject;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;
import com.sun.jna.platform.win32.OaIdl.ELEMDESC.ByReference;

import applicationUtilities.ApplicationUtilities;
import applicationUtilities.screenshot;
import generalUtilities.ReadPropertities;
import generalUtilities.ReadXl;
import jxl.Workbook;


public class ColourClassifiedPage 
{
	private static final String login = null;
	WebDriver driver;
	ApplicationUtilities utils;
	ReadPropertities Prop;
	ReadXl myXl;
	screenshot screen; 
	
	
	public ColourClassifiedPage(WebDriver driver) 
	{
		//this.driver=driver;
		this.utils=new ApplicationUtilities(driver);
		this.Prop=new ReadPropertities("E:\\Java Programs\\Colourclassified1\\Colour\\Testdata.properties");
		this.myXl= new ReadXl("EXCELPATH");
		this.screen=new screenshot();
	
	}
	
	public void launch()
	
	{
		
		driver.get("http://localhost/colour/");
		//driver.get(Prop.readData("URL"));
		
		//screenshot.grabscreenshot(driver,"Colour3");
		//screen.grabscreenshot("E://Screen.png");
	   // driver.get(myXl.getCellData("Sample", 1, 1));
	}
	//String actual_result=driver.findElement(arg0)

	public void Register()
	{
		//screen.grabscreenshot("E://Screen3.png");
	driver.findElement(By.id("register")).click();
	
	//screen.grabscreenshot("E://Screen2.png");
    
	


		//FileInputStream fs=new FileInputStream("Book1.xlsx");
		//XSSFWorkbook wk=new XSSFWorkbook(fs);
		//XSSFSheet s=wk.getSheet("sheet1");
		//int rowcount = 0;
		
		//XSSFRow r=s.getRow(0);
		//XSSFCell c=r.getCell(1);
		
		for(int i=0;i<7;i++)
		{
		
		driver.findElement(By.id("username")).sendKeys(myXl.getdata(0, i, 0));
		
		driver.findElement(By.name("password")).sendKeys(myXl.getdata(0,i, 1));
		
        driver.findElement(By.className("button")).click();
        
       
		
		driver.quit();
		}
		
		
		//screenshot.grabscreenshot(driver,"Colour2");
		
		
		/*driver.findElement(By.id("username")).sendKeys("username");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.className("button")).click();*/
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
		 driver.quit();
		 
		// Assert.assertTrue(driver.getTitle().contains("Login"));
		 
		// System.out.println("user is able to login");
	}//
	
	public void Login()
	{
		driver.findElement(By.xpath("//*[@id='login']")).click();
		driver.findElement(By.name("username")).sendKeys("chaitanyakasturi27@gmail.com");
		driver.findElement(By.name("password")).sendKeys("ap15ax7268");
		driver.findElement(By.name("submit")).click();
	}
	public void postaAd()
	{
		//driver.findElement(arg0);
	}
	
	public void PostNewAdswithimage() throws InterruptedException, IOException
	{
		
/*driver.findElement(By.xpath("//a[contains(text(),'Upload Picture')]")).click();
		//int total=Integer.parseInt(myXl.getRowCount("Sample"); 
		
		
		for(i=1;i<=total;i++)
		{
			driver.findElement(By.name("photo")).sendKeys(myXl.getCellData("Postanad", , rowNum));
			utils.returnWebElementFromCollection("name", "submit","value","Upload").click();
			utils.returnWebElementFromCollection("name ", "submit", "value", "Finsh ad").click();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		driver.findElement(By.id("addad")).click();
		Select chose=new Select(driver.findElement(By.name("catid")));
		 chose.selectByIndex(2);
		 
		 /*driver.findElement(By.id("addad")).click();
		 Select chose1=new Select(driver.findElement(By.name("catid")));
		 chose1.selectByValue("3");
		 driver.quit();
	*/
		
		 driver.findElement(By.name("ad_title")).sendKeys("Have1430");
		 driver.findElement(By.name("ad_description")).sendKeys(" Ma de in  India 2001\n CC 2509\n Sale for 1lac\n Vehicle Colour White ");
			
		 driver.findElement(By.name("submit")).click();
		
	   	driver.findElement(By.xpath("//a[contains(text(),'Upload Picture')]")).click();
	  Runtime.getRuntime().exec("D:/MyExcelsheet/Upload image.exe");
	    //driver.findElement(By.name("photo")).sendKeys("C:\\Users\\Kasturi\\Desktop\\IMG_26638438971652.jpeg");
		
	    /*utils.returnWebElementFromCollection("name", "submit", "value", "Upload").click();
		
	    utils.returnWebElementFromCollection("name", "submit", "value","Finish ad").click();
		*/
		}
	public void PostNewaddwithVideo() throws InterruptedException
	{
		driver.findElement(By.id("addad")).click();
		Select chose=new Select(driver.findElement(By.name("catid")));
		 chose.selectByIndex(2);
		 driver.findElement(By.name("ad_title")).sendKeys("Havenger0002");
		 driver.findElement(By.name("ad_description")).sendKeys(" Made in India 2000\n CC 2509\n Sale for 1lac\n Vehicle Colour White ");
	   	driver.findElement(By.name("submit")).click();
	   	
	   	driver.findElement(By.xpath("//a[contains(text(),'Upload Video')]")).click();
	   	
	   	Thread.sleep(2000);
	   	driver.findElement(By.name("photo")).sendKeys("C:\\Users\\Kasturi\\Videos\\Vv.wmv");
		Thread.sleep(2000);
	   	utils.returnWebElementFromCollection("name", "submit", "value", "Upload").click();
		Thread.sleep(2000);
	    utils.returnWebElementFromCollection("name", "submit", "value","Finish ad").click();
	   	
	}
	public void EditDescription() throws InterruptedException
	{
		driver.findElement(By.id("addad")).click();
		
		driver.findElement(By.xpath("//a[@href='my_items.php']")).click();
		
		//driver.findElement(By.xpath("//a[contains(text(),'zmr 1')]/parent::td/following-sibling::td/a/img[@alt='Edit this ad'] ")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Havenger0002')]/parent::td/following-sibling::td/a/img[@alt='Edit this ad']")).click();
		Thread.sleep(2000);
		WebElement desc = driver.findElement(By.id("ad_description"));
		Thread.sleep(2000);
		desc.clear();
		Thread.sleep(2000);
		desc.sendKeys("Hellooooo hero hero 2222");
		Thread.sleep(5000);
		utils.returnWebElementFromCollection("name", "submit", "value", "Register").click();
		
		Thread.sleep(5000);
		driver.quit();
		
	}
	public void addtofavorites() throws InterruptedException
	{ 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Latest ads')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='detail.php?id=46']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0, 450)");
		Thread.sleep(10000);
		
		//driver.findElement(By.xpath("//a[@href='index.php?catid=2']")).click();
		//driver.findElement(By.id("moread")).click();
		driver.findElement(By.id("addfav")).click();
		
		
		
		List<String> handles=new ArrayList<String>  (driver.getWindowHandles());
		driver.switchTo().window(handles.get(1));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Close window']")).click();
		Thread.sleep(50000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
		//driver.findElement(By.id("")).sendKeys(Keys.F5); 
		//driver.get("http://localhost/colour/");
		//driver.navigate().refresh();
		//Thread.sleep(2000);
		//driver.quit();
		
		/*Actions myActions=new Actions(driver);
	    myActions.moveByOffset(100,120).contextClick().build().perform();
		Right click action*/
		
		
		/*driver.getWindowHandles();
		driver.switchTo().window("Favorite");
		*/
		//driver.findElement(By.xpath("//a[contains(text(),'Close window')]")).click();
		
		/*driver.switchTo().frame("0").close();*/
		
		
		
	}

	


		
	}
	
	
	
	
	

	

