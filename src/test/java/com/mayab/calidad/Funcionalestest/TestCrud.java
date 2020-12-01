package com.mayab.calidad.Funcionalestest;

import static org.junit.Assert.*;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.Select;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestCrud {

	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");  
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\melis\\Music\\quality\\chromedriver_win32\\chromedriver.exe");

	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    
	  }
		  
		  @Test
		  public void atestAdd() throws Exception {
		    driver.get("https://mern-crud.herokuapp.com/");
		    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
		    pause(1000);
		    driver.findElement(By.name("name")).click();
		    driver.findElement(By.name("name")).clear();
		    driver.findElement(By.name("name")).sendKeys("vero");
		    driver.findElement(By.name("email")).click();
		    driver.findElement(By.name("email")).clear();
		    pause(2000);
		    driver.findElement(By.name("email")).sendKeys("melip@gmail.com");
		    driver.findElement(By.name("age")).click();
		    driver.findElement(By.name("age")).clear();
		    driver.findElement(By.name("age")).sendKeys("27");
		    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
		    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
		    driver.findElement(By.xpath("//form/button")).click();
		    pause(3000);
		    assertEquals("Successfully added!", driver.findElement(By.xpath("//div[4]/div/p")).getText());
		  }
	 
		  @Test
		  public void dtestDelete() throws Exception {
		    driver.get("https://mern-crud.herokuapp.com/");
		    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
		    pause(1000);
		    driver.findElement(By.name("name")).click();
		    driver.findElement(By.name("name")).clear();
		    pause(2000);

		    driver.findElement(By.name("name")).sendKeys("Holaa");
		    driver.findElement(By.name("email")).click();
		    driver.findElement(By.name("email")).clear();
		    pause(2000);

		    driver.findElement(By.name("email")).sendKeys("Ivanna@hotnail.com");
		    driver.findElement(By.name("age")).click();
		    driver.findElement(By.name("age")).clear();
		    driver.findElement(By.name("age")).sendKeys("27");
		    pause(1000);

		    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
		    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
		    driver.findElement(By.xpath("//form/button")).click();
		    driver.findElement(By.xpath("//i")).click();
		    
		    pause(1000);
		    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
		    driver.findElement(By.xpath("//div[3]/button")).click();
		    pause(3000);
		    assertEquals("Vero",driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr[1]/td[1]")).getText());

		   
		  }
		  @Test
		  public void btestRetrieve() throws Exception {
			  	driver.get("https://mern-crud.herokuapp.com/");
		
			    pause(3000);
			    assertEquals("Vero",driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr[1]/td[1]")).getText());

			    
			  }
		  @Test
		  public void ctestUpdate() throws Exception {
		    driver.get("https://mern-crud.herokuapp.com/");
		  
		    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button")).click();
		    driver.findElement(By.name("email")).click();
		    pause(3000);

		    driver.findElement(By.name("email")).sendKeys("om");
		    driver.findElement(By.xpath("//form/button")).click();
		    pause(2000);
		    assertEquals("Successfully updated!",driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p")).getText());
		    
		  }
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	

	  private void pause(long mils) {
		  try {
			  Thread.sleep(mils);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }

	
}
