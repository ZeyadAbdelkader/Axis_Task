package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ShoesPage extends BasePage{
    public ShoesPage(WebDriver driver) {super(driver);}

    public void ScrollDown(){
        By ScrollBar = By.xpath("//html");
        WebElement ScrollElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ScrollBar));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy(0, 2500)", ScrollElement);

    }
    public void SortingProductsFromLowToHighByPrice(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/select[1]"))).click();
        Select select = new Select(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/select[1]")));
       select.selectByValue("https://ecommerce.tealiumdemo.com/accessories/shoes.html?dir=asc&order=price");
    }

    public ShoesDetailsPage ClickOnViewDetailsBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/ul[@class='products-grid products-grid--max-4-col first last odd']/li[1]/div[1]/div[2]/a[1]"))).click();
        return new ShoesDetailsPage(driver);


    }




}
