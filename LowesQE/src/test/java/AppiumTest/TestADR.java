package AppiumTest;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
public class TestADR {
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
	  driver.findElementById("Add Contact").click();	
	  driver.findElementById("com.example.android.contactmanager:id/contactNameEditText").sendKeys("test");	
	  driver.findElementByAccessibilityId("Save").click();
	  driver.quit();
  }
}
