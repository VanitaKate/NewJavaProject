package Utilities;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseClass {

	public static WebDriver driver;
//    protected SauceSession session;
    protected RemoteWebDriver Rdriver;
	public static WebDriverWait wait;
	public static String Browser;
	public static String BrowserName;
	@BeforeClass(alwaysRun = true)
	@Test
	public void setUp() throws Throwable {
		Browser=System.getProperty("Browser");
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
		caps.setCapability("sauce:options", sauceCap);	
		caps.setCapability("browserName", Browser);
		driver = new RemoteWebDriver(new URL("https://"+User_Name+":"+AccessKey+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), caps);	

		System.out.println("Browser Name is :    ***************"+Browser+"**************");

//		sauceOptions.put("name", testInfo.getDisplayName());

//		options.setCapability("sauce:options", sauceOptions);



		driver.get("Https://google.com");
		System.out.println(driver.getCurrentUrl());
	
	}
}
