package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    //#1: Forbids visits to home url if not authenticated
    // home page redirect to login page when user is not logged
    public void forbidsHome() {

        driver.get(home);
        String expectedResulRoute = "/login";
        String actualResulRoute = driver.getCurrentUrl();

        Assert.assertTrue(actualResulRoute.contains(expectedResulRoute));
    }

    @Test
    //#2: Forbids visits to profile url if not authenticated
    // profile page redirect to login page when user is not logged
    public void forbidsProfile() {

        driver.get(profile);
        String expectedResulRoute = "/login";
        String actualResulRoute = driver.getCurrentUrl();

        Assert.assertTrue(actualResulRoute.contains(expectedResulRoute));

    }

    @Test
    //#3: Forbids visits to admin cities url if not authenticated
    // /admin/cities page redirect to login page when user is not logged
    public void forbidsAdminCities() {

        driver.get(adminCities);
        String expectedResulRoute = "/login";
        String actualResulRoute = driver.getCurrentUrl();

        Assert.assertTrue(actualResulRoute.contains(expectedResulRoute));
    }

    @Test
    //Test #4: Forbids visits to admin users url if not authenticated
    // /admin/users page redirect to login page when user is not logged
    public void forbidsAdminUsers() {

        driver.get(adminUsers);
        String expectedResulRoute = "/login";
        String actualResulRoute = driver.getCurrentUrl();

        Assert.assertTrue(actualResulRoute.contains(expectedResulRoute));
    }


}
