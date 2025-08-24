package com.qa.test;
import base.BaseTest;
import pages.YahooHomePage;
import pages.YahooFinancePage;
import pages.TopMutualFundsPage;
public class Yahootest extends BaseTest {
    public static void main(String[] args) {
        Yahootest test = new Yahootest();
        test.setUp();
        YahooHomePage homePage = new YahooHomePage(test.driver, test.wait);
        YahooFinancePage financePage = new YahooFinancePage(test.driver, test.wait);
        TopMutualFundsPage mutualFundsPage = new TopMutualFundsPage(test.driver, test.wait);
        homePage.goToYahooHomePage();
        homePage.clickFinanceLink();
        financePage.hoverOnMarkets();
        financePage.clickTopMutualFunds();
        mutualFundsPage.waitForTableToLoad();
        System.out.println("No of rows: " + mutualFundsPage.getRowCount());
        System.out.println("No of Columns: " + mutualFundsPage.getColumnCount());
        System.out.println("The Text in Row 1, Column 1 is: " + mutualFundsPage.getFirstCellText());
        System.out.println("\n===== Full Table Data =====");
        mutualFundsPage.printFullTable();
        test.tearDown();
    }
}
