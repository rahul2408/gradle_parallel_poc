package stepDefinition;

import Core.Util.Constant;
import Pages.HomePage.HomePage;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import io.cucumber.java.Before;
import serenityAction.homePageAction;

import java.awt.print.Book;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class homePageStepDef {

    @Steps
    homePageAction homeAction;

    @Steps
    HomePage homePage;




    @Before
    public void beforeAll(final Scenario scenario) throws MalformedURLException {

        for (String tagName : scenario.getSourceTagNames()) {
            if (tagName.contains("user")) {
                String user = tagName.substring(1, tagName.length());
                Constant.userUnderTest=user;
                break;
            }else {
                Constant.userUnderTest="user without login";
            }
        }
    }




    @Given("open ais homepage")
    public void openHomepage() {
        homeAction.opens_ais_home_page();
    }

    @When("verify ais homepage")
    public void verifyHomepage() {
assert homePage.getTitle().equalsIgnoreCase("Google");
    }


    @Then("Verify title is {string}")
    public void verifyTitle(String title){
        Assert.assertTrue("title not matching",homePage.getTitle().equalsIgnoreCase(title));
    }

    @When("From store user navigates to {string} and {string}")
    public void user_navigates_to_productList(String productType, String product){
        assert homeAction.findProductFromGlobalDrawer(productType,product).contains(product);

    }


}
