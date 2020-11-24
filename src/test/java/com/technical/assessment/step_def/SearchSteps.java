package com.technical.assessment.step_def;

import com.technical.assessment.page_object.HomePage;
import com.technical.assessment.page_object.ResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchSteps {

    private HomePage homePage;
    private ResultsPage resultsPage;

    public SearchSteps() {
        homePage = new HomePage();
        resultsPage = new ResultsPage();
    }

    @Given("^I am on homepage$")
    public void i_am_on_homepage() {
        String actual = homePage.getCurrentUrl();
        assertThat("User is not on HomePage. ", actual, is(endsWith(".com/")));
    }

    @When("^I search for information \"([^\"]*)\"$")
    public void i_search_for_information(String searchItem) {
        homePage.search(searchItem);
    }

    @Then("^I should be able to find appropriate information$")
    public void i_should_be_able_to_find_appropriate_information() {
        assertThat(resultsPage.getReultsHeader(), is(containsString(HomePage.headerTxt)));
        assertThat(resultsPage.getHeaderContentTxt(), is(notNullValue()));
    }

    @Then("^I should see \"([^\"]*)\" in information$")
    public void iShouldSeeInInformation(String expected) {
        assertThat("Expected and actual did not match. ", resultsPage.getHeaderContentTxt(), is(equalToIgnoringCase(expected)));
    }

    @When("^I perform search$")
    public void iPerformSearch() {
        homePage.doBlankSearch();
    }

    @Then("^I should see error message as \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageAs(String expected) {
        assertThat("Expected and actual did not match. ", resultsPage.getErrorMsg(), is(equalToIgnoringCase(expected)));
    }
}
