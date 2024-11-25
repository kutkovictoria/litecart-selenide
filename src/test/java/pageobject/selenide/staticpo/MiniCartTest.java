package pageobject.selenide.staticpo;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("Cart functionality implementation")
@Feature("Mini cart")
public class MiniCartTest extends TestBase {

    @Description("Mini cart should be updated when item is added to the cart")
    @Test(description = "Mini cart is updated when item is added to cart")
    public void miniCartIsUpdatedWhenItemIsAddedToCart() {
        SoftAssert softAssert = new SoftAssert();

        YellowDuckPage.addItemToCart();
        HomePage.waitCartQuantityLabelIsVisible("1");

        softAssert.assertEquals(HomePage.getMiniCartItemsQuantity(), 1);
        softAssert.assertEquals(HomePage.getMiniCartCurrency(),'$');
        softAssert.assertEquals(HomePage.getMiniCartTotalAmount(), 20.50);
        softAssert.assertAll();
    }
}
