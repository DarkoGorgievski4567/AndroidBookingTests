package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class SavedPropertiesPage {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Remove property from list")
    private RemoteWebElement removePropertyButton;

    public SavedPropertiesPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean savedPropertyIsDisplayed(){
        return removePropertyButton.isDisplayed();
    }
}
