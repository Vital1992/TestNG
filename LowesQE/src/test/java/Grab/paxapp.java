package Grab;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
public class paxapp {
  public static URL url;
  public static DesiredCapabilities capabilities;
  public static AndroidDriver<MobileElement> driver;
  
  @BeforeSuite
  public void setupAppium() throws MalformedURLException {

    final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
    url = new URL(URL_STRING);

    capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
    capabilities.setCapability(MobileCapabilityType.APP, "/Users/vitaly.cherkasov/Downloads/debug-5.59.04518978-universal-50590000-4518978.apk");
    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.grab.pax.newface.presentation.newface.NewFace");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.grabtaxi.passenger.com.grab.pax.newface.presentation.newface.NewFace");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.grab.on_boarding.ui.OnBoardingActivity");
    capabilities.setCapability("appPackage", "com.grabtaxi.passenger");

    driver = new AndroidDriver<MobileElement>(url, capabilities);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    //driver.resetApp();
  }

  @Test (enabled=true) public void addcontact() throws InterruptedException {
	  driver.resetApp();
	  WebDriverWait wait = new WebDriverWait (driver, 10);
	  wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("android:id/button1")));
	  driver.findElement(By.id("android:id/button1")).click();
	  driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	  driver.findElement(By.id("com.grabtaxi.passenger:id/on_boarding_google_login_button")).click();

	 /*
	  driver.findElementByAccessibilityId(Locators.AddContact).click();	
	  driver.findElement(By.id(Locators.ContactNameEdit)).sendKeys("test");	
	  driver.findElement(By.id(Locators.ContactEmailEdit)).sendKeys("test@gmail.com");
	  driver.findElementByAccessibilityId(Locators.Save).click();
	  */
	  driver.quit();
  }
}

