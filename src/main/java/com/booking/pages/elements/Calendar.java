package com.booking.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class Calendar {

    private static final String DAYS_XPATH = "//*[@class='bui-calendar__month']//..//*[contains(text(), '%s')]//..//table/tbody//td";

    @FindBy(xpath = "//*[contains(@class,'c2-button-further')]")
    private List<WebElement> furtherMonthLinks;

    private WebDriver driver;

    public Calendar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setDates(LocalDate checkInDate, LocalDate checkOutDate) {
        selectCheckInMonth(checkInDate);
        selectDay(checkInDate);
        selectCheckOutMonth(checkInDate, checkOutDate);
        selectDay(checkOutDate);
    }

    private void selectCheckInMonth(LocalDate checkInDate) {
        int currentMonth = LocalDate.now().getMonthValue();
        if (checkInDate.getYear() == LocalDate.now().getYear()) {
            changeMonth(currentMonth, checkInDate);
        } else if (checkInDate.getYear() > LocalDate.now().getYear()) {
            for (int i = currentMonth; i <= 12; i++) {
                furtherMonthLinks.get(0).click();
            }
            currentMonth = 1;
            changeMonth(currentMonth, checkInDate);
        }
    }

    private void changeMonth(int currentMonth, LocalDate checkInDate) {
        while (currentMonth != checkInDate.getMonthValue()) {
            furtherMonthLinks.get(0).click();
            currentMonth++;
        }
    }

    private void selectCheckOutMonth(LocalDate checkInDate, LocalDate checkOutDate) {
        int currentMonth = checkInDate.getMonthValue();
        while (currentMonth != checkOutDate.getMonthValue()) {
            furtherMonthLinks.get(1).click();
            currentMonth++;
        }
    }

    private void selectDay(LocalDate date) {
        String month = date.format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH));
        String fullDaysXpath = String.format(DAYS_XPATH, month);
        List<WebElement> days = driver.findElements(By.xpath(fullDaysXpath));
        for (int i = 7; i < days.size(); i++) {
            String dayNumber = days.get(i).getText().replaceAll(" ", "");
            if (!dayNumber.isEmpty()) {
                if (Integer.parseInt(dayNumber) == date.getDayOfMonth()) {
                    days.get(i).click();
                    break;
                }
            }
        }
    }
}