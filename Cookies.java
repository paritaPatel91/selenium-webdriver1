import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

import java.util.Set;

public class Cookies {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void cookieTest() throws InterruptedException {

        //using onda currency converter site

        driver.get("https://www1.oanda.com/currency/converter/");

        WebElement input = driver.findElement(By.id("base_currency_input"));
        input.sendKeys("CAD");
        input.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.navigate().refresh();
        driver.manage().deleteCookieNamed("base_currency_0");
        Thread.sleep(5000);
        driver.navigate().refresh();
       Cookie cookie = new Cookie("base_currency_0","AUD");
       driver.manage().addCookie(cookie);
        Thread.sleep(500);
        driver.navigate().refresh();
        driver.manage().deleteAllCookies();
        Thread.sleep(500);
        driver.navigate().refresh();

        //how cookie will behave

        Set<Cookie> cookies = driver.manage().getCookies();
       System.out.println(cookies);

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }


}
