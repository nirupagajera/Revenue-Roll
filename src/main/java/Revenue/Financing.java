package Revenue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Financing {

public WebDriver driver;
	
	
    @Test(priority = 1)
	public void setUp() 
    {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://3.209.68.239/revenue-roll/financing-credit-line.html");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	System.out.println("Page title is: " + driver.getTitle());
    	
	}
    
    @Test(priority = 2)
    public void financing() throws Exception
    {
    	WebElement apply_button, state_of_application, input_select, desire_credtit_limit, desired_pay_back,
    	next_button, legal_entity_name, legal_entity_address, TIN, website_url, venture_capital_backend,
    	fund_raised_to_date, greater_priority, business_detail_next, firstname_input, lastname_input,
    	date_of_birth, select_month, select_year, select_date, SSN, email, phone_number, applicant_detail_button,
    	agree_checkbox, agree_button, active_facilities, submit_application_button, slider;
    	
    	apply_button = driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/a"));
    	apply_button.click();
    	
    	input_select = driver.findElement(By.xpath("/html/body/main/div/div[3]/section[1]/div/div[2]/div[1]/div[1]/div/form/div[1]/span/span[1]/span/span[1]"));
    	input_select.click();
    	
    	state_of_application = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul"));
    	List <WebElement> list = state_of_application.findElements(By.tagName("li"));
    	for(WebElement list_tab:list)
    	{
    		String text = list_tab.getText().trim();
    		if(text.equalsIgnoreCase("Colorado"))
    		{
    			list_tab.click();
    			break;
    		}
    	}
    	
    	desire_credtit_limit = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[3]/div[1]/div/div[3]/div"));
    	desire_credtit_limit.click();
    	
    	Actions action = new Actions(driver);
    	action.dragAndDropBy(desire_credtit_limit, -140, 0).perform();
    	
    	desired_pay_back = driver.findElement(By.xpath("/html/body/main/div/div[3]/section[1]/div/div[2]/div[1]/div[1]/div/form/div[4]/ul"));
    	List<WebElement> day_list = desired_pay_back.findElements(By.tagName("li"));
    	for(WebElement list_tab : day_list)
    	{
    		String text = list_tab.getText().trim();
    		if(text.equalsIgnoreCase("30"))
    		{	
    			list_tab.click();
    			break;
    		}
    	}
    	
    	next_button = driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/form/div[5]/button[2]"));
    	next_button.click();
    	
    	legal_entity_name = driver.findElement(By.xpath("//*[@id=\"step-2\"]/div/form/div[1]/div/input"));
    	legal_entity_name.sendKeys("KrishaWeb");
    	
    	legal_entity_address = driver.findElement(By.xpath("//*[@id=\"step-2\"]/div/form/div[2]/div/input"));
    	legal_entity_address.sendKeys("510, sakar 2, Ellisbridge");
    	
    	TIN = driver.findElement(By.xpath("//*[@id=\"step-2\"]/div/form/div[3]/div/input"));
    	TIN.sendKeys("78-4234234");
    	
    	website_url = driver.findElement(By.xpath("//*[@id=\"step-2\"]/div/form/div[4]/div/input"));
    	website_url.sendKeys("https://krishaweb.com");
    	
    	venture_capital_backend = driver.findElement(By.xpath("//*[@id=\"step-2\"]/div/form/div[5]/ul"));
    	List<WebElement> capital = venture_capital_backend.findElements(By.tagName("li"));
    	for(WebElement capital_tab : capital)
    	{
    		String text = capital_tab.getText().trim();
    		if(text.equalsIgnoreCase("yes"));
    		{
    			capital_tab.click();
    			break;
    		}
    	}
    	
    	fund_raised_to_date = driver.findElement(By.xpath("//*[@id=\"step-2\"]/div/form/div[6]/div/input"));
    	fund_raised_to_date.sendKeys("4234324");
    	
    	greater_priority = driver.findElement(By.xpath("//*[@id=\"step-2\"]/div/form/div[7]/ul"));
    	List<WebElement> priority = greater_priority.findElements(By.tagName("li"));
    	for(WebElement priority_tab : priority)
    	{
    		String text = priority_tab.getText().trim();
    		if(text.equalsIgnoreCase("Profitability"));
    		{
    			priority_tab.click();
    			break;
    		}
    	}
    	
    	business_detail_next = driver.findElement(By.xpath("//*[@id=\"step-2\"]/div/form/div[8]/button[2]"));
    	business_detail_next.click();
    	
    	firstname_input = driver.findElement(By.xpath("//*[@id=\"step-3\"]/div/form/div[1]/div[1]/div/input"));
    	firstname_input.sendKeys("Kian");
    	
    	lastname_input = driver.findElement(By.xpath("//*[@id=\"step-3\"]/div/form/div[1]/div[2]/div/input"));
    	lastname_input.sendKeys("Stokes");
    	
    	date_of_birth = driver.findElement(By.xpath("/html/body/main/div/div[3]/section[1]/div/div[2]/div[1]/div[3]/div/form/div[1]/div[3]/div/input[2]"));
    	date_of_birth.click();
    	
    	select_month = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/select"));
    	List<WebElement> month_tab = select_month.findElements(By.tagName("option"));
    	for(WebElement month_tab_text : month_tab)
    	{
    		String text = month_tab_text.getText().trim();
    		System.out.println(text);
    		if(text.equalsIgnoreCase("November"))
    		{
    			month_tab_text.click();
    		}
    	} 	

    	select_year = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/input"));
    	select_year.clear();
    	select_year.sendKeys("2025");
    	 	    	
    	select_date = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div"));
    	List<WebElement> date_tab = select_date.findElements(By.tagName("span"));
    	for(WebElement date_tab_text : date_tab)
    	{
    		String text = date_tab_text.getAttribute("class");
    	    String dateText = date_tab_text.getText().trim();

    	    if (!text.contains("prevMonthDay") && !text.contains("nextMonthDay"))
    	    {
    	    	if(dateText.equalsIgnoreCase("7"))
    	    	{
    	    		date_tab_text.click();
    	    		break;
    	    	}
    	    }
    	}
    	    	
    	SSN = driver.findElement(By.xpath("//*[@id=\"step-3\"]/div/form/div[1]/div[4]/div/input"));
    	SSN.sendKeys("3112321312");
    	
    	email = driver.findElement(By.xpath("//*[@id=\"step-3\"]/div/form/div[1]/div[5]/div/input"));
    	email.sendKeys("kianstokes@gmail.com");
    	
    	phone_number = driver.findElement(By.xpath("//*[@id=\"step-3\"]/div/form/div[1]/div[6]/div/input"));
    	phone_number.sendKeys("131231231");
    	
    	applicant_detail_button = driver.findElement(By.xpath("//*[@id=\"step-3\"]/div/form/div[2]/button[2]"));
    	applicant_detail_button.click();
    	
    	Thread.sleep(1000);
    	agree_checkbox = driver.findElement(By.xpath("//*[@id=\"step-4\"]/div/form/div[1]/div[1]/input"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,-400)", agree_checkbox);
    	agree_checkbox.click();
    	
    	agree_button = driver.findElement(By.xpath("//*[@id=\"step-4\"]/div/form/div[2]/button[2]"));
    	agree_button.click();
    	
    	active_facilities = driver.findElement(By.cssSelector("input[type=file]"));
    	active_facilities.sendKeys("C:/Users/Admin/Downloads/Zadoon-service-transportation.png");
    	
    	submit_application_button = driver.findElement(By.xpath("//*[@id=\"step-5\"]/div/form/div[4]/a"));
    	submit_application_button.click();
    	
    	
    }

}
