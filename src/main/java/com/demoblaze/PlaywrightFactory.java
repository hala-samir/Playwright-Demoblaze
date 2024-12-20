package com.demoblaze;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    String url = "https://www.demoblaze.com/";

    public Page initBrowser(String browserName){
        playwright = Playwright.create();
        //condition to check the browser name that will launch
        switch (browserName.toLowerCase()){
            case "chrome":
                browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("Please, add a valid browser name");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(url);

        return page;
    }
}