package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class EditProfileTests extends BaseTest {



    @Test
    //#1: Edits profile
    public void editProfile () throws InterruptedException {

        String expectedResultSuccess = "Profile saved successfuly";

        loginPage.clickOnloginPage();
        loginPage.login("admin@admin.com", "12345");

        Thread.sleep(5000);

        homePage.getMyProfile().click();
        editProfile.editProfileWithRandomData();
        editProfile.getSaveButton().click();

        String actualResultSuccess = editProfile.getSuccessMsg().getText();
        Assert.assertTrue(actualResultSuccess.contains(expectedResultSuccess));


    }


}
