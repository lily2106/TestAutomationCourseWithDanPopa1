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
import pages.actions.AccountServices;
import pages.actions.AuthenticationUtils;
import pages.actions.HomePage;

public class TransferFundsBetweenAccounts {

    private WebDriver driver;
    private AccountServices accountServices;

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

    @When("I click on the Transfer Funds link")
    public void i_click_on_the_transfer_funds_link() {

        accountServices = new AccountServices(driver);
        accountServices.clickOnTheTransferFundsButton();
    }
    @And("I transfer {int} between two of my accounts")
    public void i_transfer_between_two_of_my_accounts(Integer int1) {

    }
    @Then("the transfer should be successful")
    public void the_transfer_should_be_successful() {

    }
    @And("the account balances should be updated")
    public void the_account_balances_should_be_updated() {

    }

    @After
    public void teardownDriver(){
        if (driver != null){
            driver.quit();
        }

}
