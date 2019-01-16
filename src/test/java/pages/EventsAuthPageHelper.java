package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Inka on 26-Dec-18.
 */
public class EventsAuthPageHelper extends PageBase {
    @FindBy (xpath = "//mat-icon[@class='but mat-icon material-icons']")
    WebElement menuButton;

    @FindBy (xpath = "//span[contains(text(),'Filters')]")
    WebElement filterButton;


    public EventsAuthPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageLoad() {
        waitUntilElementIsLoaded(driver,
                menuButton,
                20);
        waitUntilElementIsLoaded(driver,
                filterButton,30);
    }

    public String getTooltipIconMenu() {
        WebElement iconMenu = driver
                .findElement(By.
                        xpath("//mat-icon[@class='but mat-icon material-icons']"));
        return iconMenu.getAttribute("mattooltip");

    }
    public String getHeader() {
        WebElement titlePage = driver.findElement(By
                .xpath("//h1[@class='gorisontal-center']"));
        return titlePage.getText();
    }

    public void menuButtonClick() {
        menuButton.click();
    }
}