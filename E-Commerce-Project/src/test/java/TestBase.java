import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com");
        Thread.sleep(3000);

    }

    @AfterSuite
    public void afterSuite() throws InterruptedException{

        if(null != driver) {
            Thread.sleep(3000);
            driver.close();
            driver.quit();
        }
    }


}
