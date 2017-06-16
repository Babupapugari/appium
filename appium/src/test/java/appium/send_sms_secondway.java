package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class send_sms_secondway {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		//Launch App
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//Device Details
		capabilities.setCapability("devicename", "1ecabd187d62");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platform version", "5.1.1");
		
		//app details
		capabilities.setCapability("appPackage","com.android.mms");
		capabilities.setCapability("appActivity","com.android.mms.ui.MmsTabActivity");
		
		//Appium server details
		//AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(5000);
		
		String Exp_Result = "8050812844";
		System.out.println("Expected Result"+ Exp_Result);
		
		
		//click on Message compose Edit
		driver.findElementByName("Compose Button").click();
		
		Thread.sleep(3000);	
		//Enter the number, msg and click send
		driver.findElementById("com.android.mms:id/recipients_editor_to").sendKeys(Exp_Result);
		driver.findElementById("com.android.mms:id/edit_text_bottom").sendKeys("Testing");
		
		driver.findElementById("com.android.mms:id/send_button").click();
		//
		Thread.sleep(3000);
		//click on Back
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		Thread.sleep(3000);
		
		//Checking the Message in the inbox
		
		List<WebElement> ele_Msg_Cont = driver.findElementsById("com.android.mms:id/from");
		int Msg_size = ele_Msg_Cont.size();
		System.out.println(Msg_size);
		//for(datatype ref_var: array)
		int Flag =0; //mismatching
		
		for (WebElement element:ele_Msg_Cont)
		{
			System.out.println(element.getText());
			if (element.getText().equals(Exp_Result)) 
			{
				Flag =1;
				break;				
			}
			else
			{
				Flag =0;
			}
		
		}
		
		if (Flag==1)
		{
			System.out.println("Passed");
		}
		else if(Flag==0)
		{
			System.out.println("Failed");
			
		}
		
		
		

	}

}
