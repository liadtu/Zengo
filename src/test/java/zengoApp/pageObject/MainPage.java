package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy()
    @iOSXCUITFindBy()
    protected MobileElement belongAppTutorialPopupTitle;
    @AndroidFindBy()
    @iOSXCUITFindBy()
    protected List<MobileElement> belongAppTutorialButtons;
}
