package com.booking.steps;

import com.booking.pages.RoomPage;
import org.openqa.selenium.WebDriver;

public class RoomPageSteps extends BaseSteps {

    public RoomPageSteps(WebDriver driver) {
        super(driver);
    }

    public void clickReservationButton() {
        RoomPage roomPage = new RoomPage(driver);
        roomPage.clickReservationButton();
    }

    public void selectCheapestRoom() {
        RoomPage roomPage = new RoomPage(driver);
        roomPage.selectCheapestRoom();
    }
}
