package module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseInit;

public class SearchProduct extends BaseInit {

	@BeforeTest
	public static void setUp() throws Exception {

		startUP();
	}
	@Test
	public static void testSearchProduct() {
		driver.get(prop.getProperty("url"));
		isElementPresent("ip_search_name").sendKeys("JBL");
		isElementPresent("ip_search_name").sendKeys(Keys.ENTER);
		//logs.info(driver.getTitle());
		
		WebElement mainsearch=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div"));
		List<WebElement> searchproduct=mainsearch.findElements(By.tagName("a"));
		
		for(int counter=0;counter<searchproduct.size();counter++) {
			
			String productname=searchproduct.get(counter).getText();
			
			if(productname.equalsIgnoreCase("JBL T250SI")) {
				
				isElementPresent("lnk_product_linkText").click();
				isElementPresent("btn_addtocart_id").click();
			}
			else
			{
				
				System.out.println("No product found");
			}
		}
		
		
		
	}
}
