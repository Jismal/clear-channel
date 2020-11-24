package com.technical.assessment;

import com.technical.assessment.driver.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    private DriverFactory driverFactory = new DriverFactory();

    @Before
    public void setUp() {
        driverFactory.openBrowser();
        driverFactory.navigateTo("https://www.clearchannelinternational.com/");
        driverFactory.manageBrowser();
        driverFactory.manageCookies();
    }

    @After
    public void tearDown() {
        driverFactory.closeBrowser();
    }
}
