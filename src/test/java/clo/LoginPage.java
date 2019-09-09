/**
 * 
 */
package clo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import resources.Base;

/**
 * @author ssreenivasan
 *
 */
public class LoginPage extends Base{
	
	public WebDriver driver;
	Logger logger= LogManager.getLogger(getClass());
	
	@Parameters("env")
	//@Test(priority = 1)
	public void loginNegative(String env) throws IOException, InterruptedException
		{
			try {
			driver = invokeBrowser(env);
			driver.get("https://qa.crosslinkonline.com/#");
			//report1 = new ExtentReports(System.getProperty("user.dir") + "./reports/testExecutionReport1.html",false,DisplayOrder.NEWEST_FIRST);
		//	test = report1.startTest("Settings");
			LogincloPO lp = new LogincloPO(driver);
			logger.info("STARTED : LOGIN NEGATIVE");
			//lp.getusername().sendKeys(prop.getProperty("username"));
			lp.getusername().sendKeys("000334");
					//prop.getProperty("preparerlogin"));
			lp.getusername().sendKeys(prop.getProperty("000334"));
			logger.info("STARTED : LOGIN NEGATIVE");
			lp.getusername().sendKeys(prop.getProperty("username"));
			lp.getusername().sendKeys(prop.getProperty("preparerlogin"));
			lp.getPassword().sendKeys("password");
			Thread.sleep(1000);
			lp.clickLogin().click();
			WebElement invalidPassword = driver.findElement(By.xpath("//div[text() = 'Incorrect password']"));
			System.out.println(invalidPassword.getText());
			if(invalidPassword.getText().contains("Incorrect password"))
			{
			//System.out.println("Login Negative testcase passed" );
			logger.info("PASSED : LOGIN NEGATIVE");
			//logger.info("--------------------------------");
			logger.info("Login Negative testcase passed");
			test.log(LogStatus.INFO,"Login Negative testcase passed");
			}
			else
			{
				logger.info("Login Negative testcase failed");
				test.log(LogStatus.INFO,"Login Negative testcase failed");
				}
		       driver.close();
		}
			catch(Exception e) {
				logger.error("Error in Login Negative" + e);
				test.log(LogStatus.ERROR, "Error in Login Negative");
			}
		}

	@Parameters("env")
	//@Test(priority = 2)
	public void forgotPassword(String env) throws IOException, InterruptedException
	{
		try {
		driver = invokeBrowser(env);
		driver.get("https://qa.crosslinkonline.com/#");
		LogincloPO lp = new LogincloPO(driver);
		//System.out.println("in forgot pass");
		logger.info("STARTED : FORGOT PASSWORD");
		Thread.sleep(1000);
		//lp.getusername().sendKeys(prop.getProperty("username"));
		lp.clickforgotpassword().click();
		Thread.sleep(1000);
		lp.clickfpusername().click();
		lp.clickfpusername().sendKeys("nidhi");
		lp.clicksendcodebtn().click();
		Thread.sleep(1000);
		WebElement emailsentdialog = driver.findElement(By.id("confirm-delete-title"));
		System.out.println(emailsentdialog.getText());
		logger.info(emailsentdialog.getText());
		assertTrue(emailsentdialog.getText().contains("EMAIL SENT"));
		logger.info("SUCCESS : FORGOT PASSWORD");
		logger.info("forgot password passed");
		test.log(LogStatus.INFO,"forgot password passed");
		WebElement donebtn = driver.findElement(By.id("btnHideEmailSentModal"));
		donebtn.click();
		}
		catch(Exception e) {
		logger.error("Error in Forgot Password" + e);
		test.log(LogStatus.ERROR, "Error in Forgot Password");
		}
		driver.quit();
	}

	@Parameters("env")
	@Test(priority = 3)
	public void loginPositive(String env) throws IOException, InterruptedException
	{
		try {
		driver = invokeBrowser(env);
		driver.get("https://qa.crosslinkonline.com/#");
		//driver.get(prop.getProperty("url"));
		//create a obj for logincloPO 
		LogincloPO lp = new LogincloPO(driver);
		logger.info("STARTED :LOGIN POSITIVE");
		OverviewpgPO op = new OverviewpgPO(driver);
		lp.getusername().sendKeys("000334");
		lp.getPassword().sendKeys("P@ssword1");
		Thread.sleep(1000);
		lp.clickLogin().click();
		lp.clicksecLogin().click();
		lp.clickmarkaspublic().click();
		lp.clickthrdcontbtn().click();
	    //lp.clickcontbtnIRS().click();
	    //lp.clickcanceltour().click();
		Thread.sleep(2000);
	    op.clickoverview().click();
	   // logger.info(op.clickoverview().getText());
	   assertTrue(op.clickoverview().getText().contains("Overview"));
	   	logger.info("Login Positive testcase passed");
	  // System.out.println("Login Positive testcase passed" );
	   logger.info("SUCCESS : LOGIN POSITIVE");
	   //System.out.println("Login Positive testcase passed" );
	   logger.info("Login Positive testcase passed");
	   test.log(LogStatus.INFO,"Login Positive testcase passed");
	   Thread.sleep(1000);
		}
		catch(Exception e) {
		logger.error("Error in Login Positive" + e);
		test.log(LogStatus.ERROR, "Error in Login Positive");
	   
		}
	}

	@Test(priority = 4)
		public void createNewAppointment() throws IOException, InterruptedException
		{
			try {
			LogincloPO lp = new LogincloPO(driver);
			OverviewpgPO op = new OverviewpgPO(driver);
			Thread.sleep(2000);
			op.clickappointmenticonbtn().click();
			op.clicknewappointmentbtn().click();
			op.clickapptfirstname().sendKeys("First");
			op.clickapptlastname().sendKeys("Appontment");
			op.clickapptsubject().sendKeys("Appointment schedule");
			op.clickapptpreparesname().sendKeys("Testpreparer");
			op.clickapptphonenumber().sendKeys("2098352720");
			op.clickapptcomments().sendKeys("Test comments!");
			Thread.sleep(1000);
			op.clickapptsendbtn().click();
			Thread.sleep(2000);
			assertTrue(op.clickapptcreateddialog().getText().contains("The appointment was created successfully."));
			op.clickapptcreatedclsoebtn().click();
			}
			catch(Exception e) {
			logger.error("Error in Create new appointment" + e);
			test.log(LogStatus.ERROR, "Error in Create new appointment");
			}
		}
		
		@Test(priority = 5)
		public void createApptSameTime() throws IOException, InterruptedException
		{
			try {
			OverviewpgPO op = new OverviewpgPO(driver);
			Thread.sleep(2000);
			op.clickappointmenticonbtn().click();
			op.clicknewappointmentbtn().click();
			op.clickapptfirstname().sendKeys("Second");
			op.clickapptlastname().sendKeys("Appointment");
			op.clickapptsubject().sendKeys("Another appointment at same time");
			op.clickapptpreparesname().sendKeys("Testpreparer");
			op.clickapptphonenumber().sendKeys("2098352720");
			op.clickapptcomments().sendKeys("Second appointment at the same time");
			Thread.sleep(1000);
			op.clickapptsendbtn().click();
			Thread.sleep(2000);
			op.clickapptschconflictconfirmbtn().click();
			logger.info(op.clickapptcreateddialog().getText());
			logger.info("Create Second appointment passed");
			test.log(LogStatus.INFO,"Create Second appointment passed");
			op.clickapptcreatedclsoebtn().click();
			Thread.sleep(1000);
			}
			catch(Exception e) {
			logger.error("Error in Create Second appointment" + e);
			test.log(LogStatus.ERROR, "Error in Create Second appointment");
		   }
			
		}
		@Test(priority = 6)
		public void updateAppointment() throws IOException, InterruptedException
		{
			try {
			Thread.sleep(1000);
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clickapptupdatebtn().click();
			Thread.sleep(1000);
			op.clickapptsubjectupdatemodal().clear();
			op.clickapptsubjectupdatemodal().sendKeys("Updated Subject");
			//System.out.println("Updated Subject");
			logger.info("Updated Subject");
			op.clickapptphonenumberupdatemodal().clear();
			op.clickapptphonenumberupdatemodal().sendKeys("2098352777");
			//System.out.println("Updated phonenumber");
			logger.info("Updated phonenumber");
			op.clickapptscommentupdatemodal().clear();
			op.clickapptscommentupdatemodal().sendKeys("comments updated");
			//System.out.println("updated comments");
			logger.info("updated comments");
			op.clickapptupdatemodalbtn().click();
			Thread.sleep(2000);
			//System.out.println(op.clickapptcreateddialog().getText());
			assertTrue(op.clickapptcreateddialog().getText().contains("The appointment was updated successfully."));
			logger.info("Update appointment passed");
			test.log(LogStatus.INFO,"Update appointment passed");
			op.clickapptcloseupdatemodalbtn().click();
			Thread.sleep(1000);
			}
			catch(Exception e) {
			logger.error("Error in Update appointment" + e);
			test.log(LogStatus.ERROR, "Error in Update appointment");
		   }
			
		}
		
	   @Test(priority = 7)
		public void deleteAppointment() throws IOException, InterruptedException
		{
			try {
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clickapptdeletebtn().click();
			Thread.sleep(1000);
			op.clickapptdelconfirmbtn().click();
			logger.info("Delete appointment passed");
			test.log(LogStatus.INFO,"Delete appointment passed");
			}
			catch(Exception e) {
			logger.error("Error in Delete appointment" + e);
			test.log(LogStatus.ERROR, "Error in Delete appointment");
		   }
		}

	@Test(priority = 8)
		public void deleteSecondAppointment() throws IOException, InterruptedException
		{
			try {
			OverviewpgPO op = new OverviewpgPO(driver);
			Wait.until(ExpectedConditions.elementToBeClickable(op.clickapptdeletebtn()));
			op.clickapptdeletebtn().click();
			Wait.until(ExpectedConditions.elementToBeClickable(op.clickapptdelconfirmbtn()));
			op.clickapptdelconfirmbtn().click();
			logger.info("Delete Second Appointment passed");
			test.log(LogStatus.INFO,"Delete Second Appointment passed");
		}
		catch(Exception e) {
		logger.error("Error in Delete Second Appointment" + e);
		test.log(LogStatus.ERROR, "Error in Delete Second Appointment");
		}
		}
		
		@Test(priority = 9)
		public void newMessageSent() throws IOException, InterruptedException
		{
			try {
			Thread.sleep(1000);
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clicknotificonbtn().click();
			op.clicknotifnewmesgbtn().click();
			Thread.sleep(1000);
			op.clicknotifpreparerdropdown().click();
			op.clicknotifpreparerdpfirstlist().click();
			Thread.sleep(1000);
			op.clicknotifsubject().sendKeys("Automation Test Message");
			op.clicknotifbody().sendKeys("Automation test message body");
			op.clicknotifsendbtn().click();
			logger.info(op.clicknotifmesgsentdialog().getText());
			assertTrue(op.clicknotifmesgsentdialog().getText().contains("The message was sent successfully"));
			logger.info("New Message Sent passed");
			test.log(LogStatus.INFO,"New Message Sent passed");
			op.clicknotifdonebtn().click();}
			catch(Exception e) {
				logger.error("Error in New Message Sent" + e);
				test.log(LogStatus.ERROR, "Error in New Message Sent");
				}
			
		}
			
		@Test(priority = 10)
		public void newMessageReply() throws IOException, InterruptedException
		{
			try {
			Thread.sleep(2000);
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clicknotifreceivedbtn().click();
			Thread.sleep(1000);
			op.clicknotifreplybtn().click();
			op.clicknotifbody().sendKeys("Reply through Automation");
			op.clicknotifsendbtn().click();
			logger.info(op.clicknotifmesgsentdialog().getText());
			assertTrue(op.clicknotifmesgsentdialog().getText().contains("The message was sent successfully"));
			logger.info("New Message Reply passed");
			test.log(LogStatus.INFO,"New Message Reply passed");
			op.clicknotifdonebtn().click();
			}
			catch(Exception e) {
				logger.error("Error in New Message Reply" + e);
				test.log(LogStatus.ERROR, "Error in New Message Reply");
				}
			
		}	
		
	@Test(priority = 11)
		public void deleteMessage() throws IOException, InterruptedException
		{
			try {
			Thread.sleep(2000);
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clicknotifdeletebtn().click();
			op.clicknotifdelmesgdialog().click();
			op.clicknotifdelmesgdialogyesbtn().click();
			logger.info("Delete Message Passed");
			test.log(LogStatus.INFO,"Delete Message Passed");}
			catch(Exception e) {
				logger.error("Error in Delete Message" + e);
				test.log(LogStatus.ERROR, "Error in Delete Message");
				}
		}
			
		@Test(priority = 12)
		public void checksReadyToPrint() throws IOException, InterruptedException
		{
			try {
			Thread.sleep(1000);
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clickchksiconbtn().click();
			op.clickchksfilterdropdown().click();
			op.clickchksfiltertpgbank().click();
			Thread.sleep(1000);
			op.clickchksselectallchkbox().click();
			op.clickchksprintbtn().click();
			Thread.sleep(1000);
			logger.info(op.clickchksprintchecksdialog().getText());
			assertTrue(op.clickchksprintchecksdialog().getText().contains("Print Checks"));
			Thread.sleep(1000);
			op.clickchksprintcheckscancelbtn().click();
			test.log(LogStatus.INFO,"Check print Passed");
			}
			catch(Exception e) {
				logger.error("Error in Checks Ready to Print" + e);
				test.log(LogStatus.ERROR, "Error in Checks Ready to Print");
				}
		}
				
		@Test(priority = 13)
		public void checksRegister() throws IOException, InterruptedException
		{
			try {
			OverviewpgPO op = new OverviewpgPO(driver); 
			Thread.sleep(1000);
			op.clickchkscheckregistertab().click();
			Thread.sleep(1500);
			op.clickchksselectallchkbox().click();
			op.clickchksreprintbtn().click();
			Thread.sleep(1000);
			logger.info(op.clickchksreprintchecksdialog().getText());
			assertTrue(op.clickchksreprintchecksdialog().getText().contains("Check Reprint"));
			Thread.sleep(1000);
			op.clickchksprintcheckscancelbtn().click();
			test.log(LogStatus.INFO,"Checks re-print Passed");
			}
			catch(Exception e) {
				logger.error("Error in Check Register" + e);
				test.log(LogStatus.ERROR, "Error in Check Register");
				}
		}

	@Test(priority = 14)
		public void voidCheck() throws IOException, InterruptedException
		{
			try {
			OverviewpgPO op = new OverviewpgPO(driver); 
			Thread.sleep(1000);
			WebElement frstRow = driver.findElement(By.xpath("//tr/td[text() = 'TPG']"));
			Actions act = new Actions(driver);
			act.moveToElement(frstRow).moveToElement(op.clickchksthreedotsonhover()).click().build().perform();
			op.clickchksvoidcheckbtn().click();
			op.clickchksvoidcheckdialogcancelbtn().click();
			test.log(LogStatus.INFO,"Void Check Passed");
			}
			catch(Exception e) {
				logger.error("Error in Check Register" + e);
				test.log(LogStatus.ERROR, "Error in Check Register");
				}
		}
		
		@AfterClass
		public void teardown()
		{
		 logger.info("in tear down");
			driver.close();
			report.endTest(test);
			report.flush();
		}
	}
