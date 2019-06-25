import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.BookmarkListPageObject;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testCheckSearchResultContainsRequestedString(){

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        String searchString = "java";

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchString);

        List<WebElement> search_results = searchPageObject.getSearchResult();

        for (WebElement we : search_results){
            Assert.assertTrue("Result does not contains search world", we.getText().toLowerCase().contains(searchString));
        }
    }
    @Test
    public void testCheckSearchResultByTitleAndSubtitle(){

        SearchPageObject searchPageObject = new SearchPageObject(driver);

        String expecedTitle1 = "Java";
        String expectedSubtitle1 = "Island of Indonesia";
        String expecedTitle2 = "JavaScript";
        String expectedSubtitle2 = "Programming language";
        String expecedTitle3 = "Java (programming language)";
        String expectedSubtitle3 = "Object-oriented programming language";
        String searchRequest = "Java";

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchRequest);

        searchPageObject.waitForElementByTitleAndDescription(expecedTitle1, expectedSubtitle1);
        searchPageObject.waitForElementByTitleAndDescription(expecedTitle2, expectedSubtitle2);
        searchPageObject.waitForElementByTitleAndDescription(expecedTitle3, expectedSubtitle3);
    }
}