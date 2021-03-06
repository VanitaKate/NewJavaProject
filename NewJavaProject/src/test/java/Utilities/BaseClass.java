package Utilities;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
//    protected SauceSession session;
    protected RemoteWebDriver Rdriver;
	public static WebDriverWait wait;
	public static String Browser;
	public static String BrowserName;
	public String User_Name;
	public String AccessKey;
	public String hub;
	
	@BeforeClass(alwaysRun = true)
	public void validateSauceCred() {
		User_Name="oauth-vani_ket-3e468";
		AccessKey="8e176690-ece8-423e-846d-3910030becb6";		
		hub="https://"+User_Name+":"+AccessKey+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	}
@Parameters({"Browser"})	
	@Test
	public void setUp(String Browser)  throws Throwable {
//		Browser=System.getProperty("Browser");
		MutableCapabilities sauceCap=new MutableCapabilities();
		String User_Name="oauth-vani_ket-3e468";
		String AccessKey="8e176690-ece8-423e-846d-3910030becb6";
		sauceCap.setCapability("platform", "Windows 10");
		sauceCap.setCapability("version", "latest");
//		sauceCap.setCapability("username","oauth-vani_ket-3e468");
//		sauceCap.setCapability("accessKey", "8e176690-ece8-423e-846d-3910030becb6");
//	ChromeOptions browserOptions = new ChromeOptions();
//		URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");

//		browserOptions.setPlatformName("Windows 10");
//		browserOptions.setBrowserVersion("latest");
	DesiredCapabilities caps=new DesiredCapabilities();
//		caps.setCapability("sauce:options", sauceCap);	
		caps.setCapability("browserName", Browser);
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");
		System.out.println("Browser Name is :    ***************"+Browser+"**************");

		if (Browser.contains("chrome")) {
	
			caps.setCapability("sauce:options", sauceCap);	
			caps.setCapability("browserName", Browser);
		}
		driver = new RemoteWebDriver(new URL("https://"+User_Name+":"+AccessKey+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), caps);	
//		driver = new RemoteWebDriver(new URL("https://@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), caps);

//		sauceOptions.put("name", testInfo.getDisplayName());

//		options.setCapability("sauce:options", sauceOptions);



		driver.get("Https://google.com");
		System.out.println(driver.getCurrentUrl()+"@@@@@@@@@@@@@@@");


	}
@AfterMethod
public void TearDown(ITestResult Result) throws Exception {
	String status=Result.isSuccess()?"passed" : "failed";
System.out.println(Result.isSuccess()+"**************");
System.out.println(Result.getStatus()+"~~~~~~~~~~~");
	if(Result.isSuccess()) {
		System.out.println(Result.getName() +": "+"session ID: "+Result.toString() +status+"~~~~~~~~~~~~~~~~~~");
		((JavascriptExecutor) driver).executeScript("sauce:job-result=passed");
		
	}else {
		System.out.println(Result.getName() +": "+"session ID: "+Result.toString() +status+"~~~~~~~~~~~~~~~~~~");
		((JavascriptExecutor) driver).executeScript("sauce:job-result=failed");
	}

	wait(3000);
	driver.quit();
}
}
