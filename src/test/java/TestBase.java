import com.demoblaze.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.PageObjectManager;

public class TestBase {
    PlaywrightFactory playwrightFactory;
    Page page;
    PageObjectManager pageObjectManager;

    @BeforeTest
    public void setUp(){
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initBrowser("chromium");
        pageObjectManager = new PageObjectManager(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
