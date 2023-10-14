package com.qa.internetherokuapp.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TestBase{
	
	private ElementUtil elementUtil;
	
	private By totalNoOfRow_css = By.cssSelector( "table[class='dataTable']>tbody>tr");
	private By totalNoOfHeader_css = By.cssSelector( "table[class='dataTable']>thead>tr>th");

	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public List<String> getTableHeaderList(){
		elementUtil.waitForElementPresent(totalNoOfHeader_css, 60);
		List<String> companyTableHeaderList = new ArrayList();
		List<WebElement> headerLength  = driver.findElements(totalNoOfHeader_css);
		for (int i=1;i<=headerLength.size();i++)
		{
			companyTableHeaderList.add(getTableHeader(""+i));
		}
		return companyTableHeaderList;
	}

	public String getTableHeader(String indexVal){
		return driver.findElement(By.cssSelector("table[class='dataTable']>thead>tr>th:nth-of-type("+indexVal+")")).getText();
	}
	
	public List<TableContentsValues> getTableValues(List<String> companyTableHeaderList){
		TableContentsValues contents = null;
		int i,j;
		String setCompanyVal = null,setGroupVal = null,setChangeStrVal = null;
		float setPrevCloseVal = 0,setCurrentPriceVal = 0,setChangeVal = 0;
		elementUtil.waitForElementPresent(totalNoOfHeader_css, 60);
		elementUtil.getScreenshot();	
		List<TableContentsValues> tableContentsValuesList = new ArrayList();
		List<WebElement> rowLength  = driver.findElements(totalNoOfRow_css);
		for ( i=1;i< rowLength.size();i++)
		{
			for (j=1;j<=companyTableHeaderList.size();j++) {
				if(j==1)
					setCompanyVal = getTableContents(""+i,""+j);
				else if(j==2) 
					setGroupVal = getTableContents(""+i,""+j);
				else if(j==3)  
					setPrevCloseVal = Float.parseFloat(getTableContents(""+i,""+j));
				else if(j==4)  
					setCurrentPriceVal = Float.parseFloat(getTableContents(""+i,""+j));					
				else if(j==5) {  
					setChangeStrVal = getTableContents(""+i,""+j);
					setChangeStrVal = setChangeStrVal.replaceAll("[^0-9\\.]", "");
					setChangeVal = Float.parseFloat(setChangeStrVal);
				}
			}
			contents = new TableContentsValues(setCompanyVal,setGroupVal,setPrevCloseVal,setCurrentPriceVal,setChangeVal);
			tableContentsValuesList.add(contents);
			//System.out.println(i+"   "+j);
		}
		return tableContentsValuesList;
	}
	
	public String getTableContents(String rowIndex,String colIndex){
		String toBeReturn="";
		
		if (colIndex.equals("1"))
			toBeReturn =  driver.findElement(By.cssSelector("table[class='dataTable']>tbody>tr:nth-of-type("+rowIndex+")>td:nth-of-type("+colIndex+")>a")).getText();
		else 
			toBeReturn =  driver.findElement(By.cssSelector("table[class='dataTable']>tbody>tr:nth-of-type("+rowIndex+")>td:nth-of-type("+colIndex+")")).getText();
			
	return toBeReturn;
	}
	
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
}
