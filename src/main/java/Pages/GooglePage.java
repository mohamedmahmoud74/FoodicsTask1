package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GooglePage extends PageBase {

    public GooglePage(WebDriver driver) {
        super(driver);
    }


    public WebElement findsearchInput() {
        return driver.findElement(By.id("APjFqb"));
    }

    public WebElement searchResult() {
        return driver.findElement(By.id("result-stats"));
    }

    public WebElement nextButton() {
        return driver.findElement(By.id("pnnext"));
    }

    public void InsertSarechWord(String SearchWord) {
        findsearchInput().sendKeys(SearchWord);
    }

    public void SubmitSearchField() {
        findsearchInput().submit();
    }

    public void ClearSearchField() {
        findsearchInput().clear();

    }


    public int numberOfResualt(int index) {
        String resultsText = searchResult().getText();
        String[] words = resultsText.split("\\s+");
        return Integer.parseInt(words[index].replaceAll(",", ""));

    }

    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2450)", "");
    }

    public void clickOnNextButton() {
        nextButton().click();
    }

    public List<WebElement> elements() {
        return driver.findElements(By.xpath("//*[@id=\"bres\"]/div/div/div/div/div[1]/div/div/span"));
    }

}



