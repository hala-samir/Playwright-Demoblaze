package pages;

import com.microsoft.playwright.Page;

public class ContactUsPage extends PageObjectManager{
    public ContactUsPage(Page page) {
        super(page);
    }
    private String contactEmailField = "#recipient-email";
    private String contactNameField = "#recipient-name";
    private String messageField = "#message-text";
    private String sendMessageButton = "//button[contains(text(),'Send message')]";
    private String contactPopup = "//div[@id='exampleModal']/div[1]/div[1]";

    public void sendContactMessageUsingValidData(String userEmail, String userPhone, String message){
        fillTextField(contactEmailField, userEmail);
        fillTextField(contactNameField, userPhone);
        fillTextField(messageField, message);
        clickButton(sendMessageButton);
    }

    public boolean popupIsHidden(){
        return isElementVisible(contactPopup) ;
    }

}
