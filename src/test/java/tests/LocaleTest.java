package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {


    @Test
    //#1: Set locale to ES
    public void setLocaleToEs() {

        String expectedResultEs = "Página de aterrizaje";

        localePage.getLocaleButton().click();
        localePage.getEsButton().click();

        String actualResultEs = localePage.getH1().getText();
        Assert.assertEquals(expectedResultEs, actualResultEs);
    }

    @Test
    //#2: Set locale to EN
    public void setLocaleToEN() {

        String expectedResultEn = "Landing";

        localePage.getLocaleButton().click();
        localePage.getEnButton().click();

        String actualResultEn = localePage.getH1().getText();
        Assert.assertEquals(expectedResultEn, actualResultEn);

    }

    @Test
    //#3: Set locale to FR
    public void setLocaleToFR() {

        String expectedResultFr = "Page d'atterrissage";

        localePage.getLocaleButton().click();
        localePage.getFrButton().click();

        String actualResulFr = localePage.getH1().getText();
        Assert.assertEquals(expectedResultFr, actualResulFr);

    }


}
