package pageobject.selenide.staticpo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWindow;


@Listeners({ReportPortalTestNGListener.class, ScreenshotListener.class})
public class TestBase {

    @BeforeMethod
    public void methodSetup() {
        Configuration.baseUrl = "https://litecart.stqa.ru/en/";
        Configuration.browser = CHROME;
        Configuration.pageLoadTimeout = 5000;
        Configuration.browserSize = "1920x1080";
        open(Configuration.baseUrl);

    }

    @AfterMethod
    public void methodTeardown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
            try {
                Allure.addAttachment("screenshot" + result.getMethod().getMethodName(), new FileInputStream(screenshot));
            } catch(FileNotFoundException e) {
                System.out.println("Couldn't take screenshot\n" + e.getMessage());
            }
        }

        closeWindow();
    }
}

