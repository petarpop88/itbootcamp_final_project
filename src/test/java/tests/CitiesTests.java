package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CitiesTests extends BaseTest {


    @Test(priority = 1)
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


    @Test(priority = 2)
    //#2: Create new city
    public void createNewCity() throws InterruptedException {

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


    @Test(priority = 3)
    //#3: Edit city
    public void editCity() throws InterruptedException {

        String expectedResultSucces2 = "Saved successfully";
        loginPage.clickOnloginPage();
        loginPage.login("admin@admin.com", "12345");

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();

        adminCitiesPage.getActionEdit().click();
        Thread.sleep(5000);

        adminCitiesPage.getEditField().sendKeys(" - edited");
        Thread.sleep(2000);
        adminCitiesPage.getSaveButtonEditItem().click();

        Thread.sleep(2000);
        Assert.assertTrue(adminCitiesPage.getSavedSuccesEditedItem().getText().contains(expectedResultSucces2));


    }

    @Test(priority = 4)
    //#4: Search city
    public void searchCity() throws InterruptedException {

        loginPage.clickOnloginPage();
        loginPage.login("admin@admin.com", "12345");

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();

        Thread.sleep(4000);
        adminCitiesPage.getSearchField().sendKeys(adminCitiesPage.getEditedCityName().getText());

        String expectedResultEditedCity = adminCitiesPage.getEditedCityName().getText();
        Assert.assertEquals(adminCitiesPage.getEditedCityName().getText(), expectedResultEditedCity);


    }


}





