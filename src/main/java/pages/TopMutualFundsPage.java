package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMutualFundsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By tableRows = By.xpath("//table[contains(@class,'bd')]/tbody/tr");
    private By tableColumns = By.xpath("//table[contains(@class,'bd')]//thead/tr/th");
    private By firstCell = By.xpath("//table[contains(@class,'bd')]/tbody/tr[1]/td[1]");

    public TopMutualFundsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void waitForTableToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(tableRows));
    }

    public int getRowCount() {
        return driver.findElements(tableRows).size();
    }

    public int getColumnCount() {
        return driver.findElements(tableColumns).size();
    }

    public String getFirstCellText() {
        return driver.findElement(firstCell).getText();
    }

    public void printFullTable() {
        List<WebElement> rows = driver.findElements(tableRows);
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            System.out.print("Row " + (i + 1) + ": ");
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " | ");
            }
            System.out.println();
        }
    }
}
