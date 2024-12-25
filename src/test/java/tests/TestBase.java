package tests;

import com.demoblaze.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.PageObjectManager;

import java.io.IOException;
import java.util.Properties;

public class TestBase {
    PlaywrightFactory playwrightFactory;
    Page page;
    PageObjectManager pageObjectManager;
    Properties prop;

    // to open the browser to start execution
    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browserName) throws IOException {
        playwrightFactory = new PlaywrightFactory();
        prop = playwrightFactory.initializeTestConfigurations();
        if(browserName!= null){
            prop.setProperty("browserName", browserName);
        }
        page = playwrightFactory.initBrowser(prop);
        pageObjectManager = new PageObjectManager(page);
    }

    // to close the browser after execution
    @AfterMethod
    public void tearDown(){
        page.context().browser().close();
    }
}
