package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage{

    private By localeButton = By.xpath
            ("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button");
    private By esButton = By.xpath("/html/body/div/div[2]/div/div[2]");

    private By h1 = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");

    public LocalePage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public WebElement getLocaleButton () {
        return  getWebDriver().findElement(localeButton);

    }
    public WebElement getEsButton () {
        return getWebDriver().findElement(esButton);
    }

    public WebElement getH1 () {
        return getWebDriver().findElement(h1);

    }
}
