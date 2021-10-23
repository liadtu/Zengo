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

    @AndroidFindBy(xpath = "//android.widget.Button")
    @iOSXCUITFindBy()
    protected List<MobileElement> tabList;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='ActionsNavigator, tab, 2 of 4']/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy()
    protected List<MobileElement> valueTabList;


    @Step("Click on tab from the menu")
    public void clickOnTab(String tab) {
        waitForElementVisibility(tabList.get(0));
        for (int i = 0; i < valueTabList.size(); i++) {
            if (valueTabList.get(i).equals(tab)) {
                click(tabList.get(i));
                break;
            } else {
                System.out.println("The tab is not found");
            }
        }
    }
}
