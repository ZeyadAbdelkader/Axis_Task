package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    public void ClickOnAccountsBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='label'][normalize-space()='Account']"))).click();

    }
    public org.example.Pages.RegistrationPage ClickOnRegisterBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Register']"))).click();
        return new org.example.Pages.RegistrationPage(driver);

    }

    public LoginPage ClickOnLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Log In']"))).click();

        return new LoginPage(driver);
    }



}
