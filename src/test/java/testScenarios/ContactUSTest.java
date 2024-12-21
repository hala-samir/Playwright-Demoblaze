package testScenarios;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utilities.JSONReader;

import java.io.IOException;

public class ContactUSTest extends TestBase{
    HomePage homePage;
    ContactUsPage contactUsPage;
    JSONReader jsonReader =  new JSONReader();

    @Test
    public void userSendsContactUsMessage() throws IOException, ParseException {
        homePage = new HomePage(page);
        contactUsPage = new ContactUsPage(page);
        // read data from json file
        String userEmail = jsonReader.readJson("userContactData.json", "email");
        String userName = jsonReader.readJson("userContactData.json", "name");
        String userMsg = jsonReader.readJson("userContactData.json", "message_text");
        homePage.clickContactLink();
        contactUsPage.sendContactMessageUsingValidData(userEmail, userName, userMsg);
        Assert.assertFalse(contactUsPage.popupIsHidden());
    }
}
