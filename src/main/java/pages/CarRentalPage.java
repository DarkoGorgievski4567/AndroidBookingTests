package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import util.Helpers;

public class CarRentalPage extends Helpers{

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Selected, you will return the car to the same location")
    private RemoteWebElement returnToSameLocationToggle;

    @AndroidFindBy(accessibility = "Enter a pick-up location")
    private RemoteWebElement pickUpLocationButton;

    @AndroidFindBy(accessibility = "Enter a drop-off location")
    private RemoteWebElement dropOffLocationButton;

    @AndroidFindBy(id = "com.booking:id/search_query_edittext")
    private RemoteWebElement locationField;

    @AndroidFindBy(xpath = "(//android.widget.Button)[3]")
    private RemoteWebElement pickUpDateField;

    @AndroidFindBy(xpath = "(//android.widget.Button)[4]")
    private RemoteWebElement pickUpTimeField;

    @AndroidFindBy(xpath = "(//android.widget.Button)[6]")
    private RemoteWebElement dropOffTimeField;

    @AndroidFindBy(accessibility = "Enter the driver's age")
    private RemoteWebElement driversAgeField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
    private RemoteWebElement searchButton;

    @AndroidFindBy(id = "com.booking:id/calendar_confirm")
    private RemoteWebElement selectDateButton;

    public CarRentalPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void returnToSameLocation(){
        returnToSameLocationToggle.click();
    }

    public boolean pickUpLocationIsDisplayed(){
        return pickUpLocationButton.isDisplayed();
    }

    public boolean dropOffLocationIsDisplayed(){
        return dropOffLocationButton.isDisplayed();
    }

    public void addPickUpAndDropOffLocation(String pickUpLocation, String dropOffLocation){
        pickUpLocationButton.click();
        locationField.sendKeys(pickUpLocation);
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + pickUpLocation + "']"));
        element.click();
        dropOffLocationButton.click();
        locationField.sendKeys(dropOffLocation);
        WebElement element1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + dropOffLocation + "']"));
        element1.click();
    }

    public void chooseDates(String pickUpDate, String dropOffDate){
        pickUpDateField.click();
        WebElement pickUpDateElement = driver.findElement(AppiumBy.accessibilityId(pickUpDate));
        pickUpDateElement.click();
        WebElement dropOffDateElement = driver.findElement(AppiumBy.accessibilityId(dropOffDate));
        dropOffDateElement.click();
        selectDateButton.click();
    }

    public void chooseTime(String pickUpTime, String dropOffTime){
        pickUpTimeField.click();
        scrollTo(driver, Directions.DOWN, 2);
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + pickUpTime + "']"));
        element.click();
        dropOffTimeField.click();
        WebElement element1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + dropOffTime + "']"));
        element1.click();
    }

    public void addDriversAge(String age){
        driversAgeField.click();
//        driversAgeField.sendKeys(age);
    }

    public void pressSearch(){
        searchButton.click();
    }
}
