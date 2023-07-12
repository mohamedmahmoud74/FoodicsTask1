package Tests;

import Pages.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class googleSearch extends TestBase {


    GooglePage SearchObj;

    @Test
    public void GoogleSearch() throws InterruptedException {
        SearchObj = new GooglePage(driver);
        SearchObj.InsertSarechWord("Mohammed Salah");
        SearchObj.SubmitSearchField();
        SearchObj.ClearSearchField();
        SearchObj.InsertSarechWord(" Mohamed Abo Treka");
        SearchObj.SubmitSearchField();
        int resultNumber = SearchObj.numberOfResualt(1);
        Assert.assertTrue(resultNumber > 0);
        SearchObj.scroll();
        SearchObj.clickOnNextButton();
        int Result1 = SearchObj.numberOfResualt(4);
        SearchObj.scroll();
        SearchObj.nextButton();
        int Result2 = SearchObj.numberOfResualt(4);
        Assert.assertTrue(Result1 == Result2);
        int searchSuggestions = SearchObj.elements().size();
        Assert.assertTrue(searchSuggestions > 0);
    }
}
