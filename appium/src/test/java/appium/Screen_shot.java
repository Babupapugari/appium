package appium;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Screen_shot {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","GT-I9300I");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");		
		
		capabilities.setCapability("appPackage","com.android.contacts");
		capabilities.setCapability("appActivity","com.android.contacts.activities.DialtactsActivity");
		
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("//*[@index='3'][@class='android.app.ActionBar$Tab']").click();
		Thread.sleep(3000);
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		System.out.println(screenshotAs);
		
		FileUtils.copyFile(screenshotAs, new File("D:\\Testing\\May_batch17.png"));
	}

}
