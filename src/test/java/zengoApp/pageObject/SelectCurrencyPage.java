package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.List;

public class SelectCurrencyPage extends BasePage {
    public SelectCurrencyPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@text='Select Currency']")
    @iOSXCUITFindBy()
    protected MobileElement selectCurrencyTitle;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    @iOSXCUITFindBy()
    protected List<MobileElement> currencyList;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy()
    protected List<MobileElement> currencyValeList;


    @Step("Return the text of select currency title")
    public String selectCurrencyTitle() {
        return getText(selectCurrencyTitle);
    }

    @Step("Click on currency")
    public void clickOnCurrency(String currency) {
        try {
            waitForElementVisibility(currencyList.get(0));
            for (int i = 0; i < currencyValeList.size(); i++) {
                if (getText(currencyValeList.get(i)).equals(currency)) {
                    click(currencyList.get(i));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("The currency is not found");
        }
    }
}