import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class SearchTests extends TestBase{

    @Test
    public void searchForItems(){
        HomePage home = new HomePage(driver);
        home.SearchForProduct("shirt");
        int size = home.elementTitleSize();
        for(int i=0; i<size;i++){
            String actualTitle = home.elementTitleText(i).toLowerCase().trim();
            Assert.assertTrue(actualTitle.contains("shirt"));
        }
    }
}
