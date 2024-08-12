package odr;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ODRtask {

	public static void main(String[] args) {
		
		
		//open the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("dev.smartodr.in");
		
		driver.manage().window().maximize();
		
		System.out.println("Title is:" + driver.getTitle());
			
		//navigate to the login page.
		WebElement loginHereLink = driver.findElement(By.xpath("//a[text()='Login here']"));
		loginHereLink.click();
       
		//enter email id, password and click on login button.
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
        emailField.sendKeys("kalpeshpatil028@gmail.com"); 
        
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("Kalpesh@1");
        
        WebElement submitButton = driver.findElement(By.xpath("//button[@aria-label='Login']"));
        submitButton.click();
        
        //verify the login success by checking the login successful message or by presence of logout button.
        boolean isLoginSuccessful;
        try {
            WebElement logoutButton = driver.findElement(By.id("logoutButton")); 
            isLoginSuccessful = logoutButton.isDisplayed();
        } 
        
        catch (Exception e) {
            isLoginSuccessful = false;
        }

        if (isLoginSuccessful) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
       //close the browser   
        driver.quit();
    } 
}

