package testScenarios;

import com.demoblaze.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PageObjectManager;

public class TestBase {
    PlaywrightFactory playwrightFactory;
    Page page;
    PageObjectManager pageObjectManager;

    @BeforeMethod
    public void setUp(){
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initBrowser("chrome");
        pageObjectManager = new PageObjectManager(page);
    }

    @AfterMethod
    public void tearDown(){
        page.context().browser().close();
    }
}
