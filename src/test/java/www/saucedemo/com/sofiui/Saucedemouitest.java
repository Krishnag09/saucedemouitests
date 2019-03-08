package www.saucedemo.com.sofiui;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.InventoryPage;
import pageobjects.CartPage;



public class Saucedemouitest 

{
	static WebDriver driver;
	LoginPage loginpage;
	CartPage cartpage;
	InventoryPage inventorypage;
	final String username = "standard_user";
	final String password = "secret_sauce" ;
	List <String> productnames= Arrays.asList("Sauce Labs Onesie", "Sauce Labs Bike Light"); //List for any products to be used for the test

// Some initializations before the test execution. T
    @BeforeTest
     public void setup(){
    	
   	    driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }
    
    @Test
    public void endToEndTest() {
    	
    	 loginpage= new LoginPage(driver);
    	 loginpage.setUserName(username);
    	 loginpage.setPassword(password);
    	 loginpage.clickLogin();
    	 assertEquals(loginpage.getLandingurl(),"https://www.saucedemo.com/inventory.html");
    	 inventorypage = new InventoryPage(driver);
    	 inventorypage.addProductToCart(productnames);
    	 driver.get("https://www.saucedemo.com/cart.html");
    	 cartpage = new CartPage(driver);
     	for (String productname : productnames) {
     		assertTrue(cartpage.checkForAddedProducts(productname)); 
     		
     	}

    	
    }

    


}
