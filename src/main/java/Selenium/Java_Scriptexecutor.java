package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Java_Scriptexecutor {

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
        driver.get("https://demoqa.com/buttons");
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement doubleElement = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
        action.doubleClick(doubleElement).build().perform();
        WebElement doubleclicktex = driver.findElement(By.xpath("//*[text()='You have done a double click']"));
        boolean doubleclicktext = driver.findElement(By.xpath("//*[text()='You have done a double click']")).isDisplayed();
        System.out.println("Double click "+doubleclicktext);
        js.executeScript("arguments[0].style.background='yellow'", doubleclicktex);
        WebElement RightClick = driver.findElement(By.xpath("//*[@id='rightClickBtn']"));
        action.contextClick(RightClick).build().perform();
        boolean rightClick = driver.findElement(By.xpath("//*[contains(text(),'You have done a right click')]")).isEnabled();
        System.out.println("Right click "+rightClick);
        WebElement click = driver.findElement(By.xpath("//*[text()='Click Me']"));
        action.click(click).build().perform();
        boolean clickValidation = driver.findElement(By.xpath("//*[contains(text(),'You have done a dynamic click')]")).isDisplayed();
        System.out.println("click button "+clickValidation);
        WebElement textbox = driver.findElement(By.xpath("(//*[@id='item-0'])[1]"));
        action.click(textbox).build().perform();
        WebElement fullnameLabel = driver.findElement(By.xpath("//div[@id='userName-wrapper']/div/label[contains(text(),'Full Name')]"));
        WebElement fullnameTxt = driver.findElement(By.xpath("(//div[@id='userName-wrapper']/div/label[contains(text(),'Full Name')]//following::div/input)[1]"));
        WebElement EmailTxtLabel = driver.findElement(By.xpath("//div[@id='userEmail-wrapper']/div/label[contains(text(),'Email')]"));
        WebElement EmailTxt = driver.findElement(By.xpath("(//div[@id='userName-wrapper']/div/label[contains(text(),'Full Name')]//following::div/input)[2]"));
        WebElement currentaddress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        WebElement permanentaddress = driver.findElement(By.xpath("//*[@id='permanentAddress']"));
        WebElement SubmitBtn = driver.findElement(By.xpath("//*[@id='submit']"));
        js.executeScript("arguments[0].style.background='red'", fullnameLabel);
        js.executeScript("arguments[0].value='sheetal Jaswal';", fullnameTxt);
        js.executeScript("arguments[0].style.background='pink'", EmailTxtLabel);
        EmailTxt.sendKeys("jaswal@gmsil.com");
        js.executeScript("arguments[0].value='Himachal Pradesh';", currentaddress);
        js.executeScript("arguments[0].style.background='red'", currentaddress);
        js.executeScript("arguments[0].value='Punjab';", permanentaddress);
        js.executeScript("arguments[0].click();", SubmitBtn);
        Thread.sleep(5000);
        driver.close();
        
        
        
        
        
        
       

	}

}
