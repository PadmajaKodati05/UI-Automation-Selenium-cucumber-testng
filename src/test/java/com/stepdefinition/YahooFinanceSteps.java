package com.stepdefinition;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import io.cucumber.java.en.*;

public class YahooFinanceSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I launch the Yahoo homepage")
    public void i_launch_the_yahoo_homepage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.yahoo.com/");
    }

    @When("I click on Finance")
    public void i_click_on_finance() {
        WebElement financeLink = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Finance']"))
        );
        financeLink.click();
    }

    @When("I hover over Markets")
    public void i_hover_over_markets() {
        WebElement menuElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Markets']"))
        );
        Actions actions = new Actions(driver);
        actions.moveToElement(menuElement).perform();
    }

    @When("I click on Top Mutual Funds")
    public void i_click_on_top_mutual_funds() {
        WebElement mainMenu = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Top Mutual Funds']"))
        );
        mainMenu.click();
    }

    @Then("I should see the mutual funds table")
    public void i_should_see_the_mutual_funds_table() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'bd')]")));
    }

    @Then("I print the number of rows and columns")
    public void i_print_the_number_of_rows_and_columns() {
        List<WebElement> rowElements = driver.findElements(By.xpath("//table[contains(@class,'bd')]/tbody/tr"));
        System.out.println("No of rows: " + rowElements.size());

        List<WebElement> columnElements = driver.findElements(By.xpath("//table[contains(@class,'bd')]//thead/tr/th"));
        System.out.println("No of Columns: " + columnElements.size());
    }

    @Then("I print the first cell data")
    public void i_print_the_first_cell_data() {
        WebElement cell = driver.findElement(By.xpath("//table[contains(@class,'bd')]/tbody/tr[1]/td[1]"));
        System.out.println("The Text in Row 1, Column 1 is: " + cell.getText());
    }

    @Then("I print the full table data")
    public void i_print_the_full_table_data() {
        List<WebElement> rowElements = driver.findElements(By.xpath("//table[contains(@class,'bd')]/tbody/tr"));
        System.out.println("\n===== Full Table Data =====");

        for (int i = 0; i < rowElements.size(); i++) {
            List<WebElement> cells = rowElements.get(i).findElements(By.tagName("td"));
            System.out.print("Row " + (i + 1) + ": ");
            for (WebElement cellData : cells) {
                System.out.print(cellData.getText() + " | ");
            }
            System.out.println();
        }
        driver.quit();
    }
}
