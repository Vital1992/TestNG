package lowes;

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
public class TestAndroidApp {
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
    capabilities.setCapability(MobileCapabilityType.APP, "/Users/vitaly.cherkasov/ContactManager.apk");
    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

    driver = new AndroidDriver<MobileElement>(url, capabilities);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.resetApp();
  }

  @Test (enabled=true) public void addcontact() throws InterruptedException {
	  //WebDriverWait wait = new WebDriverWait (driver, 10);
	  //wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("Add Contact")));
	  driver.findElementByAccessibilityId(Locators.AddContact).click();	
	  driver.findElement(By.id(Locators.ContactNameEdit)).sendKeys("test");	
	  driver.findElement(By.id(Locators.ContactEmailEdit)).sendKeys("test@gmail.com");
	  driver.findElementByAccessibilityId(Locators.Save).click();
	  driver.quit();
  }
}

