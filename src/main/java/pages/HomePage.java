package pages;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;


public class HomePage extends PageObjectManager {
    static Faker faker = new Faker();
    final static String username = faker.name().username();
    final static String password = faker.internet().password();

    private String signUpBtnLocator = "//a[@id='signin2']";
    private String usernameFieldLocator = "input#sign-username";
    private String passwordFieldLocator = "input#sign-password";
    private String signUpPopupBtnLocator = "//button[contains(text(),'Sign up')]";
    private String loginBtnLocator = "#login2";
    private String loginPopupBtnLocator = "//button[contains(text(),'Log in')]";
    private String usernameLoginFieldLocator = "#loginusername";
    private String passwordLoginFieldLocator = "#loginpassword";
    private String logoutLocator = "#logout2";
    private String productLink = "//h4[@class='card-title']";
    private String cartPageLink = "//a[normalize-space()='Cart']";
    private String contactLink = "//a[contains(text(),'Contact')]";

    public static ThreadLocal<String> productName = new ThreadLocal<>();

    public HomePage(Page page) {
        super(page);
    }

    public void clickSignUpBtn() {
        clickButton(signUpBtnLocator);
    }

    public void fillUsernameAndPassword() {
        fillTextField(usernameFieldLocator, username);
        fillTextField(passwordFieldLocator, password);
    }

    public void clickSignUpPopupBtn() {
        clickButton(signUpPopupBtnLocator);
    }

    public void loginUsingCreatedAccount(String username, String password) {
        clickButton(loginBtnLocator);
        fillTextField(usernameLoginFieldLocator, username);
        fillTextField(passwordLoginFieldLocator, password);
        clickButton(loginPopupBtnLocator);
    }

    public void clickLogoutButton() {
        clickButton(logoutLocator);
    }

    public void clickFirstProductLink() {
        clickFirstMatchedButton(productLink);
    }

    public String getFirstProductLinkText() {
        return getTextValue(productLink);
    }

    // Method to set the value of product Name
    public void setProductNameTextValueFromHomePage() {
        productName.set(getFirstProductLinkText());
    }

    // Retrieve the value from ThreadLocal
    public String getProductNameFromHomePage() {
        setProductNameTextValueFromHomePage();
        return productName.get().trim();
    }

    // go to cart page
    public void clickCartPageLink() {
        clickButton(cartPageLink);
    }

    // go to contact page
    public void clickContactLink() {
        clickButton(contactLink);
    }

}
