package org.validation.resources;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	 
	public static WebDriver driver;
	public void LaunchUrl(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	 
	public void SendKey(WebElement WE,String value) {
		WE.sendKeys(value);
	}
	public void Click(WebElement cl) {
		cl.click();

	}
	public void WindowsHandle() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		for (String c : child) {
			if(!c.equals(parent)) {
				driver.switchTo().window(c);
			
		}}}
	public void ScreenShot() throws Exception {
		TakesScreenshot t = (TakesScreenshot)driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		File designation = new File("png");
		FileUtils.copyFile(source, designation);
		}
	
	public  void ImWaits() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	
	public void ExWaits() {
		WebDriverWait Wait = new WebDriverWait(driver, 10);
		}
	
    public void Action() {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
		a.contextClick().perform();
		a.moveToElement(null, 0, 0).perform();
		a.dragAndDrop(null, null).perform();
		}
    
}
	
	
	

