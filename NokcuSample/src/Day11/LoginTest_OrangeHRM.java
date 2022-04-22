/* Every class is a test case */

package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTest_OrangeHRM {

	public static void main(String[] args) {
		
		//open web chrome browser
		System.setProperty("webdriver.chrome.driver","/Users/nokcu/Desktop/DRIVERS_/chromedriver");
		//ChromeDriver driver=new ChromeDriver();  //Launch the chrome browser
		
		//open the web firefox browser
		System.setProperty("webdriver.gecko.driver","/Users/nokcu/Desktop/DRIVERS_/geckodriver");
		WebDriver driver=new FirefoxDriver(); 
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement usernametxt=driver.findElement(By.id("txtUsername")); //just identifies into the web element
		usernametxt.sendKeys("Admin");
		
		//yada su sekilde yazilabilir:
		// driver.findbyelement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		//clickonlogin
		driver.findElement(By.name("Submit")).click();
		
		String actual_title=driver.getTitle();
		String expected_title="OrangeHRM";
		
		//compare the strings
		if(actual_title.equals(expected_title))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		
		driver.close();
		driver.quit();
	}

}
