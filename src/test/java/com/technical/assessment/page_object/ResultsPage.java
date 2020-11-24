package com.technical.assessment.page_object;

import com.technical.assessment.driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends DriverFactory {

    @FindBy(css = ".h4")
    private WebElement resultsHeader;

    @FindBy(css = ".h5")
    private   WebElement headerContentTxt;

    @FindBy(css = "#content>h1")
    private WebElement errorTxt;

    public String getReultsHeader(){
       return resultsHeader.getText();
    }

    public String getHeaderContentTxt(){
       return headerContentTxt.getText();
    }

    public String getErrorMsg(){
      return  errorTxt.getText();
    }
}
