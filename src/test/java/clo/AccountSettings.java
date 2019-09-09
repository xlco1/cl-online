package clo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.AccountSettingsPO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import resources.Base;

public class AccountSettings extends Base {
	Logger logger= LogManager.getLogger(getClass());
	public WebDriver driver;
	
@Parameters("env")
@Test(priority =15)
public void switchYear(String env) throws IOException, InterruptedException
{
	try {
	driver = invokeBrowser(env);
	driver.get("https://qa.crosslinkonline.com/#");
	LogincloPO lp = new LogincloPO(driver);
	OverviewpgPO op = new OverviewpgPO(driver);
	lp.getusername().sendKeys("000334");
	lp.getPassword().sendKeys("P@ssword1");
	Thread.sleep(1000);
	lp.clickLogin().click();
	lp.clicksecLogin().click();
	lp.clickmarkaspublic().click();
	lp.clickthrdcontbtn().click();
   // lp.clickcontbtnIRS().click();
  //  lp.clickcanceltour().click();
	Thread.sleep(2000);
    op.clickoverview().click();
    Thread.sleep(1000);
	AccountSettingsPO ap = new AccountSettingsPO(driver);
	Thread.sleep(2000);
	ap.clickaccountsdropdown().click();
	Thread.sleep(1000);
	ap.clickswitchlink().click();
	Thread.sleep(1000);
	ap.clickswitchselectyeardropdown().click();
	ap.clickswitchoptionyear2018().click();
	ap.clickswitchbtn().click();
	//System.out.println("switched to the year 2018");
	logger.info("switched to the year 2018");
	test.log(LogStatus.INFO,"switched to the year 2018");
	Thread.sleep(5000);
	ap.clickaccountsdropdown().click();
	Thread.sleep(1000);
	ap.clickswitchlink().click();
	Thread.sleep(1000);
	ap.clickswitchselectyeardropdown().click();
	ap.clickswitchoptionyear2019().click();
	ap.clickswitchbtn().click();
	//System.out.println("Switched back to the year 2019");
	logger.info("Switched back to the year 2019");
	test.log(LogStatus.INFO,"Switched back to the year 2019");
	}
	catch(Exception e) {
		logger.error("Error in Switch Year" + e);
		test.log(LogStatus.ERROR, "Error in Switch Year");
	}
}

@Test(priority =16)
public void changePassword() throws IOException, InterruptedException
{
	try {
	AccountSettingsPO ap = new AccountSettingsPO(driver);
	Thread.sleep(2000);
	ap.clickaccountsdropdown().click();
	Thread.sleep(1000);
	ap.clickchangepasswordlink().click();
	ap.clickcurrentpassword().sendKeys("P@ssword1");
	ap.clicknewpassword().sendKeys("P@ssword1");
	ap.clickretypepassword().sendKeys("P@ssword1");
	ap.clickchangepasswordbtn().click();
	//System.out.println("Password has been changed successfully");
	logger.info("Password has been changed successfully");
	test.log(LogStatus.INFO,"Password has been changed successfully");
	}
	catch(Exception e) {
		logger.error("Error in Change Password" + e);
		test.log(LogStatus.ERROR, "Error in Change Password");
	}
	
	}

@Test(priority = 17)
public void changePasswordCancel() throws IOException, InterruptedException
{
	try {
	AccountSettingsPO ap = new AccountSettingsPO(driver);
	Thread.sleep(2000);
	ap.clickaccountsdropdown().click();
	Thread.sleep(1000);
	ap.clickchangepasswordlink().click();
	ap.clickcurrentpassword().sendKeys("P@ssword1");
	ap.clicknewpassword().sendKeys("P@ssword4");
	ap.clickretypepassword().sendKeys("P@ssword4");
	ap.clickcancelbtn().click();
	//System.out.println("Change password cancelled successfully");
	logger.info("Change password cancelled successfully");
	test.log(LogStatus.INFO,"Change password cancelled successfully");
	}
	catch(Exception e) {
		logger.error("Error in Change Password Cancel" + e);
		test.log(LogStatus.ERROR, "Error in Change Password Cancel");
	}
	
}
@Test(priority = 18)
public void toggleTrainingMode() throws IOException, InterruptedException
{
	try {
	AccountSettingsPO ap = new AccountSettingsPO(driver);
	Thread.sleep(2000);
	ap.clickaccountsdropdown().click();
	Thread.sleep(1000);
	ap.clicktoggletrainingmodelink().click();
	logger.info("Switched to training mode");
	test.log(LogStatus.INFO,"Switched to training mode");
	}
	catch(Exception e) {
		logger.error("Error in Toggle Training Mode" + e);
		test.log(LogStatus.ERROR, "Error in Toggle Training Mode");
	}

}
@Test(priority = 19)
public void toggleTrainingModeOff() throws IOException, InterruptedException
{
	try {
	AccountSettingsPO ap = new AccountSettingsPO(driver);
	Thread.sleep(2000);
	ap.clickaccountsdropdown().click();
	Thread.sleep(1000);
	ap.clicktoggletrainingmodelink().click();
	logger.info("Traning Mode off");
	test.log(LogStatus.INFO,"Traning Mode off");
	}
	catch(Exception e) {
		logger.error("Error in Traning Mode off" + e);
		test.log(LogStatus.ERROR, "Error in Traning Mode off");
	}
}
@Test(priority = 20)
public void captureSignature() throws IOException, InterruptedException
{
	try {
	AccountSettingsPO ap = new AccountSettingsPO(driver);
	Thread.sleep(2000);
	ap.clickaccountsdropdown().click();
	Thread.sleep(1000);
	ap.clickcapturesignaturelink().click();
	Thread.sleep(1000);
	ap.clickcapsigbox().click();
	Thread.sleep(1000);
	Actions builder = new Actions(driver);
	 builder.moveToElement(ap.clickcapsigbox()).perform();
	builder.clickAndHold(ap.clickcapsigbox()).perform();
	builder.moveByOffset(250, 50).perform();
	builder.moveToElement(ap.clickcapsigbox()).perform();
	builder.clickAndHold(ap.clickcapsigbox()).perform();
	builder.moveByOffset(90, 15).perform();
	builder.moveToElement(ap.clickcapsigbox()).perform();
	Thread.sleep(1000);
	ap.clickcapsigpreviewbtn().click();
	ap.clickcapsigcancelbtn().click();
	//System.out.println("Captured signature successfully");
	logger.info("Captured signature successfully");
	test.log(LogStatus.INFO,"Captured signature successfully");
	}
	catch(Exception e) {
		logger.error("Error in Capture Signature" + e);
		test.log(LogStatus.ERROR, "Capture Signature");
	}
		
			
}
@Test(priority = 21)
public void loginSettings() throws IOException, InterruptedException
{
	try {
	AccountSettingsPO ap = new AccountSettingsPO(driver);
	Thread.sleep(2000);
	ap.clickaccountsdropdown().click();
	ap.clickloginsettingslink().click();
	//System.out.println(ap.clickloginsettingsgstitle().getText());
	logger.info(ap.clickloginsettingsgstitle().getText());
	assertTrue(ap.clickloginsettingsgstitle().getText().contains("Login Preferences"));
	ap.clickloginsetgscancelbtn().click();
	logger.info("Login settings passed");
	test.log(LogStatus.INFO,"Login settings Passed");
}
catch(Exception e) {
	logger.error("Error in Login Settings" + e);
	test.log(LogStatus.ERROR, "Login Settings");
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