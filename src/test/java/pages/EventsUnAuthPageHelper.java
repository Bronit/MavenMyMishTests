package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Inka on 23-Dec-18.
 */
public class EventsUnAuthPageHelper extends PageBase {
    //WebDriver driver;
    public EventsUnAuthPageHelper(WebDriver driver)
    {
        super(driver);
    }

    public void waitUntilPageLoad() {
        waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Filters')]"),
                45 );
    }

    public String getHeader() {
        WebElement titlePage = driver.findElement(By
                .xpath("//h1[@class='gorisontal-center']"));
        return titlePage.getText();
    }
}