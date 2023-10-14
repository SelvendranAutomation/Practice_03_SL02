package com.qa.internetherokuapp.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.internetherokuapp.pages.HomePage;
import com.qa.internetherokuapp.pages.TableContentsValues;
import com.qa.internetherokuapp.pages.TestBase;



public class HomePageTest {
	
	public WebDriver driver;
	public TestBase testBase;
	public Properties prop;
	public HomePage homePage;


	
	@BeforeTest
	public void setUp(){
		testBase = new TestBase();	
		prop = testBase.initProperty();
		driver = testBase.init(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		homePage =  new HomePage(driver);
		
	}
	


	
	@Test
	public void verifyWebTable(){
		List<TableContentsValues>  TableContentsValuesList = new ArrayList();
		
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: "+ title);
		Assert.assertEquals(title, "Web Table Elements");
				
		List<String>  companyTableHeaderList = homePage.getTableHeaderList();	
		for (int i=0;i<companyTableHeaderList.size();i++)
		System.out.println("Table Header of index"+(i+1)+" : "+ companyTableHeaderList.get(i));

		TableContentsValuesList = homePage.getTableValues(companyTableHeaderList);	
		TableContentsValues maxValues = Collections.max(TableContentsValuesList, Comparator.comparing(TableContentsValues ::getCurrentPrice));

		System.out.println("Company name of maximum current price : "+maxValues.getCompany());
		System.out.println("Maximum current price : "+maxValues.getCurrentPrice());
	}

	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
