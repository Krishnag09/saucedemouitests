package pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public static WebDriver driver;
    

	public LoginPage(WebDriver driver){

    	LoginPage.driver = driver;

    }

    //Set user name

    public void setUserName(String strUserName){
        WebElement loginbox = driver.findElement(By.className("login-box"));
        WebElement username = loginbox.findElement(By.className("login-input"));
        username.sendKeys(strUserName);

    }

    //Set password 

    public void setPassword(String strPassword){
        WebElement password = driver.findElement(By.id("password"));
    	password.sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){
        WebElement loginbutton = driver.findElement(By.className("login-button"));
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click();", loginbutton);

    }

    //Get the url of the landing Page after login attempt to verify successful login

    public String getLandingurl(){
    	
    	return driver.getCurrentUrl().toString();


    }

 
    public void login(String strUserName,String strPasword){


        this.setUserName(strUserName);
        this.setPassword(strPasword);

        this.clickLogin();        
    }

}