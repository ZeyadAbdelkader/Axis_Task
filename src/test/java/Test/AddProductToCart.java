package Test;

import org.example.DataProviderObjects.UserRegistration;
import org.example.Pages.*;
import org.example.Reader.ExcelReader;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class AddProductToCart extends BaseTest{
    SoftAssert softAssert;
    org.example.Pages.HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ShoesPage shoesPage;
    ShoesDetailsPage shoesDetailsPage;

    CheckOutPage checkOutPage;


    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp(Method method, Object testData[], ITestContext ctx)
    {
        ctx.setAttribute(method.getName(), "Verify that User Can Add Product to Cart Successfully");
        softAssert = new SoftAssert();
    }
    @Test(alwaysRun = true, dataProvider = "UserRegistration",dataProviderClass = ExcelReader.class)
    public void AddingProductToCart(UserRegistration data) {
        homePage = new org.example.Pages.HomePage(driver);
        homePage.ClickOnAccountsBtn();
        loginPage=homePage.ClickOnLoginBtn();
        loginPage.EnterValidEmailAndPassword(data.getEmail(),data.getPassword());
        loginPage.ScrollDown();
        dashboardPage=loginPage.ClickOnLoginBtn();
        shoesPage=dashboardPage.HoverOnAccessoriesThenSelectShoesBtn();
        shoesPage.ScrollDown();
        shoesPage.SortingProductsFromLowToHighByPrice();
        shoesPage.ScrollDown();
        shoesDetailsPage=shoesPage.ClickOnViewDetailsBtn();
        shoesDetailsPage.SelectColor();
        shoesDetailsPage.SelectSize();
        checkOutPage=shoesDetailsPage.ClickOnAddToCartBtn();
        softAssert.assertEquals(data.getMessages(), checkOutPage.GetAddProductSuccessMessage());
        softAssert.assertAll();
    }
}
