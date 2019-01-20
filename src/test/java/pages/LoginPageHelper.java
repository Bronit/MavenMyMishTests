package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Inka on 26-Dec-18.
 */
public class LoginPageHelper extends PageBase {
    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordField;
    @FindBy(xpath = "//span[contains(text(),'Log in')]")
    WebElement loginButton;
    @FindBy(xpath =
            "//div[@class='alert alert-danger ng-star-inserted']")
    WebElement alertText;
    @FindBy(xpath =
            "//div[@class='ng-tns-c13-20 ng-trigger ng-trigger-transitionMessages ng-star-inserted']")
    WebElement alertTextEm;


    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public LoginPageHelper waitUntilPageLoad() {
        waitUntilElementIsLoaded(driver,
                cancelButton,
                20);
        return this;
    }

    public LoginPageHelper enterValueToFieldEmail(String value) {

        setValueToField(emailField, value);
        return this;
    }

    public LoginPageHelper enterValueToFieldPassword(String value) {
        setValueToField(passwordField, value);
        return this;
    }

    public void pressLogInButton() {
        waitUntilElementIsLoaded(driver, loginButton, 20);
        loginButton.click();

    }
    public void pressCancelButton() {
        waitUntilElementIsLoaded(driver, cancelButton, 20);
        cancelButton.click();
    }

    public String getAlertText() {
        waitUntilElementIsLoaded(driver, alertText, 20);
        return alertText.getText();

    }

    public String getAlertTextEm() {
        waitUntilElementIsLoaded(driver, alertTextEm, 40);
        return alertTextEm.getText();
    }
}
