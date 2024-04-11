package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.DriverSetup;

@Epic("Regression Tests")
@Feature("Calendar Tests")
public class BookingTests extends DriverSetup {

    @Test(testName = "Search for bookings")
    @Description("Test Description: Search for accommodations to book")
    public void bookingAppTest() {
        signInPage.acceptCookies();
        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign in page is not loaded.");
        signInPage.closeSignInPage();
        Assert.assertTrue(homePage.homePageLoaded(), "Home page is not loaded.");
        homePage.fillInDestination("Skopje");
        homePage.chooseDate("24 April 2024");
        homePage.chooseDate("28 April 2024");
        homePage.selectDates();
        homePage.chooseAccommodation("1 room, 2 adults, 0 children");
        homePage.increaseRooms(1);
        homePage.increaseAdults(1);
        homePage.applyAccommodationSelection();
        homePage.searchAccommodations();
        Assert.assertTrue(searchPage.searchPageLoaded(), "Search page is not loaded.");
        Assert.assertTrue(searchPage.destinationIsDisplayed("Skopje"));
        Assert.assertTrue(searchPage.dateIsDisplayed("Apr 24 - Apr 28"));
        searchPage.savePropertyToList();
        searchPage.returnBack();
        homePage.chooseSavedProperties();
        Assert.assertTrue(savedPropertiesPage.savedPropertyIsDisplayed(), "No property is saved");
        searchPage.returnBack();
        signInPage.pressSignIn();
        Assert.assertTrue(signInPage.signInIsDisplayed(), "Sign in page is not displayed");
        signInPage.chooseSettings();
        settingsPage.chooseEuroCurrency();
        settingsPage.euroCurrencyIsDisplayed();
        settingsPage.choosePrivacyPolicy();
        Assert.assertTrue(settingsPage.privacyPolicyIsDisplayed(), "Privacy policy page is not displayed");
    }

    @Test(testName = "Search for car rental")
    @Description("Test Description: Search car rental")
    public void bookingAppTest2() {
        signInPage.acceptCookies();
        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign in page is not loaded.");
        signInPage.closeSignInPage();
        Assert.assertTrue(homePage.homePageLoaded(), "Home page is not loaded.");
        homePage.pressSignIn();
        signInPage.chooseGeniusLoyaltyProgram();
        geniusLoyaltyProgramPage.chooseAboutGeniusLevel();
        geniusLoyaltyProgramPage.pressGotIt();
        geniusLoyaltyProgramPage.returnBack();
        signInPage.pressSearch();
        homePage.chooseCarRental();
        carRentalPage.returnToSameLocation();
        Assert.assertTrue(carRentalPage.pickUpLocationIsDisplayed(),"Pick-up location field is not displayed");
        Assert.assertTrue(carRentalPage.dropOffLocationIsDisplayed(),"Drop off location field is not displayed");
        carRentalPage.addPickUpAndDropOffLocation("Skopje", "Ohrid");
        carRentalPage.chooseDates("24 April 2024","27 April 2024");
        carRentalPage.chooseTime("8:15 AM", "11:00 AM");
        carRentalPage.addDriversAge("39");
        carRentalPage.pressSearch();
    }
}
