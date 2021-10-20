package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class AllureAttachment {

    @Attachment(value = "Page Screenshot", type = "image/png", fileExtension = ".png")
    static File attachScreenshot(AppiumDriver<MobileElement> driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
}