package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class SearchPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sort']")
    private RemoteWebElement sortField;
    @AndroidFindBy(id = "com.booking:id/searchbox_destination")
    private RemoteWebElement destinationField;

    @AndroidFindBy(id = "com.booking:id/searchbox_dates")
    private RemoteWebElement dateField;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Save property to list'])[1]")
    private RemoteWebElement savePropertyIcon;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement returnBackButton;

    public SearchPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean searchPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(sortField)).isDisplayed();
    }

    public boolean destinationIsDisplayed(String destination){
        return destinationField.getAttribute("text").equals(destination);
    }

    public boolean dateIsDisplayed(String date){
        return dateField.getAttribute("text").equals(date);
    }

    public void savePropertyToList(){
        savePropertyIcon.click();
    }

    public void returnBack(){
        returnBackButton.click();
    }
}
