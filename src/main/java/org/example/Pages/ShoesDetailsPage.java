package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoesDetailsPage extends BasePage{
    public ShoesDetailsPage(WebDriver driver) {
        super(driver);
    }


    public void SelectColor(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Charcoal']"))).click();
    }
    public void SelectSize(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='swatch-label'][normalize-space()='8']"))).click();
    }

    public CheckOutPage ClickOnAddToCartBtn(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='productAddToCartForm.submit(this)']//span//span[contains(text(),'Add to Cart')]"))).click();
        return new CheckOutPage(driver);

    }



}
