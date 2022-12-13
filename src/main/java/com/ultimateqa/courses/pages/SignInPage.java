package com.ultimateqa.courses.pages;

import com.ultimateqa.courses.utility.Utility;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SignInPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
    WebElement welcomeBackMessage;

    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "user[password]")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Invalid email or password.')]")
    WebElement invalidCredentialsErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signInButton;




    public String verifySignInPageMessage(){
        Reporter.log("Verify sign in page text message" + welcomeBackMessage.toString());
        return getTextFromElement(welcomeBackMessage);
    }

    public void enterEmailAddress(String email){
        Reporter.log("Enter email "+ email + " in the email address field" + emailField.toString() );
        sendTextToElement(emailField, email);
    }

    public void enterPassword(String password){
        Reporter.log("Enter password "+ password + " in the password field" + passwordField.toString() );
        sendTextToElement(passwordField, password);
    }

    public void clickOnSignInButton(){
        Reporter.log("Click on sign in button" + signInButton.toString());
        clickOnElement(signInButton);
    }

    public String verifyInvalidCredentialsErrorMessage(){
        Reporter.log("Verify invalid credentials Error message" + invalidCredentialsErrorMessage.toString());
        return getTextFromElement(invalidCredentialsErrorMessage);
    }


}
