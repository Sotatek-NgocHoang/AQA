package com.AQA.common;

import com.AQA.pages.Products;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    public void getTitle (WebDriver driver, String text)
    {
        String namePage = driver.getTitle();
        Assert.assertTrue(namePage.contains(text));
        System.out.println(namePage);
    }

    public  void keyWord(WebDriver driver, By inputSearch, String key)
    {
        WebElement seach = driver.findElement(inputSearch);
        seach.sendKeys(key);
    }

    public  void click(WebDriver driver, By btnSearch)
    {
        WebElement clickSearch = driver.findElement(btnSearch);
        clickSearch.click();
    }

    public int changeprice(String price) {
        int number;
        if (price == null) {
            return 0;
        }
        try {
            int d = Integer.parseInt(price);
            return d * 22681;
        } catch (NumberFormatException nfe) {

            String ary[] = price.split(" ");

            String strNew1 = ary[0].replace(".", "-");

            String ary1[] = strNew1.split("-");

            String strNew = ary1[0].replace(",", "");
            return Integer.parseInt(strNew);
        }
    }

    public void verifySearch(WebDriver driver, By verifySearch) {
        boolean verify = driver.findElement(verifySearch).isDisplayed();
        Assert.assertTrue(verify);
    }

    public List<Products> getProduct(WebDriver driver, By product1, By nameElement, By linkElement, By priceElement) {

        List<WebElement> product = driver.findElements(product1);

        ArrayList<Products> arrayList = new ArrayList<Products>();

        for (WebElement product2 : product) {
            List<WebElement> nameProduct = product2.findElements(nameElement);

            Products products = new Products();

            for (WebElement tg1 : nameProduct) {
                products.name = tg1.getText();
                break;
            }

            List<WebElement> linkProduct = product2.findElements(linkElement);

            for (WebElement tg1 : linkProduct) {
                products.link = tg1.getAttribute("href");
                break;
            }

            List<WebElement> priceProduct = product2.findElements(priceElement);

            for (WebElement tg1 : priceProduct) {
                products.price = changeprice(tg1.getText());
                break;
            }
            arrayList.add(products);
        }
        return arrayList;
    }

    public void printProduct(WebDriver driver, List<Products> products) {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).name);
            System.out.println(products.get(i).link);
            System.out.println(products.get(i).price);
            System.out.println("===============================");
        }
    }

    public void openURL(WebDriver driver,String URL)
    {
        driver.get(URL);
    }
}
