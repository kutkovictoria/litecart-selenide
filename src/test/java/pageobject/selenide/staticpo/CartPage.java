package pageobject.selenide.staticpo;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private static By duckCardTitle = By.xpath("//div[@id='box-checkout-cart']//strong");  ////strong[text()='Yellow Duck']
    private static By duckSize = By.xpath("//div[@id='box-checkout-cart']//p[2]");
    private static By duckPrise = By.xpath("//div[@id='box-checkout-cart']//p[3]");
    private static By itemsQuantity = By.xpath("//input[@name='quantity']");
    private static By removeButton = By.xpath("//button[@name='remove_cart_item']");
    private static By noItemsInCartMessage = By.xpath("//div[@id='checkout-cart-wrapper']/p/em");

    @Step("validate duck cart title text")
    public static void validateDuckCardTitle(String expectedText) {
        $(duckCardTitle).shouldHave(Condition.text(expectedText));
    }

    @Step("validate duck size text")
    public static void validateDuckSize(String expectedText) {
        $(duckSize).shouldHave(Condition.text(expectedText));
    }

    @Step("validate duck size")
    public static double getDuckPrise() {
        return Double.parseDouble($(duckPrise)
                .getText().replaceAll("\\$", "")
                .replaceAll("€", ""));
    }
    @Step("get items quantity")
    public static int getItemsQuantity() {
        return Integer.parseInt($(itemsQuantity).getAttribute("value"));
    }

    @Step("click remove button")
    public static void clickRemoveButton() {
        $(removeButton).click();
    }

    @Step("validate 'no items in the cart' message text")
    public static void validateNoItemsInCartMessageText(String expectedText) {
        $(noItemsInCartMessage).shouldHave(Condition.text(expectedText));
    }
}
