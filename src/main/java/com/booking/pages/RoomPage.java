package com.booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomPage extends BasePage {

    private static final String SELECT_NUMBER_OF_ROOMS_XPATH = "//td[contains(@class,'hprt-table-room-select')]//select";
    private static final String OPTION_ROOMS_XPATH =  "/option[@value='%d']";

    @FindBy(xpath = "//*[@class='hprt-price-price ']")
    private List<WebElement> price;

    @FindBy(xpath = SELECT_NUMBER_OF_ROOMS_XPATH)
    private WebElement selectRooms;

    @FindBy(xpath = "//div[@class='hprt-reservation-cta']/button")
    private WebElement reservationButton;

    public RoomPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean selectAnApartment(int count) {
        waitForClickable(selectRooms);
        selectRooms.click();
        List <WebElement> option = selectRooms.findElements(By.xpath(String.format(SELECT_NUMBER_OF_ROOMS_XPATH + OPTION_ROOMS_XPATH, count)));
        if(!option.isEmpty()){
            waitForClickable(option.get(0));
            option.get(0).click();
            return true;
        }
        return false;
    }

    public boolean selectAnApartment(int count, int numberFromList) {
        waitForClickable(selectRooms);
        selectRooms.click();
        List <WebElement> option = selectRooms.findElements(By.xpath(String.format(SELECT_NUMBER_OF_ROOMS_XPATH + OPTION_ROOMS_XPATH, count)));
        if(!option.isEmpty()){
            waitForClickable(option.get(numberFromList));
            option.get(numberFromList).click();
            return true;
        }
        return false;
    }

    public void clickReservationButton(){
        waitForClickable(reservationButton);
        reservationButton.click();
    }

    public void selectCheapestRoom(){
        waitForClickable(selectRooms);
        List <Double> prices = new ArrayList<>();
        for (int i = 0; i < price.size(); i++) {
            String prise2 = price.get(i).getText();
            prices.add(Double.parseDouble(prise2.substring(prise2.indexOf(" ")+1).replace(",", ".")));
        }
        selectAnApartment(1, (prices.indexOf((Collections.min(prices)))));
    }

    private void waitForClickable(WebElement element){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
