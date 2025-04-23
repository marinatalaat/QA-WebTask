package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Helpers.Utils.ClickOnElement;
import static Helpers.Utils.waitVisibilityOfElement;

public class MyAccountPage {

    // By Locators and driver
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By myAccountPageTitle = By.cssSelector("");
    private final By detailsOfTheAccount = By.cssSelector(".block-dashboard-info");
    private final By logoLink = By.cssSelector(".header.content > a");

    // Constructor
    public MyAccountPage(WebDriver driver) {
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public MyAccountPage validateOnAccountDetails(String firstName, String lastName, String email){

        waitVisibilityOfElement(wait, myAccountPageTitle);

        Assert.assertTrue(driver.findElement(detailsOfTheAccount).getText().contains(firstName));
        Assert.assertTrue(driver.findElement(detailsOfTheAccount).getText().contains(lastName));
        Assert.assertTrue(driver.findElement(detailsOfTheAccount).getText().contains(email));

        return this;
    }

    public HomePage clickOnTheLogo(){
        ClickOnElement(driver, wait, logoLink);
        return new HomePage(driver);
    }
}
