package pages;

import com.microsoft.playwright.Page;

public class PageObjectManager {
    private Page page;

    public PageObjectManager(Page page) {
        this.page = page;
    }

    public void clickButton(String locatorName){
        page.locator(locatorName).click();
    }

    public void fillTextField(String locatorName, String text){
        page.locator(locatorName).fill(text);
    }

    public String getPageTitle(){
        return page.title();
    }
    public String getPageURL(){
        return page.url();
    }
    public String getTextValue(String locator){
        return page.textContent(locator);
    }
}

