package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Call_through_Swipe {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","GT-I9300I");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");		
		
		capabilities.setCapability("appPackage","com.android.contacts");
		capabilities.setCapability("appActivity","com.android.contacts.activities.TwelveKeyDialer");		
		
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@index='0'][@class='Contacts']").click();
		Thread.sleep(3000);
		Dimension contact_size = driver.manage().window().getSize();
		System.out.println(contact_size);
		// Vertical Swipe
		
		int starty =(int)(contact_size.height*0.9);
		int Endy =(int)(contact_size.height*0.5);
		
		int startx=(int)(contact_size.width*0.50);
		
		WebElement ele_Cont = driver.findElementByClassName("android.widget.TextView");		
		do
		{
			List<WebElement> find_cont = driver.findElementsByXPath("//*[@text='MyLove'][@class='android.widget.TextView']");
			int size_Contact = find_cont.size();
			System.out.println(size_Contact);
			Thread.sleep(3000);
			if (size_Contact>0)
			{
				//horizontal swipe
				System.out.println("Swipe horizontaly");
				int Startx1 = (int)(contact_size.width*.10);
				int Endx1 = (int)(contact_size.width*.90);
				WebElement ele_swipe = driver.findElementByXPath("//*[@text='MyLove'][@class='android.widget.TextView']");
				int starty1 = ele_swipe.getLocation().getY();
				//horizontal swipe
				driver.swipe(Startx1, starty1, Endx1, starty1, 1000);
				Thread.sleep(2000);				
				break;				
			}
			
			//vertcal swipe
			driver.swipe(startx, starty, startx, Endy, 1000);
			Thread.sleep(2000);
			
		} while(ele_Cont.isDisplayed()==true);
		
		Thread.sleep(5000);

		String Actual_Result = driver.findElementByXPath("//*[@text='Dialling'][@class='android.widget.TextView']").getText();
		System.out.println("Actual output"+Actual_Result);
		if (Actual_Result.equals("Dialling"))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
	}

}
