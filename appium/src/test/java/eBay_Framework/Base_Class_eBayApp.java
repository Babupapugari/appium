package eBay_Framework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class Base_Class_eBayApp {

	public Process process;
	public AndroidDriver driver;
	public void Start_Server() throws IOException, InterruptedException {
		// TODO Auto-generated method stub		
		String Start_Server="D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!= null)
		{
			System.out.println("Started the Appium Server");
		}
		else
		{
			System.out.println("NOT started");
		}
		
		Thread.sleep(12000);
		
		}
	
	public void Launch_app() throws MalformedURLException, InterruptedException {
	
	DesiredCapabilities capabilities= new DesiredCapabilities();
	
	capabilities.setCapability("deviceName","GT-I9300I");
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("platformVersion","4.4.4");		
	
	capabilities.setCapability("appPackage","com.ebay.mobile");
	capabilities.setCapability("appActivity","com.ebay.mobile.activities.MainActivity");
	
	
	driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	Thread.sleep(10000);
	}
	
	public void StopServer() throws InterruptedException{
	//stop server
			if(process!=null)
			{
				process.destroy();
				Thread.sleep(4000);
				System.out.println("Stopped the Appium Server");
				
			}
	}	
	
	
	
	
	}

	
		
	

