package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;
import util.Helpers;

public class SignInPage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement closeSignInButton;

    @AndroidFindBy(id = "com.booking:id/bt_accept")
    private RemoteWebElement acceptCookiesButton;

    @AndroidFindBy(id = "com.booking:id/facet_profile_header_sign_in_warning")
    private RemoteWebElement signInTitleField;

    @AndroidFindBy(accessibility = "Sign in")
    private RemoteWebElement signInIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Genius loyalty program']")
    private RemoteWebElement geniusLoyaltyProgramButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private RemoteWebElement settingsButton;

    @AndroidFindBy(accessibility = "Search")
    private RemoteWebElement searchButton;

    public SignInPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean signInPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(closeSignInButton)).isDisplayed();
    }

    public void acceptCookies(){
        acceptCookiesButton.click();
    }
    public void closeSignInPage(){
        closeSignInButton.click();
    }

    public void pressSignIn(){
        signInIcon.click();
    }

    public boolean signInIsDisplayed(){
        return signInTitleField.getAttribute("text").equals("Sign in to see deals and Genius discounts, manage your trips, and more");
    }

    public void chooseSettings(){
        swipeVertically(driver, Directions.UP);
        settingsButton.click();
    }

    public void chooseGeniusLoyaltyProgram(){
        geniusLoyaltyProgramButton.click();
    }

    public void pressSearch(){
        searchButton.click();
    }
}
