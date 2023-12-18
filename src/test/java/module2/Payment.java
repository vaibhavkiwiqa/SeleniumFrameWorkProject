package module2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseInit;
import utility.MyLibrary;

public class Payment extends BaseInit{
	
	@BeforeTest
	public static void setUp() throws Exception {

		startUP();

	}
  @Test
	public void testPayment() throws InterruptedException 
	{
		MyLibrary.signIn();
		SearchProduct.testSearchProduct();  
		Thread.sleep(1000);
		isElementPresent("lnk_checkout_linkText").click();
		driver.findElement(By.name("comments")).sendKeys("New product is added");
		isElementPresent("btn_continue_id").click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/form/div/div[4]/table[1]/tbody/tr/td[2]/input")).click();
		driver.findElement(By.name("comments")).sendKeys("Product is confirmed");
		isElementPresent("btn_continue_id").click();
		Thread.sleep(2000);
		isElementPresent("btn_confirmorder_id").click();
		
		
	}
}
