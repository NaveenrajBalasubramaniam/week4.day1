package week4.day1.table;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindDublicateFromTable1 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		Set<String> securityName = new LinkedHashSet<String>();
		List<WebElement> column3 = driver.findElements(By.xpath(".//table[contains(@class, 'table table-bordered table-condensed table-striped')]/tbody/tr/td[3]"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "+ column3 .size());
		int row_num=1;
		for (WebElement tdElement : column3 )
		{
			System.out.println("row # " + row_num + ", col #3 text=" +tdElement.getText());
			securityName.add(tdElement.getText());
			row_num++;
		}
		System.out.println(securityName);
		driver.quit();

	}

}
