import Utils.DriverHolder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void SetUp() {
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();
        DriverHolder.setDriver(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
    //   driver.quit();
        }
    }

    public MainPage openMainPage() {
        driver.get("https://demowebshop.tricentis.com/");
        return new MainPage();
    }
    public ExpensiveComputerPage openExpensiveComputerPage() {
        driver.get("https://demowebshop.tricentis.com/build-your-own-expensive-computer-2");
        return new ExpensiveComputerPage();
    }
}
