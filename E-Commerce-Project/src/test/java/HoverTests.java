import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTests extends TestBase{

    @Test
    public void chooseNoteBooksFromHoverCategories(){
        HomePage home = new HomePage(driver);
        home.hoverCategory(0);
        home.clickNoteBooks();
        String actualPageTitle = home.pageText();
        Assert.assertTrue(actualPageTitle.contains("Notebooks"));
    }
}
