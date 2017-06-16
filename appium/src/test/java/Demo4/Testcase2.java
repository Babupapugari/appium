package Demo4;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Testcase2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//launch app
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","GT-I9300I");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");
		
		capabilities.setCapability("appPackage","com.ebay.mobile");
		capabilities.setCapability("appActivity","com.ebay.mobile.activities.eBay");
		
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//**********************************************
		Thread.sleep(4000);
		
		String Expected_Res="136,763";
		System.out.println("Expected Result is "+Expected_Res);
		
		
		//click on search
		
		driver.findElementById("com.ebay.mobile:id/search_box").click();	
		
		
		//enter the search item and click search
		driver.findElementById("com.ebay.mobile:id/search_src_text").sendKeys("shoes" +"\n");
		
		//wait
		Thread.sleep(12000);
		
		//get the output
		String Output = driver.findElementById("com.ebay.mobile:id/textview_item_count").getText();
		System.out.println("Output is "+Output);
		
		String Actual_Result = Output.replace(" Items", "");
		System.out.println("Actual Result is "+Actual_Result);
		
		
		//validate
		if(Actual_Result.equals(Expected_Res))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
		//close app
		driver.quit();
		

	}

}
