package com.demoblaze;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    public Page initBrowser(Properties prop) {
        String browserName= prop.getProperty("browserName");
        playwright = Playwright.create();
        //condition to check the browser name that will launch
        switch (browserName.toLowerCase().trim()){
            case "chrome":
                browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless").trim())));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless").trim())));
                break;
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(Boolean.parseBoolean(prop.getProperty("headless").trim())));
                break;
            default:
                System.out.println("Please, add a valid browser name");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(prop.getProperty("url").trim());

        return page;
    }

    public Properties initializeTestConfigurations() throws IOException {
        FileInputStream fileIP= new FileInputStream("./src/test/java/resources/config/testConfig.properties");
        prop = new Properties();
        prop.load(fileIP);
        return prop;
    }
}