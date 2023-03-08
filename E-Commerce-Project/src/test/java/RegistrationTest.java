import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest extends TestBase{


@Test(priority = 1)
public void validRegister() throws InterruptedException {

    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.registerInfo("Nesma1","Adel","30", "September","1999" , "nesma1@gmail.com","Nes1_1999","Nes1_1999");
    String actualResult = registrationPage.getText(By.xpath("//div[@class='result']"));
    //String actualResult = driver.findElement(By.xpath("//div[@class='result']")).getText();
    String expectedResult = "Your registration completed";
    Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority = 2)
    public  void registerWithExistingAcc() throws InterruptedException{

    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.registerInfo("Nesma1","Adel","30", "September","1999" , "nesma1@gmail.com","Nes1_1999","Nes1_1999");
    String actualEmailExistsErrorMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']/ul/li")).getText();
    String expectedEmailExistsErrorMsg = "The specified email already exists";
    Assert.assertTrue(actualEmailExistsErrorMsg.contains(expectedEmailExistsErrorMsg));

    }


    @Test
    public void registerWithInvalidEmail() throws InterruptedException{

    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.registerInfo("Nesma1","Adel","30", "September","1999" , "nesma1gmail.com","Nes1_1999","Nes1_1999");
    String actualEmailErrorMsg = driver.findElement(By.xpath("//span[@id='Email-error']")).getText();
    String expectedEmailErrorMsg = "Wrong email";
    Assert.assertTrue(actualEmailErrorMsg.contains(expectedEmailErrorMsg));

    }


    @Test
    public void registerWithBlankEmail() throws InterruptedException{

    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.registerInfo("Nesma1","Adel","30", "September","1999" , "","Nes1_1999","Nes1_1999");
    String actualEmptyEmailErrorMsg = driver.findElement(By.xpath("//span[@id='Email-error']")).getText();
    String expectedEmptyEmailErrorMsg = "Email is required.";
    Assert.assertTrue(actualEmptyEmailErrorMsg.contains(expectedEmptyEmailErrorMsg));

    }



    @Test
    public  void registerWithInvalidPassword() throws InterruptedException{

    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.registerInfo("Nesma1","Adel","30", "September","1999" , "nesma1gmail.com","Nes1","");
    String actualPassErrorMsg = driver.findElement(By.xpath("//span[@id='Password-error']")).getText();
    String expectedPassErrorMsg = "must have at least 6 characters";
    Assert.assertTrue(actualPassErrorMsg.contains(expectedPassErrorMsg));
    }


    @Test
    public void registerWithBlankPassword() throws InterruptedException{

    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.registerInfo("Nesma1","Adel","30", "September","1999" , "nesma1gmail.com","","");
    String actualEmptyPassErrorMsg = driver.findElement(By.xpath("//span[@id='Password-error']")).getText();
    String expectedEmptyPassErrorMsg = "Password is required.";
    Assert.assertTrue(actualEmptyPassErrorMsg.contains(expectedEmptyPassErrorMsg));
    }



    @Test
    public void registerWithNotMatchConfPass() throws InterruptedException{

    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.registerInfo("Nesma1","Adel","30", "September","1999" , "nesma1gmail.com","Nes1_1999","nes");
    String actualConfPassErrorMsg = driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText();
    String expectedConfPassErrorMsg = "The password and confirmation password do not match";
    Assert.assertTrue(actualConfPassErrorMsg.contains(expectedConfPassErrorMsg));
    }



    @Test
    public void registerWithBlancConfPass() throws InterruptedException{

    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.registerInfo("Nesma1","Adel","30", "September","1999" , "nesma1gmail.com","Nes1_1999","");
    String actualEmptyConfPassErrorMsg = driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText();
    String expectedEmptyConfPassErrorMsg = "Password is required.";
    Assert.assertTrue(actualEmptyConfPassErrorMsg.contains(expectedEmptyConfPassErrorMsg));

    }








}
