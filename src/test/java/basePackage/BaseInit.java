package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseInit {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logs;

	public static void startUP() throws Exception {
		logs = Logger.getLogger("devpinoyLogger");
		logs.info("Property file will be loaded soon");
		prop = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/java/sitedata/Sitedata.properties");
		prop.load(fi);
		logs.info("Property file is loaded successfully");
		String browserVal = prop.getProperty("browser");
		if (browserVal.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			logs.info("Chrome browser is opened");
		} else if (browserVal.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			logs.info("Safari browser is opened");
		} else if (browserVal.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			logs.info("firefox browser is opened");
		} else {
			System.out.println("No browser will be open");
			logs.info("No browser will be open");

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public static WebElement isElementPresent(String propKey) {
		
		try {
			if(propKey.contains("xpath")) {
				
				 return driver.findElement(By.xpath(prop.getProperty(propKey)));
			}
			else if(propKey.contains("id")) {
				
				 return driver.findElement(By.id(prop.getProperty(propKey)));
			}
			else if(propKey.contains("name")) {
				
				 return driver.findElement(By.name(prop.getProperty(propKey)));
		    }
			else if(propKey.contains("linkText")) {
				
				 return driver.findElement(By.linkText(prop.getProperty(propKey)));
			}
			else {
				
				System.out.println("Location is not found in property file");
			}
			
			
			
		}
		catch(Exception e) {
			
		}
		return null;
		
	}
	
}
