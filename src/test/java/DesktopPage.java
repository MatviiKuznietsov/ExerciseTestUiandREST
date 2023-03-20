import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DesktopPage extends BasePage {
    @FindBy(css = "#products-pagesize")
    private WebElement displaySelector;
    @FindBy(xpath = "//option[contains(text(),'4')]")
    private WebElement four;
    @FindBy(css = "#products-orderby")
    private WebElement sortBy;
    @FindBy(xpath = "//option[contains(text(),'Price: High to Low')]")
    private WebElement highToLow;
    @FindBy(xpath = "//input[@value='Add to cart']")
    private WebElement addToCard;
    @FindBy(css = "span.cart-qty")
    private WebElement shoppingCartCounter;
    @FindBy(xpath = "//div[@class='product-item']")
    List<WebElement> allComp;

    public DesktopPage() {
        PageFactory.initElements(driver, this);
    }

    public DesktopPage clickDisplaySelector() {
        displaySelector.click();
        return new DesktopPage();
    }

    public DesktopPage selectFour() {
        four.click();
        return new DesktopPage();
    }

    public DesktopPage sortBy() {
        int i = 0;
        for (WebElement copm : allComp) {
            i++;
        }
        Assert.assertEquals(i,4);
        sortBy.click();
        return new DesktopPage();
    }

    public DesktopPage selectHighToLow() {
        highToLow.click();
        return new DesktopPage();
    }

    public DesktopPage addToCard() {
        addToCard.click();
        return new DesktopPage();
    }

    public String showCountProducts() {
        String count = shoppingCartCounter.getText();
        return count;
    }
}
