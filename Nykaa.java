package week4.day1.table;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		act.moveToElement(driver.findElement(By.xpath("//*[@id='headerMenu']/div[1]/ul[2]/li/a"))).perform();
		//act.moveToElement(driver.findElement(By.id("brandSearchBox"))).sendKeys("L\'Oreal Paris").build().perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L\'Oreal Paris");
		act.moveToElement(driver.findElement(By.xpath("//*[@id='scroller-container']/div[2]/a"))).click().build().perform();
		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("//*[@id='filter-sort']/div/div/ul/div[4]/label/div[1]/span")).click();
		driver.findElement(By.xpath("//*[@id='first-filter']/div")).click();
		driver.findElement(By.xpath("//*[@id='custom-scroll']/ul/li[2]/div")).click();
		driver.findElement(By.xpath("//*[@id='custom-scroll']/ul/li/ul/li[1]/div")).click();
		driver.findElement(By.xpath("//*[@id='custom-scroll']/ul/li/ul/li/ul/li[1]/div/label")).click();
		driver.findElement(By.xpath("//*[@id='filters-strip']/div/div/div[6]/div")).click();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[@id='custom-scroll']/div/div[11]/label")).click();
		driver.findElement(By.xpath("//*[@id='filters-listing']/div[1]/div[2]/div[1]/span")).isDisplayed();
		driver.findElement(By.xpath("//*[@id='product-list-wrap']/div/div/div[1]/a/div[1]/img")).click();
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String winow : windows) {
			driver.switchTo().window(winow);
			System.out.println(driver.getTitle());
			if(driver.getTitle().contains("L'Oreal Paris Colour Protect Shampoo")) {
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div[2]/div/div[1]/div[4]/div[1]/div/select")).click();
				Select size = new Select(driver.findElement(By.xpath("//[@tite='SIZE']")));
				size.selectByVisibleText("175ml");
				String mrp = driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div[2]/div/div[1]/div[2]/div/span[2]")).getText();
				System.out.println("MRP: "+mrp);
				driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div[2]/div/div[1]/div[5]/div[1]/div/button/span")).click();
				driver.findElement(By.xpath("//*[@id='header_id']/div[2]/div/div[2]/div[2]/button/span")).click();
				String grandTotal = driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div[1]/div[4]/div[2]")).getText();
				System.out.println("Grand Total: "+grandTotal);
				driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div/div[2]/div/div/div[2]/div[2]/div/div[2]/button/span/span")).click();
				driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div/div/div/div[4]/button")).click();
				String grandTotalNew = driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[3]/div/div/div[2]/div[2]/div[2]/span")).getText();
				assertEquals(grandTotal, grandTotalNew);
			}
				
			}
		driver.close();
		
		
	}

}
