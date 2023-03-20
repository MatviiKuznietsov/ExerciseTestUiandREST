import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    @Test
    public void Test1() {
        String count = openMainPage()
                .putMouseOnComputer()
                .clickDesktop()
                .clickDisplaySelector()
                .selectFour()
                .sortBy()
                .selectHighToLow()
                .addToCard()
                .showCountProducts();
        Assert.assertEquals(count, "(1)");

        driver.close();
    }

    @Test
    public void Test2() {
        openExpensiveComputerPage()
                .setProcessorFast()
                .setRam8Gb()
                .setSoftwareOptions()
                .clickAddToCard()
                .checkQuantity()
                .clickShoppingCart()
                .checkQty()
                .checkPrice()
                .deleteProduct();
    }

}
