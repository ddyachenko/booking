package com.booking.steps;

import com.booking.pages.HomePage;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;

public class HomePageSteps extends BaseSteps {

    public HomePageSteps(WebDriver driver) {
        super(driver);
    }

    public HomePage openMainPage() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        closeFlyDropdown(homePage);
        return homePage;
    }

    public void closeFlyDropdown(HomePage homePage){
        homePage.closeFlyDropdown();
    }

    public void fillSearchField(String name) {
        HomePage mainPage = new HomePage(driver);
        mainPage.fillSearchField(name);
    }

    public void selectDates(LocalDate checkInDate, LocalDate checkOutDate) {
        HomePage mainPage = new HomePage(driver);
        mainPage.selectDates(checkInDate, checkOutDate);
    }

    public void clickSearchButton() {
        HomePage mainPage = new HomePage(driver);
        mainPage.clickSearchButton();
    }
}
