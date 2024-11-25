package pageobject.selenide.staticpo;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {
    private static By yellowDuckLink = By.xpath("//div[@class='name'][text()='Yellow Duck']");
    private static By searchResultLocator = By.xpath("//div[@class='name']");
    private static By duckTitleName = By.xpath("//h1[@class='title']");

    @Step("click yellow duck link")
    public static void clickYellowDuckLink() {
        $(yellowDuckLink).click();
    }

    @Step("validate duck title name")
    public static void validateDuckTitleName(String expectedText) {
        $(duckTitleName).shouldHave(Condition.text(expectedText));
    }

    @Step("get search result title names")
    public static List<String> getSearchResultNames() {
        return $$(searchResultLocator).texts();
    }
}

