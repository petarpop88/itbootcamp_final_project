package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.logging.SocketHandler;

public class CitiesTests extends BaseTest{


    @Test (priority = 1)
    //#1: Visits the admin cities page and verify:
    // verify that logout button is visible
    // verify that admin page url contains /admin/cities
    public void visitAdminPage () {

        loginPage.clickOnloginPage();
        loginPage.login("admin@admin.com", "12345");
        Assert.assertTrue(homePage.getLogOutButton().isDisplayed());

        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");

        String expectedResultRoute = "admin/cities";

        String actualResultUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualResultUrl.contains(expectedResultRoute));

    }
    @Test (priority = 2)
    //#2: Create new city
    public void createNewCity () throws InterruptedException {

        String expectedResultSucces = "Saved successfully";

        loginPage.clickOnloginPage();

        loginPage.login("admin@admin.com", "12345");

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();
        adminCitiesPage.getNewItemButton().click();

        Thread.sleep(5000);
        adminCitiesPage.getEnterNewCityNameField().sendKeys(faker.gameOfThrones().city());
        adminCitiesPage.getSaveButton().click();

        String actualResultSucces = adminCitiesPage.getSavedSucces().getText();

        Assert.assertTrue(actualResultSucces.contains(expectedResultSucces));

    }

    @Test (priority = 3)
    //#3: Edit city
    public void editCity () {

        loginPage.clickOnloginPage();

        loginPage.login("admin@admin.com", "12345");

       /* WebElement selectEl = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]"));
        Select select = new Select(selectEl);
        select.selectByVisibleText("Cities");

        adminCitiesPage.getNewItemButton().click();
*/
    }



}
