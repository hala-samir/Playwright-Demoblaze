import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends TestBase{
    HomePage homePage;

    @Test
    public void homePageTest(){
        homePage = new HomePage(page);
        homePage.clickSignUpBtn();
        homePage.fillUsernameAndPassword();
        homePage.clickSignUpPopupBtn();
        homePage.loginUsingCreatedAccount();
    }
    @Test
    public void logoutTest(){
        homePage.loginUsingCreatedAccount();
        homePage.clickLogoutButton();
    }
}
