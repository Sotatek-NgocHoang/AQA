package com.AQA.testcase;

import com.AQA.common.BaseSetup;
import com.AQA.common.BasePage;
import com.AQA.common.SortProduct;
import com.AQA.pages.Products;
import com.AQA.pages.EbayPage;
import com.AQA.pages.AmazonPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchTest extends BaseSetup {
    BasePage basePage = new BasePage();
    private WebDriver driver;
    public String key = "iphone 11";
    public String titleEbay = "Electronics, Cars, Fashion, Collectibles & More | eBay";
    public String titleAmazon = "Amazon.com. Spend less. Smile more.";

    EbayPage ebayPage1 = new EbayPage(driver);
    AmazonPage amazon1 = new AmazonPage(driver);
    Products webs = new Products();

    List<Products> result = new ArrayList<>();
    List<Products> resultAll = new ArrayList<>();

    @BeforeClass
    public void setUp()
    {
        driver = getDriver();
    }

    @Test
    public void searchProduct()
    {
        basePage.openURL(driver, webs.ebayURL );
        basePage.getTitle(driver, titleEbay);
        basePage.keyWord(driver, ebayPage1.inputSearch, key);
        basePage.click(driver, ebayPage1.btnSearch);
        basePage.verifySearch(driver,ebayPage1.verifyResultSearch);
        result = ebayPage1.getProductEbay(driver);
        resultAll.addAll(result);

        basePage.openURL(driver,webs.amazonURL);
        basePage.getTitle(driver, titleAmazon);
        basePage.keyWord(driver, amazon1.inputSearch, key);
        basePage.click(driver, amazon1.btnSearch);
        basePage.verifySearch(driver, amazon1.verifyResultSearch);
        result = amazon1.getProductAmazon(driver);
        resultAll.addAll(result);

        Collections.sort(resultAll, new SortProduct());
        basePage.printProduct(driver,resultAll);

    }




}
