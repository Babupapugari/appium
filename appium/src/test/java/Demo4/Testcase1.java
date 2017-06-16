 package Demo4;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Testcase1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch app
		
		//Device details
		//Class               reference variable= Object
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","Redmi");
									//Key        //value
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");
				
		//app details
		capabilities.setCapability("appPackage", "com.boondoggle.mortcalc");
		capabilities.setCapability("appActivity", "com.boondoggle.mortcalc.MortCalc");		
		
		//appium server
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		
		//*******************************************************
		
		String Expected_Result="222.44";
		System.out.println("Expected Result is "+Expected_Result);
		Thread.sleep(6000);
		//Enter amount, years and Interest
		driver.findElementById("com.boondoggle.mortcalc:id/var_amount").isDisplayed();
		System.out.println("Displayed");
		Thread.sleep(3000);
		driver.findElementById("com.boondoggle.mortcalc:id/var_amount").sendKeys("10000");
		driver.findElementById("com.boondoggle.mortcalc:id/var_years").sendKeys("5");
		driver.findElementById("com.boondoggle.mortcalc:id/var_interest").sendKeys("12");
		
		//click on calculate
		driver.findElementById("com.boondoggle.mortcalc:id/buttoncalc").click();
				
		//Get the output
		
		String Output = driver.findElementById("com.boondoggle.mortcalc:id/var_mortgage").getText();
		System.out.println("Output is  " +Output);
		
		String Actual_Result = Output.replace("$", "");
		System.out.println("Actual Result is "+Actual_Result);
		
		//Validation
		
		if(Actual_Result.equals(Expected_Result))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		//close the app
		driver.quit();
		
		
		
		

	}

}
