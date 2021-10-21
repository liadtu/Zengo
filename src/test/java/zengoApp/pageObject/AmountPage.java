package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AmountPage extends BasePage{
    public AmountPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Amount']")
    @iOSXCUITFindBy()
    protected MobileElement amountTitle;


    @Step("Return the text of amount title")
    public String amountTitle(){
        return getText(amountTitle);
    }
}
