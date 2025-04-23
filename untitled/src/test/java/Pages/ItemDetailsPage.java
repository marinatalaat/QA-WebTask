package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Helpers.Utils.ClickOnElement;
import static Helpers.Utils.waitVisibilityOfElement;

public class ItemDetailsPage {

    // By Locators and driver
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By itemDetailsPageTitle = By.cssSelector(".page-title");
    private final By xsSizeField = By.cssSelector("#option-label-size-143-item-166");
    private final By blueColorField = By.cssSelector("#option-label-color-93-item-57");
    private final By quantityNumbersField = By.cssSelector("#qty");
    private final By addToCompareListBtn = By.cssSelector(".action.tocompare");
    private final By successMessage = By.xpath("//div[@role='alert']");


    //Texts
    private String successMsgText = "You added product Breathe-Easy Tank to the ";

    // Constructor
    public ItemDetailsPage(WebDriver driver) {
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public ItemDetailsPage addItemsToCart(String itemsNumber){
        waitVisibilityOfElement(wait, itemDetailsPageTitle);
        ClickOnElement(driver, wait, xsSizeField);
        ClickOnElement(driver, wait, blueColorField);
        driver.findElement(quantityNumbersField).sendKeys(itemsNumber);
        return this;
    }

    public void clickOnAddToCompareListBtn(){
        ClickOnElement(driver, wait, addToCompareListBtn);
        waitVisibilityOfElement(wait, successMessage);

        Assert.assertTrue(driver.findElement(successMessage).getText().contains(successMsgText));
    }
}
