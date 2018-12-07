package com.booking.steps;

import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {

    protected WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
