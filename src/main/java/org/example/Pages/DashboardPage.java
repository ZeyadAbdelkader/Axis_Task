package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String CheckSuccessScreen () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Thank you for registering with Tealium Ecommerce.']")));
       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Thank you for registering with Tealium Ecommerce.']"))).getText();
    }

    public String CheckLoggedInMessage () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='My Dashboard']")));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='My Dashboard']"))).getText();
    }

    public ShoesPage HoverOnAccessoriesThenSelectShoesBtn(){
        WebElement Accessories = driver.findElement(By.xpath("//a[@class='level0 has-children'][normalize-space()='Accessories']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Accessories).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Shoes']"))).click();
        return new ShoesPage(driver);


    }



}
