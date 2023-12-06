package module2;

import org.openqa.selenium.Keys;
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
		isElementPresent("ip_search_name").sendKeys("JBL T450");
		isElementPresent("ip_search_name").sendKeys(Keys.ENTER);
		logs.info(driver.getTitle());
		
		
		
	}
}
