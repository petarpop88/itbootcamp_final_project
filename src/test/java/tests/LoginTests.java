package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {



    @Test (priority = 1)
    //Test #1: Visits the login1 page
    public void testVisitLoginPage () {


        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        loginPage.clickOnloginPage();

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(expectedResult, actualResult);
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
        Assert.assertEquals(expectedResultPassword, expectedResultPassword);

    }

    @Test (priority = 3)
    //#3: Displays errors when user does not exist
    public void testUserNotFound () {


        Faker faker = new Faker();
        String expectedResultMessage = "User does not exists";

        loginPage.clickOnloginPage();
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());

        Assert.assertTrue(loginPage.errorMessage().isDisplayed());

        String actualResultMessage = loginPage.userDoesntExist().getText();

        Assert.assertEquals(expectedResultMessage, actualResultMessage );

    }


    }
