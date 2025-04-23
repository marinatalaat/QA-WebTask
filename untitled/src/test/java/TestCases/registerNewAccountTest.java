package TestCases;

import Helpers.PropertiesLoader;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Random;

import static Helpers.Utils.takeScreenShot;

public class registerNewAccountTest {

    String FilePath="ConfigData/Data.properties";
    String URL, firstName, lastName, email, password;
    public WebDriver driver;


    @Test(dataProvider = "new account details data")
    public void registerNewAccountWithValidData(){
        new HomePage(driver).clickOnSignUpLink().
                fillFormWithValidData(firstName, lastName, email, password)
                .ClickRegisterButton()
                .validateOnAccountDetails(firstName, lastName, email)
                .clickOnTheLogo()
                .scrollDownToHotSellerSection()
                .clickOnSecondItem()
                .addItemsToCart("2")
                .clickOnAddToCompareListBtn();

    }




    // Configurations
    @BeforeClass
    public void startDriver() {
        driver = new ChromeDriver();
        new HomePage(driver).navigateToHomepage(URL);

    }

    @BeforeMethod
    public void methodSetup(){
        URL = PropertiesLoader.readPropertyFile(FilePath).getProperty("URL");
        firstName = PropertiesLoader.readPropertyFile(FilePath).getProperty("firstName");
        lastName = PropertiesLoader.readPropertyFile(FilePath).getProperty("lastName")+new Random().nextInt();
        email = lastName + PropertiesLoader.readPropertyFile(FilePath).getProperty("email");
        password = PropertiesLoader.readPropertyFile(FilePath).getProperty("password") + lastName;

        System.out.println(firstName +" / " + lastName +" / " + email +" / " + password);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE)
            takeScreenShot(driver, result);
    }
    @AfterClass
    public void TearDown() {
        driver.quit();
    }
}
