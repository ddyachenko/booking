package com.booking.pages;

import com.booking.pages.elements.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.List;

public class HomePage extends BasePage {

    private static final String BASE_URL = "https://www.booking.com";
    private static final String FLY_DROPDOWN_CLOSE = "//div[contains(@class,'fly-dropdown')]//div[contains(@class,'bicon')]";

    @FindBy(id = "ss")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='xp__button']//button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@data-mode='checkin']//button")
    private WebElement checkInButton;

    @FindBy(xpath = "//div[@data-mode='checkout']//button")
    private WebElement checkOutButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(BASE_URL);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void fillSearchField(String text) {
        searchField.clear();
        searchField.sendKeys(text);
    }

    public void openCheckInCalendar() {
        checkInButton.click();
    }

    public void openCheckOutCalendar() {
        checkOutButton.click();
    }

    public void selectDates(LocalDate checkInDate, LocalDate checkOutDate) {
        Calendar cl = new Calendar(driver);
        openCheckInCalendar();
        cl.setDates(checkInDate, checkOutDate);
    }

    public void closeFlyDropdown() {
        List<WebElement> flyDropdownClose = driver.findElements(By.xpath(FLY_DROPDOWN_CLOSE));
        if (!flyDropdownClose.isEmpty()) {
            flyDropdownClose.get(0).click();
        }
    }
}
