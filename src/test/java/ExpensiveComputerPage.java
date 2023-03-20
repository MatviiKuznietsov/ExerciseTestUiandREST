import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class ExpensiveComputerPage extends BasePage {
    @FindBy(css = "input[value='82']")
    private WebElement processorFast;
    @FindBy(css = "input[value='85']")
    private WebElement ram8Gb;
    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> allElements;
    @FindBy(xpath = "//input[@id='add-to-cart-button-74']")
    private WebElement addToCard;
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    private WebElement shoppingCart;
    @FindBy(css = "span.cart-qty")
    private WebElement shoppingCartCounter;
    public ExpensiveComputerPage() {
        PageFactory.initElements(driver, this);
    }

    public ExpensiveComputerPage setProcessorFast() {
        processorFast.click();
        return new ExpensiveComputerPage();
    }

    public ExpensiveComputerPage setRam8Gb() {
        ram8Gb.click();
        return new ExpensiveComputerPage();
    }

    public ExpensiveComputerPage setSoftwareOptions() {
        for (WebElement element : allElements) {
            element.click();
        }
        return new ExpensiveComputerPage();
    }

    public ExpensiveComputerPage clickAddToCard() {
        addToCard.click();
        return new ExpensiveComputerPage();
    }

    public ShopingCartPage clickShoppingCart() {
        shoppingCart.click();
        return new ShopingCartPage();
    }
    public ExpensiveComputerPage checkQuantity() {
        String countComp = shoppingCartCounter.getText();
        countComp =countComp.replace("(","").replace(")","");
        int count = Integer.parseInt(countComp);
        Assert.assertEquals(count,1);
        return new ExpensiveComputerPage();
    }

}
