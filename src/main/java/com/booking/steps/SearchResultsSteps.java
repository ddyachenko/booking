package com.booking.steps;

import com.booking.pages.RoomPage;
import com.booking.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsSteps extends BaseSteps {

    public SearchResultsSteps(WebDriver driver) {
        super(driver);
    }

    public void selectOnlyAvailable() {
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.selectAvailabilityCheckbox();
    }

    public RoomPage openAndSwitchToResultDetailsPage(int number) {
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        if (resultsPage.openResultRoomDetailsPage(number)) {
            switchToWindowHandle();
            return new RoomPage(driver);
        }
        return null;
    }

    public void switchToWindowHandle() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}
