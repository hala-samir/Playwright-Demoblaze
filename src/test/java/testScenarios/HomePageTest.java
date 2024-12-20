package testScenarios;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.JSONReader;

import java.io.IOException;

public class HomePageTest extends TestBase{
    HomePage homePage;
    JSONReader jsonReader = new JSONReader();

    @Test
    public void homePageTest(){
        homePage = new HomePage(page);
        homePage.clickSignUpBtn();
        homePage.fillUsernameAndPassword();
        homePage.clickSignUpPopupBtn();
    }

    @Test
    public void logoutTest() throws IOException, ParseException {
        homePage = new HomePage(page);
        String username = jsonReader.readJson("userLoginData.json","email");
        String password = jsonReader.readJson("userLoginData.json","password");
        homePage.loginUsingCreatedAccount(username, password);
        homePage.clickLogoutButton();
    }

}