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
public class AddaReturnpgCDSPO {
	public WebDriver driver;
	public AddaReturnpgCDSPO(WebDriver driver) {
		this.driver=driver;
	}
	By ssn = By.id("txtSSNAddNewReturn");
	By confirmssn = By.id("txtSSNConfirmAddNewReturn");
	By cancelbtn = By.id("btnCancelAddNewReturn");
	By addbtn = By.id("btnAddNewReturnAddNewReturn");
	By prepID= By.id("PPID00");
	By Efin = By.id("EFIN00");
	By dob=By.id("PDOB00");
	By firstname=By.id("PNMA00");
	By lastname=By.id("PNMC00");
	By occup=By.id("132200");
	By cellph=By.id("CPHN00");
	By emailid = By.id("EMAL00");
	By filingstatus=By.id("FLST00");
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
	
	By Clientdatabtn = By.id("000000");
	//---------------------- Refund Calc PO
	By refundCalcSideBarbtn = By.id("btnSideBar4");
	By singleCheckbox = By.xpath("//*[@id='zsingle0']"); 
	By aboutheFamilyNextbtn = By.id("ZZ0155");
	By singleTextbox = By.id("001000");
	By FilingstatusNextbtn = By.id("ZZ13145");
	By taxpayersDOB = By.id("001000");
	By taxPayerinfoNextbtn = By.id("ZZ16150");
	By w2WagesCheckbox = By.id("zzw2wages0");
	By taxpayersWages = By.id("009000");
	By taxpayersFedWith = By.id("010000");
	By incomeNextbtn = By.id("ZZ30470");
	By adjustmentsNextbtn = By.id("ZZ40255");
	By creditsNextbtn = By.id("ZZ50175");
	By createReturnbtn = By.id("ZZ90230");
	By exitbtn = By.id("ZZ90250");
	By cancelbtninExit = By.id("btnCancelDialog");
	
	//----------------------------
	
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
		return driver.findElement(cellph);
	}
	public WebElement getemailid()
	{
		return driver.findElement(emailid);
	}
	public WebElement getfilingstatus()
	{
		return driver.findElement(filingstatus);
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
	
	public WebElement clickrefundCalcSideBarbtn()
	{
		return driver.findElement(refundCalcSideBarbtn);
	}
	public WebElement clicksingleCheckbox()
	{
		return driver.findElement(singleCheckbox);
	}
	public WebElement clickaboutheFamilyNextbtn()
	{
		return driver.findElement(aboutheFamilyNextbtn);
	}
	public WebElement getsingleTextbox()
	{
		return driver.findElement(singleTextbox);
	}
	public WebElement clickFilingstatusNextbtn()
	{
		return driver.findElement(FilingstatusNextbtn);
	}
	public WebElement gettaxpayersDOB()
	{
		return driver.findElement(taxpayersDOB);
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
	public WebElement clickincomeNextbtn()
	{
		return driver.findElement(incomeNextbtn);
	}
	public WebElement clickadjustmentsNextbtn()
	{
		return driver.findElement(adjustmentsNextbtn);
	} 
	public WebElement clickcreditsNextbtn()
	{
		return driver.findElement(creditsNextbtn);
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
		
}
