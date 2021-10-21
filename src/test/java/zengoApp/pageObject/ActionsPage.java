package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.List;

public class ActionsPage extends BasePage{
    public ActionsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Actions']")
    @iOSXCUITFindBy()
    protected MobileElement actionsTitle;
    @AndroidFindBy(className = "android.view.ViewGroup")
    @iOSXCUITFindBy()
    protected List<MobileElement> actionsList;


    @Step("Return the text of actions title")
    public String actringTitle(){
        return getText(actionsTitle);
    }

    @Step("Click on action from the menu")
    public void clickOnAction(String action){
        for (MobileElement el : actionsList){
            if (getText(el).equals(action)){
                click(el);
                break;
            }
        }
    }
}
