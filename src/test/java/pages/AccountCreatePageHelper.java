package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Inka on 06-Jan-19.
 */
public class AccountCreatePageHelper extends PageBase {
    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@formcontrolname='passwordRep']")
    WebElement repPasswordField;
    @FindBy(xpath = "//span[contains(text(),'Registration')]")
    WebElement registrationButton;

    public AccountCreatePageHelper(WebDriver driver) {
        super(driver);
    }

    public AccountCreatePageHelper waitUntilPageLoad() {

        waitUntilElementIsLoaded(driver,cancelButton, 40);
        return this;
    }

    public AccountCreatePageHelper enterValueToFieldEmail(String value) {

        setValueToField(emailField, value);
        return this;
    }

    public AccountCreatePageHelper enterValueToFieldPassword(String value) {

        setValueToField(passwordField,value);
        return this;
    }

    public AccountCreatePageHelper enterValueToFieldRepPassword(String value) {
        setValueToField(repPasswordField,value);
        return this;
    }
    public AccountCreatePageHelper pressRegistrationButton(){
        waitUntilElementIsLoaded(driver, registrationButton,20);
        registrationButton.click();
        return this;
    }

    public AccountCreatePageHelper enterValueToFieldEmailRandom() {
        String email = latinDigitString(10)+"@gmail.com";
        setValueToField(emailField,email);
              return this;
    }

}