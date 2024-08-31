package task18_question2;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class drag_drop {
	
	public static void main(String args[]) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		try {
		
		driver.get("https://jqueryui.com/droppable/");
		
		driver.manage().window().maximize();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(iframe);
		
		Actions action = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		Thread.sleep(5000);
		
		WebElement target = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, target).perform();
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='droppable']")));
			 System.out.println("Successfully Dragged");
		}
		catch (Exception e) {
            // Handle success or other outcomes
            System.out.println("Failure");
        }
		
		System.out.println("thankyou");
		}
		catch(Exception e){
			
			e.printStackTrace();	
		}
		
		finally {
		driver.close();
		}
	}

}
