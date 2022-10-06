package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {


    @Test(priority = 1)
    //#1: Set locale to ES
    public void setLocaleToEs() {

        String expectedResultEs = "Página de aterrizaje";

        localePage.getLocaleButton().click();
        localePage.getEsButton().click();

        String actualResultEs = localePage.getH1().getText();
        Assert.assertEquals(expectedResultEs, actualResultEs);
    }

    @Test(priority = 2)
    //#2: Set locale to EN
    public void setLocaleToEN() {

        String expectedResultEn = "Landing";

        localePage.getLocaleButton().click();
        localePage.getEnButton().click();

        String actualResultEn = localePage.getH1().getText();
        Assert.assertEquals(expectedResultEn, actualResultEn);

    }

    @Test(priority = 3)
    //#3: Set locale to FR
    public void setLocaleToFR() {

        String expectedResultFr = "Page d'atterrissage";

        localePage.getLocaleButton().click();
        localePage.getFrButton().click();

        String actualResulFr = localePage.getH1().getText();
        Assert.assertEquals(expectedResultFr, actualResulFr);

    }


}
