package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Drag_DragRemove {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","5.1.1");		
		
		capabilities.setCapability("appPackage","com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity","com.mobeta.android.demodslv.Launcher");
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(3000);
		
		driver.findElementByXPath("//*[@index='0'][@text='Warp'][@class='android.widget.TextView']").click();
		
		
		

	}

}
