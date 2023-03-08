import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final By currency = By.id("customerCurrency");
    private static final By elementPrice = By.xpath("//span[@class='price actual-price']");
    private static final By searchField = By.xpath("//input[@id=\"small-searchterms\"]");

    private static final By searchButton = By.xpath("//button[@type=\"submit\"]");

    private static final By elementTitle = By.xpath("//h2[@class=\"product-title\"]/a");
    private static final By categories = By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a");
    private static final By pageTitle = By.xpath("//div[@class=\"page-title\"]/h1");
    private static final By noteBooks = By.xpath("(//ul[@class=\"sublist first-level\"]/li/a)[2]");







    //currancy

    public void selectCurrency(String currencyType){

       Select(currency,currencyType);
   }


    public String elementPricesText(int index){

     return elementText(index, elementPrice);
    }

    public int elementPricesSize(){

      return   elementSize(elementPrice);
    }

    //search

    public void SearchForProduct(String productName){
        sendValue(searchField,productName);
        click(searchButton);

    }
    public String elementTitleText(int index){

        return elementText(index, elementTitle);
    }

    public int elementTitleSize(){

        return   elementSize(elementTitle);
    }

    //hover

    public void hoverCategory(int index){
        hoverAction(index,categories);
    }
    public void clickNoteBooks(){
        click(noteBooks);
    }

    public String pageText(){
       return getText(pageTitle);
    }





}
