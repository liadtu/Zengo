package zengoApp.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='£0']")
    @iOSXCUITFindBy()
    protected MobileElement usdAmount;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='send-modal-amount-coin']")
    @iOSXCUITFindBy()
    protected MobileElement coinAmount;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
    @iOSXCUITFindBy()
    protected List<MobileElement> keypadButtons;


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

    @Step("Click on keypad button")
    public void clickOnKeypadButton(String button) {
        waitForElementVisibility(keypadButtons.get(0));
        for (MobileElement el : keypadButtons) {
            if (getText(el).equals(button)) {
                click(el);
                break;
            } else {
                System.out.println("The button is not found");
            }
        }
    }

    @Step("Check if the keypad button is enable or disable")
    public boolean checkIfKeypadButtonIsEnable(String button) {
        waitForElementVisibility(keypadButtons.get(0));
        for (MobileElement el : keypadButtons) {
            if (getText(el).equals(button)) {
                return isEnable(el);
            } else {
                System.out.println("The button is not found");
            }
        }
        return false;
    }
}
