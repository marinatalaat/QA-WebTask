package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Helpers.Utils.waitVisibilityOfElement;

public class CreateAccountPage {

    // By Locators and driver
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By registerPageTitle = By.cssSelector(".base");
    private final By formFields = By.cssSelector("form-create-account");
    private final By firstNameField = By.cssSelector("#firstname");
    private final By lastNameField = By.cssSelector("#lastname");
    private final By emailField = By.cssSelector("#email_address");
    //try using css
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By confirmPasswordField = By.cssSelector("#password-confirmation");
    private final By registerButton = By.cssSelector(".action.submit.primary");
    private final By registerConfirmationMessage = By.cssSelector(".page.messages");


    //Texts
    private final String confirmationMessageText = "Thank you for registering with Main Website Store.";


    // Constructor
    public CreateAccountPage(WebDriver driver) {
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public CreateAccountPage fillFormWithValidData(String firstName, String lastName, String email, String password){
        waitVisibilityOfElement(wait, registerPageTitle);
        waitVisibilityOfElement(wait, formFields);

        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);

        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);

        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(password);

        return this;
    }

    public MyAccountPage ClickRegisterButton (){
        waitVisibilityOfElement(wait, registerButton);
        driver.findElement(registerButton).click();

        Assert.assertEquals(driver.findElement(registerConfirmationMessage).getText(), confirmationMessageText);
        return new MyAccountPage(driver);
    }
}
