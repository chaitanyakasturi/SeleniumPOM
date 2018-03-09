package generalUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Sheet;
import jxl.Workbook;

public class ReadXl 
{
	XSSFWorkbook wb;
	XSSFSheet sheet;
	String execelpath;
	
	
	public ReadXl(String execelpath) 
	{
this.execelpath=execelpath;
		File src=new File(execelpath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb=new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*public String getdata(int SheetNumber,int row,int column){
		
		sheet=wb.getSheetAt(SheetNumber);
		String data=sheet.getRow(row).getCell(column).getStringCellValue();
		return data;}*/
	
	public int getrowcount(int sheetindex){
		int row=wb.getSheetAt(sheetindex).getLastRowNum();
		row=row+1;
		return row;
	}

	public String getdata(int sheetNumber, int row, int column) 
	{
	sheet=wb.getSheetAt(sheetNumber);
	String data=sheet.getRow(row).getCell(column).getStringCellValue();
	
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
	
	
	

/*
	FileInputStream myFile;
	Workbook myBook;
	Sheet mySheet;
	String filePath;
	
	
	public ReadXl(String filePath)
	{
		this.filePath = filePath;
	}
	
	public Sheet getMySheet(String sheetName)
	{
		try {
			myFile=new FileInputStream(filePath);
			myBook=Workbook.getWorkbook(myFile);
			
			} 
		catch (Exception e) 
			{
			e.printStackTrace();
			}
		;
		return myBook.getSheet(sheetName);
	}
	
	
	public int getRowCount(String sheetName)
	{
		mySheet =getMySheet(sheetName);
		return mySheet.getRows(); 
	}
	
	
	public int getColumnCount(String sheetName)
	{
		mySheet = getMySheet(sheetName);
		return mySheet.getColumns();
		
	}
	
	
	public String getCellData(String sheetName,int colNum,int rowNum)
	{
		mySheet = getMySheet(sheetName);
	
		return mySheet.getCell(colNum, rowNum).getContents();
	}*/



