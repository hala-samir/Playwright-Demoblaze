package pages;

import com.microsoft.playwright.Page;

public class ProductsPage extends PageObjectManager {
    public ProductsPage(Page page) {
        super(page);
    }
    private String productNameLocator = ".name";
    private String addToCartButton = "a.btn.btn-success.btn-lg";

    //return product name via locator
    public String getProductName(){
        return getTextValue(productNameLocator).trim();
    }

    //go to the cart page
    public void clickAddToCartButton(){
       clickButtonByJavaScript(addToCartButton);
    }

}
