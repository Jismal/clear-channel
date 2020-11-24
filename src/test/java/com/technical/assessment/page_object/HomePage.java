package com.technical.assessment.page_object;

import com.technical.assessment.driver.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverFactory {

    @FindBy(id = "icon-search")
    private WebElement searchBoxonHeader;

    @FindBy(name = "keywords")
    private WebElement searchTxtArea;

    public static String headerTxt;

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void search(String item) {
        searchBoxonHeader.click();
        isElementVisible(searchTxtArea);
        headerTxt = item;
        searchTxtArea.sendKeys(item);
        searchTxtArea.sendKeys(Keys.ENTER);
    }

    public void doBlankSearch() {
        searchBoxonHeader.click();
        searchTxtArea.sendKeys(Keys.ENTER);
    }

    }

