package eBay_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Template_eBay extends Base_Class_eBayApp {
	
	public String Search_item() throws InterruptedException{
	
	driver.findElementById("com.ebay.mobile:id/search_box").click();
	Thread.sleep(3000);
	
	driver.findElementById("com.ebay.mobile:id/search_src_text").sendKeys("Shoes" +"\n");
	//Thread.sleep(10000);
	
	WebDriverWait wait= new WebDriverWait(driver, 35);
	WebElement ele_txt = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ebay.mobile:id/textview_item_count")));
	System.out.println("Search txt is found  "+ele_txt.isDisplayed());
	
	String Output = ele_txt.getText();
	System.out.println("Output is "+Output);
	
	String Actual_Result = Output.replace(" results", "");
	return Actual_Result;
	
	}
	

}
