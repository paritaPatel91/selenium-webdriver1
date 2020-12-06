import jdk.internal.cmm.SystemResourcePressureImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ImplicitWaitTest {

    // implicit and explicit timeout

 private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://zoom.us/");
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testImplicitWaits() throws InterruptedException {
        WebElement signUpBTN = driver.findElement(By.cssSelector("#signupfree>a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility ='hidden'", signUpBTN);

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement trustBTTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("truste-consent-button")));
        trustBTTN.click();


        ((JavascriptExecutor) driver).executeAsyncScript("setTimeout(function(){ $('#signupfree>a').css('visibility','visible');},5000)");

        WebElement webElement = wait.until(ExpectedConditions.visibilityOf(signUpBTN));

        signUpBTN.click();



    }
        @AfterSuite
        public void tearDown () {
            driver.quit();
        }
    }
