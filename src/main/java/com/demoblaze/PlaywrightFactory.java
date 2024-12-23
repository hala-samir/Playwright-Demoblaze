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

    // define the variables for setting up the browser for parallel execution config
    private ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    private ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    private ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    //threadLocal variables getters
    private Playwright getPlaywright(){
        return playwrightThreadLocal.get();
    }

    private BrowserContext getBrowserContext() {
        return browserContextThreadLocal.get();
    }

    private Page getPage(){
        return pageThreadLocal.get();
    }

    public Page initBrowser(Properties prop) {
        String browserName= prop.getProperty("browserName");
        //playwright = Playwright.create();
        playwrightThreadLocal.set(Playwright.create());
        //condition to check the browser name that will launch
        switch (browserName.toLowerCase().trim()){
            case "chrome":
                //browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless").trim())));
                browserThreadLocal.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless").trim()))));
                break;
            case "firefox":
               // browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless").trim())));
                browserThreadLocal.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless").trim()))));
                break;
            case "chromium":
               // browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(Boolean.parseBoolean(prop.getProperty("headless").trim())));
                browserThreadLocal.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(Boolean.parseBoolean(prop.getProperty("headless").trim()))));
                break;
            default:
                System.out.println("Please, add a valid browser name");
                break;
        }

        //browserContext = browser.newContext();
        browserContextThreadLocal.set(browserThreadLocal.get().newContext());
        //page = browserContext.newPage();
        pageThreadLocal.set(getBrowserContext().newPage());
        //page.navigate(prop.getProperty("url").trim());
        getPage().navigate(prop.getProperty("url").trim());

        //return page;
        return getPage();
    }

    public Properties initializeTestConfigurations() throws IOException {
        FileInputStream fileIP= new FileInputStream("./src/test/java/resources/config/testConfig.properties");
        prop = new Properties();
        prop.load(fileIP);
        return prop;
    }
}