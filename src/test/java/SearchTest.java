import org.testng.annotations.*;

import java.util.Random;
import java.time.LocalDate;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    private static final LocalDate CHECKIN_DATE = LocalDate.now().plusDays(1);
    private static final LocalDate CHECKOUT_DATE = CHECKIN_DATE.plusDays(3);
    private static final String SECURE_URL = "secure.booking.com";
    private static final String SEARCH = "Los Angeles";

    @BeforeMethod
    public void navigate() {
        homePageSteps.openMainPage();
    }

    @Test
    public void searchTest() {
        Random rand = new Random();
        int random = rand.nextInt(3) + 1;
        homePageSteps.fillSearchField(SEARCH);
        homePageSteps.selectDates(CHECKIN_DATE, CHECKOUT_DATE);
        homePageSteps.clickSearchButton();
        searchResultsSteps.selectOnlyAvailable();
        searchResultsSteps.openAndSwitchToResultDetailsPage(random);
        roomPageSteps.selectCheapestRoom();
        roomPageSteps.clickReservationButton();
        String url = roomPageSteps.getCurrentUrl();
        assertTrue(url.contains(SECURE_URL));
    }
}


















