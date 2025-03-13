/**
 * 
 */
package clo;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.AccountSettingsPO;
import pageObjects.AddaReturnpgPO;
import pageObjects.BankAppPO;
import pageObjects.BillingSetupPO;
import pageObjects.FRM1040PO;
import pageObjects.FRM1099_MISCPO;
import pageObjects.FRM8867PO;
import pageObjects.FRM8879PO;
import pageObjects.FRMSCHK1_1065PO;
import pageObjects.FRMSCH_CPO;
import pageObjects.FRMSCH_EPO;
import pageObjects.FRMSCH_FPO;
import pageObjects.FRMW2PO;
import pageObjects.InterviewModePO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import pageObjects.TaxreturnBarPO;
import pageObjects.addaforminaReturnPO;
import resources.Base;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


//@Listeners(Listener.class)
/**
 * @author ssreenivasan -----PROD--------
 */
public class AddaNewReturn extends Base {

	public WebDriver driver;
	Logger logger = LogManager.getLogger(getClass());
	//public Actions action = new Actions(driver);

	
	public void generateSSN(String env)  throws IOException, InterruptedException {
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		sheet = getCellData();
		// *********** creates SSN*************
		int aSSNnum = 0;
		int bSSNnum = 0, cSSNnum = 0;
		aSSNnum = (int) ((Math.random() * 700) + 100);
		bSSNnum = (int) ((Math.random() * 9000) + 1000);
		cSSNnum = (int) ((Math.random() * 90) + 10);	
		if (aSSNnum < 011) {
			aSSNnum = (int) ((Math.random() * 700) + 100);
		}
		if (env.equalsIgnoreCase("qa") || (env.equalsIgnoreCase("dev"))) {
			ap.getssn().sendKeys(String.valueOf(aSSNnum) + String.valueOf(cSSNnum) + String.valueOf(bSSNnum));
			ap.getconfirmssn().sendKeys(String.valueOf(aSSNnum) + String.valueOf(cSSNnum) + String.valueOf(bSSNnum));
		} else if (env.equalsIgnoreCase("prod")) {
			Thread.sleep(1000);
			ap.getssn().sendKeys(String.valueOf(aSSNnum) + "11" + String.valueOf(bSSNnum));
			ap.getconfirmssn().sendKeys(String.valueOf(aSSNnum) + "11" + String.valueOf(bSSNnum));
		}
		// ************************************
		ap.clkaddbtn().click();
		test.log(LogStatus.INFO, "SSN ENTERED");
		logger.info("SSN taken");
		logger.info("New Taxreturn Opened");
		Reporter.log("SSN ENTERED");
		Reporter.log("<br>");
		
	}
	public void addDOB() throws InterruptedException {
		
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.getdob().click();
		Thread.sleep(2000);
		ap.getdob().sendKeys("05051987");
		Thread.sleep(2000);
		ap.clickinfoandstatusbtn().click();
		ap.clicksigned8879().sendKeys("X"); ///TY2021
	}
	
	public void changeto23(String env,String year) throws InterruptedException, IOException
	{
		
		
		  Reporter.log("opened a preparer"); Reporter.log("<br>");
		  test.log(LogStatus.INFO, "opened a preparer"); AddaReturnpgPO ap = new
		  AddaReturnpgPO(driver);
		//  ap.clkCloseNewRtrnbtn().click(); 
		//  switchYear(year);
		  OverviewpgPO op = new OverviewpgPO(driver);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  Thread.sleep(1000); op.clickdashboardBtn().click(); 
	}

	public void addCDS(String env,String year, String firstname,String filingstatus) throws IOException, InterruptedException {
			
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickClientdatabtn()));
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Entering CDS info");
		Thread.sleep(1000);
		Boolean staleElement = true; 
		while(staleElement){
		  try{
			  ap.getfirstname().click();
		     staleElement = false;

		  } catch(Exception e){
		    staleElement = true;
		  }
		}
		try {
		ap.getfirstname().click();
		}
		catch(Exception ex) {
			ap.getfirstname().click();
		}
		//Thread.sleep(2000);
		//ap.getfirstname().click();
		
		Thread.sleep(1000);
		//ap.getdob().sendKeys("05051985");
		
		Thread.sleep(500);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ap.getoccup().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(6).getCell(1))));
		Thread.sleep(500);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ap.getcellph().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(7).getCell(1))));
		Thread.sleep(500);
		ap.getcellph2().sendKeys("6103088236");
		//ap.gettextmsg().sendKeys("X");
		//ap.gettextmsg().sendKeys(Keys.TAB);
		//ap.clkagreeForTextmsg().click();
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(500);
		//ap.getcellphcarrier().sendKeys("T-MOBILE");
		//AltplusC("cellphcarrier",ap.getcellphcarrier());
		Thread.sleep(500);
		ap.getemailid().sendKeys("saran10@mailinator.com");
		Thread.sleep(500);
		ap.getfilingstatus().sendKeys(filingstatus);
		ap.getfirstname().sendKeys(firstname);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ap.getlastname().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ap.getlastname().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(5).getCell(1)));
		
		if(filingstatus.equals("2"))
		{
			//Thread.sleep(500);
			ap.getspousessn().click();
			ap.getspousessn().clear();
			ap.getspousessn().sendKeys("456123456");
			ap.getspousedob().sendKeys("05051989");
			ap.getspousefirstname().sendKeys("spousename");
			ap.getspouselastname().sendKeys("return");
			AltplusC("spouseoccup",ap.getspouseoccup());
			//ap.getspouseoccup().sendKeys("homemaker");
			
			ap.getspousehomeph().sendKeys("2092258965");
			ap.getspouseemail().sendKeys("email@gmail.com");
			
		}
		//(new DataFormatter().formatCellValue(sheet.getRow(8).getCell(1)));
		ap.getusaddress().sendKeys("12 main st");
		Thread.sleep(1000);
		AltplusC("zipcode", ap.getzip());
		//ap.getzip().sendKeys("95330");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,250);");
		int year_int = Integer.parseInt(year); //convert year string to Int
		if(ap.getenrollProtection().isDisplayed())		{
			ap.getenrollProtection().sendKeys("N");
		}
		if(year_int != 2020) {
		//ap.gethealthinsA().sendKeys("x"); // not in 2019
		}
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0,250);");
		if(filingstatus.equalsIgnoreCase("2")) {
			Thread.sleep(1000);
			ap.getenrollProtection().sendKeys("TAB");
			ap.getenrollProtection().sendKeys("TAB");
			ap.getenrollProtection().click();
			ap.getkid1firstname().click();
			ap.getkid1firstname().sendKeys("joe");
			ap.getkid1lastname().sendKeys("return");
			ap.getkid1DOB().sendKeys("04042015");
			ap.getkid1ssn().sendKeys("6262626262");
			//AltplusC("child",ap.getkid1relationship());
			ap.getkid1relationship().sendKeys("SON");
			ap.getkid1noofmonths().sendKeys("12");
			ap.getkid1dependentcode().sendKeys("N");
		}
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		//ap.getremotesignConsent().sendKeys("Y");
		//ap.clickinfoandstatusbtn().click();
		//ap.clicksigned8879().sendKeys("X");
		tb.clkbtnSaveTaxReturn().click();
	}

	public void addW2(String env,String status) throws IOException, InterruptedException {
		
		Reporter.log("W2 ADDED");
		Reporter.log("</br>");
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.clickaddaform().click();
		addaforminaReturnPO fm = new addaforminaReturnPO(driver);
		Thread.sleep(1000);
		fm.clkfrmw2().click();
		Actions action = new Actions(driver);
		//action.doubleClick(fm.clkfrmw2());
		action.doubleClick(fm.clkAddbtnAddanewform()).perform();
		
		if(status.equalsIgnoreCase("2")) {
			fm.clkfrmw2_TP().click();
			//action.doubleClick(fm.clkAddbtnAddanewform()).perform();
		}
		//fm.clkAddbtnAddanewform().click();
		//Actions action = new Actions(driver);
		logger.info("FRM W2 ADDED");
		test.log(LogStatus.INFO, "w2 form added");
		FRMW2PO w2 = new FRMW2PO(driver);
		w2.getwages().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(13).getCell(1)));
		//action.sendKeys("65000").perform();
		w2.getwages().sendKeys(Keys.TAB);
		//w2.getdbleentryWages().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(13).getCell(1)));
		//w2.clkokindblentryWages().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		w2.getFedtax().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(14).getCell(1)));
		w2.getFedtax().sendKeys(Keys.TAB);
		//w2.getdbleentryFedTax().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(14).getCell(1)));
		//w2.clkokindblentryFedTax().click();
		Thread.sleep(1000);
		w2.getein().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(15).getCell(1))));
		w2.getEmployername().clear();
		//Wait.until(ExpectedConditions.textToBePresentInElement(w2.getEmployername(), "")); // changed from thread.sleep
		Thread.sleep(1000);
		AltplusC("EmpName", w2.getEmployername());
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();
	}

	public void frm8879(String env,String refundtype) throws IOException, InterruptedException {
		Reporter.log("FRM 8879 ADDED");
		Reporter.log("</br>");
		
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		addaforminaReturnPO fm = new addaforminaReturnPO(driver);
		ap.clickaddaform().click();
		Thread.sleep(1000);
		fm.clksearchAForm().sendKeys("8879");
		fm.clkfrm8879().click();
		Actions action = new Actions(driver);
		action.doubleClick(fm.clkAddbtnAddanewform()).perform();
		//fm.clkAddbtnAddanewform().click();
		logger.info("8879 form added");
		test.log(LogStatus.INFO, "8879 form added");
		FRM8879PO f879 = new FRM8879PO(driver);
		String mwh= driver.getWindowHandle();//mwh - main window handle
		f879.getRefndtype().sendKeys(refundtype);
		//sendKeys(new DataFormatter().formatCellValue(sheet.getRow(21).getCell(1)));
		f879.getRefndtype().sendKeys(Keys.TAB);
	//	Wait.until(ExpectedConditions.elementToBeClickable(f879.clickokbtninRefundType()));// changed from thread.sleep
		Thread.sleep(500);
		Set s = driver.getWindowHandles(); //how many windows open
		System.out.println(s);
		Iterator ite ;
		Boolean factor = null;
		int refundtype_int = Integer.parseInt(refundtype);
		System.out.println(refundtype_int);
		if(refundtype_int==1)
			 factor=true;
		else if(refundtype_int==5)
			factor=false;
		
		System.out.println(factor);
		
		while(factor)
		{	
			//f879.clickokbtninRefundType().click(); 
			System.out.println("inside while");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(1000);
			f879.gettaxpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(30).getCell(1)));
			f879.getEROpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(22).getCell(1)));
			f879.getpreptype().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(29).getCell(1)));
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();
			break;
		}
			while(!factor)
			{
				
				System.out.println("no disclosure in 334");
				
				System.out.println("inside while(!factor");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				f879.gettaxpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(30).getCell(1)));
				f879.getEROpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(22).getCell(1)));
				f879.getpreptype().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(29).getCell(1)));
				TaxreturnBarPO tb = new TaxreturnBarPO(driver);
				tb.clkbtnSaveTaxReturn().click();
				break;
				/* if disclosure
				 * JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("scroll(0,250);");
				f879.clickokbtninDisclosureReminder().click();
				 */
				
			}
	}
		
		
		
	public void verifyareturn(String env) throws IOException, InterruptedException {
		try {
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			Thread.sleep(1000);
			test.log(LogStatus.INFO, "in Verify a return");
			Reporter.log("verifyareturn");
			tb.clkbtnSaveTaxReturn().click();
			tb.clkverifyReturnbtn().click();
			Thread.sleep(1000);
			try {
				if (tb.clkOKinVerifysuccessbtn().isDisplayed()) {
					System.out.println("Verify success");
					/*String path = TakeScreenshot();
					String imagePath = test.addScreenCapture(path);
					test.log(LogStatus.PASS, "Took screen shot", imagePath);*/
					File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenshotFile, new File("./reports/verifyerror.png"));
					String path = "verifyerror.png";
					//String imagePath = test.addScreenCapture(path);
					logger.info("screen shot taken");
					test.log(LogStatus.PASS, "Took screen shot", test.addScreenCapture(path));
					
				}
			} catch (Exception e) {
				System.out.println("Verified with errors");
			}
			if(tb.clkOKinVerifysuccessbtn().isDisplayed())
			{
			tb.clkOKinVerifysuccessbtn().click();
			
			tb.clkbtnArrowOptions().click();
    		tb.clkbtnSaveTaxReturn().click();
			}
			else 
				tb.clkcloseinverify().click();
			tb.clkbtnArrowOptions().click();
    		tb.clkbtnSaveTaxReturn().click();
			//Thread.sleep(1000);
			/*	Wait.until(ExpectedConditions.elementToBeClickable(tb.clkbtnSaveTaxReturn()));
			tb.clkbtnSaveTaxReturn().click();
			
			 * tb.clkbtnArrowOptions().click();
			 * //driver.findElement(By.id("btnOptionsHeaderBarForms")).click();
			 * Thread.sleep(1000); tb.clkbtnsaveinarrow().click();
			 */
			// driver.findElement(By.xpath("//li[@id='menuOptions9']")).click(); /// save a
			// return btn
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			} catch (Exception e) {
			logger.error("Error in Addareturn testcase" + e);
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\error1.png"));
		}

	}
	public void addAssets() throws InterruptedException
	{
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.clicktabDepreciation().click();
		ap.clickbtnAddAsset().click();
		addaforminaReturnPO af = new addaforminaReturnPO(driver);
		/*Actions action = new Actions(driver);
		action.doubleClick(af.clkcartruck()).perform();*/
		af.clkcartruck().click();
		af.clkAddbtnAddanewform().click();
		
		ap.clickaddAssetDesc().clear();
		ap.clickaddAssetDesc().sendKeys("PORCHE");
		ap.clickaddAssetDate().clear();
		ap.clickaddAssetDate().sendKeys("01012019");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ap.clickgasPoweredAuto().click();
		ap.clickaddbtninAddAsset().click();
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.getoriginalCost()));
		ap.getoriginalCost().sendKeys("25000");
		ap.getvehiclePersUse_Y().sendKeys("X");
		ap.getvehiclemorethan5_Y().sendKeys("X");
		ap.getisAnotherVehicle_Y().sendKeys("X");
		//Wait.until(ExpectedConditions.textToBePresentInElement(ap.getvehiclemorethan5_Y(), "X"));
		//	Wait.until(ExpectedConditions.textToBePresentInElement(ap.getvehiclePersUse_Y(), "X"));
		ap.getownthisVehicle_y().sendKeys("X");
		//Wait.until(ExpectedConditions.textToBePresentInElement(ap.getownthisVehicle_y(), "X"));
		ap.getforceActExpense_N().sendKeys("X");
		//Wait.until(ExpectedConditions.textToBePresentInElement(ap.getvehiclePersUse_Y(), "X"));
		ap.getforceStndMileage_N().sendKeys("X");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		//Wait.until(ExpectedConditions.textToBePresentInElement(ap.getforceStndMileage_N(), "X"));
		//ap.getACRSinprevYear_N().sendKeys("X");
		Thread.sleep(500);
		ap.clickbtnClose().click();
		test.log(LogStatus.INFO,"Asset Added");
		ap.clickcarTruckVehAlloc().click();		
	}
	
	

	@Parameters({"env","year"})
	//@BeforeTest
	@BeforeMethod
	public void login(String env,String year) throws IOException, InterruptedException {
		driver = invokeBrowser(env);
		LogincloPO lp = new LogincloPO(driver);
		//test = report.startTest("add a return");
		if (env.equalsIgnoreCase("dev")) {
			driver.get(prop.getProperty("url"));
			String mwh = driver.getWindowHandle();
			lp.getusername().click();
			Thread.sleep(500);
			lp.getusername().sendKeys(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("password"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			lp.clickLogin().click();
			//changepasspopup
			Thread.sleep(1000);
			Set s=driver.getWindowHandles();
			Iterator ite=s.iterator();
			while(ite.hasNext())
			{
				String popupHandle = ite.next().toString();
				System.out.println(popupHandle);
				if(!popupHandle.contains(mwh))
				{
					driver.switchTo().window(popupHandle);
					lp.clickpwdexpireCancelbtn().click();
					logger.info("Username and Password success");
					Reporter.log("reporter working");
					Thread.sleep(1000); 
				}
				driver.switchTo().window(mwh);
				Thread.sleep(5000); 
				
				lp.clicksecLogin().click();
				//lp.clickmarkaspublic().click();	
				lp.clickconfirmationkey().sendKeys("devabc");
			}
		}
		 else if (env.equalsIgnoreCase("prod")) {
			test.log(LogStatus.INFO, "ENV : PROD");
			driver.get(prop.getProperty("url"));
			test.log(LogStatus.INFO, "OPENING CROSSLINK.COM");
		//	WebElement loginbtn = driver.findElement(By.id("btnLoginButtonLogin"));
			//Assert.assertEquals("Log In", loginbtn.getText());
			Boolean staleElement = true; 
			while(staleElement){
				try {
					staleElement = false;
				lp.getusername().clear();
				}
				catch(Exception e)
				{
					staleElement =true;
					lp.getusername().click();
					
				}
			}
			
			lp.getusername().sendKeys(prop.getProperty("prod1username"));;
			lp.getPassword().sendKeys(prop.getProperty("prod1password"));
			
			lp.clickrememberPassword().click();
			lp.clickLogin().click();
			Thread.sleep(500);
			/*while(lp.clickpwdexpireCancelbtn().isDisplayed())
			{
				lp.clickpwdexpireCancelbtn().click();
				Thread.sleep(500);
				lp.clickLogin().click();
				break;
			}*/
			logger.info("Username and Password success");
			test.log(LogStatus.INFO, "USERNAME AND PASSWORD SUCCESS");
			Thread.sleep(4000);
			lp.clicksecLogin().click();
			Thread.sleep(2000);
			//lp.clickmarkaspublic().click();
			
			WebElement confirmkey =driver.findElement(By.id("txtConfirmKey"));
			String otpKeyStr = prop.getProperty("1700011_secretkey");
					//"7XZ43POG3SJY54TD";
			Totp totp = new Totp(otpKeyStr);
			String twoFcode = totp.now();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			confirmkey.sendKeys(twoFcode);
			logger.info("In OverView Page");
			test.log(LogStatus.INFO, "CLEARED TFA");
		}
		logger.info("URL open-Success");
		lp.clickthrdcontbtn().click();
		// lp.clickcontbtnIRS().click();
		// lp.clickcanceltour().click();
	//	logger.info("In OverView Page");
		test.log(LogStatus.INFO, "SUCCESSFULLY LOGGED IN");
			
		
	}
	public void switchYear(String year) throws IOException, InterruptedException {
		
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		Thread.sleep(500);
		ap.clickaccountsdropdown().click();
		Thread.sleep(500);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		ap.clickswitchlink().click();
	//	Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));
		ap.clickswitchselectyeardropdown().click();
		switch(Integer.valueOf(year))
		{
		case 2017:
			ap.clickswitchoptionyear2017().click();
			logger.info("switched to the year 2017");
			test.log(LogStatus.INFO,"switched to the year 2017");
			break;
		case 2018:
			ap.clickswitchoptionyear2018().click();
			logger.info("switched to the year 2018");
			test.log(LogStatus.INFO,"switched to the year 2018");
			break;
		case 2019:
			ap.clickswitchoptionyear2019().click();
			logger.info("switched to the year 2019");
			test.log(LogStatus.INFO,"switched to the year 2019");
			break;
		case 2020: 
			ap.clickswitchoptionyear2020().click();
			logger.info("switched to the year 2020");
			test.log(LogStatus.INFO,"switched to the year 2020");
			break;
		case 2021: 
			ap.clickswitchoptionyear2021().click();
			logger.info("switched to the year 2021");
			test.log(LogStatus.INFO,"switched to the year 2021");
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		ap.clickswitchbtn().click();
		
	}
	
	@Parameters("env")
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(String env) throws InterruptedException {
		logger.info("in tear down");
		if(driver != null )
		{
		driver.close();driver.quit();
		}
	}

	/*@Parameters("env")
	@AfterMethod(alwaysRun = true)
	public void teardown(String env) throws InterruptedException {
		logger.info("in tear down");
		if(driver != null )
		{
		//driver.close();
		//	driver.quit();
		}
		
	//	 report.endTest(test); report.flush();
		 
		 } 
	}*/

	// @Test(priority = 3, dependsOnMethods = "addareturn")
	public void scheduleC(String year) throws InterruptedException, IOException {
		try {
			System.out.println("SCHEDULE C");
			AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			Thread.sleep(1000);
			ap.clickaddaform().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			addaforminaReturnPO af = new addaforminaReturnPO(driver);
			af.clksearchAForm().click();
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			af.clksearchAForm().sendKeys("sch c");
			Actions action = new Actions(driver);
			action.doubleClick(af.clkfrmschC()).perform();
		//	af.clkfrmschC().click();
		//	af.clkAddbtnAddanewform().click();
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			FRMSCH_CPO schc = new FRMSCH_CPO(driver);
			logger.info("ADDED FORM SCH-C");
			test.log(LogStatus.INFO, "ADDED FORM SCH-C");
			schc.getA().clear();
			schc.getA().sendKeys("paintings");
			System.out.println(schc.getA().getLocation());
			AltplusC("schc_bizcode", schc.getB());
			schc.getE_Bizaddress().sendKeys("12 z st");
			AltplusC("zipcode", schc.getE_Zip());
			schc.getF_Cash().sendKeys("X");
			schc.getI_No().sendKeys("X");
			if(year != "2017")
			{
			schc.getQualbizIndicator().sendKeys("Q");
			}
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0,250);");
			schc.getgrossSales().sendKeys("2000");
			schc.getutilities().sendKeys("2000");
			logger.info("SCH-C SUCCESS");
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();

		} catch (Exception e) {
			logger.error("Error in SCH C " + e);
			test.log(LogStatus.ERROR, "Error in SCH C");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\error2.png"));
		}

	}

	// @Test(priority = 4, dependsOnMethods = { "addareturn", "scheduleC" })
	public void scheduleE(String year) throws InterruptedException, IOException {
		try {
			System.out.println("SCHEDULE E");
			AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			Thread.sleep(1000);
			ap.clickaddaform().click();
			addaforminaReturnPO af = new addaforminaReturnPO(driver);
			af.clksearchAForm().sendKeys("sch e");
			af.clkfrmschE().click();
			af.clkAddbtnAddanewform().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			FRMSCH_EPO sche = new FRMSCH_EPO(driver);
			sche.getpayments_Question().sendKeys("X");
			sche.getA_streetaddr().sendKeys("87 bolsom ct");
			logger.info("ADDED FORM SCH-E");
			test.log(LogStatus.INFO, "ADDED FORM SCH-E");
			//AltplusC("zipcode", sche.getA_zip());
			sche.getA_zip().sendKeys("95330");
			AltplusC("proptype", sche.getA_proptype());
			sche.getA_numofdays().sendKeys("365"); 
			if(year != "2017"){
			sche.getA_QBI().sendKeys("N"); }
			//sche.getMortInterest().sendKeys("15000");
			sche.getRepairs().sendKeys("15000");
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();
			logger.info("FRM SCH-E SUCCESS");
		} catch (Exception e) {
			logger.error("Error in SCH E " + e);
			test.log(LogStatus.ERROR, "Error in SCH E");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\errorInSCH-E.png"));
		}

	}

	// @Test(priority = 5, dependsOnMethods = { "addareturn", "scheduleC",
	// "scheduleE" })
	public void frm1099_MISC() throws InterruptedException, IOException {
		try {
			System.out.println("1099MISC");
			AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 Thread.sleep(1000);
		//	Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaddaform()));// changed from thread.sleep
			
			/*try {
				Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaddaform()));
		        JavascriptExecutor jse = (JavascriptExecutor)driver;
		    }
		    catch(Exception e) {
		        e.printStackTrace();
		    }*/
			ap.clickaddaform().click();
			addaforminaReturnPO af = new addaforminaReturnPO(driver);
			af.clksearchAForm().sendKeys("1099-MIS");
			af.clkfrm1099MISC().click();
			af.clkAddbtnAddanewform().click();
			FRM1099_MISCPO obj1 = new FRM1099_MISCPO(driver);
			AltplusC("payersEIN", obj1.getpayersEIN());
			logger.info("ADDED FORM 1099-MISC");
			test.log(LogStatus.INFO, "ADDED FORM 1099-MISC");
			obj1.getrents().sendKeys("15000");
			AltplusC("linkto", obj1.getlinksTo());
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();
			// tb.clkbtnSaveAndClose().click();
			Thread.sleep(1000);	
			logger.info("1099MISC SUCCESS");
		} catch (Exception e) {
		//	logger.error("Error in SCH 1099-MISC " + e);
			test.log(LogStatus.ERROR, "Error in SCH 1099-MISC");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\errorIn1099MISC.png"));
		}

	}

	 //@Test(priority = 6 )//,dependsOnMethods = { "addareturn", "scheduleC",
	// "scheduleE", "frm1099_MISC" }
	public void printTaxReturn() throws InterruptedException, IOException {
			System.out.println("PRINT FINAL TAX RETURN");
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			Thread.sleep(1000);
			tb.clkprintbtn().click();
			logger.info("clicked print button");
			test.log(LogStatus.INFO, "PRINT FINAL TAX RETURN");
			//Wait.until(ExpectedConditions.elementToBeClickable(tb.clkfinalTaxReturnbtn())); // changed from thread.sleep
			Thread.sleep(500);
			tb.clkfinalTaxReturnbtn().click();
			//logger.info("clicked final tax return button");
			//Wait.until(ExpectedConditions.elementToBeClickable(tb.clkprintInVerifybtn())); // changed from thread.sleep
			Assert.assertTrue(isElementPresent(tb.clkprintInVerifybtn()), "Print button disabled"); // changed from thread.sleep
			tb.clkprintInVerifybtn().click();
			logger.info("clicked print button in verify");
			tb.clkprintBankDocsbtn().click();
			Thread.sleep(3000);
			//takescreenshot of print page
			TakePRNTScreenshot();
			Thread.sleep(1000);
			logger.info("PRINT SUCCESS");
			test.log(LogStatus.INFO, "PRINT SUCCESS");
			Reporter.log("PRINT SUCCESS");
			Reporter.log("<br>");
		    //tb.clkbtnSaveTaxReturn().click();
			//logger.info("save and closing the tax return");
			test.log(LogStatus.INFO, "save and closing the tax return");
			Thread.sleep(500);
		/*} catch (Exception e) {
			logger.error("Error in PRINT TAX RETURN " + e);
			test.log(LogStatus.ERROR, "Error in PRINT TAX RETURN");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\errorInPrintTaxRtrn.png"));
		}*/

	}
	public void addSchF(String env) throws InterruptedException, IOException {
		
		System.out.println("SCHF");
		FRMSCH_FPO schf = new FRMSCH_FPO(driver);
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.clickaddaform().click();
		addaforminaReturnPO af= new addaforminaReturnPO(driver);
		af.clksearchAForm().sendKeys("sch f");
		af.clkfrmSchF().click();
		af.clkAddbtnAddanewform().click();
		schf.getactivity_A().clear();
		schf.getactivity_A().sendKeys("farming");
		AltplusC("activitycode", schf.getactivitycode_B());
		schf.getcash_C().sendKeys("X");
		schf.getE_yes().sendKeys("X");
		schf.getF_No().sendKeys("X");
		schf.getQBIindicator().sendKeys("N");
		schf.getpart1_1a().sendKeys("2000");
		schf.getpart1_1b().sendKeys("1000");
		schf.getpart11_28().sendKeys("1000");	
	
	}
	
	public void frm8867(String env) throws InterruptedException
    	{
    		//AddaReturnpgPO ap = new AddaReturnpgPO(driver);
    		addaforminaReturnPO fm = new addaforminaReturnPO(driver);
    		//ap.clickaddaform().click();
    		Thread.sleep(1000);
    		/*fm.clksearchAForm().sendKeys("FRM 8867");
    		fm.clkfrm8867().click();
    		fm.clkAddbtnAddanewform().click();
    		fm.clkfrm8867().click();
    		fm.clkAddbtnAddanewform().click();*/
    		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
    		tb.clkbtnSaveTaxReturn().click();
    		Thread.sleep(1000);
    		
    		fm.clkfrm8867().click();
    		FRM8867PO f867 = new FRM8867PO(driver);
    		f867.getyes_1().sendKeys("X");
    		f867.getyes_2().sendKeys("X");
    		f867.getyes_3().sendKeys("X");
    		f867.getNo_4().sendKeys("X");
    		f867.getyes_5().sendKeys("X");
    		f867.getyes_6().sendKeys("X");
    		f867.getyes_7().sendKeys("X");
    		f867.getyes_10().sendKeys("X");
    		f867.getyes_11().sendKeys("X");
    		f867.getyes_12().sendKeys("X");
    		f867.getyes_15().sendKeys("X");
    		f867.getline5_A_d().sendKeys("X");
    		//TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();
    	 	  
    	}
    	
    	@Parameters({"env","year"})
    	//@Test
    	final void BillinginSetup(String env,String year) throws IOException, InterruptedException {
    		
    		test.log(LogStatus.INFO, "STARTING ~ MarriedwithKids RETURN");
    		//switchYear(year);
    		openaPreparer(env,334);
    		//close the ssn box
    		AddaReturnpgPO ar = new AddaReturnpgPO(driver);
    		ar.clkcancelbtn().click();//click cancel in ssn box
    		AccountSettingsPO as = new AccountSettingsPO(driver);
    		as.clickaccountsdropdown().click();
    		as.clicksetupinsettings().click();
    		BillingSetupPO bs = new BillingSetupPO(driver);
    		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    		Thread.sleep(1000);
    		bs.clickbillingLink().click();
    		bs.clickaddformbtn().click();
    		bs.getRetSch4peritem().sendKeys("50");
    		bs.clickaddbtninselectform().click();
    		//worksheet
    		Thread.sleep(1000);
    		bs.clickaddworksheetbtn().click();
    		bs.getret1040peritem().sendKeys("45");
    		bs.clickaddbtninWorksheet().click();
    		//Linesheetbilling
    		Thread.sleep(1000);
    		bs.clickaddlineitemsbtn().click();
    		bs.getret1040perlineitem().sendKeys("55");
    		bs.clickaddbtninlineitem().click();
    		//discounts
    		//Thread.sleep(1000);
    		JavascriptExecutor js = (JavascriptExecutor)driver;
    		js.executeScript("scroll(0,500);");
    		bs.clickdisaddrowbtn().click();
    		bs.getdiscountcode().sendKeys("Automation charge");
    		bs.getdisamount().sendKeys("100");
    		//custom charge
    		//Thread.sleep(1000);
    		bs.clickcustomaddrowbtn().click();
    		bs.getchargedesc().sendKeys("Automation custom");
    		bs.getcustomamount().sendKeys("25");
    		bs.clicksavebillingbtn().click();
    		Thread.sleep(1000);
  
    		
    	}
    	
    	public void schk11065(String env,String year) throws InterruptedException 
    	{
    		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			Thread.sleep(1000);
			ap.clickaddaform().click();
			addaforminaReturnPO af = new addaforminaReturnPO(driver);
			af.clksearchAForm().sendKeys("k");
			af.clkfrmSchk11065().click();
			af.clkAddbtnAddanewform().click();
    		FRMSCHK1_1065PO schk = new FRMSCHK1_1065PO(driver);
    		schk.getpatnershipEIN_A().sendKeys("132123123");
    		schk.getpatnershipName_B().sendKeys("PATNERSHIP123");
    		schk.getpatnershipAddress().sendKeys("12 k st");
    		AltplusC("sck_zip",schk.getpatnershipZipcode());
    		schk.getirsCenter_C().sendKeys("ogden");
    		schk.getresidentStatecode().sendKeys("CA");
    		schk.getmaterialParticipation_Yes().sendKeys("X");
    		schk.getactiveParticipatein2019_No().sendKeys("X");
    		schk.getDomesticPatner_H1().sendKeys("X");
    		schk.getprofitBeggining().sendKeys("50.00");
    		schk.getprofitEnding().sendKeys("50.00");
    		schk.getlossBeggining().sendKeys("50.00");
    		schk.getlossEnding().sendKeys("50.00");
    		schk.getcapitalBeggining().sendKeys("50.00");
    		schk.getcapitalEnding().sendKeys("50.00");
    		schk.getnonrecourseBeggining_K().sendKeys("9650");
    		schk.getbegginingCapitalAccnt_L().sendKeys("2700");
    		schk.getcurrentyrNetIncome().sendKeys("500");
    		schk.getwithdrawals().sendKeys("600");
    		schk.getendingCapitalAccnt().sendKeys("1600");
    		schk.getM_No().sendKeys("X");
    		schk.getpart3_1().sendKeys("500");
    		schk.getpart3_10().sendKeys("250");
    		schk.getpart3_16A().sendKeys("A");
    		schk.getpart3_countryAbbreviation().sendKeys("VARIOUS");
    		schk.getpart3_16B().sendKeys("B");
    		schk.getpart3_16B_Amount().sendKeys("1370");
    		schk.getpart3_16F().sendKeys("F");
    		schk.getpart3_16F_Amount().sendKeys("200");
    		schk.getpart3_16G().sendKeys("G");
    		schk.getpart3_16G_Amount().sendKeys("100");
    		schk.getpart3_19A().sendKeys("A");
    		schk.getpart3_19_Amount().sendKeys("300");
    		
    	}
    	public void frm1040() throws InterruptedException 
    	{
    		FRM1040PO obj1 = new FRM1040PO(driver);
    		Thread.sleep(1000);
    		Boolean bool = true;
    		while(bool) {
    			try {
    		obj1.clkFrm1040btn().click();
    		bool = false; 
    		}
    			catch(Exception e)
    			{
    				obj1.clkFrm1040btn().click();
    	    		bool = true; 
    			}
    		}
    		
    		
    			obj1.clkFrm1040btn().click(); 
    			
    		Thread.sleep(1000);
    		obj1.getvirtualcurrency_No().sendKeys("X");
    		obj1.clkarrownear1040btn().click();
    	//	obj1.clkrecoveryrebatesheettbn().click();
    		obj1.clkbox30infrom1040().click();
    		obj1.clkthreedotsnearbox30().click();
    		Thread.sleep(500);
    		obj1.clkworksheetbtnin3dots().click();
    		JavascriptExecutor jse = (JavascriptExecutor)driver;
    		jse.executeScript("window.scrollBy(0,250)");
    		obj1.clknostimuluspaymntcheckbx1().sendKeys("X");
    	//	obj1.clknostimuluspaymntcheckbx2().sendKeys("X");
    		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
    		tb.clkbtnSaveTaxReturn().click();
    		
    	}
    	
    	@Parameters({"env","year"})
    	@Test
    	final void devaddaReturn(String env,String year) throws IOException, InterruptedException {
    		
    		
    		test.log(LogStatus.INFO, "STARTING ADD A RETURN IN PROD");
    		Reporter.log("STARTING ADDARETURN");
    		Reporter.log("<br>");
    	//	switchYear(year);
    		changeto23(env,year);
    		openaPreparer(env,334);
    		Reporter.log("PREPARER OPENED");
    		Reporter.log("<br>");
    		test.log(LogStatus.INFO, "PREPARER OPENED");
    		generateSSN(env);
    		//addFilingstats("Auto","1");
    		addCDS(env,year,"Auto","1");
    		addDOB();
    		Reporter.log("CDS COMPLETED");
    		Reporter.log("</br>");
    		addW2(env,"single");
    		frm8879(env,"1");
    		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
    	  	Thread.sleep(500);
    	

    	}
		public void addFilingstats(String fname, String filingstatus) throws InterruptedException {
			
			System.out.println("in FS");
			AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(40));
			//wait.until(ExpectedConditions.elementToBeClickable(ap.getfirstname()));
			Thread.sleep(4000);
			ap.getfirstname().sendKeys(fname);
			ap.getlastname().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(5).getCell(1)));
			ap.getTpmarried_No().sendKeys("X");
			//ap.getlastname().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(5).getCell(1)));
			driver.findElement(By.xpath("//html")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			ap.getdidspousedie_No().sendKeys("X");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//html")).click();
			ap.getTppaidhalfofhome_No().sendKeys("X");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//html")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();
			
		}
    	

}
