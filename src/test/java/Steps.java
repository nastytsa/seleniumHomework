import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseTest {

    @Before
    public void start(){
        begin();
    }

    @After
    public void finish(){
        end();
    }

    @Given("I connect to epam.com")
    public void openMain(){
        mainPage.goTo();
        mainPage.closeDisclaimer();
    }

    @When("I click on {string} button")
    public void clickButton(String arg0) {
        mainPage.clickButton(arg0);
    }

    @Then("I check that I come to {string} page")
    public void redirectToPage(String arg0) throws InterruptedException {
        mainPage.redirection(arg0);
    }

    @Then("I check that page changed its careers region")
    public void changeCareersRegion() throws InterruptedException {
        careersPage.seeCareersPage();
    }

    @And("I enter 'RPA'")
    public void enterRPA() {
        mainPage.enterSearchText("RPA");
    }

    @Then("I check that page changed to search result")
    public void changedToSearchRpa() throws InterruptedException {
        searchPage.seeRpaSearch();
    }

    @When("I point cursor to {string}")
    public void pointCursorToButton(String arg0) {
        mainPage.pointToButton(arg0);
    }

    @Then("I check that it is hovered by text")
    public void checkIsHovered() {
        mainPage.consultHover();
    }

    @Then("I check that {string} opens on a new page")
    public void goToNewPage(String arg0) {
        mainPage.openInNewPage(arg0);
    }

    @Then("I check that I come to investors page")
    public void toInvestorsPage() throws InterruptedException {
        mainPage.redirectPage("https://investors.epam.com/investors/faq");
    }
}
