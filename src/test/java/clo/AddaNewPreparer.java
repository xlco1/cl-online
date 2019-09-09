/**
 * 
 */
package clo;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.CompletesetupPO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import pageObjects.PreparerinCompleteSetupPO;
import resources.Base;

/**
 * @author ssreenivasan
 * office level
 *
 */
public class AddaNewPreparer extends Base{
	
	public WebDriver driver;
	Logger logger= LogManager.getLogger(getClass());
	
	@Test(priority=1)
	public void newPreparer()
	{
		try {
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clickpreparertab().click();
			Wait.until(ExpectedConditions.elementToBeClickable(op.clickCreateNewPrep()));
			op.clickCreateNewPrep().click();
			logger.info("Clicked New preparer button");
			Thread.sleep(1000);
			PreparerinCompleteSetupPO pc= new PreparerinCompleteSetupPO(driver);
			pc.clkAddNewbtn().click();
			logger.info("Entering New Preparers Info");
			pc.getPrepID().sendKeys("009");
			pc.getPrepName().sendKeys("Auto preparer");
			pc.getPrepSSN().sendKeys("123456789");
			pc.getPrepPTIN().sendKeys("01111111");
			pc.getPrepType().click();
			pc.getPrepTypeOption().click();
			pc.getPrepEmail().sendKeys("qa13@petzent.com");
			pc.getFirmName().sendKeys("The Firm");
			pc.getFirmAddress().sendKeys("12 main st");
			pc.getCity().sendKeys("tracy");
			pc.getState().sendKeys("CA");
			pc.getZip().sendKeys("95337");
			pc.clickAddNewPrep().click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			try
			{
			if(pc.getErrortoNewPrep().isDisplayed())
			{
				Thread.sleep(1000);
				logger.error("Alert shows: " + pc.getErrortoNewPrep().getText());
				logger.fatal("Error Desc : " + pc.getErrorDesc().getText());
				pc.clickDonebtninError().click();
			}
			}
			catch(Exception E)
			{
				Thread.sleep(1000);
				logger.info("New Preparer Created");
				//pc.clickDonebtninError().click();
				//Thread.sleep(1000);
			}
			
			//CompletesetupPO cs = new CompletesetupPO(driver);
			//Wait.until(ExpectedConditions.elementToBeClickable(cs.clkCloseSetupBtn()));
			//cs.clkCloseSetupBtn().click();
			//logger.info("Closing the setup.Going to Overview page");
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error("Error " + e);
		}
	}
	
	@Test(priority=2)
	public void deleteaPreparer()
	{
		try {
			logger.info("Delete prep");
			//OverviewpgPO op = new OverviewpgPO(driver);
			//op.clickCreateNewPrep().click();
			logger.info("Clicked New preparer button");
			Thread.sleep(1000);
			PreparerinCompleteSetupPO pc= new PreparerinCompleteSetupPO(driver);
			/*WebElement deletebtn = (WebElement) By.xpath("//button[@id='btnExecuteAction4'[0]]");
			deletebtn.click();*/
			pc.clickDelete_btnexecuteaction3().click();
			logger.info("Preparer Deleted");
			pc.clickClosebtn().click();
			logger.info("Closing the setup.Going to Overview page");
			Thread.sleep(1000);	
		} catch (Exception e) {
			logger.error("Error " + e);
		}
	}
	
	@Parameters("env")
	@BeforeClass
	public void login(String env) throws IOException, InterruptedException
	{
		driver= invokeBrowser(env);
		driver.get(prop.getProperty("url"));
		logger.info("URL open-Success");
		LogincloPO lp = new LogincloPO(driver);
		lp.getusername().sendKeys(prop.getProperty("preparerlogin"));
		lp.getPassword().sendKeys(prop.getProperty("preparerpass"));
		Thread.sleep(1000);
		lp.clickLogin().click();
		logger.info("Username and Password success");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(lp.clicksecLogin()));
		lp.clicksecLogin().click();
		logger.info("clicked secLogin");
		lp.clickmarkaspublic().click();
		logger.info("Clicked markaspublic");
		lp.clickthrdcontbtn().click();
		logger.info("clicked thirdcontbtn");
		logger.info("In OverView Page");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
}
