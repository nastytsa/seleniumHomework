package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class BasePage {

    protected String url = "https://www.epam.com/";
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//*[contains(@class,'button-ui bg-color-light-blue cookie-disclaimer__button')]")
    protected WebElement disclaimerButton;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    public void redirectPage(String link) throws InterruptedException {
        sleep(500);
        assertEquals(link, driver.getCurrentUrl());
    }

    public void closeDisclaimer(){
        disclaimerButton.click();
    }
}
