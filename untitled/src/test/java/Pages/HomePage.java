package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Helpers.Utils.*;

public class HomePage {

    // By Locators and driver
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By homePageTitle = By.cssSelector(".base");
    private final By signUpLink = By.xpath("//div[@class='panel wrapper']//a[contains(.,'Create an Account')]");
    private final By hotSellerSectionTitle = By.cssSelector(".content-heading");
    private final By secondItem = By.xpath("(//li[@class='product-item'])[2]");


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public HomePage navigateToHomepage(String URL){
        driver.navigate().to(URL);
        waitVisibilityOfElement(wait, homePageTitle);
        return this;
    }

    public CreateAccountPage clickOnSignUpLink(){
        ClickOnElement(driver, wait, signUpLink);
        return new CreateAccountPage(driver);
    }

    public HomePage scrollDownToHotSellerSection(){
        ScrollToElement(driver, hotSellerSectionTitle);
        return this;
    }

    public ItemDetailsPage clickOnSecondItem(){
        ClickOnElement(driver, wait, secondItem);

        return new ItemDetailsPage(driver);
    }

}
