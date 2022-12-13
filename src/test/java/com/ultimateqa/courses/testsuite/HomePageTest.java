package com.ultimateqa.courses.testsuite;

import com.ultimateqa.courses.pages.HomePage;
import com.ultimateqa.courses.pages.SignInPage;
import com.ultimateqa.courses.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        signInPage = new SignInPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnSignInLink();
        Assert.assertEquals(signInPage.verifySignInPageMessage(), "Welcome Back!", "Not navigated to sign in page");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessage() {
        homePage.clickOnSignInLink();
        signInPage.enterEmailAddress("test12@gmail.com");
        signInPage.enterPassword("test123456");
        signInPage.clickOnSignInButton();
        Assert.assertEquals(signInPage.verifyInvalidCredentialsErrorMessage(), "Invalid email or password.", "Error message for invalid credentials not displayed");

    }
}
