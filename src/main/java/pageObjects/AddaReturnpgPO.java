/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ssreenivasan
 * changed ids
 *
 */
public class AddaReturnpgPO {
	public WebDriver driver;
	public AddaReturnpgPO(WebDriver driver) {
		this.driver=driver;
	}
	By ssn = By.id("txtSSNAddNewReturn");
	By confirmssn = By.id("txtSSNConfirmAddNewReturn");
	By cancelbtn = By.id("btnCancelAddNewReturn");
	By CloseNewRtrnbtn = By.xpath("//img[@class='addNewReturn-multiply-img']");
	By addbtn = By.id("btnAddNewReturnAddNewReturn");
	By prepID= By.id("PPID00");
	By Efin = By.id("EFIN00");
	By dob=By.id("PDOB00");
	By firstname=By.id("PNMA00");
	By lastname=By.id("PNMC00");
	By occup=By.id("132200");
	By homeph=By.id("HOME00");
	By cellph = By.id("CPHN00");
	By textmsg = By.id("TEXT00");
	By agreeForTextmsg = By.id("agreeConsentBtn");
	By disagreeForTextmsg = By.id("disagreeConsentBtn");	
	By cellphcarrier = By.id("CARR00");
	By emailid = By.id("EMAL00");
	By filingstatus=By.id("FLST00");
	By remotesignConsent = By.id("RMST00");
	//MWK 
	By remotesignConsent_tp =By.id("RMST01");
	By remotesignConsen_sp = By.id("RMSS00");
	
	//spousedetails
	By spousessn = By.id("SSSN00");
	By spousedob = By.id("SDOB00");
	By spousefirstname = By.id("SNMA00");
	By spouselastname = By.id("SNMC00");
	By spouseoccup = By.id("132700");
	By spousehomeph = By.id("SHME00");
	By spouseemail = By.id("SEML00");
	By spousetext = By.id("STXT00");
	By spousecellphcarrier = By.id("SCAR00");
	By spouseprefcontact = By.id("SONT00");
	//kids
	By kid1firstname = By.id("AA0300");
	By kid1lastname = By.id("AB0300");
	By kid1DOB = By.id("AY0300");
	By kid1ssn = By.id("AD0300");
	By kid1relationship = By.id("AE0300");
	By kid1noofmonths = By.id("AM0300");
	By kid1dependentcode = By.id("AX0300"); 
	By usaddress=By.id("dadd00");
	By city=By.id("dcty00");
	By state=By.id("dsta00");
	By zip=By.id("dzip00");
	By enrollProtection = By.id("HCQ400");
	By healthinsA=By.id("HCQ200");
	By Addaform = By.id("btnAddFormSidebar");
	By generalbtn =By.id("GENERAL");
			//By.xpath("//*[@id='GENERAL']/li/svg");
			//By.xpath("//*[@id=\"GENERAL\"]/li/div/p");
	//General side bar btns
	By Clientdatabtn = By.id("form000000");
	By fileOptionsbtn = By.id("formUSFO01");
	By infoandstatusbtn = By.id("form000100");
	//Inside info and status option
	By signed8879 = By.id("887900");
	//FileOPtions inside PO
	By removeAdvancements = By.id("450500");
	//---------------------- Refund Calc PO
	By refundCalcSideBarbtn = By.xpath("//div[@id='btnSideBar7']");
	By singleCheckbox = By.xpath("//*[@id='ivmsingle0']"); //zsingle0
	By marriedCheckbox = By.xpath("//*[@id='ivmmarried0']");
	By hadChildrenCheckbox=By.xpath("//*[@id='ivmdep0']");
	By aboutheFamilyNextbtn = By.id("ZZ0155");
	By aboutheFamilyNextbtn19 = By.id("ZZ013955");
	By singleTextbox = By.id("001000");
	By MFJcheckbox = By.id("004000");
	By filingstatusNextbtn = By.id("ZZ13145");
	By filingstatusNextbtn19 = By.id("ZZ133955");
	By taxpayersDOB = By.id("001000");
	By spouseDOB = By.id("001500");
	By childrenUnder17 = By.id("001000");
	By childrenandotherNextBtn = By.id("ZZ20115");
	By childernandotherNextbtn_complex = By.id("ZZ203955");
	By taxPayerinfoNextbtn = By.id("ZZ16150");
	//income
	By w2WagesCheckbox = By.id("ircw2wages0");//zzw2wages0
	By taxpayersWages = By.id("009000");
	By taxpayersFedWith = By.id("010000");
	By spouseswages = By.id("011000");
	By spouseFedWith = By.id("012000");
	By IRApension = By.id("IRA/Pension"); //2019
	By TPdistriNotSubtoPen = By.id("016000");
	By TPwithholding = By.id("017000");
	By spouseDistriNotSubtoPen = By.id("018000");
	By spousewithholding = By.id("019000");
	By socialSecurity = By.id("zzsocialsecurity0");
	By socialsecIncome = By.id("020000");
	By incomeNextbtn18 = By.id("ZZ30470");
	By incomeNextbtn19 = By.id("ZZ303955");
	//AdjustmentsandDeduction
	By charity = By.id("zzcharity0");//19
			//By.id("Charity");//18
	By giftstoCharity = By.id("011000");
	By medicalCosts = By.id("Medical-Costs");//19 
			//By.id("004000");//18
	By medicalExpenses = By.id("014000");
	By studentLoan = By.id("Student-Loan");
	By studentLoanExpenses = By.id("016000");
	By adjustmentsNextbtn18 = By.id("ZZ40255");
	By adjustmentsNextbtn19 = By.id("ZZ403955");
	//Daycare
	By daycarepaid = By.id("zzdaycarepaid0");
	By amountDayCarePaid = By.id("009000");
	By numofChildren = By.id("010000");
	By creditsNextbtn18 = By.id("ZZ50175");
	By creditsNextbtn19 = By.id("ZZ503955");
	By createReturnbtn = By.id("ZZ90230");
	By exitbtn = By.id("ZZ90250");
	By cancelbtninExit = By.id("btnCancelDialog");
	//----Assets
	By tabDepreciation = By.id("formform12");
	By btnAddAsset = By.id("btnOpenAttachModalDocArchive");
	By addAssetDesc = By.id("addAssetDesc");
	By addAssetDate = By.id("addAssetDate");
	By gasPoweredAuto = By.xpath("//*[text()='Gas-powered Automobiles under 6000 lb']");
	By addbtninAddAsset = By.id("btnAddAsset");
	By carTruckVehAlloc = By.xpath("//*[text()='Vehicle Allocation']"); //to check if the asset has been added
	//..general form  in Assets	
	By originalCost = By.id("030000");
	By vehiclePersUse_Y = By.id("809000");
	By vehiclemorethan5_Y = By.id("810000");
	By isAnotherVehicle_Y = By.id("811000");
	By ownthisVehicle_y = By.id("814000");
	By forceActExpense_N = By.id("815100");
	By forceStndMileage_N = By.id("817100");
	By ACRSinprevYear_N = By.id("817300");
	By btnClose = By.id("asta454");
	//FilingStats form
	By tpmarried_No = By.id("grp200");
	By didspousedie_No= By.id("grp400");
	By tppaidhalfofhome_No = By.id("grp800");
	
	public WebElement getssn()
	{
		return driver.findElement(ssn);
	}
	public WebElement getconfirmssn()
	{
		return driver.findElement(confirmssn);
	}
	public WebElement clkcancelbtn()
	{
		return driver.findElement(cancelbtn);
	}
	
	public WebElement clkCloseNewRtrnbtn()
	{
		return driver.findElement(CloseNewRtrnbtn);
	}
	public WebElement clkaddbtn()
	{
		return driver.findElement(addbtn);
	}
	public WebElement getprepID()
	{
		return driver.findElement(prepID);
	}
	public WebElement getEfin()
	{
		return driver.findElement(Efin);
	}
	
	public WebElement getdob()
	{
		return driver.findElement(dob);
	}
	public WebElement getfirstname()
	{
		return driver.findElement(firstname);
	}
	public WebElement getlastname()
	{
		return driver.findElement(lastname);
	}
	public WebElement getoccup()
	{
		return driver.findElement(occup);
	}
	public WebElement getcellph()
	{
		return driver.findElement(homeph);
	}
	public WebElement getcellph2()
	{
		return driver.findElement(cellph);
	}
	public WebElement gettextmsg()
	{
		return driver.findElement(textmsg);
	}
	public WebElement clkagreeForTextmsg()
	{
		return driver.findElement(agreeForTextmsg);
	}
	public WebElement clkdisagreeForTextmsg()
	{
		return driver.findElement(disagreeForTextmsg);
	}
	public WebElement getcellphcarrier()
	{
		return driver.findElement(cellphcarrier);
	}
	public WebElement getemailid()
	{
		return driver.findElement(emailid);
	}
	public WebElement getfilingstatus()
	{
		return driver.findElement(filingstatus);
	}
	
	public WebElement getremotesignConsent()
	{
		return driver.findElement(remotesignConsent);
	}
	
	public WebElement getremotesignConsent_tp()
	{
		return driver.findElement(remotesignConsent_tp);
	}
	public WebElement getremotesignConsen_sp()
	{
		return driver.findElement(remotesignConsen_sp);
	}
	public WebElement getspousessn()
	{
		return driver.findElement(spousessn);
	}
	public WebElement getspousedob()
	{
		return driver.findElement(spousedob);
	}
	public WebElement getspousefirstname()
	{
		return driver.findElement(spousefirstname);
	}
	public WebElement getspouselastname()
	{
		return driver.findElement(spouselastname);
	}
	public WebElement getspouseoccup()
	{
		return driver.findElement(spouseoccup);
	}
	public WebElement getspousehomeph()
	{
		return driver.findElement(spousehomeph);
	}
	public WebElement getspouseemail()
	{
		return driver.findElement(spouseemail);
	}
	public WebElement getspousetext()
	{
		return driver.findElement(spousetext);
	}	
	public WebElement getspousecellphcarrier()
	{
		return driver.findElement(spousecellphcarrier);
	}
	public WebElement getspouseprefcontact()
	{
		return driver.findElement(spouseprefcontact);
	}
	public WebElement getkid1firstname()
	{
		return driver.findElement(kid1firstname);
	}
	public WebElement getkid1lastname()
	{
		return driver.findElement(kid1lastname);
	}
	public WebElement getkid1DOB()
	{
		return driver.findElement(kid1DOB);
	}
	public WebElement getkid1ssn()
	{
		return driver.findElement(kid1ssn);
	}
	public WebElement getkid1relationship()
	{
		return driver.findElement(kid1relationship);
	}
	public WebElement getkid1noofmonths()
	{
		return driver.findElement(kid1noofmonths);
	}
	public WebElement getkid1dependentcode()
	{
		return driver.findElement(kid1dependentcode);
	}
	public WebElement getusaddress() 
	{
		return driver.findElement(usaddress);
	}
	public WebElement getcity()
	{
		return driver.findElement(city);
	}
	public WebElement getstate()
	{
		return driver.findElement(state);
	}
	public WebElement getzip()
	{
		return driver.findElement(zip);
	}
	public WebElement getenrollProtection()
	{
		return driver.findElement(enrollProtection);
	}
	public WebElement gethealthinsA()
	{
		return driver.findElement(healthinsA);
	}
	public WebElement clickaddaform()
	{
		return driver.findElement(Addaform);
	}
	public WebElement clickgeneralbtn()
	{
		return driver.findElement(generalbtn);
	}
		
	public WebElement clickClientdatabtn()
	{
		return driver.findElement(Clientdatabtn);
	}
	//file options
	public WebElement clickfileOptionsbtn()
	{
		return driver.findElement(fileOptionsbtn);
	}
	public WebElement getremoveAdvancements()
	{
		return driver.findElement(removeAdvancements);
	}	
	public WebElement clickinfoandstatusbtn()
	{
		return driver.findElement(infoandstatusbtn);
	}
	public WebElement clicksigned8879()
	{
		return driver.findElement(signed8879);
	}
	//------------
	public WebElement clickrefundCalcSideBarbtn()
	{
		return driver.findElement(refundCalcSideBarbtn);
	}
	public WebElement clicksingleCheckbox()
	{
		return driver.findElement(singleCheckbox);
	}
	public WebElement clickmarriedCheckbox()
	{
		return driver.findElement(marriedCheckbox);
	}
	public WebElement clickhadChildrenCheckbox()
	{
		return driver.findElement(hadChildrenCheckbox);
	}
	public WebElement clickaboutheFamilyNextbtn()
	{
		return driver.findElement(aboutheFamilyNextbtn);
	}
	public WebElement clickaboutheFamilyNextbtn19()
	{
		return driver.findElement(aboutheFamilyNextbtn19);
	}
	public WebElement getsingleTextbox()
	{
		return driver.findElement(singleTextbox);
	}
	public WebElement clickMFJcheckbox()
	{
		return driver.findElement(MFJcheckbox);
	}
	public WebElement clickFilingstatusNextbtn()
	{
		return driver.findElement(filingstatusNextbtn);
	}
	public WebElement clickFilingstatusNextbtn19()
	{
		return driver.findElement(filingstatusNextbtn19);
	}
	public WebElement gettaxpayersDOB()
	{
		return driver.findElement(taxpayersDOB);
	}
	public WebElement getspouseDOB()
	{
		return driver.findElement(spouseDOB);
	}
	public WebElement getchildrenUnder17()
	{
		return driver.findElement(childrenUnder17);
	}
	public WebElement clickchildrenandotherNextBtn()
	{
		return driver.findElement(childrenandotherNextBtn);
	}
	public WebElement clickchildrenandotherNextBtn_complex()
	{
		return driver.findElement(childernandotherNextbtn_complex);
	}
	public WebElement clicktaxPayerinfoNextbtn()
	{
		return driver.findElement(taxPayerinfoNextbtn);
	}
	public WebElement clickw2WagesCheckbox()
	{
		return driver.findElement(w2WagesCheckbox);
	}
	public WebElement gettaxpayersWages()
	{
		return driver.findElement(taxpayersWages); 
	}
	public WebElement gettaxpayersFedWith()
	{
		return driver.findElement(taxpayersFedWith); 
	}
	public WebElement getspouseswages()
	{
		return driver.findElement(spouseswages);
	}
/*	public WebElement getspouseFedWith()
	{
		return driver.findElement(spouseFedWith);
	}*/
	public WebElement clickIRApension()
	{
		return driver.findElement(IRApension);
	}
	public WebElement getTPdistriNotSubtoPen()
	{
		return driver.findElement(TPdistriNotSubtoPen);
	}
	public WebElement getTPwithholding()
	{
		return driver.findElement(TPwithholding);
	}
	public WebElement getspouseDistriNotSubtoPen()
	{
		return driver.findElement(spouseDistriNotSubtoPen);
	}
	public WebElement getspousewithholding()
	{
		return driver.findElement(spousewithholding);
	}
	public WebElement clicksocialSecurity()
	{
		return driver.findElement(socialSecurity);
	}
	public WebElement getsocialsecIncome()
	{
		return driver.findElement(socialsecIncome);
	}
	public WebElement getspouseFedWith()
	{
		return driver.findElement(spouseFedWith);
	} 
	public WebElement getIRApension()
	{
		return driver.findElement(IRApension);
	}
	public WebElement clickincomeNextbtn18()
	{
		return driver.findElement(incomeNextbtn18);
	}
	public WebElement clickincomeNextbtn19()
	{
		return driver.findElement(incomeNextbtn19);
	}
	public WebElement clickcharity()
	{
		return driver.findElement(charity);
	}
	public WebElement getgiftstoCharity()
	{
		return driver.findElement(giftstoCharity);
	}
	public WebElement clickmedicalCosts()
	{
		return driver.findElement(medicalCosts);
	}
	public WebElement getmedicalExpenses()
	{
		return driver.findElement(medicalExpenses);
	}
	public WebElement clickstudentLoan()
	{
		return driver.findElement(studentLoan);
	}
	public WebElement getstudentLoanExpenses()
	{
		return driver.findElement(studentLoanExpenses);
	}
	
	public WebElement clickadjustmentsNextbtn18()
	{
		return driver.findElement(adjustmentsNextbtn18);
	} 
	public WebElement clickadjustmentsNextbtn19()
	{
		return driver.findElement(adjustmentsNextbtn19);
	}
	public WebElement clickdaycarepaid()
	{
		return driver.findElement(daycarepaid);
	} 
	public WebElement getdayCarePaid()
	{
		return driver.findElement(amountDayCarePaid);
	}
	public WebElement getnumofChildren()
	{
		return driver.findElement(numofChildren);
	}
	public WebElement clickcreditsNextbtn18()
	{
		return driver.findElement(creditsNextbtn18);
	} 
	public WebElement clickcreditsNextbtn19()
	{
		return driver.findElement(creditsNextbtn19);
	} 
	public WebElement clickcreateReturnbtn()
	{
		return driver.findElement(createReturnbtn);
	} 
	public WebElement clickexitbtn()
	{
		return driver.findElement(exitbtn);
	} 
	public WebElement clickcancelbtninExit()
	{
		return driver.findElement(cancelbtninExit);
	}
	public WebElement clicktabDepreciation()
	{
		return driver.findElement(tabDepreciation);
	}
	public WebElement clickbtnAddAsset()
	{
		return driver.findElement(btnAddAsset);
	}
	public WebElement clickaddAssetDesc()
	{
		return driver.findElement(addAssetDesc);
	}
	public WebElement clickaddAssetDate()
	{
		return driver.findElement(addAssetDate);
	}
	public WebElement clickgasPoweredAuto()
	{
		return driver.findElement(gasPoweredAuto);
	}
	public WebElement clickaddbtninAddAsset()
	{
		return driver.findElement(addbtninAddAsset);
	}
	public WebElement clickcarTruckVehAlloc()
	{
		return driver.findElement(carTruckVehAlloc);
	}
	public WebElement getoriginalCost()
	{
		return driver.findElement(originalCost);
	}
	public WebElement getisAnotherVehicle_Y()
	{
		return driver.findElement(isAnotherVehicle_Y);
	}
	public WebElement getvehiclePersUse_Y()
	{
		return driver.findElement(vehiclePersUse_Y);
	}
	public WebElement getvehiclemorethan5_Y()
	{
		return driver.findElement(vehiclemorethan5_Y);
	}
	public WebElement getownthisVehicle_y()
	{
		return driver.findElement(ownthisVehicle_y);
	}
	public WebElement getforceStndMileage_N()
	{
		return driver.findElement(forceStndMileage_N);
	}
	public WebElement getforceActExpense_N()
	{
		return driver.findElement(forceActExpense_N);
	}
	public WebElement getACRSinprevYear_N()
	{
		return driver.findElement(ACRSinprevYear_N);
	}
	public WebElement clickbtnClose()
	{
		return driver.findElement(btnClose);
	}
	public WebElement getTpmarried_No()
	{
		return driver.findElement(tpmarried_No);
	}
	public WebElement getdidspousedie_No()
	{
		return driver.findElement(btnClose);
	}
	public WebElement getTppaidhalfofhome_No()
	{
		return driver.findElement(btnClose);
	}
	
	
		
}
