/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ssreenivasan
 *
 */
public class TaxreturnBarPO {
	
	public WebDriver driver;
	public TaxreturnBarPO(WebDriver driver) {
		this.driver=driver;
	}
	
	By verifyReturnbtn = By.id("verifyReturn");
	By interviewClientbtn = By.id("interviewClient");
	By btnSaveAndClose = By.id("btnSaveAndClose");
	By btnArrowOptions = By.id("btnOptionsHeaderBarForms");
	By btnsaveinarrow= By.xpath("//*[@id='menuItemSave']");
	By closeinverify = By.id("btnCloseErrorRejectModal");
	By printbtn = By.id("expanedprinticon");
			//By.xpath("//img[@id='printClient']");
	//--------------PRINT OPTIONS------------------------
	By finalTaxReturnbtn =By.xpath("//li[@id='printOptions2']");
			//By.id("printOptions2");
			//By.xpath("//ul/li[@id='final-return-print']");
	By printInVerifybtn = By.id("btnSubmitErrorRejectModal");
	By printFinalReturnbtn = By.id("btnPrint");
	By remoteSignbtn = By.id("printActionsDialogBtnRemoteSign");
	By saveRtrnInRemotesign = By.xpath("//button[@id='btnClosePrintActionsDialog'][2]");
			//By.id("btnClosePrintActionsDialog");
	  //---IN OFFICE SIGNATURE CAPTURE----
	By taxPayerEmail_checkbx = By.id("chkTaxpayerEmailSelectedRemoteSign");
	By paidPrepEmail_checkbx = By.id("chkPreparerEmailSelectedRemoteSign");
	By OKbtn_inoffcsignature = By.xpath("//button/span[contains(text(),'OK')]");
	By remotesignComplete = By.id("confirm-return-close");
	By OKbtnInRemoteSignComplete = By.id("btnCompletedRemoteSignClose");
	
	
	public WebElement clkverifyReturnbtn()
	{
		return driver.findElement(verifyReturnbtn);
	}
	public WebElement clkinterviewClientbtn()
	{
		return driver.findElement(interviewClientbtn);
	}
	public WebElement clkbtnSaveAndClose()
	{
		return driver.findElement(btnSaveAndClose);
	}
	public WebElement clkbtnArrowOptions()
	{
		return driver.findElement(btnArrowOptions);
	}
	public WebElement clkbtnsaveinarrow()
	{
		return driver.findElement(btnsaveinarrow);
	}
	public WebElement clkcloseinverify()
	{
		return driver.findElement(closeinverify);
	}
	public WebElement clkprintbtn()
	{
		return driver.findElement(printbtn);
	}
	public WebElement clkfinalTaxReturnbtn()
	{
		return driver.findElement(finalTaxReturnbtn);
	}
	public WebElement clkprintInVerifybtn()
	{
		return driver.findElement(printInVerifybtn);
	}
	public WebElement clkprintFinalReturnbtn()
	{
		return driver.findElement(printFinalReturnbtn);
	}
	public WebElement clkremoteSignbtn()
	{
		return driver.findElement(remoteSignbtn);
	}
	public WebElement clksaveRtrnInRemotesign()
	{
		return driver.findElement(saveRtrnInRemotesign);
	}
	public WebElement clktaxPayerEmail_checkbx()
	{
		return driver.findElement(taxPayerEmail_checkbx);
	}
	public WebElement clkpaidPrepEmail_checkbx()
	{
		return driver.findElement(paidPrepEmail_checkbx);
	}
	public WebElement clkOKbtn_inoffcsignature()
	{
		return driver.findElement(OKbtn_inoffcsignature);
	}
	public WebElement getremotesignComplete()
	{
		return driver.findElement(remotesignComplete);
	}
	public WebElement clkOKbtnInRemoteSignComplete()
	{
		return driver.findElement(OKbtnInRemoteSignComplete);
	}
	
}
