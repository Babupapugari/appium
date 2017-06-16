package day2;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Flipkart_counter {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","GT-I9300I");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");		
		
		capabilities.setCapability("appPackage","com.flipkart.android");
		capabilities.setCapability("appActivity","com.flipkart.android.activity.HomeFragmentHolderActivity");
		
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(3000);
		
		//Explicit wait
		
		WebDriverWait wait= new WebDriverWait(driver, 35);
		WebElement ele_txtbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/search_widget_textbox")));
		System.out.println("Search txtbox is found  "+ele_txtbox.isDisplayed());
		
		ele_txtbox.click();
		Thread.sleep(3000);
		
		driver.findElementById("com.flipkart.android:id/search_autoCompleteTextView").sendKeys("Reebok Shoes" +"\n");
		Thread.sleep(8000);
		
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		
		int Starty=(int)(size.height*0.90);
		int Endy=(int)(size.height*0.10);
		
		int Startx=(int)(size.width*0.50);
		
		
		WebElement ele_item = driver.findElementByClassName("android.widget.TextView");
		Thread.sleep(3000);
		int count=0;
		
		do
		{
			
			List<WebElement> ele_item2 = driver.findElementsByXPath("//*[@index='2'][@text='Reebok SPEED XT Running Shoes'][@class='android.widget.TextView']");
			int size2 = ele_item2.size();
			System.out.println(size2);
			
			if(size2>0)
			{
				count++;
				System.out.println("Count is "+count);
				
				if(count==2)
				{
				driver.findElementByXPath("//*[@index='2'][@text='Reebok SPEED XT Running Shoes'][@class='android.widget.TextView']").click();
				break;
				}
			}
			
			
			driver.swipe(Startx, Starty, Startx, Endy, 1000);
			Thread.sleep(2000);
			
		} while(ele_item.isDisplayed()==true);
		
		//Thread.sleep(4000);
		
		WebDriverWait wait2= new WebDriverWait(driver, 35);
		WebElement ele_Buy = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/product_buynow_1")));
		System.out.println("Buy now button is found "+ele_Buy.isDisplayed());
		
		ele_Buy.click();
		Thread.sleep(7000);
		
		driver.findElementByXPath("//*[@index='0'][@text='6'][@class='android.widget.TextView']").click();
		Thread.sleep(3000);
		
		driver.findElementById("com.flipkart.android:id/continue_variant").click();
		
		WebDriverWait wait3= new WebDriverWait(driver, 35);
		WebElement ele_delivery = wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/title_action_bar")));
		System.out.println("Delivery text is found "+ele_delivery.isDisplayed());
		
		
		String Actual_Result = ele_delivery.getText();
		System.out.println("Actual Result is "+Actual_Result);

	}

}
