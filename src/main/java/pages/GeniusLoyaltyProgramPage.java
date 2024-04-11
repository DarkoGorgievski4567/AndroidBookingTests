package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import util.Helpers;

public class GeniusLoyaltyProgramPage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/action_button")
    private RemoteWebElement gotItButton;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement returnBackButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About Genius Levels']")
    private RemoteWebElement aboutGeniusLevelLink;

    public GeniusLoyaltyProgramPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void chooseAboutGeniusLevel(){
        scrollTo(driver, Helpers.Directions.UP, 4);
        aboutGeniusLevelLink.click();
    }

    public void pressGotIt(){
        gotItButton.click();
    }

    public void returnBack(){
        returnBackButton.click();
    }
}
