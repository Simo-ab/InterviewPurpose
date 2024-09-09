package com.proj.steps;


import com.proj.pages.Pom;
import com.proj.utility.BrowserUtil;
import com.proj.utility.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;


public class StepDefs {

    Pom pom = new Pom();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    /**
     * TC_01
     */
    @Given("Job seeker is on Google page")
    public void job_seeker_is_on_google_page() {
        wait.until(ExpectedConditions.titleIs("Google"));
        Assert.assertEquals("Google",Driver.getDriver().getTitle());
    }

    @When("Enter Infinite Campus Careers in the search bar and press Enter")
    public void enter_in_the_search_bar_and_press_enter() {
        pom.searchBox.sendKeys("Infinite Campus Careers");
        pom.searchBox.sendKeys(Keys.ENTER);
    }

    /**
     * TC_02
     */
    @Then("The first result should be the official Infinite Campus career page")
    public void the_first_result_should_be_the_official_infinite_campus_career_page() {
        pom.firstResult.click();
        Assert.assertEquals("Careers · Infinite Campus",Driver.getDriver().getTitle());
    }


    /**
     * TC_03
     */
    @And("the page should have one or more View Open Positions buttons")
    public void the_page_should_have_one_or_more_buttons() {
        Assert.assertTrue(pom.viewOpenPositions.isDisplayed());
    }


    @When("Job seeker click on the first View Open Positions button")
    public void click_on_the_first_button() {
        BrowserUtil.hover(pom.viewOpenPositions);
        wait.until(ExpectedConditions.elementToBeClickable(pom.viewOpenPositions));
        pom.viewOpenPositions.click();
    }

    @Then("New tab opens displaying current job openings")
    public void new_tab_opens_displaying_current_job_openings() {
        BrowserUtil.switchToWindow("Search Openings");
        Assert.assertTrue(pom.OpenPositions.isDisplayed());
    }


}
