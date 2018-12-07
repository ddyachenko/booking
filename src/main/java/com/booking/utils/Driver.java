package com.booking.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    public enum BrowserType {
        FIREFOX,
        CHROME,
        IE,
        OPERA,
    }

    private Driver() {
    }

    public static WebDriver getInstance(BrowserType type) {
        if (driver == null) {
            switch (type) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case IE:
                    driver = new InternetExplorerDriver();
                    break;
                case OPERA:
                    driver = new OperaDriver();
                    break;
            }
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
