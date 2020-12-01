import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ZoomTesting {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testZoom() throws InterruptedException {
        driver.get("https://www.cn.ca/en/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("truste-consent-button")).click();

        // is didplay method //
        //-----------------------------------//

        WebElement email1 = driver.findElement(By.id("signupfree"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none'",email1);

        //  Thread.sleep(8000);

         // getposition, get location , get rectangal
//        --------------------------------------------------------

//        System.out.println(email.getLocation().x);
//        System.out.println(email.getLocation().y);
//        System.out.println(email.getRect().height);
//        System.out.println(email.getRect().width);
//        System.out.println(email.getSize().height);
//        System.out.println(email.getSize().width);
//
//        // Thread.sleep(5000);
//        System.out.println(email.isDisplayed()?"Displayed": "Hidden");
//        System.out.println(email.getCssValue("border-color"));
//        System.out.println(email.getCssValue("background-color"));


        System.out.println(email1.isDisplayed()?"Displayed": "Hidden");



       // WebElement sales = driver.findElement(By.xpath("//div[@id='navbar']/ul/li[9]/a"));
        WebElement sales = driver.findElement(By.linkText("Contact Sales"));
        sales.click();
//-------------------------------------------------------------
//         fill up all information zoom contact sales
//        -------------------------------------------------
//
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("ppatel23@Gamil.com");
        driver.findElement(By.cssSelector("#company")).sendKeys("Apotex");

        driver.findElement(By.id("first_name")).sendKeys("Parita");

        driver.findElement(By.id("last_name")).sendKeys("Patel");

        WebElement employee_count = driver.findElement(By.id("employee_count"));
        Select empSelect = new Select(employee_count);
        empSelect.selectByValue("11-50");

        driver.findElement(By.id("phone")).sendKeys("25464729028");

        driver.findElement(By.id("country")).sendKeys("Canada");

        driver.findElement(By.id("state")).sendKeys("ontario");

        driver.findElement(By.id("city")).sendKeys("l839feu");

        driver.findElement(By.id("description")).sendKeys("Important Information");
        driver.findElement(By.id("btnSubmit")).click();

        driver.findElement(By.id("gdpr-optin")).click();

    }
        //------------------------------
        // By clicking over mouse actions::
        //------------------------------

        WebElement solutions = driver.findElement(By.id("btnSolutions"));

        WebElement element1 = driver.findElement(By.id("second-col-nav"));

        WebElement webElement1 = driver.findElement(By.xpath("//li[@id='second-col-nav']//div//a[1]"));


//    for cn.ca site on google
//         driver.get("https://www.cn.ca/en/");
//
//        WebElement element = driver.findElement(By.id("ctl06__99fcc438929770_repMainNav_topLevelLink_1"));
//
//        WebElement webElement = driver.findElement(By.id("ctl06__99fcc438929770_repMainNav_repSecondLevel_1_secondLevelLink_5"));
//
//        WebElement otherElements = driver.findElement(By.id("ctl06__99fcc438929770_repMainNav_repSecondLevel_1_repThirdLevel_5_thirdLevelLink_2"));
//
//        WebElement nothing = driver.findElement(By.id("ctl06__99fcc438929770_repMainNav_repSecondLevel_1_repThirdLevel_5_repFourthLevel_2_fourthLevelLink_0"));
//
//
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element)
//                .pause(4000)
//                .moveToElement(webElement)
//                .pause(4000)
//                .moveToElement(otherElements)
//                .pause(4000)
//                .moveToElement(nothing)
//                .pause(4000)
//                .click()
//                .build()
//                .perform();
    

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);

    }
}
