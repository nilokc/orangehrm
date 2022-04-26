package Day12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VolunteerSignUp {
	
	public static void main(String[] args) throws InterruptedException {

	System.setProperty("webdriver.chrome.driver", "/Users/nokcu/Desktop/DRIVERS_/chromedriver");
	WebDriver driver=new ChromeDriver();  //this command just launchs the application
	
	driver.get("https://goo.gl/RVdKM9");
	String title=driver.getTitle();
	System.out.println("Title of the page is :"+title);
	
	String url=driver.getCurrentUrl();
	System.out.println("URL is :"+url);
	
	driver.manage().window().maximize();
	
	//copy-> copy with xpath
			//First name
			driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-1\"]")).sendKeys("nil");;
			
			//Last name
			driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-2\"]")).sendKeys("okc");
			
			//phone numberr
			driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-3\"]")).sendKeys("1234");
			
			//country
			driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-4\"]")).sendKeys("qbdcx");
			
			//city
			driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-5\"]")).sendKeys("asdfg");
			
			//email
			driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-6\"]")).sendKeys("nokc@email.com");
			
			
			//Handling Dropdown
			//------------------------------
			
			//store this element to a web element variable 
			
			//1.option
			/*
			WebElement drp=driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-9\"]"));
			Select dropdown=new Select(drp);
			*/
			//Find how many elements on the dropdown
			
			
			//2.option
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-9\"]")));
			
			//Returns all the options present on the dropdown 
			System.out.println("Number of options presented on dropdown is " +dropdown.getOptions().size());
			
			//variable ii depolamak icin /multiple web element store edilecegi icin list& webelement kullaniliyorr:
			//Listi indirmek icin java util package i sec, import et
			List <WebElement> options=dropdown.getOptions(); 
			
			//optionslari tektek okuyacak yani list olarak degil 1-by-1 bu yuzden WebElement e diye tanimlaniyor 
			
			for(WebElement e:options) // options contains every option & it should be a webelement -morning afternoon evening
			{
				System.out.println(e.getText());
			}
			//dropdown.selectByVisibleText("Morning");//Dropdown menu icerisinden seciyor
			//indexle de secilebilir: dropdown.selectByIndex(3); index starts from 0
			dropdown.selectByValue("Radio-1");//3 unden birini kullanabilirsin 
			
			//Handling radio button
			WebElement radmale=driver.findElement(By.id("RESULT_RadioButton-7_0"));
			System.out.println(radmale.isDisplayed()); //Check displayed or not 
			System.out.println(radmale.isEnabled()); //Checks enabled or not
			System.out.println("Before selecting the radio button : "+radmale.isSelected()); //returns false because not selected defaultly
			
			//CLICK OLMUYOR BURAYA BAK
			radmale.click();
			System.out.println("After selecting the radio button : "+radmale.isSelected()); //it returns True
			driver.findElement(By.id("RESULT_CheckBox-8_0")).click();
			driver.findElement(By.id("RESULT_CheckBox-8_6")).click();
			
			
			driver.findElement(By.linkText("Software Testing Tutorials")).click();
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
			driver.navigate().back(); // go back to your previous page
			Thread.sleep(3000);
			
			driver.findElement(By.partialLinkText("Tools Training")).click();
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
			driver.navigate().back(); // go back to your previous page
			Thread.sleep(3000);
			
			driver.navigate().forward();//move forward to your page
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
			
			driver.navigate().refresh(); //refresh the page
			
			//driver.close();
			driver.quit();
}
	
}
