package com.testng;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class YahooAutomationTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.yahoo.com/");
    }

    @Test(priority = 1)
    public void navigateToFinance() {
        WebElement financeLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Finance']"))
        );
        financeLink.click();
    }

    @Test(priority = 2)
    public void hoverOverMarketsAndClickMutualFunds() {
        WebElement menuElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Markets']"))
        );
        Actions actions = new Actions(driver);
        actions.moveToElement(menuElement).perform();

        WebElement mainMenu = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Top Mutual Funds']"))
        );
        mainMenu.click();
    }

    @Test(priority = 3)
    public void verifyTableData() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'bd')]")));

        // Count rows
        List<WebElement> rowElements = driver.findElements(By.xpath("//table[contains(@class,'bd')]/tbody/tr"));
        System.out.println("No of rows: " + rowElements.size());

        // Count columns
        List<WebElement> columnElements = driver.findElements(By.xpath("//table[contains(@class,'bd')]//thead/tr/th"));
        System.out.println("No of Columns: " + columnElements.size());

        // First cell data
        WebElement cell = driver.findElement(By.xpath("//table[contains(@class,'bd')]/tbody/tr[1]/td[1]"));
        System.out.println("The Text in Row 1, Column 1 is: " + cell.getText());

        // Full table data
        System.out.println("\n===== Full Table Data =====");
        for (int i = 0; i < rowElements.size(); i++) {
            List<WebElement> cells = rowElements.get(i).findElements(By.tagName("td"));
            System.out.print("Row " + (i + 1) + ": ");
            for (WebElement cellData : cells) {
                System.out.print(cellData.getText() + " | ");
            }
            System.out.println();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
