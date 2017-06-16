package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Drag_drop {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch app
		//class              ref_variable= Object
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		//device details
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");
		
		//app details
		capabilities.setCapability("appPackage","com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity","com.mobeta.android.demodslv.Launcher");
		
		//Appium server details
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(8000);
		
		//click on Basic usage element
		//driver.findElementById("com.mobeta.android.demodslv:id/activity_title").click();
		
		WebElement ele_Basic = driver.findElementById("com.mobeta.android.demodslv:id/activity_title");
		System.out.println(ele_Basic.isDisplayed());
		//System.out.println(ele_Basic);
		
//		ele_Basic.click();
//		driver.findElementById("com.mobeta.android.demodslv:id/activity_title").
		ele_Basic.click();
		System.out.println("clicked");
		ele_Basic.click();
		
		
		//count of the element
		Thread.sleep(10000);
		
		List<WebElement> ele_cont = driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle");
		
		
//		int size = ele_cont.size();
//		System.out.println(size);
		
		//longpress and move Brad
		
//		TouchAction action= new TouchAction(driver);
//		//move Brad
//		action.longPress(ele_cont.get(0)).moveTo(ele_cont.get(5)).release().perform();
//		
//		Thread.sleep(10000);
//		
//		//longpress and move Micheal
//		//move Micheal Brecker
//		
//		action.longPress(ele_cont.get(6)).moveTo(ele_cont.get(1)).release().perform();
//		
//		
		

	}

}
