package orangeHam;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SybolForLogout {
  WebDriver driver;

  @Before
    public void verifylogoutsymbol(){
      String url = "https://opensource-demo.orangehrmlive.com";
      System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      driver.get(url);
  }
  @Test
    public void logout(){

    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
    driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
    driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
    driver.findElement(By.xpath("//a[text()='Welcome Paul']")).click();
    //driver.findElement(By.xpath("//a[text()='Logout']")).click();
    String expectederrormessage = "welcome Paul";
    WebElement errormessageIS = driver.findElement(By.id("welcome"));

    String actualmessage = errormessageIS.getText();
    Assert.assertEquals("Welcome message is correct",expectederrormessage,actualmessage);
    driver.findElement(By.xpath("//a[text()='Logout']")).click();
  }
  @Test
  public void verifyMessageAfterLogout (){

    String expectedLogoutMessage= "Login Panel";
    WebElement logoutPanel = driver.findElement(By.id("logInPanelHeading"));
    String actualLogoutMessage= logoutPanel.getText();
    Assert.assertEquals("User logout successfully", expectedLogoutMessage,actualLogoutMessage);
  }

  @After
  public void teardown(){
    driver.quit();
  }

}
