package week4.day1.table;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintRowBasedOnHeader {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.findElement(By.id("navbtn_stockmarket")).click();
//		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
//		Set<String> securityName = new LinkedHashSet<String>();
		List<WebElement> tr_collection = driver.findElements(By.xpath(".//div[contains(@class, 'render')]/table/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
//		for (WebElement trElement : tr_collection) {
//			 List<WebElement> td_collection = trElement.findElements(By.tagName("td")); 
//			 if(!td_collection.get(0).getText().equals("Market Share")) {
//				 td_collection.r
//			 }
//		}
		  for (WebElement trElement : tr_collection)
			  
		  {
		    List<WebElement> td_collection = trElement.findElements(By.tagName("td")); 
		   int n = td_collection.size();
		   for(int i=0;i<td_collection.size();i++) {
			   if(td_collection.get(0).getText().equals("Market Share")) {
				   System.out.println(td_collection.get(i).getText());
			   
			   }
		    
		   }
		   
		   System.out.println("NUMBER OF COLUMNS="+td_collection.size());
//		   col_num=1;
//		   for (WebElement tdElement  :td_collection)
//		   {
//			   System.out.println("row # " +row_num+ ", col # " +col_num+ "text=" +tdElement.getText());
//			   //col_num++;
//		   }
//		   row_num++;
		  }
		  
		driver.quit();

	}

}
