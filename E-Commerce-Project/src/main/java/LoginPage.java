import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase{


    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    WebElement openLoginPage = driver.findElement(By.xpath("//a[@href='/login?returnUrl=%2F']"));
//    WebElement email = driver.findElement(By.xpath("//input[@class='email']"));
//    WebElement password = driver.findElement(By.xpath("//input[@name='Password']"));
//    WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));

    private static final By openLoginPage = By.xpath("//a[@href='/login?returnUrl=%2F']");
    private static final By email = By.xpath("//input[@class='email']");
    private static final By password = By.xpath("//input[@name='Password']");
    private static final By loginButton = By.xpath("//button[@class='button-1 login-button']");

    public void loginInfo(String emailN , String password1)throws  InterruptedException{
        click(openLoginPage);
        sendValue(email , emailN);
        Thread.sleep(2000);
        sendValue(password,password1);
        click(loginButton);

    }
}
