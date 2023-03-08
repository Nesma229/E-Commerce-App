import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public  void validLogin() throws InterruptedException{

      LoginPage  loginPage = new LoginPage(driver);
      loginPage.loginInfo("nesma1@gmail.com" , "Nes1_1999");


    }

    @Test
    public void loginWithInvalidEmail() throws InterruptedException{

        LoginPage  loginPage = new LoginPage(driver);
        loginPage.loginInfo("nesma1gmail.com" , "Nes1_1999");

        String actualEmailErrorMsg = driver.findElement(By.xpath("//span[@id='Email-error']")).getText();
        String expectedEmailErrorMsg = "Wrong email";
        Assert.assertTrue(actualEmailErrorMsg.contains(expectedEmailErrorMsg));

    }

    @Test
    public void loginWithBlankEmail() throws  InterruptedException{

        LoginPage  loginPage = new LoginPage(driver);
        loginPage.loginInfo("" , "Nes1_1999");

        String actualEmptyEmailErrorMsg = driver.findElement(By.xpath("//span[@id='Email-error']")).getText();
        String expectedEmptyEmailErrorMsg = "Please enter your email";
        Assert.assertTrue(actualEmptyEmailErrorMsg.contains(expectedEmptyEmailErrorMsg));

    }


    @Test
    public void loginWithInvalidOrBlankPass() throws  InterruptedException{

        LoginPage  loginPage = new LoginPage(driver);
        loginPage.loginInfo("nesma@1gmail.com" , "Nes");

        String actualPassErrorMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        String expectedPassErrorMsg = "Login was unsuccessful. Please correct the errors and try again.";
        Assert.assertTrue(actualPassErrorMsg.contains(expectedPassErrorMsg));


    }




}
