package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CitiesTests extends BaseTest {


    @Test
    //#1: Visits the admin cities page and verify:
    // verify that logout button is visible
    // verify that admin page url contains /admin/cities
    public void visitAdminPage() {

        loginPage.clickOnloginPage();
        loginPage.login("admin@admin.com", "12345");
        Assert.assertTrue(homePage.getLogOutButton().isDisplayed());

        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");

        String expectedResultRoute = "admin/cities";

        String actualResultUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualResultUrl.contains(expectedResultRoute));

    }


    @Test
    //#2: Create new city
    public void createNewCity() {

        String expectedResultSucces = "Saved successfully";

        loginPage.clickOnloginPage();

        loginPage.login("admin@admin.com", "12345");

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();
        adminCitiesPage.getNewItemButton().click();


        adminCitiesPage.getEnterNewCityNameField().sendKeys(faker.gameOfThrones().city());
        adminCitiesPage.getSaveButton().click();

        String actualResultSucces = adminCitiesPage.getSavedSucces().getText();
        Assert.assertTrue(actualResultSucces.contains(expectedResultSucces));

    }


    @Test
    //#3: Edit city
    public void editCity() {

        String expectedResultSucces2 = "Saved successfully";
        loginPage.clickOnloginPage();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();
        adminCitiesPage.getActionEdit().click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        adminCitiesPage.getEditField().sendKeys(" - edited");
        adminCitiesPage.getSaveButtonEditItem().click();

        Assert.assertTrue(adminCitiesPage.getSavedSuccesEditedItem().getText().contains(expectedResultSucces2));

    }

    @Test
    //#4: Search city
    public void searchCity() {

        loginPage.clickOnloginPage();
        loginPage.login("admin@admin.com", "12345");

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        adminCitiesPage.getSearchField().sendKeys(adminCitiesPage.getEditedCityName().getText());

        String expectedResultEditedCity = adminCitiesPage.getEditedCityName().getText();
        Assert.assertEquals(adminCitiesPage.getEditedCityName().getText(), expectedResultEditedCity);


    }

    @Test
    //#5: Delete city
    public void deleteCity() {

        /*loginPage.clickOnloginPage();
        loginPage.login("admin@admin.com", "12345");

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        adminCitiesPage.getSearchField().sendKeys(adminCitiesPage.getEditedCityName().getText());

        String actualResult = adminCitiesPage.getSearchField().getText();

*/
    }


}





