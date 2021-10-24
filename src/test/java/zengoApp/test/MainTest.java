package zengoApp.test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import zengoApp.pageObject.*;

public class MainTest extends BaseTest {

    MainPage mainPage;
    ActionsPage actionsPage;
    SellPage sellPage;
    SelectCurrencyPage selectCurrencyPage;
    AmountPage amountPage;


    @Test(priority = 1, description = "Home task")
    @Description("Home task - test")
    public void homeTask() throws InterruptedException {
        mainPage = new MainPage(driver);
        actionsPage = new ActionsPage(driver);
        sellPage = new SellPage(driver);
        selectCurrencyPage = new SelectCurrencyPage(driver);
        amountPage = new AmountPage(driver);


        // Click on 'Actions' tab
        mainPage.clickOnTab("Actions");
        // Check that the user enter to actions screen
        Assert.assertEquals(actionsPage.actionTitle(), "Actions");
        // Click on sell action
        actionsPage.clickOnAction("Sell");
        // Check that the user enter to sell screen
        Assert.assertEquals(sellPage.sellTitle(), "Sell");
        // Click on bitcoin
        sellPage.clickOnBitcoinButton();
        // Check that the user enter to select currency screen
        Assert.assertEquals(selectCurrencyPage.selectCurrencyTitle(), "Select Currency");
        // Click on 'GBP' currency
        selectCurrencyPage.chooseCurrency("GBP");
        // Check that the user enter to amount screen
        Assert.assertEquals(amountPage.amountTitle(), "Enter Amount");
        // Get the text of usd amount
        String usd = amountPage.usdAmount();
        // Click on switch currency button
        amountPage.clickOnSwitchCurrencyButton();
        // Get the text of coin amount
        String coin = amountPage.coinAmount();
        // Check that the currency change after the user clicks to switch currency
        Assert.assertNotEquals(usd, coin);
        // Click on 50%
        amountPage.clickOnKeypadButton("50%");
        // Check that the Minimum: 0.001 BTC button is disable
        Assert.assertFalse(amountPage.checkIfKeypadButtonIsEnable("Minimum: 0.001 BTC"));
    }
}