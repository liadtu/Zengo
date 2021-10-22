package zengoApp.pageObject;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    AppiumDriver<MobileElement> driver;
    protected final int timeOutInSeconds = 30;

    public BasePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    protected void click(MobileElement el) {
        waitForElementClickable(el);
        el.click();
    }

    protected void fillText(MobileElement el, String text) {
        waitForElementClickable(el);
        el.clear();
        el.sendKeys(text);
        clickEnter();
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

    public void swipe(int startX, int startY, int endX, int endY) {
        TouchAction touchAction = new TouchAction(driver);
        PointOption pointStart = PointOption.point(startX, startY);
        PointOption pointEnd = PointOption.point(endX, endY);
        WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(1000));
        touchAction.press(pointStart).waitAction(waitOption).moveTo(pointEnd).release().perform();
    }

    public void swipeByElements(MobileElement el, String text) {
        driver.findElement(By.id("new UiScrollable(new UiSelector()" + ".resourceId(" + el + "))" +
                ".scrollIntoView(" + "new UiSelector().text(" + text + "));"));
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