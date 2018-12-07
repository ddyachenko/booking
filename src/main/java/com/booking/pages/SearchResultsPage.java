package com.booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private static final String LOAD_WAIT_SPINNER_XPATH = "//*[@id='b2searchresultsPage']//div[@class='sr-usp-overlay__container']";

    @FindBy(xpath = "//div[@data-block-id='heading']//div[@role='heading']/*")
    private WebElement searchResultText;

    @FindBy(xpath = "//a[@data-id='oos-1']")
    private WebElement availabilityCheckbox;

    @FindBy(xpath = "//a[contains(@class,'b-button_primary')]")
    private List<WebElement> buttonsFullInfo;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean openResultRoomDetailsPage(int number) {
        waitLoadEnd();
        if (!buttonsFullInfo.isEmpty()) {
            buttonsFullInfo.get(number - 1).click();
            return true;
        }
        return false;
    }

    public void selectAvailabilityCheckbox() {
        waitAndClickCheckbox(availabilityCheckbox);
    }

    private void waitLoadEnd() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOAD_WAIT_SPINNER_XPATH)));
    }

    private void waitAndClickCheckbox(WebElement checkbox) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(checkbox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
    }
}