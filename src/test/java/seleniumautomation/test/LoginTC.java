package seleniumautomation.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.functors.SwitchTransformer;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.webbitserver.WebbitException;

import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;
import com.thoughtworks.selenium.Wait;

public class LoginTC {	
	Properties prop = new Properties();
	
	@BeforeTest 
	public void Startup() throws IOException
	{
		
		FileInputStream objfile = new FileInputStream(new File("./src/main/Object_Repository.properties"));
		prop.load(objfile);
		
		String username=prop.getProperty("username.id");
		System.out.println("Property Value is :"+username);
	}

  @Test
  public void test() throws InterruptedException
  {
	try
	{
	  WebDriver driver = new FirefoxDriver();
	  driver.get("https://wordpress.com/wp-login.php");
//	  WebElement uname =driver.findElement(By.id("user_login"));
//	  uname.click();
//	  uname.sendKeys("pr.deshmukh1@gmail.com");
	  
	  String username=prop.getProperty("username.id");
	  System.out.println("Property Value is :"+username);
	  WebElement uname =driver.findElement(By.id(username));
	  uname.click();
	  uname.sendKeys("pr.deshmukh1@gmail.com");
//	  
	  WebElement passwd =driver.findElement(By.id("user_pass"));
	  passwd.click();
	  passwd.sendKeys("uranium235");
//	  driver.wait(2000);
	  WebElement signinbtn =driver.findElement(By.id("wp-submit"));
	  signinbtn.click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
//	  Assert.assertTrue(driver.findElement(By.linkText("Welcome to booking history")).isDisplayed());
	  WebElement newpost_link =driver.findElement(By.partialLinkText("New Post"));
	  newpost_link.click();
	  
	  
	  WebElement post_title =driver.findElement(By.id("title"));
	  post_title.click();
	  post_title.sendKeys("Prashants Post");
	  String Parenthandel= driver.getWindowHandle();
//	  WebElement frame=driver.findElement(By.id("edit-content_ifr"));
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
