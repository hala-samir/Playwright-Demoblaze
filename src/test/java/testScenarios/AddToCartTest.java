package testScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class AddToCartTest extends TestBase{
    HomePage homePage ;
    ProductsPage productsPage;
    CartPage cartPage;

    @Test
    public void userVisitsProductDetailsPage(){
        homePage = new HomePage(page);
        productsPage = new ProductsPage(page);
        String productName = homePage.getProductNameFromHomePage();
        homePage.clickFirstProductLink();
        Assert.assertTrue(productsPage.getProductName().equalsIgnoreCase(productName));
    }

    @Test
    public void userAddsProductInToCartList(){
        homePage= new HomePage(page);
        productsPage=new ProductsPage(page);
        cartPage=new CartPage(page);
        String productName = homePage.getProductNameFromHomePage();
        homePage.clickFirstProductLink();
        productsPage.clickAddToCartButton();
        homePage.clickCartPageLink();
        Assert.assertTrue(productName.equalsIgnoreCase(cartPage.getProductName()));
    }

    @Test
    public void userDeletesItemFromCart(){
        homePage= new HomePage(page);
        productsPage=new ProductsPage(page);
        cartPage=new CartPage(page);
        homePage.clickFirstProductLink();
        productsPage.clickAddToCartButton();
        homePage.clickCartPageLink();
        cartPage.deleteProductFromCart();
        Assert.assertTrue(page.locator("tr").count()<=2);
    }

}
