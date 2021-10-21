package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.A;

import java.util.List;

public class SelectCurrencyPage extends BasePage{
    public SelectCurrencyPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@text='Select Currency']")
    @iOSXCUITFindBy()
    protected MobileElement selectCurrencyTitle;
    @AndroidFindBy(className = "android.view.ViewGroup")
    @iOSXCUITFindBy()
    protected List<MobileElement> currencyList;

    @Step("Return the text of select currency title")
    public String selectCurrencyTitle(){
        return getText(selectCurrencyTitle);
    }

    @Step("Choose currency from the list")
    public void chooseCurrency(String currency){
        for (MobileElement el: currencyList){
            if (getText(el).equals(currency)) {
                click(el);
                break;
            }
        }
    }
}
