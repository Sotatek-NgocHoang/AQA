package com.AQA.pages;

import com.AQA.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class EbayPage extends BasePage {
    private WebDriver driver;

    List<Products> result = new ArrayList<>();

    public EbayPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public By inputSearch = By.xpath("//input[@id='gh-ac']");
    public By btnSearch = By.xpath("//input[@id='gh-btn']");
    public By verifyResultSearch = By.xpath("//span[contains(text(),'iphone 11')]");
    public By product1 = By.className("s-item__pl-on-bottom");
    public By nameElement = By.className("s-item__title");
    public By linkElement = By.className("s-item__link");
    public By priceElement = By.className("s-item__price");

    public List<Products> getProductEbay(WebDriver driver)
    {
        result = getProduct(driver, product1, nameElement,linkElement,priceElement);
        return result;
    }


}
