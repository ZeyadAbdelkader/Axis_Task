package Test;

import org.example.DataProviderObjects.UserRegistration;
import org.example.Reader.ExcelReader;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class RegisterWithMissingField extends BaseTest{
    SoftAssert softAssert;
    Pages.HomePage homePage;
    Pages.RegistrationPage registrationPage;


    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, Object testData[], ITestContext ctx)
    {
        ctx.setAttribute(method.getName(), "Verify that User Can't Register With Missing Mandatory Field");
        softAssert = new SoftAssert();
    }
    @Test(alwaysRun = true, dataProvider = "UserRegistration",dataProviderClass = ExcelReader.class)
    public void RegisterWithMissingField(UserRegistration data) {
        homePage = new Pages.HomePage(driver);
        homePage.ClickOnAccountsBtn();
        registrationPage=homePage.ClickOnRegisterBtn();
        registrationPage.EnterCredentials(data.getFirstName(), data.getLastname(), data.getEmail(),data.getPassword(), data.getConfirmPassword());
        registrationPage.ClickOnRegisterBtn();
        softAssert.assertEquals(data.getMessages(), registrationPage.CheckEmptyStateMessage());
        softAssert.assertAll();
    }
}

