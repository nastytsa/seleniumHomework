package pages;

import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {

    public CareersPage(WebDriver driver){
        super(driver);
        url = "https://careers.epam.ua/";
    }

    public void seeCareersPage() throws InterruptedException {
        redirectPage(url);
    }
}
