package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {



    @Test (priority = 1)
    //Test #1: Visits the login1 page
    public void testVisitLoginPage () {

        String expectedResult = "/login";

        loginPage.clickOnloginPage();

        String actualResult = driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test (priority = 2)
    //#2: Checks input types
    public void testChecksInputTypes () {

        String expectedResultEmail = "email";
        String expectedResultPassword = "password";

        loginPage.clickOnloginPage();

        String actualResultEmail = getDriver().findElement(By.id("email")).getAttribute("type");
        String actualResultPassword = getDriver().findElement(By.id("password")).getAttribute("type");

        Assert.assertEquals(expectedResultEmail, actualResultEmail);
        Assert.assertEquals(expectedResultPassword,actualResultPassword);

    }

    @Test (priority = 3)
    //#3: Displays errors when user does not exist
    public void testUserNotFound () {

        String expectedResultMessage = "User does not exists";
        String expectedRoute = "/login";
        loginPage.clickOnloginPage();
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());

        String actualResultUrl = driver.getCurrentUrl();

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        String actualResultMessage = loginPage.getUserDoesntExist().getText();
        Assert.assertEquals(expectedResultMessage, actualResultMessage);
        Assert.assertTrue(actualResultUrl.contains(expectedRoute));
    }

    @Test (priority = 4)
    //#4: Displays errors when password is wrong
    // in order to get wrong password error message, we need to use existing email!
    public void testWrongPassword () {

        loginPage.clickOnloginPage();
        loginPage.getEmail().sendKeys("petarpop88@gmail.com");
        loginPage.getPassword().sendKeys(faker.internet().password());
        loginPage.getLoginButton().click();

        loginPage.getWrongPasswordMessage().isDisplayed();

        String expectedResultWrongPass = "Wrong password";
        String actualResultWrongPass = loginPage.getWrongPasswordMessage().getText();

        String expectedRoute2 = "/login";
        String actualResultUrl2 = driver.getCurrentUrl();

        Assert.assertEquals(expectedResultWrongPass, actualResultWrongPass);
        Assert.assertTrue(actualResultUrl2.contains(expectedRoute2));
    }

    @Test (priority = 5)
    //#5: Login
    public void login () {

        loginPage.clickOnloginPage();
        loginPage.login("petarpop88@gmail.com", "WgU^21ngok93");

        String expectedRoute3 = "/login";
        String actualResultUrl3 = driver.getCurrentUrl();

        Assert.assertTrue(actualResultUrl3.contains(expectedRoute3));
    }

    @Test (priority = 6)
    //#6: Logout
    public void logOut () {

        //verify that attempt to open /home route page redirect to /login route
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedRoute4 = "/login";
        String actualResultUrl4 = driver.getCurrentUrl();
        Assert.assertTrue(actualResultUrl4.contains(expectedRoute4));

        loginPage.clickOnloginPage();
        loginPage.login("admin@admin.com",  "12345");

        Assert.assertTrue(homePage.getLogOutButton().isDisplayed());

    }

}
