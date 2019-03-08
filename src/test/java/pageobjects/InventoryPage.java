package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
	
    public static WebDriver driver;

    

    
    public InventoryPage(WebDriver driver) {
    	InventoryPage.driver = driver;
    }
    
    public void addProductToCart(List <String> productnames) {
    	
    	for (String productname : productnames) {
        	JavascriptExecutor executor = (JavascriptExecutor)driver;

        	WebElement inventorylist = driver.findElement(By.className("inventory_container"));
        	inventorylist.findElement(By.linkText(productname)).click();
        	WebElement addtocart= driver.findElement(By.className("add-to-cart-button"));
        	executor.executeScript("arguments[0].click();", addtocart);
        	driver.get("https://www.saucedemo.com/inventory.html");
    		
    	}
    	
    	
    }
    
}
    

    
    
    
 
