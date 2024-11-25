package pageobject.selenide.staticpo;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.xpath("//button[@type='submit'][@name='login']");
    private static By successMessage = By.xpath("//div[@class='notice success']");
    private static By errorMessage = By.xpath("//div[@class='notice errors']");

    @Step("type email")
    public static void typeEmail(String email){
        $(emailInput).sendKeys(email);
    }

    @Step("type password")
    public static void typePassword(String password){
        $(passwordInput).sendKeys(password);
    }

    @Step("click login button")
    public static void clickLoginButton(){
        $(loginButton).click();
    }

    @Step("login with credentials")
    public static void loginWithCredentials (String email, String password){
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }
    @Step("validate that the success message is displayed")
    public static void validateSuccessMessage(){
        $(successMessage).shouldBe(Condition.visible);
    }
    @Step("validate that the error message is displayed")
    public static void validateErrorMessage(){
        $(errorMessage).shouldBe(Condition.visible);
    }

    @Step("validate the success message text")
    public static void validateSuccessMessageText(String expectedText){
        $(successMessage).shouldHave(Condition.text(expectedText));
    }
    @Step("validate the error message text")
    public static void validateErrorMessageText(String expectedText){
        $(errorMessage).shouldHave(Condition.text(expectedText));
    }
}
