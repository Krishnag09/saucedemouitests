package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	
    public static WebDriver driver;
    

    public CartPage(WebDriver driver) {
    	CartPage.driver = driver;
    }
    
    public Boolean checkForAddedProducts(String productname) {
    	
    	Boolean productadded;
    	
    	WebElement cartcontainer = driver.findElement(By.className("cart_contents_container"));
    	productadded = cartcontainer.
    			                  findElement(By.xpath("//div[contains(text(),productname) and (@class = 'cart_item')] ")).isDisplayed();
    	
//    	String productnamereturned = addedproduct.findElement(By.className("inventory_item_name")).getText();
    	return productadded;
    	
  	
    }
    	
    	   

}
