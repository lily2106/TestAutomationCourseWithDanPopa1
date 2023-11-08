package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.actions.AuthenticationUtils;
import pages.actions.HomePage;
import utility.BaseTest;

public class RegisterNewUser extends BaseTest {

    @BeforeMethod
    public void setup(){
        //Initialize the ExtentTest instance for this test
        initTest( "Register new user");
    }

    @Test
    public void registerNewUser(){

        HomePage homePage = new HomePage(driver);
        homePage.clickOnRegisterButton();

        String username = RandomStringUtils.randomAlphabetic(9);
        String passwword = RandomStringUtils.randomAlphabetic(10);

        System.out.println("Username: " + username + ", password" + passwword);

        AuthenticationUtils authenticationUtils = new AuthenticationUtils(driver);
        authenticationUtils.registerUser(username, passwword);

//        homePage.loginUser(username, passwword);

    }


}
