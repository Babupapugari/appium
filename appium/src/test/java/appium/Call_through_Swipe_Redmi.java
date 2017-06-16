package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Call_through_Swipe_Redmi {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");		
		
		capabilities.setCapability("appPackage","com.android.contacts");
		capabilities.setCapability("appActivity","com.android.contacts.activities.TwelveKeyDialer");		
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		 
		System.out.println("contacts app opened successfully");
		
		//Click on Contacts tab
		 
		driver.findElementByXPath("//*[@text='Contacts'][@class='android.widget.TextView']").click();
		
		System.out.println("clicked on contacts tab successfully");
	}

}
