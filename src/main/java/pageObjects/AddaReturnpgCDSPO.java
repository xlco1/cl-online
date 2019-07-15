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
	By healthinsA=By.id("HCQ200");
	By Addaform = By.id("btnAddFormSidebar");
	By generalbtn =By.id("GENERAL");
			//By.xpath("//*[@id='GENERAL']/li/svg");
			//By.xpath("//*[@id=\"GENERAL\"]/li/div/p");
	
	By Clientdatabtn = By.id("000000");
	
			//By.xpath("//button/span[text()='Add A Form']");
	
	
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
		
}
