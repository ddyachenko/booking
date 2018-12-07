import com.booking.steps.HomePageSteps;
import com.booking.steps.RoomPageSteps;
import com.booking.steps.SearchResultsSteps;
import com.booking.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected HomePageSteps homePageSteps;
    protected SearchResultsSteps searchResultsSteps;
    protected RoomPageSteps roomPageSteps;

    @BeforeClass
    public void setUpTest() {
        WebDriver chromeDriver = Driver.getInstance(Driver.BrowserType.CHROME);
        initSteps(chromeDriver);
    }

    @AfterClass
    public void closeDriver() {
        Driver.closeDriver();
    }

    private void initSteps(WebDriver driver) {
        homePageSteps = new HomePageSteps(driver);
        searchResultsSteps = new SearchResultsSteps(driver);
        roomPageSteps = new RoomPageSteps(driver);
    }
}