package testScenarios;

import com.demoblaze.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PageObjectManager;

import java.io.IOException;
import java.util.Properties;

public class TestBase {
    PlaywrightFactory playwrightFactory;
    Page page;
    PageObjectManager pageObjectManager;
    Properties prop;

    @BeforeMethod
    public void setUp() throws IOException {
        playwrightFactory = new PlaywrightFactory();
        prop = playwrightFactory.initializeTestConfigurations();
        page = playwrightFactory.initBrowser(prop);
        pageObjectManager = new PageObjectManager(page);
    }

    @AfterMethod
    public void tearDown(){
        page.context().browser().close();
    }
}
