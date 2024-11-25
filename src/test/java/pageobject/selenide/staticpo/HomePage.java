package pageobject.selenide.staticpo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class HomePage {

    private static By rubberDucksLink = By.xpath("//nav[@id='site-menu']//li[@class='category-1']");
    private static By cartLink = By.xpath("//div[@id='cart']//a[@class='content']");
    private static By cartQuantityLabel = By.xpath("//div[@id='cart']//span[@class='quantity']");
    private static By searchInput = By.xpath("//input[@type='search']");
    private static By miniCartItemsQuantity = By.className("quantity");
    private static By miniCartAmount = By.className("formatted_value");

    @Step("get mini cart items quantity")
    public static int getMiniCartItemsQuantity() {
        return Integer.parseInt($(miniCartItemsQuantity).getText());
    }

    @Step("get mini cart currency")
    public static char getMiniCartCurrency() {
        return $(miniCartAmount).getText().replaceAll("\\d.\\d", "")
                .replaceAll("\\d,\\d", "")
                .replaceAll(" ", "").toCharArray()[0];
    }

    @Step("get mini cart total amount")
    public static double getMiniCartTotalAmount() {
        return Double.parseDouble($(miniCartAmount)
                .getText().replaceAll("\\$", "")
                .replaceAll("€", ""));
    }

    @Step("click rubber ducks link")
    public static void clickRubberDucksLink() {
        $(rubberDucksLink).click();
    }

    @Step("click cart link")
    public static void clickCartLink() {
        $(cartLink).click();
    }

    @Step("wait cart quantity label is visible")
    public static void waitCartQuantityLabelIsVisible(String expectedText) {
        $(cartQuantityLabel).shouldHave(text(expectedText));
    }

    @Step("search data via search input")
    public static void searchDataViaSearchInput(String searchData) {
        $(searchInput).setValue(searchData).pressEnter();
    }
}
