package utility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseInit;

public class MyLibrary extends BaseInit {

	public static void signIn() {

		driver.get(prop.getProperty("url"));
		isElementPresent("lnk_logyourselfin_linkText").click();
		isElementPresent("ip_emailaddress_name").sendKeys("vaibhav.esprit@gmail.com");
		isElementPresent("ip_password_name").sendKeys("Test@123");
		isElementPresent("btn_signin_id").click();

	}

}
