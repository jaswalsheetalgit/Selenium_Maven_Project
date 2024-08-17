package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_WebdriverManagercode {

	@Test
	 public void method() throws InterruptedException
	 {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
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
        driver.get("https://demoqa.com/buttons");
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        WebElement doubleElement = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
        action.doubleClick(doubleElement).build().perform();
        boolean doubleclicktext = driver.findElement(By.xpath("//*[text()='You have done a double click']")).isDisplayed();
        System.out.println("Double click "+doubleclicktext);
        WebElement RightClick = driver.findElement(By.xpath("//*[@id='rightClickBtn']"));
        action.contextClick(RightClick).build().perform();
        boolean rightClick = driver.findElement(By.xpath("//*[contains(text(),'You have done a right click')]")).isEnabled();
        System.out.println("Right click "+rightClick);
        WebElement click = driver.findElement(By.xpath("//*[text()='Click Me']"));
        action.click(click).build().perform();
        boolean clickValidation = driver.findElement(By.xpath("//*[contains(text(),'You have done a dynamic click')]")).isDisplayed();
        System.out.println("click button "+clickValidation);
        driver.quit();

	}

}
