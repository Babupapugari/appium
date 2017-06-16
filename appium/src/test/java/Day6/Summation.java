package Day6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

public class Summation {
	
	@DataProvider(name="dp_Sum")
	public static Iterator<Object[]> gettestdata() throws IOException
	{
		
		return Common_method_for_testdata("Sheet1");
		
	}
	
	
	
	public static Iterator<Object[]> Common_method_for_testdata(String sheetname) throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("D:\\PYTHON\\3-Jun-2017");
		HSSFSheet Sheet = xl.Setsheet(sheetname);
		
		int Rowcount = xl.getrowcount(Sheet);
		int Colcount = xl.getcolcount(Sheet, 0);
		//Declare List
		List<Object[]> arr_list= new ArrayList<Object[]>();
		
		for(int i=1;i<=Rowcount;i++)
		{
			//Create object array
			Object[] x= new Object[1];
			//Declare map
			Map<String,String> dMap= new HashMap<String,String>();
			
			for(int j=0;j<Colcount;j++)
			{
				
				String Skey = xl.Readvalue(Sheet, 0, j);
				String Value = xl.Readvalue(Sheet, i, j);
				
				dMap.put(Skey, Value);				
				
				
			}//end of col for loop
			
			x[0]=dMap;
			arr_list.add(x);
			
			
		}//end of row loop
		
		
		return arr_list.iterator();
		
		
	}
	
	

}
