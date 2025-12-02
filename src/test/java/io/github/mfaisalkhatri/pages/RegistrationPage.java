package io.github.mfaisalkhatri.pages;

import io.github.mfaisalkhatri.data.RegistrationData;
import io.github.mfaisalkhatri.data.RegistrationRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    private final WebDriver driver;

    public RegistrationPage (WebDriver driver) {
        this.driver = driver;
    }

    public void fillRegistrationForm (RegistrationData registrationData) {
        clearAndType(firstNameField (), registrationData.getFirstName ());
        clearAndType(lastNameField (), registrationData.getLastName ());
        dobField ().sendKeys (registrationData.getDob ());
        clearAndType(streetField (), registrationData.getStreet ());
        clearAndType (postalCodeField (), registrationData.getPostalCode ());
        clearAndType (cityField (), registrationData.getCity ());
        clearAndType (stateField (),registrationData.getState ());
        selectCountryVisibleText (registrationData.getCountry ());
        clearAndType (phoneField (), registrationData.getPhone ());
        clearAndType (emailAddressField (), registrationData.getEmailAddress ());
        clearAndType (passwordField (), registrationData.getPassword ());
        registerButton ().click ();
    }

    public String pageHeader () {
        return driver.findElement (By.cssSelector ("app-register h3"))
            .getText ();
    }

    public String passwordAlertMessage () {
        return driver.findElement (By.cssSelector (".alert-danger div"))
            .getText ();
    }

    public void registerUser (RegistrationRecord registrationRecord) {
        clearAndType(firstNameField (), registrationRecord.firstName ());
        clearAndType(lastNameField (), registrationRecord.lastName ());
        dobField ().sendKeys (registrationRecord.dob ());
        clearAndType(streetField (), registrationRecord.street ());
        clearAndType (postalCodeField (), registrationRecord.postalCode ());
        clearAndType (cityField (), registrationRecord.city ());
        clearAndType (stateField (),registrationRecord.state ());
        selectCountryVisibleText (registrationRecord.country ());
        clearAndType (phoneField (), registrationRecord.phone ());
        clearAndType (emailAddressField (), registrationRecord.emailAddress ());
        clearAndType (passwordField (), registrationRecord.password ());
        registerButton ().click ();

    }

    private WebElement cityField () {
        return driver.findElement (By.id ("city"));
    }

    private WebElement countryField () {
        return driver.findElement (By.id ("country"));
    }

    private WebElement dobField () {
        return driver.findElement (By.id ("dob"));
    }

    private WebElement emailAddressField () {
        return driver.findElement (By.id ("email"));
    }

    private WebElement firstNameField () {
        return driver.findElement (By.id ("first_name"));
    }

    private WebElement lastNameField () {
        return driver.findElement (By.id ("last_name"));
    }

    private WebElement passwordField () {
        return driver.findElement (By.id ("password"));
    }

    private WebElement phoneField () {
        return driver.findElement (By.id ("phone"));
    }

    private WebElement postalCodeField () {
        return driver.findElement (By.id ("postal_code"));
    }

    private WebElement registerButton () {
        return driver.findElement (By.cssSelector (".btnSubmit"));
    }

    private void selectCountryVisibleText (String countryName) {
        //countryField ().click ();
        new Select (countryField ()).selectByVisibleText (countryName);
    }

    private WebElement stateField () {
        return driver.findElement (By.id ("state"));
    }

    private WebElement streetField () {
        return driver.findElement (By.id ("street"));
    }

    private void clearAndType (WebElement element, String text) {
        element.clear ();
        element.sendKeys (text);
    }
}