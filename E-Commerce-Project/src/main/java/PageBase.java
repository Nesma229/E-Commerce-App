import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;


public class PageBase {

    protected WebDriver driver;
//    private WebDriverWait wait;
//    private static final int TIMEOUT = 5;

    public PageBase(WebDriver driver) {
        this.driver = driver;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }
    protected List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

//    protected void clearinput(By locator){
//        find(locator).clear();
//    }

//    public void clickjs(By locator) {
//
//        JavascriptExecutor executor=(JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", find(locator));
//    }

    protected  String getText(By locator){
        String actual = find(locator).getText();
        return actual;
    }

    protected     void click(By locator){
        find(locator).click();
    }
    protected     void sendValue(By locator, String value){
        find(locator).sendKeys(value);
    }

    protected void Select(By locator,String text){

        Select locatorSelect  = new Select(find(locator));
        locatorSelect.selectByVisibleText(text);    }

    public  String elementText(int index , By locator){
        return findElements(locator).get(index).getText();
    }

    public  int elementSize(By locator){
        return findElements(locator).size();
    }

    public void hoverAction(int index , By locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElements(locator).get(index)).perform();

    }


}
