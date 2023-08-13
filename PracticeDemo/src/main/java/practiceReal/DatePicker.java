package practiceReal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePicker 
{
	WebDriver driver;
	String monthYear;
    String month;
    String year;
    
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\003KT8744\\Downloads\\chromedriver_win32 (7)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
	    Thread.sleep(1000);
	}
	
	public void getMonthYear()
	{
		monthYear=driver.findElement(By.className("ui-datepicker-title")).getText();
	    //
	    month=monthYear.split(" ")[0]; // jan 
	    year=monthYear.split(" ")[1];
	}
	
	public String[] getMonthYearWthSplit(String monthYear)
	{
		return monthYear.split(" ");   
	}
	
	public void selectDate(String expMonth, String expYear, String expDate) 
	{
		if(expMonth.equalsIgnoreCase("Febraury") && Integer.parseInt(expDate)>29)
		{
			System.out.println("wrong date choosed" + expMonth + expDate);
			return;
		}
		else if((expMonth.equalsIgnoreCase("April")||expMonth.equalsIgnoreCase("July"))&&Integer.parseInt(expDate)>30)
		{
			System.out.println("wrong date choosed" + expMonth + expDate);
			return;
		}
		else if(Integer.parseInt(expDate)>31)
		{
			return;
		}
	    driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	    
	    // monthYear=driver.findElement(By.className("ui-datepicker-title")).getText();
		// String month=getMonthYearWthSplit(monthYear)[0];
		// String year=getMonthYearWthSplit(monthYear)[1];
	    getMonthYear();
	    //
	    while(!(month.equalsIgnoreCase(expMonth) && year.equalsIgnoreCase(expYear)))
	    {
	    	driver.findElement(By.xpath("//a[@title='Next']")).click();
	    	getMonthYear();
	    }
	    driver.findElement(By.xpath("//a[text()='"+expDate+"']")).click();  
	}
	
	public void selectPastDate(String date) throws Exception 
	{
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		Calendar calendar= Calendar.getInstance();
		// String date="08-Mar-1997";
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyyy");
		//
		dateFormat.setLenient(false);
		Date formattedDate = dateFormat.parse(date);
		calendar.setTime(formattedDate);
		//
		int targetDay=calendar.get(Calendar.DAY_OF_MONTH);
		int targetYear=calendar.get(Calendar.YEAR);
		int targetMonth=calendar.get(Calendar.MONTH);
		//
		String actualDate=driver.findElement(By.className("ui-datepicker-title")).getText(); // Jan 2023
		calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));
		//
		int actualMonth=calendar.get(Calendar.MONTH);
		int actualYear=calendar.get(Calendar.YEAR);
		//
		while(targetMonth < actualMonth || targetYear < actualYear)
		{
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
			actualDate = driver.findElement(By.className("ui-datepicker-title")).getText(); 
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));
			//
			actualMonth = calendar.get(Calendar.MONTH);
			actualYear = calendar.get(Calendar.YEAR);
		}
		while(targetMonth > actualMonth || targetYear > actualYear) 
		{
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			actualDate = driver.findElement(By.className("ui-datepicker-title")).getText(); 
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));
			//
			actualMonth = calendar.get(Calendar.MONTH);
			actualYear = calendar.get(Calendar.YEAR);
		}
		driver.findElement(By.xpath("//a[text()='23']")).click();  
			
	} 
		
		
	
	
	public void selectActualDate() 
	{
		selectDate("April", "2021", "31");
	}
	@Test
	public void selectDate() throws Exception
	{
		selectPastDate("08-Mar-1997");
	}
	
	
}
