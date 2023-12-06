package module1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseInit;

public class Extractlinks extends BaseInit {
	
	
	@BeforeTest
	public static void setUp() throws Exception {

		startUP();
	}
	
	@Test
	public void testExtractlinks() throws InterruptedException 
	{
		driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		WebElement main=driver.findElement(By.xpath("//*[@id=\"right_sidebar\"]/div[2]/div[2]"));
		List<WebElement> list=main.findElements(By.tagName("a"));
		System.out.println(list.size());
		
		for(int counter=0;counter<list.size();counter++) {
			
			
			list.get(counter).click();
			logs.info(driver.getTitle()+">>" +driver.getCurrentUrl());
			driver.navigate().back();
            main=driver.findElement(By.xpath("//*[@id=\"right_sidebar\"]/div[2]/div[2]"));
		    list=driver.findElements(By.tagName("a"));
		}
		
	}

}
