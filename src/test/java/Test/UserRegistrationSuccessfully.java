package Test;

import org.example.DataProviderObjects.UserRegistration;
import org.example.Pages.DashboardPage;
import org.example.Reader.ExcelReader;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;


public class UserRegistrationSuccessfully extends BaseTest {

    SoftAssert softAssert;
    org.example.Pages.HomePage homePage;
    org.example.Pages.RegistrationPage registrationPage;
    DashboardPage dashboardPage;


    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, Object testData[], ITestContext ctx)
             {
        ctx.setAttribute(method.getName(), "Verify that User Can Register Successfully");
        softAssert = new SoftAssert();
    }
    @Test(alwaysRun = true, dataProvider = "UserRegistration",dataProviderClass = ExcelReader.class)
    public void RegisterWithValidData(UserRegistration data) {
        homePage = new org.example.Pages.HomePage(driver);
        homePage.ClickOnAccountsBtn();
        registrationPage=homePage.ClickOnRegisterBtn();
        registrationPage.EnterCredentials(data.getFirstName(), data.getLastname(), data.getEmail(),data.getPassword(), data.getConfirmPassword());
        dashboardPage=registrationPage.ClickOnRegisterBtn();
        softAssert.assertEquals(data.getMessages(), dashboardPage.CheckSuccessScreen());
        softAssert.assertAll();
    }


}
