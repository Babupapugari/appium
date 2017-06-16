package day2;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Driver_ebay {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String Start_Server="D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		Process process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!= null)
		{
			System.out.println("Started the Appium Server");
		}
		else
		{
			System.out.println("NOT started");
		}
		
		Thread.sleep(12000);
		
		//******************************************************

		
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","GT-I9300I");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");		
		
		capabilities.setCapability("appPackage","com.ebay.mobile");
		capabilities.setCapability("appActivity","com.ebay.mobile.activities.MainActivity");
		
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(10000);
		String Exp_Result="247,844";
		System.out.println("Expected Result is "+Exp_Result);
		
		driver.findElementById("com.ebay.mobile:id/search_box").click();
		Thread.sleep(3000);
		
		driver.findElementById("com.ebay.mobile:id/search_src_text").sendKeys("Shoes" +"\n");
		//Thread.sleep(10000);
		
		WebDriverWait wait= new WebDriverWait(driver, 35);
		WebElement ele_txt = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ebay.mobile:id/textview_item_count")));
		System.out.println("Search txt is found  "+ele_txt.isDisplayed());
		
		String Output = ele_txt.getText();
		System.out.println("Output is "+Output);
		
		String Actual_Result = Output.replace(" results", "");
		System.out.println("Actual Resulr is "+Actual_Result);
		
		if(Actual_Result.equals(Exp_Result))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		//stop server
				if(process!=null)
				{
					process.destroy();
					Thread.sleep(4000);
					System.out.println("Stopped the Appium Server");
					
				}
				
				
		
		
	}

}
