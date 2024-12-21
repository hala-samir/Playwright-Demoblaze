package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class PageObjectManager {
    private Page page;

    public PageObjectManager(Page page) {
        this.page = page;
    }

    public void clickButton(String locatorName){
        page.waitForLoadState(LoadState.NETWORKIDLE);
        page.waitForSelector(locatorName, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        page.locator(locatorName).click();
    }

    public void clickFirstMatchedButton(String locatorName){
        page.locator(locatorName).first().click();
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
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return page.locator(locator).first().textContent();
    }

    public void clickButtonByJavaScript(String selector){
        page.waitForLoadState(LoadState.NETWORKIDLE);
        page.evaluate("selector => document.querySelector(selector).click()", selector);
    }

    public boolean isElementVisible(String locator){
        return page.isVisible(locator);
    }
}