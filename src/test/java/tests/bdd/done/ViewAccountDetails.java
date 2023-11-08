package tests.bdd;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.actions.AccountServices;
import pages.actions.AuthenticationUtils;
import pages.actions.HomePage;

public class ViewAccountDetails {

    private WebDriver driver;
    private AccountServices accountServices;
    private String firstAccountNumber;

    @Before
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Given("I am logged in to my Parabank account")
    public void i_am_logged_in_to_my_parabank_account() {

        HomePage homePage = new HomePage(driver);
        homePage.clickOnRegisterButton();

        String username = RandomStringUtils.randomAlphabetic(9);
        String passwword = RandomStringUtils.randomAlphabetic(10);

        System.out.println("Username: " + username + ", password" + passwword);

        AuthenticationUtils authenticationUtils = new AuthenticationUtils(driver);
        authenticationUtils.registerUser(username, passwword);

    }

    @When("I click on the Accounts link")
    public void i_click_on_the_accounts_link() {

        accountServices = new AccountServices(driver);
        accountServices.clickOnTheAccountOverviewButton();
    }

    @And("I select an account")
    public void i_select_an_account() throws InterruptedException {

        Thread.sleep(3000);
        firstAccountNumber = accountServices.firstAccountNumber();
        System.out.println(firstAccountNumber);
        accountServices.clickOnTheFirstAccount();
    }

    @Then("I should see the account details")
    public void i_should_see_the_account_details() {

        Assert.assertEquals(accountServices.accountDetailTitle(), "Account Details",
                "Account detail is not as expected");
        Assert.assertEquals(accountServices.accountNumberFromAccountDetail(), firstAccountNumber,
                "Account number is not as expected");
    }

    @After
    public void teardownDriver(){
        if (driver != null){
            driver.quit();
        }
    }
}
