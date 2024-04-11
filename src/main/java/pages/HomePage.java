package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

import java.util.stream.IntStream;

public class HomePage {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Enter your destination")
    private RemoteWebElement enterDestinationButton;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private RemoteWebElement enterDestinationField;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private RemoteWebElement selectDestinationDropMenu;

    @AndroidFindBy(id = "com.booking:id/facet_date_picker_confirm")
    private RemoteWebElement selectDatesButton;

    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc='Increase'])[1]")
    private RemoteWebElement increaseRoomsNumberButton;

    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc='Increase'])[2]")
    private RemoteWebElement increaseAdultsNumberButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Search'])[1]")
    private RemoteWebElement searchButton;
    @AndroidFindBy(id = "com.booking:id/group_config_apply_button")
    private RemoteWebElement applyButton;
    @AndroidFindBy(accessibility = "Saved")
    private RemoteWebElement savedButton;
    @AndroidFindBy(accessibility = "Sign in")
    private RemoteWebElement signInIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Car rental']")
    private RemoteWebElement carRentalButton;

    public HomePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean homePageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(enterDestinationButton)).isDisplayed();
    }

    public void fillInDestination(String destination){
        enterDestinationButton.click();
        enterDestinationField.sendKeys(destination);
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + destination + "']"));
        element.click();
    }

    public void chooseDate(String date){
        WebElement element = driver.findElement(AppiumBy.accessibilityId(date));
        element.click();
    }

    public void selectDates(){
        selectDatesButton.click();
    }

    public void chooseAccommodation(String accommodation){
        WebElement element = driver.findElement(AppiumBy.accessibilityId(accommodation));
        element.click();
    }
    public void increaseRooms(int roomNumber) {
        IntStream.range(0, roomNumber).forEach(obj -> {
            increaseRoomsNumberButton.click();
        });
    }

    public void increaseAdults(int adultsNumber) {
        IntStream.range(0, adultsNumber).forEach(obj -> {
            increaseAdultsNumberButton.click();
        });
    }

    public void applyAccommodationSelection(){
        applyButton.click();
    }

    public void searchAccommodations(){
        searchButton.click();
    }

    public void chooseSavedProperties(){
        savedButton.click();
    }

    public void pressSignIn(){
        signInIcon.click();
    }

    public void chooseCarRental(){
        carRentalButton.click();
    }
}
