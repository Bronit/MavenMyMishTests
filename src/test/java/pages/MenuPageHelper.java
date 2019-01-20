package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Inka on 07-Jan-19.
 */
public class MenuPageHelper extends PageBase {
    @FindBy(xpath = "//span[@class='marginLeft']")
    WebElement logOutButton;

    public MenuPageHelper(WebDriver driver) {
        super(driver);
    }
    public MenuPageHelper waitUntilPageLoad(){
        waitUntilElementIsLoaded(driver, logOutButton, 40);
        return this;
    }

    public void pressLogOutButton(){
        logOutButton.click();

    }
}