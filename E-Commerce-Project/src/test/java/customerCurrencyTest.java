import org.testng.Assert;
import org.testng.annotations.Test;

public class customerCurrencyTest extends TestBase{




    @Test
    public  void selectDollarFromCurrencies(){
        HomePage home = new HomePage(driver);
        home.selectCurrency("US Dollar");
        int size =home.elementPricesSize();
        for(int i=0; i<size; i++){
         String actualPrice = home.elementPricesText(i);
            Assert.assertTrue(actualPrice.contains("$"));
        }

    }

    @Test
    public  void selectEuroFromCurrencies(){
        HomePage home = new HomePage(driver);
        home.selectCurrency("Euro");
        int size =home.elementPricesSize();
        for(int i=0; i<size; i++){
            String actualPrice = home.elementPricesText(i);
            Assert.assertTrue(actualPrice.contains("€"));
        }

    }


}
