package com.AQA.pages;

import com.AQA.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class AmazonPage extends BasePage {
    private WebDriver driver;

    List<Products> result = new ArrayList<>();

    public AmazonPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public By inputSearch = By.xpath("//input[@id='twotabsearchtextbox']");
    public By btnSearch = By.xpath("//input[@id='nav-search-submit-button']");
    public By verifyResultSearch = By.xpath("//span[contains(text(),'iphone 11')]");
    public By product1 = By.className("s-asin");
    public By nameElement = By.className("a-size-medium");
    public By linkElement = By.className("a-text-normal");
    public By priceElement = By.className("a-price-whole");

    public List<Products> getProductAmazon(WebDriver driver)
    {
        result = getProduct(driver, product1, nameElement, linkElement, priceElement);
        return result;
    }

}
