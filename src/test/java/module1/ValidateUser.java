package module1;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseInit;
import utility.MyLibrary;

public class ValidateUser extends BaseInit {

	@BeforeTest
	public static void setUp() throws Exception {

		startUP();
	}

	@Test
	public static void testValidateUser()

	{
		MyLibrary.signIn();
		try {

			driver.findElement(By.linkText("new products")).isDisplayed();
			logs.info("User has been login successfully");

		} catch (Exception e) {

			logs.info("Invalid Username & Password");
		}

	}
}
