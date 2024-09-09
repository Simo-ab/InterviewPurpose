package com.proj.pages;

import com.proj.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom {


    public Pom() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(xpath = "//h3[contains(text(), 'Careers')]")
    public WebElement firstResult;
    @FindBy(xpath = "//a[text()='View Open Positions']")
    public WebElement viewOpenPositions;
    @FindBy(xpath = "//h3[text()='Positions Open']")
    public WebElement OpenPositions;


}
