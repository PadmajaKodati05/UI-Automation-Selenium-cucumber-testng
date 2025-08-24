package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By financeLink = By.xpath("//a[text()='Finance']");

    public YahooHomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToYahooHomePage() {
        driver.get("https://www.yahoo.com/");
    }

    public void clickFinanceLink() {
        wait.until(ExpectedConditions.elementToBeClickable(financeLink)).click();
    }
}
