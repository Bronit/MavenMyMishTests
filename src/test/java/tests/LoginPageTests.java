package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EventsAuthPageHelper;
import pages.ProfilePageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import pages.AccountCreatePageHelper;
import pages.MenuPageHelper;
import util.DataProviders;


/**
 * Created by Inka on 19-Dec-18.
 */
public class LoginPageTests extends TestBase {
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    EventsAuthPageHelper eventsAuthPage;
    ProfilePageHelper profilePage;
    AccountCreatePageHelper accountCreatePage;
    MenuPageHelper menuPage;

    @BeforeMethod
    public void initPage() {
        homePage = PageFactory
                .initElements(driver, HomePageHelper.class);
        loginPage = PageFactory
                .initElements(driver, LoginPageHelper.class);
        accountCreatePage = PageFactory
                .initElements(driver, AccountCreatePageHelper
                        .class);
        eventsAuthPage = PageFactory.initElements(driver,
                EventsAuthPageHelper.class);
        profilePage = PageFactory.initElements(driver,
                ProfilePageHelper.class);
        menuPage = PageFactory
                .initElements(driver, MenuPageHelper.class);

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginPositiveWithProfile")
    public void loginPositiveWithProfile(String email, String password) {
        homePage.waitUntilPageLoad()
                .pressLoginButton();

        loginPage.waitUntilPageLoad()
                .enterValueToFieldEmail(email)
                .enterValueToFieldPassword(password)
                .pressLogInButton();
        eventsAuthPage.waitUntilPageLoad();

        Assert.assertEquals("Menu", eventsAuthPage.getTooltipIconMenu());
        Assert.assertEquals("Find event", eventsAuthPage.getHeader());
        //driver.quit();
        eventsAuthPage.menuButtonClick();
        menuPage.waitUntilPageLoad()
                .pressLogOutButton();
        homePage.waitUntilPageLoad();
        Assert.assertEquals(homePage.getHeader(),
                "Shabbat in the family circle");

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginPositiveWithoutProfile")
    public void loginPositiveWithoutProfile(String email, String password) {
        homePage.waitUntilPageLoad()
                .pressLoginButton();
        loginPage.waitUntilPageLoad()
                .enterValueToFieldEmail(email)
                .enterValueToFieldPassword(password)
                .pressLogInButton();
        profilePage.waitUntilPageLoad();

        Assert.assertEquals("menu", profilePage.getIconButton());
        Assert.assertEquals("Registration", profilePage.getHeader());
        //driver.quit();
        profilePage.menuButtonClick();
        menuPage.waitUntilPageLoad()
                .pressLogOutButton();
        homePage.waitUntilPageLoad();
        Assert.assertEquals(homePage.getHeader(),
                "Shabbat in the family circle");

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginNegativeAuth")
    public void loginNegativeAuth(String email, String password) {
        homePage.waitUntilPageLoad()
                .pressLoginButton();
        loginPage.waitUntilPageLoad()
                .enterValueToFieldEmail(email)
                .enterValueToFieldPassword(password)
                .pressLogInButton();

        Assert.assertEquals(loginPage.getAlertText(),
                "Wrong authorization, login or password");

           }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginNegative")
    public void loginNegative(String email) {
        homePage.waitUntilPageLoad()
                .pressLoginButton();
        loginPage.waitUntilPageLoad()
                .enterValueToFieldEmail(email);
                //.pressCancelButton();
        driver.quit();
        Assert.assertEquals(loginPage.getAlertTextEm(),"Not a valid email");
    }
}