package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AmountPage extends BasePage {
    public AmountPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Amount']")
    @iOSXCUITFindBy()
    protected MobileElement amountTitle;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='send-modal-currency-switch']")
    @iOSXCUITFindBy()
    protected MobileElement switchCurrencyButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='send-modal-amount-usd']")
    @iOSXCUITFindBy()
    protected MobileElement usdAmount;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='send-modal-amount-coin']")
    @iOSXCUITFindBy()
    protected MobileElement coinAmount;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='keypad-button-center']")
    @iOSXCUITFindBy()
    protected MobileElement keypadButtonCenter;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[17]")
    @iOSXCUITFindBy()
    protected MobileElement minimumAmountButton;


    @Step("Return the text of amount title")
    public String amountTitle() {
        return getText(amountTitle);
    }

    @Step("Click on switch currency button")
    public void clickOnSwitchCurrencyButton() {
        click(switchCurrencyButton);
    }

    @Step("Return the text of usd amount")
    public String usdAmount() {
        return getText(usdAmount);
    }

    @Step("Return the text of coin amount")
    public String coinAmount() {
        return getText(coinAmount);
    }

    @Step("Click on 50% button")
    public void clickOn50PercentageButton() {
        click(keypadButtonCenter);
    }

    @Step("Check if the minimum amount button is enable or disable")
    public boolean checkIfKeypadButtonIsEnable() {
        waitForElementClickable(minimumAmountButton);
        return isEnable(minimumAmountButton);
    }
}