package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooFinancePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By marketsMenu = By.xpath("//span[text()='Markets']");
    private By topMutualFunds = By.xpath("//div[text()='Top Mutual Funds']");

    public YahooFinancePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void hoverOnMarkets() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(marketsMenu));
        new Actions(driver).moveToElement(menu).perform();
    }

    public void clickTopMutualFunds() {
        wait.until(ExpectedConditions.elementToBeClickable(topMutualFunds)).click();
    }
}
