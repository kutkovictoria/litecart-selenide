package pageobject.selenide.staticpo;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;


@Epic("Search functionality implementation")
@Feature("Search")
public class CatalogTest extends TestBase {
    @Description("Search item by title name")
    @Test(description = "find duck by title name")
    public void findDuckByTitleName() {
        String expectedDuckTitleName = "Purple Duck";
        HomePage.searchDataViaSearchInput(expectedDuckTitleName);
        CatalogPage.validateDuckTitleName(expectedDuckTitleName);
    }

    @Description("Search item by keyword")
    @Test(description = "find all ducks by keyword 'duck' ")
    public void findAllDucksByKeywordDuck() {
        String searchInputValue = "Duck";
        HomePage.searchDataViaSearchInput(searchInputValue);

        Assert.assertTrue(CatalogPage.getSearchResultNames().stream().anyMatch(result -> result.contains(searchInputValue)), "Not all result names contain " + searchInputValue);
    }
}

