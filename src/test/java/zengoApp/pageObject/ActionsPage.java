package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.List;

public class ActionsPage extends BasePage {
    public ActionsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy()
    protected List<MobileElement> actionsList;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy()
    protected List<MobileElement> actionsTextList;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[@text='Actions']")
    @iOSXCUITFindBy()
    protected MobileElement actionsTitle;


    @Step("Return the text of actions title")
    public String actionTitle() {
        return getText(actionsTitle);
    }

    @Step("Choose action")
    public void clickOnAction(String action) {
        try {
            waitForElementVisibility(actionsList.get(0));
            for (int i = 0; i < actionsTextList.size(); i++) {
                if (getText(actionsTextList.get(i)).equals(action)) {
                    click(actionsList.get(i));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("The action is not found");
        }
    }
}