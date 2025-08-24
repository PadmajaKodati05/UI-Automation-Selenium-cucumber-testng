package com.qa.automation;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooAutomation {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		// Click on 'Finance'
		WebElement financeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Finance']")));
		financeLink.click();
		// Hover over 'Markets'
		WebElement menuElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Markets']")));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuElement).perform();
		// Click on 'Top Mutual Funds'
		WebElement mainMenu = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Top Mutual Funds']")));
		mainMenu.click();
		// Wait until the table is present
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'bd')]")));
		// Count number of rows in the table body
		List<WebElement> rowElements = driver.findElements(By.xpath("//table[contains(@class,'bd')]/tbody/tr"));
		System.out.println("No of rows: " + rowElements.size());
		// Count number of columns in the table header
		List<WebElement> columnElements = driver.findElements(By.xpath("//table[contains(@class,'bd')]//thead/tr/th"));
		System.out.println("No of Columns: " + columnElements.size());
		// Retrieve data from first row, first column
		WebElement cell = driver.findElement(By.xpath("//table[contains(@class,'bd')]/tbody/tr[1]/td[1]"));
		System.out.println("The Text in Row 1, Column 1 is: " + cell.getText());
		// Print the full table data
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
}