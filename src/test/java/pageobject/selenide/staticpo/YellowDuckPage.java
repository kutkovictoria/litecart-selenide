package pageobject.selenide.staticpo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

public class YellowDuckPage {
    private static By sizeDropDown = By.xpath("//select[@name='options[Size]']");
    private static By addToCartButton = By.xpath("//button[@name='add_cart_product']");

    @Step("click add to cart button")
    public static void clickAddToCartButton() {
        $(addToCartButton).click();
    }

    @Step("select duck size")
    public static void selectDuckSize() {
        Select dropdown = new Select($(sizeDropDown));
        dropdown.selectByValue("Medium");
    }

    @Step("add item to cart")
    public static void addItemToCart() {
        HomePage.clickRubberDucksLink();
        CatalogPage.clickYellowDuckLink();
        selectDuckSize();
        clickAddToCartButton();
    }
}
