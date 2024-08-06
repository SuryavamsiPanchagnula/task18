package task18_question1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class facebook_signup {
	
	public static void main(String args[]) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//form//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	     WebElement register_form = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='reg']")));
		
	     WebElement firstname = register_form.findElement(By.xpath("//form//input[@name='firstname']"));
	     
	     firstname.sendKeys("Test");
	     
	     WebElement lastname = register_form.findElement(By.xpath("//form//input[@name='lastname']"));
	     
	     lastname.sendKeys("user");
	     
	     WebElement email = register_form.findElement(By.xpath("//form//input[@name='reg_email__']"));
	     
	     email.sendKeys("tst@gmail.com");
	     
	     WebElement re_enter_email = register_form.findElement(By.xpath("//form//input[@name='reg_email_confirmation__']"));
	     
	     re_enter_email.sendKeys("tst@gmail.com");
	     
	     WebElement password = register_form.findElement(By.xpath("//form//input[@name='reg_passwd__']"));
	     
	     password.sendKeys("Vamsi@2000");
	     
	     WebElement DOB = register_form.findElement(By.xpath("//form//span[@class='_5k_4']"));
	     
	     WebElement day = DOB.findElement(By.xpath("//form//span//select[@id='day']"));
	     
	     Select day_of_month = new Select(day);
	     
	     day_of_month.selectByValue("11");
	       
	     WebElement month = DOB.findElement(By.xpath("//form//span//select[@id='month']"));
	     
	     Select birth_month = new Select(month);
	     
	     birth_month.selectByValue("5");
	     
	     WebElement year = DOB.findElement(By.xpath("//form//span//select[@id='year']"));
	     
	     Select year_of_birth = new Select(year);
	     
	     year_of_birth.selectByValue("1985");
	     
	     WebElement Gender = register_form.findElement(By.xpath("//form//div//span[@class='_5k_3']"));
	     
	     WebElement confirm_gender= Gender.findElement(By.xpath("//form//div//span/input[@value='2']"));
	     
	     confirm_gender.click();
	     
	     Thread.sleep(5000);
	     
	     WebElement registration_submit = register_form.findElement(By.xpath("//form//div//button[@name='websubmit']"));
	     
	     registration_submit.click();
	     
	     WebElement error_message = driver.findElement(By.id("reg_error_inner"));
	     
	     if(error_message.isDisplayed()) {
	    	 
	    	 System.out.println("Registration Failed");
	     }
	     else {
	    	 System.out.println("Success");
	     }
	     
		System.out.println("thankyou");
		
		
	}
}
