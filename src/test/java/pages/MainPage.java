package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MainPage extends BasePage{
    private Actions actions = new Actions(driver);

    @FindBy(xpath = "//a[contains(text(),'Services')]")
    private WebElement servicesButton;

    @FindBy(xpath = "//button[contains(@class,'location-selector__button')][ contains(text(),'Global (EN)')]")
    private WebElement languageButton;

    @FindBy(xpath = "//span[contains(text(),'CONTACT US')]")
    private WebElement contactUsButton;

    @FindBy(xpath = "//a[contains(@href, 'https://careers.epam.ua')]")
    private WebElement ukraineButton;

    @FindBy(xpath = "//button[contains(@class, 'header-search__button header__icon')]")
    private WebElement searchButton;

    @FindBy(id = "new_form_search")
    private WebElement searchField;

    @FindBy(xpath = "//a[contains(text(),'About')][contains(@href, '/about')]")
    private WebElement aboutButton;

    @FindBy(xpath = "//a[contains(text(), 'Careers')][contains(@href, '/careers')]")
    private WebElement careersButton;

    @FindBy(xpath = "//img[contains(@class, 'rollover-tiles__image')][contains(@src, '/content/dam/epam/what_we_do/Consult-Yellow.svg')]")
    private WebElement consultButton;

    @FindBy(xpath = "//strong[contains(@class, 'rollover-tiles__title')][contains(text(), 'Consult')]")
    private WebElement consultHover;

    @FindBy(xpath = "//a[contains(@href, '/about/investors/faq')]")
    private WebElement faqButton;

    @FindBy(xpath = "//a[contains(@href, '/careers/blog')]")
    private WebElement blogButton;

    @FindBy(xpath = "//a[contains(text(),'How We Do It')]")
    private WebElement howWeDoItButton;

    @FindBy(xpath = "//a[contains(text(),'Our Work')]")
    private WebElement ourWorkButton;

    @FindBy(xpath = "//a[contains(@href,'https://www.telescopeai.com/')]")
    private WebElement telescopeAiButton;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void goTo(){
        driver.get(url);
    }

    public void enterSearchText(String searchText){
        searchField.sendKeys(searchText);
        searchField.submit();
    }

    public void pointToButton(String button){
        actions.moveToElement(findButton(button)).build().perform();
    }

    private WebElement findButton(String name){
        switch (name){
            case "CONSULT":
                return consultButton;
            case "ABOUT":
                return aboutButton;
            case "FAQ":
                return faqButton;
            case "Contact Us":
                return contactUsButton;
            case "Blog":
                return blogButton;
            case "TELESCOPEAI":
                return telescopeAiButton;
            case "SERVICES":
                return servicesButton;
            case "HOW WE DO IT":
                return howWeDoItButton;
            case "OUR WORK":
                return ourWorkButton;
            case "language":
                return languageButton;
            case "search":
                return searchButton;
            case "CAREERS":
                return careersButton;
            default:
                return ukraineButton;
        }
    }

    public void clickButton(String button){
        WebElement but = findButton(button);
        wait.until(ExpectedConditions.elementToBeClickable(but));
        but.click();
    }

    public void redirection(String page) throws InterruptedException {
        redirectPage(url + page);
    }

    public void consultHover(){
        consultHover.isDisplayed();
    }

    public void openInNewPage(String link){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertEquals(driver.getCurrentUrl(), link);
    }
}
