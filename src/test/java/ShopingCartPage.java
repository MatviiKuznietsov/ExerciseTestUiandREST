import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShopingCartPage extends BasePage {
    @FindBy(xpath = "//input[@name='removefromcart']")
    private WebElement checkBoxItem;
    @FindBy(xpath = "//input[@name='updatecart']")
    private WebElement updateButton;

    @FindBy(xpath = "//input[@class='qty-input']")
    private WebElement quantity;

    @FindBy(xpath = "//span[@class='product-subtotal']")
    private WebElement price;

    public ShopingCartPage() {
        PageFactory.initElements(driver, this);
    }

    public ShopingCartPage deleteProduct() {
        checkBoxItem.click();
        updateButton.click();
        return new ShopingCartPage();
    }

    public ShopingCartPage checkQty() {
        quantity.getAttribute("value");
        Assert.assertEquals(quantity.getAttribute("value"), "1");
        return new ShopingCartPage();
    }

    public ShopingCartPage checkPrice() {
        Assert.assertEquals(price.getText(), "2105.00");
        return new ShopingCartPage();
    }
}
