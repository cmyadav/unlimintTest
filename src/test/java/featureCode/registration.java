package featureCode;


import Utility.utils;
import org.junit.Assert;

public class registration extends utils {


    public static void registerUser() {
        clickOnElement("//a[text()='Create an Account']");
        enterValue("//input[@name='firstname']",getDetails("results[0].name.first"));
        enterValue("//input[@name='lastname']",getDetails("results[0].name.last"));
        enterValue("//input[@name='email']",getDetails("results[0].email"));
        enterValue("//input[@name='password']","AKKIyadav@277");
        enterValue("//input[@name='password_confirmation']","AKKIyadav@277");
        clickOnElement("//button[@title='Create an Account']");
    }

    public static void verifyTheAccountCreation(){
        Assert.assertTrue(isElemetVisible("//div[text()='Thank you for registering with Fake Online Clothing Store.']"));
    }

    public static void buyProduct() throws InterruptedException {
        clickOnElement("//span[contains(text(),'What')]");
        clickOnElement("//div[@class='product-item-info']");
        clickOnElement("//div[@aria-label='XS']");
        clickOnElement("//div[@aria-label='Gray']");
        clickOnElement("//button[@title='Add to Cart']");
        clickOnElement("//a[text()='shopping cart']");
        clickOnElement("//span[text()='Proceed to Checkout']");
        enterValue("//input[@name='street[0]']","Mohan Garden");
        enterValue("//input[@name='city']","Delhi");
        selectDropdownValue("//select[@name='country_id']","IN");
        selectDropdownIndex("//span[text()='State/Province']//parent::label//following-sibling::div/select",5);
        enterValue("//input[@name='postcode']","123456");
        enterValue("//input[@name='telephone']","9999363798");
        Thread.sleep(3000);
        clickOnElement("//input[@type='radio']");
        clickOnElement("//button/span[text()='Next']");
        Thread.sleep(3000);
        clickOnElement("//span[text()='Place Order']");
    }
    public static void validatePurchase(){
        Assert.assertTrue(isElemetVisible("//span[text()='Thank you for your purchase!']"));
    }
}
