package JenkinsParametersTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Utilities.BaseClass;

public class VerifyGoogle extends BaseClass {
public WebDriver driver;


@Test
	public void OpenGoogle( ) throws IOException {
	Properties pro=new Properties();
	
	System.out.println("==================="+System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties"+"===================");
	pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties")));
	String Browser=pro.getProperty("BrowserParameter");
	String BrowserName=System.getProperty("BrowserName");
System.out.println(Browser);
System.out.println(BrowserName+"************");
		if (Browser.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if (Browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		driver.get("https://google.co.in");
	}

}
