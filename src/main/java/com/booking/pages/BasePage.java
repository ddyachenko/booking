package com.booking.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}