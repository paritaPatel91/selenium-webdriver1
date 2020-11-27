import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomeTest {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void testDriver() throws InterruptedException {
        driver.get("https://zoom.us");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("truste-consent-button")).click();

        WebElement element = driver.findElement(By.linkText("Contact Sales"));

        element.click();

       driver.manage().window().setSize(new Dimension(960,960));
  driver.manage().window().setPosition(new Point(500,200));
        System.out.println(driver.manage().window().getPosition().x);
        System.out.println(driver.manage().window().getPosition().y);
        System.out.println(driver.manage().window().getSize());


        Thread.sleep(5000);
        driver.navigate().forward();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().refresh();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).pause(100).click(element).build().perform();

        Thread.sleep(5000);

        String mixerWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();


        ((JavascriptExecutor) driver).executeScript("alert(\"from my HAV\")");

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

        System.out.println(mixerWindow);
        System.out.println(windows);

        for (String ohk : windows) {
           if (mixerWindow != ohk) {
                driver.switchTo().window(ohk);
            }
        }
    }
  @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
       driver.quit();
  }


    }








