package pageobject.selenide.staticpo;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Login functionality implementation")
@Feature("UI Login form")
public class LoginTest extends TestBase {

    @Description("Login with correct email and correct password")
    @Test(description = "login with correct credentials")
    public void loginWithValidCredentials() {
        LoginPage.loginWithCredentials("nickysmith2023@yahoo.com", "lSOnFe");
        LoginPage.validateSuccessMessage();
        LoginPage.validateSuccessMessageText("You are now logged in as Nicky Smith.");
    }

    @Description("Login with correct email and wrong password and check error message")
    @Test(description = "login with correct email and wrong password")
    public void loginWithCorrectEmailAndWrongPassword() {
        LoginPage.loginWithCredentials("nickysmith2023@yahoo.com", "12341234");
        LoginPage.validateErrorMessage();
        LoginPage.validateErrorMessageText("Wrong password or the account is disabled, or does not exist");
    }

    @Description("Login with wrong email and correct password and check error message")
    @Test(description = "login with wrong email and correct password")
    public void loginWithWrongEmailAndCorrectPassword() {
        LoginPage.loginWithCredentials("nickysmith@yahoo.com", "12341234");
        LoginPage.validateErrorMessage();
        LoginPage.validateErrorMessageText("Wrong password or the account is disabled, or does not exist");

    }

    @Description("Login with correct email and correct password and check error message")
    @Test(description = "login with correct email and empty password")
    public void loginWithCorrectEmailEmptyPassword() {
        LoginPage.loginWithCredentials("nickysmith@yahoo.com", "");
        LoginPage.validateErrorMessage();
        LoginPage.validateErrorMessageText("You must provide both email address and password.");
    }
}
