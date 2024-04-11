package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class SettingsPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='U.S. Dollar (US$)']")
    private RemoteWebElement currencyButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Euro']")
    private RemoteWebElement euroCurrencyButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Euro (€)']")
    private RemoteWebElement euroCurrencyWithSymbolButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private RemoteWebElement privacyPolicyButton;

    @AndroidFindBy(xpath = "//android.webkit.WebView[@text='Privacy & Cookie Statement. | Booking.com']")
    private RemoteWebElement privacyPolicyTitleField;

    public SettingsPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void chooseEuroCurrency(){
        currencyButton.click();
        euroCurrencyButton.click();
    }

    public boolean euroCurrencyIsDisplayed(){
        return euroCurrencyWithSymbolButton.getAttribute("text").equals("Euro (€)");
    }

    public void choosePrivacyPolicy(){
        privacyPolicyButton.click();
    }

    public boolean privacyPolicyIsDisplayed(){
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(privacyPolicyTitleField)).isDisplayed();
        return privacyPolicyTitleField.getAttribute("text").equals("Privacy & Cookie Statement. | Booking.com");
    }
}
