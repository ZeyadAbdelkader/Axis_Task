package Pages;

import org.example.Pages.BasePage;
import org.example.Pages.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);

    }

    public void EnterCredentials(String Fn, String Ln, String Em, String Ps, String Cp ) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname"))).sendKeys(Fn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname"))).sendKeys(Ln);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_address"))).sendKeys(Em);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(Ps);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation"))).sendKeys(Cp);
    }
    public DashboardPage ClickOnRegisterBtn( ) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Register']"))).click();
        return new DashboardPage(driver);
    }
    public String CheckErrorMessage () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='advice-validate-password-password']")));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='advice-validate-password-password']"))).getText();
    }
    public String CheckEmptyStateMessage () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("advice-required-entry-email_address")));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("advice-required-entry-email_address"))).getText();
    }

}




