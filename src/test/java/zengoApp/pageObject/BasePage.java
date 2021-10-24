package zengoApp.pageObject;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    AppiumDriver<MobileElement> driver;
    protected final int timeOutInSeconds = 10;

    public BasePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    protected void click(MobileElement el) {
        waitForElementClickable(el);
        el.click();
    }

    protected String getText(MobileElement el) {
        waitForElementVisibility(el);
        return el.getText();
    }

    protected void clickEnter() {
        sleep(1000);
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }

    protected boolean isEnable(MobileElement el) {
        return el.isEnabled();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementVisibility(MobileElement el) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public void waitForElementClickable(MobileElement el) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }
}