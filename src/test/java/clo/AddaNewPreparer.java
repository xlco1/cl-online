/**
 * 
 */
package clo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
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
	
	@Test
	public void newPrep()
	{
		try {
			logger.info("In adding a new prep test case");
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clickNewpreparerbtn().click();
			logger.info("Clicked New preparer button");
			Thread.sleep(1000);
			PreparerinCompleteSetupPO pc= new PreparerinCompleteSetupPO(driver);
			pc.clkAddNewbtn().click();
			logger.info("Entering New Preparers Info");
			pc.getPrepID().sendKeys("505");
			//pc.getThirdPartyPIN().sendKeys("12345");
			pc.getPrepName().sendKeys("505Test Preparer");
			pc.getPrepSSN().sendKeys("123456789");
			pc.getPrepPTIN().sendKeys("P01111111");
			pc.getPrepType().click();
			pc.getPrepTypeOption().click();
			pc.getPrepEmail().sendKeys("qa13@petzent.com");
			pc.getPrepcellph().sendKeys("6103088236");
			pc.getPrepcellCarrier().click();
			pc.getprepcellCarrierOption().click();
			pc.getFirmName().sendKeys("The Firm");
			//pc.getEIN().sendKeys("123456789");
			pc.getFirmAddress().sendKeys("12 main st");
			pc.getCity().sendKeys("tracy");
			pc.getState().sendKeys("CA");
			pc.getZip().sendKeys("95337");
			pc.getOfficeph().sendKeys("2094568252");
			pc.getEFINID().sendKeys("0000333");
			pc.clickAddNewPrep().click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			if(pc.getErrortoNewPrep().isDisplayed())
			{
				logger.error("Alert shows: " + pc.getErrortoNewPrep().getText());
				logger.fatal("Error Desc : " + pc.getErrorDesc().getText());
				pc.clickDonebtninError().click();
			}
			else 
			{
				logger.info("New Preparer Created");
				pc.clickDonebtninError().click();
			}
			
			CompletesetupPO cs = new CompletesetupPO(driver);
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(cs.clkCloseSetupBtn()));
			//logger.info("explicit wait success");
			cs.clkCloseSetupBtn().click();
			logger.info("Closing the setup.Going to Overview page");
			//Thread.sleep(1000);--------------1st change
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.error("Error " + e);
		}
	}
	
	@Parameters("env")
	@BeforeClass
	public void login(String env) throws IOException, InterruptedException
	{
		//*************change this before running
		driver= invokeBrowser(env);
		driver.get(prop.getProperty("url"));
		logger.info("URL open-Success");
		LogincloPO lp = new LogincloPO(driver);
		lp.getusername().sendKeys(prop.getProperty("preparerlogin"));
		lp.getPassword().sendKeys(prop.getProperty("preparerpass"));
		Thread.sleep(1000);
		lp.clickLogin().click();
		logger.info("Username and Password success");
		//Thread.sleep(1000);-----------------1st change
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(lp.clicksecLogin()));
		lp.clicksecLogin().click();
		logger.info("clicked secLogin");
		lp.clickmarkaspublic().click();
		logger.info("Clicked markaspublic");
		lp.clickthrdcontbtn().click();
		logger.info("clicked thirdcontbtn");
		lp.clickcontbtnIRS().click();
		logger.info("clicked continuein IRS");
		lp.clickcanceltour().click();
		logger.info("Clickedcanceltour");
		logger.info("In OverView Page");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
}
