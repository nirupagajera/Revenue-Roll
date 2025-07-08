package Revenue;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MIS {
	
public WebDriver driver;
	
	@Test(priority=1)
	public void mis_window_open() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://teamwork.krishaweb.com/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=2)
	public void google_login() throws Exception
	{
		WebElement login_with_google, email_input, next_button, password_input, password_next_button,
		project_tab, project_name, task_tab, add_task_button, task_name, estimate, add_button,
		add_hour, hover_task, date_picker, year, year_list_main, month_list, day;
		
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		login_with_google = driver.findElement(By.linkText("Login with Google"));
		login_with_google.click();
		
		email_input = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
		email_input.sendKeys("nirupa@krishaweb.com");
		
		next_button = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
		next_button.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		password_input = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
		password_input.sendKeys("Nirupa@1234");
		
		password_next_button = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
		password_next_button.click();
		
		Thread.sleep(5000);
		
		project_tab = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[2]/a"));
		project_tab.click();
		
		project_name = driver.findElement(By.xpath("//a[starts-with(text(),'HR Activities')]"));		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", project_name);
		
		task_tab = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div[4]/div/div/div/div[2]/ul/li[3]/a"));
		task_tab.click();
		
		Thread.sleep(5000);

		
//		add_task_button = driver.findElement(By.xpath("//button[@id=\"1634\"]"));
//		js.executeScript("arguments[0].click();", add_task_button);
//		
//		//Add Task Form
//		
//		task_name = driver.findElement(By.xpath("//*[@id=\"name\"]"));
//		task_name.sendKeys("Test Automation");
	
//		estimate = driver.findElement(By.xpath("//*[@id=\"estimate\"]"));
//		estimate.sendKeys("2");
		
//		Thread.sleep(2000);
//		
//		add_button = driver.findElement(By.xpath("//button[@id=\"add-app\"]"));
//		js.executeScript("arguments[0].click();", add_button);
//		
//		System.out.println("Task is successfully added.");
//		
		
		//find task
				
		List <WebElement> find_task = driver.findElements(By.tagName("a"));
		for(WebElement find : find_task)
		{
			String text = find.getText().trim();
			System.out.println(text);
			if(text.equalsIgnoreCase("Test Automation"))
			{
				find.click();
				break;
			}
		}
		
		Thread.sleep(3000);
	
		hover_task = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div[4]/div/div/div[1]/div[2]/div[2]/div/div[1]/ul/li[3]/span/a"));
		Actions action = new Actions(driver);
		action.moveToElement(hover_task).perform();
		
		add_hour = driver.findElement(By.xpath("//*[@id=\"timer_button\"]"));
		add_hour.click();
		
		//Add hour form
		Thread.sleep(1000);
		date_picker = driver.findElement(By.xpath("//*[@id=\"log-date\"]"));
		date_picker.click();
		
		month_list = driver.findElement(By.xpath("//*[@id=\"loghome\"]/div[1]/div[2]/div/div/div/div/div[1]/div[2]"));
		String get_text = month_list.getText().trim();
		System.out.println(get_text);

		for(int i=0;i<=11;i++)
		{
			WebElement next = driver.findElement(By.xpath("//*[@id=\"loghome\"]/div[1]/div[2]/div/div/div/div/div[1]/div[3]/a"));
			next.click();
			
			Thread.sleep(1000);
			
			get_text = month_list.getText().trim();
			
			Thread.sleep(1000);

			if(get_text.contains("November"))
			{
				break;
			}
		}
		
		year = driver.findElement(By.xpath("//*[@id=\"loghome\"]/div[1]/div[2]/div/div/div/div/div[1]/div[2]/a/span"));
		year.click();
		
		WebElement yearListMain = driver.findElement(By.xpath("//*[@id=\"loghome\"]/div[1]/div[2]/div/div/div/div/div[2]/div[1]"));
		List<WebElement> yearList = yearListMain.findElements(By.tagName("a"));
		   
		int yearvalue= 1994;
		int min_value = Integer.parseInt(yearList.get(0).getText());
		int max_value = Integer.parseInt(yearList.get(yearList.size()-1).getText());
		while(true)
		{
			for(int i = 0;i<yearList.size();i++)
			{
				if(yearvalue < min_value)
				{
					WebElement previous = driver.findElement(By.xpath("//*[@id=\"loghome\"]/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[1]"));
					previous.click();
					
					System.out.println(min_value);
					
					min_value = Integer.parseInt(yearList.get(0).getText());
 
				}
				else if(yearvalue > max_value)
				{
					WebElement next = driver.findElement(By.xpath("//*[@id=\"loghome\"]/div[1]/div[2]/div/div/div/div/div[2]/div[2]/a[2]"));
					next.click();
										
					System.out.println(max_value);
					
					max_value = Integer.parseInt(yearList.get(yearList.size()-1).getText());
				}
				else
				{
					break;
				}
			}
			
			for(WebElement value : yearList)
			{
				if(value.getText().equalsIgnoreCase(Integer.toString(yearvalue)))
				{
					value.click();
					break;
				}
			}
			
			break;		
		}
		
		day = driver.findElement(By.xpath("//*[@id=\"loghome\"]/div[1]/div[2]/div/div/div/div/div[4]"));
		List<WebElement> day_list = day.findElements(By.tagName("a"));
		for(WebElement days: day_list)
		{
			String text = days.getAttribute("ng-repeat");
			String value_day = days.getText().trim();
			if(!text.contains("px in prevMonthDays") && !text.contains("nx in nextMonthDays"))
			{
				if(value_day.equalsIgnoreCase("7"))
				{
					days.click();
					break;
				}
				
			}
		}
		
		
	}
			
}
