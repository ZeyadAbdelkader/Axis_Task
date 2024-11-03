package Test;

import org.example.DataProviderObjects.UserRegistration;
import org.example.Pages.DashboardPage;
import org.example.Pages.LoginPage;
import org.example.Reader.ExcelReader;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class LoginWithValidCredentials extends BaseTest{

    SoftAssert softAssert;
    Pages.HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;


    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, Object testData[], ITestContext ctx)
    {
        ctx.setAttribute(method.getName(), "Verify that User Can Login With Valid Credentials");
        softAssert = new SoftAssert();
    }
    @Test(alwaysRun = true, dataProvider = "UserRegistration",dataProviderClass = ExcelReader.class)
    public void LoginWithValidCredentials(UserRegistration data) {
        homePage = new Pages.HomePage(driver);
        homePage.ClickOnAccountsBtn();
       loginPage=homePage.ClickOnLoginBtn();
       loginPage.EnterValidEmailAndPassword(data.getEmail(),data.getPassword());
       loginPage.ScrollDown();
       dashboardPage=loginPage.ClickOnLoginBtn();
        softAssert.assertEquals(data.getMessages(), dashboardPage.CheckLoggedInMessage());

        softAssert.assertAll();
    }
}
