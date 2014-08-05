package seleniumautomation.test;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility<Webelement> {
	
	WebDriver driver;
	PathType p;
	WebElement element;
	String extractPath;
	
	public Utility(WebDriver driver)
	{
		this.driver=driver;
		
	}// Utility
	
	public String getElementLocator(String elementType)
	{
		int i=elementType.indexOf('.');
		extractPath=elementType.substring(i+1);
		return extractPath;	
		
	}
	public WebElement getElement(String elementType, String elementName)
	{
		String path= getElementLocator(elementType);
		p=PathType.valueOf(path);
		
		try
		{
			switch(p)
			{
			case id:
				element =driver.findElement(By.id(elementName));
				break;
			case xpath:
				element =driver.findElement(By.xpath(elementName));
				break;
			case css:
				element =driver.findElement(By.cssSelector(elementName));
				break;
			case name:
				element =driver.findElement(By.name(elementName));
				break;
				
			}// switch
		}// try
		catch(NoSuchElementException ex)
		{
			
		}
		return element;
		
	}// WebelementgetElement

}
