package Day6;

import java.util.Map;

import org.testng.annotations.Test;

public class driver_Summation {
	
	@Test(dataProvider="dp_Sum", dataProviderClass=Day6.Summation.class)
	public void testsummation(Map<String,String> calc)
	{
	
	String Num1=calc.get("Num1");
	double Number1= Double.parseDouble(Num1);
		
	String Num2=calc.get("Num2");
	double Number2= Double.parseDouble(Num2);
	
	String Exp_Result=calc.get("Exp_Result");
	double Expected_Result= Double.parseDouble(Exp_Result);
			
	double Actual_Result=Number1+Number2;
	
	if(Actual_Result==Expected_Result)
	{
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail");
	}
		
		
		
	}

}
