package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MainPage extends BasePage {

    public MainPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ActionsNavigator, tab, 2 of 4']/android.view.ViewGroup")
    @iOSXCUITFindBy()
    protected MobileElement actionsButton;


    @Step("Click on actions button")
    public void clickOnActions() {
        click(actionsButton);
    }
}
