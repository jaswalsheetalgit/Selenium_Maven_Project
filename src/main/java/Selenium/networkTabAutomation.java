package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;

public class networkTabAutomation {

	@Test
	 public void method() throws InterruptedException
	 {
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
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            String responseUrl = responseReceived.getResponse().getUrl();
            if (responseUrl.contains("https://api-gateway.juno.lenskart.com/v2/products/wishlist?attributes=true")) {
                System.out.println("Url: " + responseUrl);
                System.out.println("Response headers: " + responseReceived.getResponse().getHeaders().toString());
                int status = responseReceived.getResponse().getStatus();
                String responce = responseReceived.getResponse().toString();
                System.out.println(status);
                System.out.println(responce);
                
                
            }
 
        });
 
       driver.get("https://www.lenskart.com/");
        
      


   
    

	}

}
