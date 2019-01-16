package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Inka on 22-Dec-18.
 */
public class AccountCreatePageTests extends TestBase {
    HomePageHelper homePage;
    AccountCreatePageHelper accountCreatePage;
    ProfilePageHelper profilePage;
    MenuPageHelper menuPage;
    LoginPageHelper loginPage;


    @BeforeMethod
    public void initPage() {
        homePage = PageFactory
                .initElements(driver, HomePageHelper.class);
        accountCreatePage = PageFactory
                .initElements(driver, AccountCreatePageHelper
                        .class);
        profilePage = PageFactory.initElements(driver,
                ProfilePageHelper.class);
        menuPage = PageFactory
                .initElements(driver, MenuPageHelper.class);
        loginPage = PageFactory
                .initElements(driver, LoginPageHelper.class);
    }

    @Test
    public void createNewAccount(){
        homePage.waitUntilPageLoad()
                .pressCreateAccountButton();
        accountCreatePage.waitUntilPageLoad()
                .enterValueToFieldEmailRandom() //enterValueToFieldEmail(email1)
                .enterValueToFieldPassword("123456")
                .enterValueToFieldRepPassword("123456")
                .pressRegistrationButton();
        profilePage.waitUntilPageLoad()
                .menuButtonClick();
        menuPage.waitUntilPageLoad()
                .pressLogOutButton();
        homePage.waitUntilPageLoad();
        Assert.assertEquals(homePage.getHeader(), "Shabbat in the family circle");
    }

    @Test
    public void createNewAccountAndLogin(){
        String email2 = accountCreatePage.latinDigitString(10) + "@gmail.com";
        System.out.println("email2:" + email2);
        homePage.waitUntilPageLoad()
                .pressCreateAccountButton();
        accountCreatePage.waitUntilPageLoad()
                .enterValueToFieldEmail(email2)
                .enterValueToFieldPassword("123456")
                .enterValueToFieldRepPassword("123456")
                .pressRegistrationButton();
        profilePage.waitUntilPageLoad()
                .menuButtonClick();
        menuPage.waitUntilPageLoad()
                .pressLogOutButton();
        homePage.waitUntilPageLoad();
        Assert.assertEquals(homePage.getHeader(), "Shabbat in the family circle");

        homePage.pressLoginButton();
        loginPage.enterValueToFieldEmail(email2)
                .enterValueToFieldPassword("123456")
                .pressLogInButton();
        profilePage.waitUntilPageLoad();
        System.out.println("email2:" + email2);
        Assert.assertEquals(profilePage.getHeader(),"Registration");

        profilePage.menuButtonClick();
        menuPage.waitUntilPageLoad();
        menuPage.pressLogOutButton();
        homePage.waitUntilPageLoad();

        Assert.assertEquals(homePage.getHeader(),"Shabbat in the family circle");

    }

}
