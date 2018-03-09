package generalUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertities 
{
	public  String filepath;
	
	
	public ReadPropertities(String filepath)
	{
		this.filepath= filepath;
		
	}
		 static FileInputStream myFile;
		 static Properties myProp;
		

		public String readData(String Key)

		{ 
			try 
			{
				myFile=new FileInputStream(filepath);
				myProp= new Properties();
				myProp.load(myFile);
				} 
			catch (Exception e) 
			{
				System.out.println(e);
					e.printStackTrace();
			}
			
			return myProp.getProperty(Key);
		}
		public static String readValue(String key)
		{
			try {
				myFile = new FileInputStream("E:\\Java Programs\\Kasturi1\\TestData.Propertities");
				myProp = new Properties();
				myProp.load(myFile);
			} catch ( Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			return myProp.getProperty(key);



		}}



