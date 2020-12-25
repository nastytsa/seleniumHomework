import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected CareersPage careersPage;
    protected SearchPage searchPage;

    @BeforeClass
    public void begin(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        careersPage = PageFactory.initElements(driver, CareersPage.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    @AfterEach
    public void end(){
        driver.quit();
    }
}
