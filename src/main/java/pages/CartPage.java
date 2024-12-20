package pages;

import com.microsoft.playwright.Page;

public class CartPage extends PageObjectManager{
    public CartPage(Page page) {
        super(page);
    }
    private String productName = "tbody tr:nth-child(1) td:nth-child(2)";
    private String deleteProductBtn = "//a[normalize-space()='Delete']";

    public String getProductName() {
        return getTextValue(productName);
    }

    public void deleteProductFromCart(){
        clickButton(deleteProductBtn);
    }

}
