package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.Button")
    @iOSXCUITFindBy()
    protected List<MobileElement> tabList;


    @Step("Click on tab from the menu")
    public void clickOnTab(String tab) {
        waitForElementClickable(tabList.get(0));
        for (MobileElement el : tabList) {
            if (getText(el).equals(tab)) {
                click(el);
                break;
            } else {
                System.out.println("The tab is not found");
            }
        }
    }
}
