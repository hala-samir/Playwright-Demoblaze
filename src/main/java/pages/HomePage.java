package pages;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;

public class HomePage extends PageObjectManager {
    Faker faker = new Faker();
    String username = faker.name().username();
    String password = faker.internet().password();

    private String signUpBtnLocator = "//a[@id='signin2']";
    private String usernameFieldLocator = "input#sign-username";
    private String passwordFieldLocator = "input#sign-password";
    private String signUpPopupBtnLocator = "//button[contains(text(),'Sign up')]";
    private String loginBtnLocator = "#login2";
    private String loginPopupBtnLocator = "//button[contains(text(),'Log in')]";
    private String usernameLoginFieldLocator = "#loginusername";
    private String passwordLoginFieldLocator = "#loginpassword";
    private String logoutLocator= "#logout2";


    public HomePage(Page page) {
        super(page);
    }

    public void clickSignUpBtn(){
       clickButton(signUpBtnLocator);
    }

    public void fillUsernameAndPassword(){
        fillTextField(usernameFieldLocator, username);
        fillTextField(passwordFieldLocator, password);
    }

    public void clickSignUpPopupBtn(){
        clickButton(signUpPopupBtnLocator);
    }
    public void loginUsingCreatedAccount(){
        clickButton(loginBtnLocator);
        fillTextField(usernameLoginFieldLocator, username);
        fillTextField(passwordLoginFieldLocator, password);
        clickButton(loginPopupBtnLocator);
    }
    public void clickLogoutButton(){
        clickButton(logoutLocator);
    }

}
