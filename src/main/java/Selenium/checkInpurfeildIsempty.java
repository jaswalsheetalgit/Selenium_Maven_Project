package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class checkInpurfeildIsempty {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setBinary("C:\\Users\\hp\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		option.setAcceptInsecureCerts(true);
		option.addArguments("--remote-allow-origins=*");
        option.addArguments("start-maximized"); 
        option.addArguments("--incognito");
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, option);
        capabilities.setBrowserName("chrome");
        option.merge(capabilities);
        WebDriver  driver = new ChromeDriver(option);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);
        WebElement inputElement = driver.findElement(By.xpath("//*[@id='name']"));
        inputElement.sendKeys("sheetal");
         
         String value = inputElement.getAttribute("value");
         if (value.isEmpty()) {
             System.out.println("The input field is empty.");
         } else {
             System.out.println("The input field is not empty." +value);
             Thread.sleep(9000);
             inputElement.clear();
             System.out.println("Clear the name" +value);
             
         }
  

	}

}
