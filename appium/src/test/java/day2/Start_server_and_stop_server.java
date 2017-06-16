package day2;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class Start_server_and_stop_server {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//		String Start_Server="D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		
		String Start_Server = "C:\\Program Files\\Appium\\node.exe C:\\Program Files\\Appium\\node_modules\\appium\\bin\\appium.js";
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
		
		capabilities.setCapability("appPackage","com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity","com.mobeta.android.demodslv.Launcher");
		
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("//*[@index='0'][@text='CursorAdapter'][@class='android.widget.TextView']").click();
		Thread.sleep(2000);
		
		//*********************************
		
		//stop server
		if(process!=null)
		{
			process.destroy();
			Thread.sleep(4000);
			System.out.println("Stopped the Appium Server");
			
		}

	}

}
