import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Computers')]")
    private WebElement computers;
    @FindBy(xpath = "//a[contains(text(),'Desktops')]")
    private WebElement desktop;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }
    public MainPage putMouseOnComputer (){
        actions.moveToElement(computers).perform();
        return new MainPage();
    }
    public DesktopPage clickDesktop (){
        desktop.click();
        return new DesktopPage();
    }


}
