/**
 * 
 */
package clo;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pageObjects.AddaReturnpgCDSPO;
import pageObjects.FRM1099_MISCPO;
import pageObjects.FRM8879PO;
import pageObjects.FRMSCH_CPO;
import pageObjects.FRMSCH_EPO;
import pageObjects.FRMW2PO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import pageObjects.TaxreturnBarPO;
import pageObjects.addaforminaReturnPO;
import resources.Base;

/**
 * @author ssreenivasan
 * OverviewpgPO op
 * AddaReturnpgCDSPO ap
 * TaxreturnBarPO tb
 * addaforminaReturnPO af
 */
public class AddaNewReturn extends Base {
	
	public WebDriver driver;
	Logger logger= LogManager.getLogger(getClass());
		
	@Parameters("env")
	@Test(priority=1)
	public void addareturn(String env) throws IOException, InterruptedException	
	{
	try {
		System.out.println("in Test " + env);
		OverviewpgPO op=new OverviewpgPO(driver);
		op.clickoffices().click();
		logger.info("Clicked Offices");
		test.log(LogStatus.INFO,"Clicked Offices");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(env.equalsIgnoreCase("qa"))
		{
		op.clickviewbtn().click();
		}
		else
		{
			op.clickdevViewbtn().click();
		}
		logger.info("Opening a Office");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		op.clickpreparersbtn().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(env.equalsIgnoreCase("qa"))
		{
		op.clickviewprepbtn().click();
		}
		else
		{
			op.clickdevViewprepbtn().click();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		op.clickTaxreturns().click();
		if(op.clickNewTaxreturnsbtn().isEnabled())
		{
		op.clickNewTaxreturnsbtn().click();
		}
		else
		{
				logger.error("Add New Tax Return button is disabled");
			test.log(LogStatus.ERROR,"Add a Tax Return button disabled");
		
		}
		AddaReturnpgCDSPO ap = new AddaReturnpgCDSPO(driver);
		sheet = getCellData();
		//String ssn = String.valueOf(sheet.getRow(0).getCell(1).getNumericCellValue());
		//*********** creates SSN*************// 
		int aSSNnum = 0;
		int bSSNnum = 0;
		aSSNnum=(int)((Math.random()*700)+100);
		bSSNnum=(int)((Math.random()*9000)+1000);
		if(aSSNnum<011)
		{
			aSSNnum=(int)((Math.random()*700)+100);
		}
		if(env.equalsIgnoreCase("qa") || (env.equalsIgnoreCase("dev")))
		{
		ap.getssn().sendKeys(String.valueOf(aSSNnum)+"00"+String.valueOf(bSSNnum));
		ap.getconfirmssn().sendKeys(String.valueOf(aSSNnum)+"00"+String.valueOf(bSSNnum));
		}
		else if(env.equalsIgnoreCase("prod"))
		{
			ap.getssn().sendKeys(String.valueOf(aSSNnum)+"11"+String.valueOf(bSSNnum));
			ap.getconfirmssn().sendKeys(String.valueOf(aSSNnum)+"11"+String.valueOf(bSSNnum));
		}
		//************************************//
		ap.clkaddbtn().click();
		test.log(LogStatus.INFO,"Entered SSN");
		logger.info("SSN taken");
		logger.info("New Taxreturn Opened");
		ap.clickgeneralbtn().click();
		ap.clickClientdatabtn().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AltplusC("prepID",ap.getprepID());
		AltplusC("efin",ap.getEfin());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		ap.getdob().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(3).getCell(1)));
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//String text =  ap.getdob().getText();
		//wait.until(ExpectedConditions.
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO,"Entering CDS info");
		ap.getfirstname().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(4).getCell(1)));
		Thread.sleep(500);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ap.getlastname().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(5).getCell(1)));
		Thread.sleep(500);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ap.getoccup().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(6).getCell(1))));
		Thread.sleep(500);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ap.getcellph().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(7).getCell(1))));
		Thread.sleep(500);
		ap.getemailid().sendKeys("qa1@petzent.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ap.getfilingstatus().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(8).getCell(1)));
		ap.getusaddress().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(9).getCell(1)));
		AltplusC("zipcode",ap.getzip());
		ap.gethealthinsA().sendKeys("x");
		ap.clickaddaform().click();
		addaforminaReturnPO fm = new addaforminaReturnPO(driver);
		fm.clkfrmw2().click();
		fm.clkAddbtnAddanewform().click();
		logger.info("Added w2 form");
		test.log(LogStatus.INFO,"w2 form added");
		FRMW2PO w2=new FRMW2PO(driver);
		w2.getwages().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(13).getCell(1)));
		w2.getFedtax().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(14).getCell(1)));
		w2.getein().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(15).getCell(1))));
		w2.getEmployername().clear();
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AltplusC("EmpName",w2.getEmployername());
		ap.clickaddaform().click();
		fm.clkfrm8879().click();
		fm.clkAddbtnAddanewform().click();
		logger.info("8879 form added");
		test.log(LogStatus.INFO,"8879 form added");
		FRM8879PO f879 = new FRM8879PO(driver);
		f879.getRefndtype().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(21).getCell(1)));
		f879.getEROpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(22).getCell(1)));
		f879.getPTIN().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(23).getCell(1)));
		//f879.getprepname().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(24).getCell(1)));
		//f879.getprepaddress().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(25).getCell(1)));
		//f879.getprepcity().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(26).getCell(1)));
		//f879.getprepstate().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(27).getCell(1)));
	//	f879.getprepzip().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(28).getCell(1)));
		f879.getpreptype().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(29).getCell(1)));
		f879.gettaxpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(30).getCell(1)));
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkverifyReturnbtn().click();
		Thread.sleep(1000);
		String path = TakeScreenshot();
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.PASS,"Took screen shot",imagePath);
		logger.info("screen shot taken");
		tb.clkcloseinverify().click();
		//driver = saveTaxReturn();
		Thread.sleep(1000);
		driver.findElement(By.id("btnOptionsHeaderBarForms")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@id='menuOptions9']")).click(); ///save a return btn
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
	} catch (Exception e) {
		logger.error("Error in Addareturn testcase"  + e);
		 File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\error1.png"));
	 
	}

	}
	
	@Parameters("env")	
	@BeforeTest
	public void login(String env) throws IOException, InterruptedException
	{
		System.out.println(env);
		driver= invokeBrowser(env);
		LogincloPO lp = new LogincloPO(driver);
		if(env.equalsIgnoreCase("qa"))
		{
		driver.get("https://qa.crosslinkonline.com/#");
		lp.getusername().clear();
		Thread.sleep(500);
		lp.getusername().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.clickLogin().click();
		logger.info("Username and Password success");
		lp.clicksecLogin().click();
		lp.clickmarkaspublic().click();
		}
		else if(env.equalsIgnoreCase("dev"))
		{
			driver.get("https://dev.crosslinkonline.com/#");
			lp.getusername().sendKeys(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("devssbpassword"));
			lp.clickLogin().click();
			logger.info("Username and Password success");
			lp.clicksecLogin().click();
			lp.clickmarkaspublic().click();
		}
		else if(env.equalsIgnoreCase("prod"))
		{
			driver.get("https://crosslinkonline.com/#");
			lp.getusername().clear();
			lp.getusername().sendKeys(prop.getProperty("produsername"));
			lp.getPassword().sendKeys(prop.getProperty("prodpassword"));
			lp.clickrememberPassword().click();
			lp.clickLogin().click();
			logger.info("Username and Password success");
			lp.clicksecLogin().click();
			Thread.sleep(2000);
			lp.getdeviceLabel().sendKeys("testing Pc");//or testing Pc1
			Runtime.getRuntime().exec("C:\\Users\\ssreenivasan\\Desktop\\autoitscript\\googleauthenticator.exe");
			Thread.sleep(2000);
			lp.getverificationCode().click();
			lp.getverificationCode().sendKeys(Keys.chord(Keys.CONTROL,"v"));
		
			Thread.sleep(2000);
			lp.clickthrdcontbtn().click();
			lp.clickcontbtnIRS().click();
			lp.clickcanceltour().click();
			logger.info("In OverView Page");
			
		}
		logger.info("URL open-Success");
		lp.clickthrdcontbtn().click();
		lp.clickcontbtnIRS().click();
		lp.clickcanceltour().click();
		logger.info("In OverView Page");
		
	}
		
	@Parameters("env")
	@AfterClass(alwaysRun = true)
	public void teardown(String env) throws InterruptedException
	{
		/*if(env.equalsIgnoreCase("prod"))
		{
		logger.info("in tear down");
		report.endTest(test);
		report.flush();
	}*/
		/*if(env.equalsIgnoreCase("prod1"))
		{
		*/	logger.info("in tear down");
			driver.close();
			report.endTest(test);
			report.flush();
	/*	}*/
	}
	
	@Test(priority=2,dependsOnMethods="addareturn")
	public void scheduleC() throws InterruptedException, IOException
	{
		try {
			System.out.println("SCHEDULE C");
			
			// ap-AddaReturnpgCDSPO
			AddaReturnpgCDSPO ap = new AddaReturnpgCDSPO(driver);
			Thread.sleep(1000);
			ap.clickaddaform().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			addaforminaReturnPO af= new addaforminaReturnPO(driver);
			af.clksearchAForm().sendKeys("sch c");
			af.clkfrmschC().click();
			af.clkAddbtnAddanewform().click();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			FRMSCH_CPO schc = new FRMSCH_CPO(driver);
			logger.info("ADDED FORM SCH-C");
			test.log(LogStatus.INFO,"ADDED FORM SCH-C");
			schc.getA().sendKeys("paintings");
			System.out.println(schc.getA().getLocation());
			AltplusC("schc_bizcode",schc.getB());
			schc.getE_Bizaddress().sendKeys("12 z st");
			AltplusC("zipcode",schc.getE_Zip());
			schc.getF_Cash().sendKeys("X");
			schc.getI_No().sendKeys("X");
			schc.getQualbizIndicator().sendKeys("Q");
			schc.getgrossSales().sendKeys("2000");
			schc.getutilities().sendKeys("2000");
			logger.info("SCH-C SUCCESS");
			
		} catch (Exception e) {
			logger.error("Error in SCH C " + e);
			test.log(LogStatus.ERROR,"Error in SCH C");
		 File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\error2.png"));
		}
		
		driver = saveTaxReturn();
		
	}
	
	
	@Test(priority=3,dependsOnMethods= {"addareturn","scheduleC"})
	public void scheduleE() throws InterruptedException, IOException
	{
		try {
			System.out.println("SCHEDULE E");
			AddaReturnpgCDSPO ap = new AddaReturnpgCDSPO(driver);
			Thread.sleep(1000);
			ap.clickaddaform().click();
			addaforminaReturnPO af= new addaforminaReturnPO(driver);
			af.clksearchAForm().sendKeys("sch e");
			af.clkfrmschE().click();
			af.clkAddbtnAddanewform().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			FRMSCH_EPO sche=new FRMSCH_EPO(driver);
			sche.getA_streetaddr().sendKeys("87 bolsom ct");
			logger.info("ADDED FORM SCH-E");
			test.log(LogStatus.INFO,"ADDED FORM SCH-E");
			AltplusC("zipcode",sche.getA_zip());
			AltplusC("proptype",sche.getA_proptype());
			sche.getA_numofdays().sendKeys("365");
			sche.getA_QBI().sendKeys("Q");
			sche.getMortInterest().sendKeys("15000");
			driver = saveTaxReturn();
			logger.info("FRM SCH-E SUCCESS");
		} catch (Exception e) {
			logger.error("Error in SCH E " + e);
			test.log(LogStatus.ERROR,"Error in SCH E");
			 File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\errorInSCH-E.png"));
		}
		
	}
	
	@Test(priority=4,dependsOnMethods= {"addareturn","scheduleC","scheduleE"})
	public void frm1099_MISC() throws InterruptedException, IOException 
	{
		try {
			System.out.println("1099MISC");
			AddaReturnpgCDSPO ap = new AddaReturnpgCDSPO(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
			ap.clickaddaform().click();
			addaforminaReturnPO af= new addaforminaReturnPO(driver);
			af.clksearchAForm().sendKeys("1099-MIS");
			af.clkfrm1099MISC().click();
			af.clkAddbtnAddanewform().click();
			FRM1099_MISCPO obj1= new FRM1099_MISCPO(driver);
			AltplusC("payersEIN",obj1.getpayersEIN());
			logger.info("ADDED FORM 1099-MISC");
			test.log(LogStatus.INFO,"ADDED FORM 1099-MISC");
			obj1.getrents().sendKeys("15000");
			AltplusC("linkto",obj1.getlinksTo());
			/*TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveAndClose().click();
			Thread.sleep(1000);*/
			driver = saveTaxReturn();
			logger.info("1099MISC SUCCESS");
		} catch (Exception e) {
			logger.error("Error in SCH 1099-MISC " + e);
			test.log(LogStatus.ERROR,"Error in SCH 1099-MISC");
			 File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\errorIn1099MISC.png"));
		}
		
		}
	
    //@Test(priority=5,dependsOnMethods= {"addareturn","scheduleC","scheduleE","frm1099_MISC"})
	public void printTaxReturn() throws InterruptedException, IOException
	{
		try {
			System.out.println("PRINT FINAL TAX RETURN");
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			Thread.sleep(1000);
			tb.clkprintbtn().click();
			logger.info("clicked print button");
			test.log(LogStatus.INFO,"PRINT FINAL TAX RETURN");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			tb.clkfinalTaxReturnbtn().click();
			logger.info("clicked final tax return button");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			tb.clkprintInVerifybtn().click();
			logger.info("clicked print button in verify");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			tb.clkremoteSignbtn().click();
			logger.info("clicked remote signature button");
			tb.clksaveRtrnInRemotesign().click();
			tb.clkpaidPrepEmail_checkbx().click();
			tb.clktaxPayerEmail_checkbx().click();
			logger.info("saved and checked Email checkbox");
			tb.clkOKbtn_inoffcsignature().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			if(tb.getremotesignComplete().getText().equalsIgnoreCase("Remote Signature Request Complete"))
			{
				System.out.println(tb.getremotesignComplete().getText());
				logger.info("PRINT SUCCESS");
				test.log(LogStatus.INFO,"PRINT SUCCESS");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			tb.clkOKbtnInRemoteSignComplete().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
			//!!! change this to the last form!!!!!!!!!!!!
					//TaxreturnBarPO tb = new TaxreturnBarPO(driver);
					tb.clkbtnSaveAndClose().click();
					logger.info("save and closing the tax return");
					test.log(LogStatus.INFO,"save and closing the tax return");
					Thread.sleep(1000);
		} catch (Exception e) {
			logger.error("Error in PRINT TAX RETURN " + e);
			test.log(LogStatus.ERROR,"Error in PRINT TAX RETURN");
			 File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\errorInPrintTaxRtrn.png"));
		}
		
	}

	
}

	

