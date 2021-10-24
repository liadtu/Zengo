package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActionsPage extends BasePage {
    public ActionsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[@text='Actions']")
    @iOSXCUITFindBy()
    protected MobileElement actionsTitle;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy()
    protected List<MobileElement> actionsList;


    @Step("Return the text of actions title")
    public String actionTitle() {
        return getText(actionsTitle);
    }

    @Step("Click on action from the menu")
    public void clickOnAction(String action) {
        waitForElementVisibility(actionsList.get(0));
        for (MobileElement el : actionsList) {
            if (getText(el).equals(action)) {
                click(el);
                break;
            } else {
                System.out.println("The action is not found");
            }
        }
    }
}
