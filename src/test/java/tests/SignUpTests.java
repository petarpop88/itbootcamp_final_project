package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {


    @Test
    //#1: Visits the signup page
    public void signUpPageVisit() {

        String expectedResult = "/signup";
        homePage.getSignUpButton().click();
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    // #2: Checks input types
    public void checkInputTypes() {

        String expectedResultEmail = "email";
        String expectedResultPassword = "password";
        String expectedResultConfirmPassword = "password";

        homePage.getSignUpButton().click();

        Assert.assertEquals(signUpPage.getEmailField().getAttribute("type"), expectedResultEmail);
        Assert.assertEquals(signUpPage.getPasswordField().getAttribute("type"), expectedResultPassword);
        Assert.assertEquals(signUpPage.getConfirmPasswordField().getAttribute("type"), expectedResultConfirmPassword);

    }

    @Test
    // #3: Displays errors when user already exists
    public void userExist() {

        String expectedResultMsg = "E-mail already exists";
        homePage.getSignUpButton().click();
        signUpPage.userCantSignUpWithExistingEmail();
        Assert.assertTrue(signUpPage.getEmailExist().getText().contains(expectedResultMsg));

        String expectedResult = "/signup";
        homePage.getSignUpButton().click();
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    // #4: Signup
    public void signUp() {

        String expectedResultMsg2 = "IMPORTANT: Verify your account";

        homePage.getSignUpButton().click();
        signUpPage.signUp(faker.name().fullName(), faker.internet().emailAddress(), "12345", "12345");

        webDriverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));

        String actualResultMsg2 = signUpPage.getImportantMsg().getText();
        Assert.assertEquals(actualResultMsg2, expectedResultMsg2);


    }


}

