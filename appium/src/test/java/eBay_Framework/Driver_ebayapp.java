package eBay_Framework;

import java.io.IOException;

public class Driver_ebayapp {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		Template_eBay c1 = new Template_eBay();
		c1.Start_Server();
		c1.Launch_app();
		
		String Exp_Result="247,844";
		System.out.println("Expected Result is "+Exp_Result);
		String Actual_Result = c1.Search_item();
		
		if(Actual_Result.equals(Exp_Result))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
		c1.StopServer();
		

	}

}
