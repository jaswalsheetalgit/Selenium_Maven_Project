package Selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiuple_windowhandle {

	@Test
	 public void method() throws InterruptedException
	 {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().clearResolutionCache().setup();
		 WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		//option.setBinary("C:\\Users\\hp\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
		option.setAcceptInsecureCerts(true);
		option.addArguments("--remote-allow-origins=*");
        option.addArguments("start-maximized"); 
        option.addArguments("--incognito");
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, option);
        capabilities.setBrowserName("chrome");
        option.merge(capabilities);
       // WebDriverManager.chromedriver().setup();
        WebDriver  driver = new ChromeDriver(option);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("bc")));
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='openwindow' and contains(text(),'Open Window')]")));
        driver.findElement(By.xpath("//*[@id='openwindow' and contains(text(),'Open Window')]")).click();
        
        String parentWindow = driver.getWindowHandle();
        System.out.println("parent window "+parentWindow);
        
        Set<String> childwindow = driver.getWindowHandles();
        System.out.println("child window "+childwindow);
        
        Iterator<String> it = childwindow.iterator();
        while(it.hasNext())
        {
        	String childs = it.next();
        	System.out.println(childs);
        	 if(!parentWindow.equals(childs))
        	 {
        		 driver.switchTo().window(childs);
        		 driver.manage().window().maximize();
        	 }
        }
        driver.quit();

	}

}
