package lowes;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class NewTest {
	private WebDriver driver;

//This is my test here
	
  @Test
  (priority =0, enabled=true) public void testweb1() {
	  driver.get("http://automationpractice.com/index.php");
	    driver.findElement(By.id("search_query_top")).click();
	    driver.findElement(By.id("search_query_top")).clear();
	    driver.findElement(By.id("search_query_top")).sendKeys("dress");
	    driver.findElement(By.name("submit_search")).click();
	    driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//img[@class='replace-2x img-responsive']")).click();
	    
}

  @Test
  (priority =1, enabled=true) public void testweb2() {
	  driver.get("http://automationpractice.com/index.php");
	    driver.findElement(By.id("search_query_top")).click();
	    driver.findElement(By.id("search_query_top")).clear();
	    driver.findElement(By.id("search_query_top")).sendKeys("tshirt");
	    driver.findElement(By.name("submit_search")).click();
	    Assert.assertEquals(driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText(),  "No results were found for your search \"tshirt\"");
	    
}
  
  @Test
  (priority =2, enabled=true) public void testweb3() {
	  driver.get("http://automationpractice.com/index.php");
	    driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")).getText(),  "Faded Short Sleeve T-shirts");
}
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  System.setProperty ("webdriver.chrome.driver", "chromedriver");
	  driver = new ChromeDriver();
  }
  
  @AfterTest
  public void afterTest() throws MalformedURLException {
	  driver.quit();
  }

}
