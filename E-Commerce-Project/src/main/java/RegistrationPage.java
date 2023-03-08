import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends  PageBase{

    public RegistrationPage(WebDriver driver) {
        super(driver);}

    private static final By regButton = By.xpath("//a[@href='/register?returnUrl=%2F']");
    private static final By genderFemale = By.xpath("//input[@value='F']");
    private static final By fName = By.xpath("//input[@id='FirstName']");
    private static final By lName = By.xpath("//input[@id='LastName']");
    private static final By birthDay =(By.xpath("//select[@name='DateOfBirthDay']"));
    private static final By birthDayDate= (By.xpath("//select[@name='DateOfBirthDay']//option[@value='1']"));
    private static final By birthMonth = By.xpath("//select[@name='DateOfBirthMonth']");
    private static final By birthMonthDate = By.xpath("//select[@name='DateOfBirthMonth']//option[@value='1']");

    private static final By birthYear = By.xpath("//select[@name='DateOfBirthYear']");
    private static final By birthYearDate = By.xpath("//select[@name='DateOfBirthYear']//option[@value='1995']");

    private static final By emailN = By.xpath("//input[@id='Email']");
    private static final By password = By.xpath("//input[@id='Password']");
    private static final By passwordConf = By.xpath("//input[@id='ConfirmPassword']");
    private static final By registerConf = By.xpath("//button[@id='register-button']");


    public void registerInfo (String firstName, String lastName,String day , String month , String year , String email, String password1, String password1Conf) throws InterruptedException {

        click(regButton);
        Thread.sleep(2000);
        click(genderFemale);
        sendValue(fName,firstName);
        sendValue(lName,lastName);
        Thread.sleep(2000);
        Select(birthDay, day);
        Select(birthMonth,month);
        Select(birthYear,year);
        Thread.sleep(2000);
        sendValue(emailN,email);
        Thread.sleep(2000);
        sendValue(password,password1);
        sendValue(passwordConf,password1Conf);
        Thread.sleep(2000);
        click(registerConf);






    }



}
