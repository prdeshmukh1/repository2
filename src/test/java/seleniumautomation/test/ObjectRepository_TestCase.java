package seleniumautomation.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ObjectRepository_TestCase {
	
	Properties prop = new Properties();
	  Utility util;
	@BeforeTest 
	public void Startup() throws IOException
	{
		
		FileInputStream objfile = new FileInputStream(new File("./src/main/Object_Repository.properties"));
		prop.load(objfile);
		
		String username=prop.getProperty("username.id");
		System.out.println("Property Value is :"+username);
	}
	
	
	 @Test
	  public void testwithproperties() throws InterruptedException
	  {
		try
		{
		  WebDriver driver = new FirefoxDriver();
		  driver.get("https://wordpress.com/wp-login.php");

		  util = new Utility(driver);
		  
		  String userId=prop.getProperty("username.id");
		  WebElement username=util.getElement("username.id",userId);		  
		  username.sendKeys("pr.deshmukh1@gmail.com");
//		  
		  String passwd=prop.getProperty("user_pass.id");
		  WebElement password=util.getElement("user_pass.id",passwd);
		  password.click();
		  password.sendKeys("%#$Boron5");

		  
		  String signinbtn=prop.getProperty("signinbtn.id");
		  WebElement signin=util.getElement("signinbtn.id",signinbtn);
		  signin.click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  WebElement newpost_link =driver.findElement(By.partialLinkText("New Post"));
		  newpost_link.click();
  
		  WebElement post_title =driver.findElement(By.id("title"));
		  post_title.click();
		  post_title.sendKeys("Prashants Post");
		  String Parenthandel= driver.getWindowHandle();
//		  WebElement frame=driver.findElement(By.id("edit-content_ifr"));
		  driver.switchTo().frame("edit-content_ifr");
		  WebElement desc_text=driver.findElement(By.id("tinymce"));
		  desc_text.sendKeys("Prashant Post");	  
		  driver.switchTo().window(Parenthandel);  
		  
		  WebElement btn_publish=driver.findElement(By.id("publish-button"));
		  btn_publish.click();  
		  
		  driver.quit();
			  
		}
	  catch(Throwable e)
		{
		  System.out.println("Exception is: "+e);
		}
	  }
	  
}
