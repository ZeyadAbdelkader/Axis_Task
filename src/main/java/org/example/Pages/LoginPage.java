package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void EnterValidEmailAndPassword(String Ma, String Pa) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(Ma);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass"))).sendKeys(Pa);
    }
    public void ScrollDown(){
        By ScrollBar = By.xpath("(//html)[1]");
        WebElement ScrollElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ScrollBar));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy(0, 600)", ScrollElement);

    }

    public DashboardPage ClickOnLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='send2']"))).click();

        return new DashboardPage(driver);
    }

    public String EmailErrorMessage(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("advice-validate-email-email")));
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("advice-validate-email-email"))).getText();


    }
    public String PasswordErrorMessage(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Invalid login or password.']")));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Invalid login or password.']"))).getText();


    }

}
