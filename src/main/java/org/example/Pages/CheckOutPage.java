package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends BasePage{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public String GetAddProductSuccessMessage(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/select[1]")));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/select[1]"))).getText();


    }
}
