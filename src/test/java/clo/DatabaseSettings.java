package clo;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pageObjects.AccountSettingsPO;
import pageObjects.DatabaseSettingsPO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import resources.Base;

public class DatabaseSettings extends Base {
	Logger logger= LogManager.getLogger(getClass());
	public WebDriver driver;
	
	@Parameters("env")
	@Test(priority =22)
	public void dbAddCity(String env) throws IOException, InterruptedException
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
	  //  lp.clickcontbtnIRS().click();
	    //lp.clickcanceltour().click();
		Thread.sleep(2000);
	    op.clickoverview().click();
	    Thread.sleep(1000);
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);
		Thread.sleep(2000);
		ap.clickaccountsdropdown().click();
		Thread.sleep(1000);
		dp.clickdatabaselink().click();
		dp.clickcitieszipcodeslink().click();
		dp.clickaddnewbtn().click();
		dp.clickcitieszipcodetxtbox().sendKeys("12345");
		dp.clickcitiescitytxtbox().sendKeys("Test City");
		dp.clickcitiesstatecodetxtbox().sendKeys("CA");
		dp.clickcitiesaddbtn().click();
		logger.info("New city added");
		test.log(LogStatus.INFO,"New city added");
		}
		catch(Exception e) {
			logger.error("Error in Add DB city" + e);
			test.log(LogStatus.ERROR, "Error in Add DB City");
		}
		}
	
	@Test(priority = 23)
	public void dbEditCity() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickcitieszipcodetxtbox().clear();
		dp.clickcitieszipcodetxtbox().sendKeys("12346");
		dp.clickcitiescitytxtbox().clear();
		dp.clickcitiescitytxtbox().sendKeys("Test City Edited");
		dp.clickcitiesaddbtn().click();
		logger.info("City Edited Sucessfully");
		test.log(LogStatus.INFO,"City Edited Sucessfully");
		}
		catch(Exception e) {
			logger.error("Error in Edit DB city" + e);
			test.log(LogStatus.ERROR, "Error in Edit DB City");
		}
		
		}
	
	@Test(priority = 24)
	public void dbDeleteCity() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("City Deleted Successfully");
		test.log(LogStatus.INFO,"City Deleted Successfully");
		}
		catch(Exception e) {
			logger.error("Error in Delete DB city" + e);
			test.log(LogStatus.ERROR, "Error in Delete DB City");
		}
	
	}
	
	@Test(priority = 25)
	public void dbaddEmployer() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickemployerspayerslink().click();
		dp.clickaddnewbtn().click();
		dp.clickempfederaleintxtbx().sendKeys("111111111");
		dp.clickempnamecontroltxtbx().sendKeys("Test");
		dp.clickempcompanyname().sendKeys("Automation company");
		dp.clickempcompanyaddress().sendKeys("7575 Linne Rd");
		dp.clickempcitytxtbx().sendKeys("Tracy");
		dp.clickempstatetxtbx().click();
		dp.clickempCAstatetxtbx().click();
		dp.clickempzipcodetxtbx().sendKeys("95304");
		dp.clickempstate1identftxtbx().sendKeys("123456789");
		dp.clickempsavebtn().click();
		logger.info("New Employer added Successfully");
		test.log(LogStatus.INFO,"New Employer added Successfully");
		}
		catch(Exception e) {
			logger.error("Error in Add DB Employer" + e);
			test.log(LogStatus.ERROR, "Error in Add DB Employer");
		}
	}
	
	@Test(priority = 26)
	public void dbeditEmployer() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickempfederaleintxtbx().clear();
		dp.clickempfederaleintxtbx().sendKeys("111111112");
		dp.clickempnamecontroltxtbx().clear();
		dp.clickempnamecontroltxtbx().sendKeys("TestUpdated");
		dp.clickempcompanyname().clear();
		dp.clickempcompanyname().sendKeys("Automation company Update");
		dp.clickempcompanyaddress().clear();
		dp.clickempcompanyaddress().sendKeys("7576 Linne Rd");
		dp.clickempsavebtn().click();
		logger.info("New Employer Editted Successfully");
		test.log(LogStatus.INFO,"New Employer Editted Successfully");
		}
		catch(Exception e) {
			logger.error("Error in Edit DB Employer" + e);
			test.log(LogStatus.ERROR, "Error in Edit DB Employer");
		}
	}
	
	@Test(priority = 27)
	public void dbDeleteEmployer() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("Employer Deleted Successfully");
		test.log(LogStatus.INFO,"Employer Deleted Successfully");
		}
		catch(Exception e) {
			logger.error("Error in Delete DB Employer" + e);
			test.log(LogStatus.ERROR, "Error in Delete DB Employer");
		}
}
	
	@Test(priority = 28)
	public void dbaddCareProvider() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickcareproviderslink().click();
		dp.clickaddnewbtn().click();
		dp.clickprovidercode().sendKeys("11111111");
		dp.clickprovidertype().sendKeys("Test type");
		dp.clickprovidernamecontrol().sendKeys("Proctrl");
		dp.clickcareprovidername().sendKeys("Test Careprovider");
		dp.clickprovideradd().sendKeys("128 Indigo dr");
		dp.clickprovidercity().sendKeys("Mountain House");
		dp.clickproviderstate().click();
		dp.clickproviderCAstate().click();
		dp.clickproviderzipcode().sendKeys("95391");
		dp.clickprovidersavebtn().click();
		logger.info("New Care provider added successfully");
		test.log(LogStatus.INFO,"New Care provider added successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Add DB Care Provider" + e);
			test.log(LogStatus.ERROR, "Error in Add DB Care Provider");
		}
		}
	
	@Test(priority = 29)
	public void dbeditCareProvider() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickprovidercode().clear();
		dp.clickprovidercode().sendKeys("11111112");
		dp.clickcareprovidername().clear();
		dp.clickcareprovidername().sendKeys("NameUpdated Careprovider");
		dp.clickprovideradd().sendKeys("128 ritta dr");
		dp.clickprovidersavebtn().click();
		logger.info("Care provider editted successfully");
		test.log(LogStatus.INFO,"Care provider editted successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Edit DB Care Provider" + e);
			test.log(LogStatus.ERROR, "Error in Edit DB Care Provider");
		}
		}
	
	
	@Test(priority = 30)
	public void dbDeleteCareProvider() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("Care Provider Deleted Successfully");
		test.log(LogStatus.INFO,"Care Provider Deleted Successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Delete DB Care Provider" + e);
			test.log(LogStatus.ERROR, "Error in Delete DB Care Provider");
		}
	}
		
	@Test(priority = 31)
	public void dbaddReferrals() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickreferralslink().click();
		dp.clickaddnewbtn().click();
		dp.clickreferralsname().sendKeys("12345");
		dp.clickreferralsaddbtn().click();
		logger.info("Refferrals added successfully");
		test.log(LogStatus.INFO,"Refferrals added successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Add DB Referrals" + e);
			test.log(LogStatus.ERROR, "Error in Add DB Referrals");
		}
	}
	
	@Test(priority = 32)
	public void dbeditReferrals() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickreferralsname().clear();
		dp.clickreferralsname().sendKeys("Refferals Updated");
		dp.clickreferralsaddbtn().click();
		logger.info(" Refferrals editted successfully");
		test.log(LogStatus.INFO,"Refferrals editted successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Edit DB Referrals" + e);
			test.log(LogStatus.ERROR, "Error in Edit DB Referrals");
		}
	}
	
	@Test(priority = 33)
	public void dbDeleteReferrals() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		WebElement donebtn = driver.findElement(By.id("btnHideSettingsError"));
		if(donebtn.isDisplayed())
		{
			donebtn.click();
		}
		logger.info(" Referrals Deleted Successfully");
		test.log(LogStatus.INFO,"Referrals Deleted Successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Delete DB Referrals" + e);
			test.log(LogStatus.ERROR, "Error in Delete DB Referrals");
		}
	}
		
	
	@Test(priority = 34)
	public void dbaddDonee() throws IOException, InterruptedException
	{
		
		try{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickdoneelink().click();
		dp.clickaddnewbtn().click();
		dp.clickdoneeein().sendKeys("11111111");
		dp.clickdoneename().sendKeys("Automation Donee");
		dp.clickdoneeadd().sendKeys("1111 Test Street");
		dp.clickdoneecity().sendKeys("Test City");
		dp.clickdoneestate().click();
		dp.clickdoneeCAstate().click();
		dp.clickdoneezipcode().sendKeys("91119");
		dp.clickdoneesavebtn().click();
		logger.info(" Donee added successfully");
		test.log(LogStatus.INFO,"Donee added successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Add DB Donee" + e);
			test.log(LogStatus.ERROR, "Error in Add DB Donee");
		}
	}
	
	@Test(priority = 35)
	public void dbeditDonee() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickdoneeein().clear();
		dp.clickdoneeein().sendKeys("111111112");
		dp.clickdoneename().clear();
		dp.clickdoneename().sendKeys("Updated Automation Donee");
		dp.clickdoneeadd().clear();
		dp.clickdoneeadd().sendKeys("1111 Updated Street");
		dp.clickdoneecity().clear();
		dp.clickdoneecity().sendKeys("Updated City");
		dp.clickdoneesavebtn().click();
		logger.info(" Donee editted successfully");
		test.log(LogStatus.INFO,"Donee editted successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Edit DB Donee" + e);
			test.log(LogStatus.ERROR, "Error in Edit DB Donee");
		}
		
	}
	
	@Test(priority = 36)
	public void dbDeleteDonee() throws IOException, InterruptedException
	{
		try {
	
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info(" Donee Deleted Successfully");
		test.log(LogStatus.INFO,"Donee Deleted Successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Delete DB Donee" + e);
			test.log(LogStatus.ERROR, "Error in Delete DB Donee");
		}
	}
		
	
	@Test(priority = 37)
	public void dbaddBankRTN() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickbankrtnslink().click();
		dp.clickaddnewbtn().click();
		dp.clickbankrtn().sendKeys("111111111");
		dp.clickbankname().sendKeys("Automation Bank");
		Wait.until(ExpectedConditions.elementToBeClickable(dp.clickbanksavebtn()));
		dp.clickbanksavebtn().click();
		logger.info(" Bank RTN added successfully");
		test.log(LogStatus.INFO,"Bank RTN added successfully");
	}
	catch(Exception e) {
		logger.error("Error in  Add DB Bank RTN" + e);
		test.log(LogStatus.ERROR, "Error in Add DB Bank RTN");
	}
	}
	
	@Test(priority = 38)
	public void dbeditBankRTN() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickbankrtn().clear();
		dp.clickbankrtn().sendKeys("111111112");
		dp.clickbankname().clear();
		dp.clickbankname().sendKeys("Updated Bank");
		dp.clickbanksavebtn().click();
		logger.info(" Bank RTN editted successfully");
		test.log(LogStatus.INFO,"Bank RTN editted successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Edit DB Bank RTN" + e);
			test.log(LogStatus.ERROR, "Error in Edit DB Bank RTN");
		}
			
	}
	
	@Test(priority = 39)
	public void dbDeleteBankRTN() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("Bank RTN Deleted Successfully");
		test.log(LogStatus.INFO,"Bank RTN Deleted Successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Delete DB Bank RTN" + e);
			test.log(LogStatus.ERROR, "Error in Delete DB Bank RTN");
		}
	}
		
	@Test(priority = 40)
	public void dbaddOccupations() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickoccupationslink().click();
		dp.clickaddnewbtn().click();
		dp.clickoccupationname().sendKeys("Automation Occupation");
		dp.clickoccupationaddbtn().click();
		logger.info("New Occupation added successfully");
		test.log(LogStatus.INFO,"New Occupation added successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Add DB Occupations" + e);
			test.log(LogStatus.ERROR, "Error in Add DB Occupations");
		}
	 
	}
	
	@Test(priority = 41)
	public void dbeditOccupations() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickoccupationname().clear();
		dp.clickoccupationname().sendKeys("Automation Occupation");
		dp.clickoccupationaddbtn().click();
		logger.info("Occupation  editted successfully");
		test.log(LogStatus.INFO,"Occupation  editted successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Edit DB Occupations" + e);
			test.log(LogStatus.ERROR, "Error in Edit DB Occupations");
		}
	}	
	
	
@Test(priority = 42)
	public void dbDeleteOccupations() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("Occupations Deleted Successfully");
		test.log(LogStatus.INFO,"Occupations Deleted Successfully");
	}
	catch(Exception e) {
		logger.error("Error in  Delete DB Occupations" + e);
		test.log(LogStatus.ERROR, "Error in Delete DB Occupations");
	}
	}
		
	@Test(priority = 43)
	public void dbaddEducationalInstitute() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeducationalinstitutionslink().click();
		dp.clickaddnewbtn().click();
		dp.clickedufederalein().sendKeys("111111111");
		dp.clickeduinstitutionname().sendKeys("Automation Institute");
		dp.clickeduinstitutionadd().sendKeys("7577 automation rd");
		dp.clickeducity().sendKeys("Tracy");
		dp.clickeduCAstate().click();
		dp.clickeduzipcode().sendKeys("95441");
		dp.clickeduaddbtn().click();
		logger.info("New Educational Institution  added  successfully");
		test.log(LogStatus.INFO,"New Educational Institution  added  successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Add DB Eduational Institute" + e);
			test.log(LogStatus.ERROR, "Error in Add DB Eduational Institute");
		}
	}
	
	@Test(priority = 44)
	public void dbeditEducationalInstitute() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickedufederalein().clear();
		dp.clickedufederalein().sendKeys("111111112");
		dp.clickeduinstitutionname().clear();
		dp.clickeduinstitutionname().sendKeys("Updated Institute");
		dp.clickeduaddbtn().click();
		logger.info("Educational Institution editted  successfully");
		test.log(LogStatus.INFO,"Educational Institution editted  successfully");
		}
		catch(Exception e) {
			logger.error("Error in  Edit DB Eduational Institute" + e);
			test.log(LogStatus.ERROR, "Error in Edit DB Eduational Institute");
		}
	}

    @Test(priority = 45)
	public void dbDeleteEducationalInstitute() throws IOException, InterruptedException
	{
		try {
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("Educational Institute Deleted Successfully");
		test.log(LogStatus.INFO,"Educational Institute Deleted Successfully");
		Thread.sleep(2000);
		dp.clickdatabaseclosebtn().click();
	}
	catch(Exception e) {
		logger.error("Error in  Delete DB Eduational Institute" + e);
		test.log(LogStatus.ERROR, "Error in Delete DB Eduational Institute");
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

	