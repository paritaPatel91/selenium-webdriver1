import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

//(((    THIS IS FIRST PART OF WEBELEMENTS    ))))


public class WebElements {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void webElements() throws InterruptedException {

        //using onda currency converter site

        driver.get("https://www1.oanda.com/currency/converter/");
        Thread.sleep(5000);

        WebElement element = driver.findElement(By.id("\"quote_currency_input\""));
        Thread.sleep(2000);

        element.click();

        WebElement form = driver.findElement(By.id("ncc_detail_form"));
        form.submit();

        element.sendKeys("INR");
        Thread.sleep(5000);

        element.clear();

        System.out.println(element.getTagName());

        WebElement amount = driver.findElement(By.className("currency_amount"));
        System.out.println(amount.getTagName());


        System.out.println(element.getAttribute("id"));

        WebElement webElement = driver.findElement(By.id("range60"));

        if (webElement.isSelected()){
            System.out.println("yes it is selected");
        }else {
            System.out.println("oops not selectd");
        }
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",webElement);
        webElement.click();

        if (webElement.isSelected()){
            System.out.println("yes it is selected after clicking");
        }else {
            System.out.println("oops not selectd after clicking");
        }

        WebElement element1 = driver.findElement(By.id("quote_amount_input"));
        System.out.println(element1.isEnabled());
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('disabled','disabled');",element1);
        Thread.sleep(3000);
        System.out.println(element1.isEnabled());

        System.out.println(driver.findElement(By.id("infoDetails")).getText());

    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }


}

