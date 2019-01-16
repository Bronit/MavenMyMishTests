package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EventsUnAuthPageHelper;
import pages.HomePageHelper;

/**
 * Created by Inka on 16-Dec-18.
 */
public class HomePagesTests extends TestBase {
    HomePageHelper homePage;
    EventsUnAuthPageHelper eventsUnAuthPage;

    @BeforeMethod
    public void initPage(){
        homePage = PageFactory
                .initElements(driver, HomePageHelper.class);
        eventsUnAuthPage = PageFactory
                .initElements(driver, EventsUnAuthPageHelper.class);

    }
    @Test
    public void openHomePage()  {

        homePage.waitUntilPageLoad();
        String goToButtonName =
                homePage.getGoToEventButtonName();

        Assert.assertEquals("Go to Event list",goToButtonName);
    }

    @Test
    public void goToEventsTest()  {
        homePage.waitUntilPageLoad()
                .pressGoToEventButton();
        eventsUnAuthPage.waitUntilPageLoad();
        String header = eventsUnAuthPage.getHeader();
        Assert.assertEquals("Find event",header);
    }

}