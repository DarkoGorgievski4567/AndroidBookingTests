package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Listeners({ TestListener.class })
public class DriverSetup extends ConfigReader{

    public static AndroidDriver driver;

    public DesiredCapabilities capabilities = new DesiredCapabilities();

    protected HomePage homePage;
    protected SignInPage signInPage;
    protected SearchPage searchPage;
    protected SavedPropertiesPage savedPropertiesPage;
    protected SettingsPage settingsPage;
    protected GeniusLoyaltyProgramPage geniusLoyaltyProgramPage;
    protected CarRentalPage carRentalPage;

    @BeforeMethod
    public void setUp() {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(getProperty("device.name"))
                .setAutomationName(getProperty("automation.name"))
                .setApp(getProperty("app.path"))
                .setAppActivity(getProperty("app.activity"))
                .setAppPackage(getProperty("app.package"))
                .setNoReset(false)
                .setFullReset(true);

        try {
            driver = new AndroidDriver(new URL(GlobalVariables.localAppiumServerUrl), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        searchPage = new SearchPage(driver);
        savedPropertiesPage = new SavedPropertiesPage(driver);
        settingsPage = new SettingsPage(driver);
        geniusLoyaltyProgramPage = new GeniusLoyaltyProgramPage(driver);
        carRentalPage = new CarRentalPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
