package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest{


    @Test (priority = 1)
    //#1: Set locale to ES
    public void setLocaleToEs () {

        String expectedResultEs = "Página de aterrizaje";

        localePage.getLocaleButton().click();
        localePage.getEsButton().click();

        String actualResultEs = localePage.getH1().getText();
        Assert.assertEquals(expectedResultEs, actualResultEs);

    }

}
