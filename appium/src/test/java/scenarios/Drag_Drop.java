package scenarios;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Drag_Drop {

	public static void main(String[] args) throws MalformedURLException {
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
				capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
				capabilities.setCapability("appActivity", "com.mobeta.android.demodslv");		
				
				//appium server
				
				AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//				AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

}
