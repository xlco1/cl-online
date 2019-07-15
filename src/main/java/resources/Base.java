/**
 * 
 */
package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author ssreenivasan
 *
 */
public class Base {
	
	public ChromeDriver driver= null;
	public Properties prop;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public ExtentReports report;
	public ExtentTest test;
	public String filename;
	public String projectPath = System.getProperty("user.dir");
	//---
	
	
	
	//@Parameters("env")
	//@Test
	public WebDriver invokeBrowser(String env) throws IOException
	{
		//System.setProperty("webdriver.chrome.driver", projectPath +"/driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		if(env.equalsIgnoreCase("prod"))
		{
			options.addArguments("user-data-dir=C:\\Users\\ssreenivasan\\AppData\\Local\\Google\\Chrome\\User Data");
			options.addArguments("--start-maximized");
			options.addArguments("disable-infobars");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			 driver=new ChromeDriver(capabilities);
			//driver = new ChromeDriver(options);
		}
		else
		{	
			//to open incognito mode
			//ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--start-maximized");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver=new ChromeDriver(capabilities);
		}
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssreenivasan\\Downloads\\chromedriver_new\\chromedriver.exe");
		
				//projectPath +"/driver/chromedriver.exe");
				//"C:\\Users\\ssreenivasan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		prop = new Properties();
		FileInputStream fs=new FileInputStream(projectPath +"/src/main/java/resources/data.properties");
		prop.load(fs);
		report = new ExtentReports(System.getProperty("user.dir") + "./reports/testExecutionReport.html",true);
				//new ExtentHtmlReporter("./reports/testExecutionReport.html");
				//new ExtentReporter(System.getProperty("user.dir") + "./reports/testExecutionReport.html",true);
				//new ExtentReports("AddareturnReport.html",true);//where to save the report//H:\\CLO\\
		//extent = new ExtentReports();
		test = report.startTest("Adding a New Tax Return");
		test.log(LogStatus.INFO,"Browser Maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public XSSFSheet getCellData()
	{
		try {
			//user.dir will give the current project path
		
		
		//change to / if moving the proj
		workbook = new XSSFWorkbook(projectPath + "\\excel\\addareturndata.xlsx");
		sheet = workbook.getSheet("Sheet1");
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return sheet;
	}
	
	
	public void AltplusC(String arg1,WebElement arg2) throws InterruptedException
	{
		arg2.sendKeys(Keys.chord(Keys.ALT,"c"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver.findElement(By.id("choiceListRow0")).isDisplayed() || driver.findElement(By.xpath("//td[text()='95304']")).isDisplayed())
			{
			if(arg1.equals("prepID"))
			{
				driver.findElement(By.id("choiceListRow1")).click();
			}
			else if(arg1.equals("efin"))
			{
				driver.findElement(By.id("choiceListRow0")).click();			
			}
			else if(arg1.equals("zipcode"))
			{
			driver.findElement(By.xpath("//td[text()='95336']")).click();
			}
			else if(arg1.equals("EmpName"))
			{
				driver.findElement(By.id("choiceListRow4")).click();
			}
			else if(arg1.equals("schc_bizcode"))
			{
				driver.findElement(By.id("choiceListRow2")).click();
			}
			else if(arg1.equals("proptype"))
			{
				driver.findElement(By.id("choiceListRow0")).click();
			}
			else if(arg1.equals("payersEIN"))
			{
				driver.findElement(By.id("choiceListRow1")).click();
			}
			else if(arg1.equals("linkto"))
			{
				driver.findElement(By.id("choiceListRow5")).click();
						//By.xpath("//td[contains(text(),'87')")).click();
			}
			driver.findElement(By.id("btnConfirmChoiceList")).click();
		}
	
		else
		{
			driver.findElement(By.id("btnCancelChoiceList")).click();
			System.out.println("choices not found");
		}
	}
	
	
	
	public ChromeDriver saveTaxReturn() throws InterruptedException
	{
		driver.findElement(By.id("btnOptionsHeaderBarForms")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@id='menuOptions9']")).click();//save button in the bar
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Parameters("env")
	@Test
	public String TakeScreenshot()
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File ScreenShots = ts.getScreenshotAs(OutputType.FILE);
		try {
			filename = "./Screenshots/errorsSnapshot.png";
					//"H:\\CLO\\AddaReturnReport.png";
					//"C:\\CLOAutoSnaps\\verifyerror.png";
		
			FileUtils.copyFile(ScreenShots, new File(filename));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
		
	}
	
}
