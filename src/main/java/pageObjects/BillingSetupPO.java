package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillingSetupPO {
	public WebDriver driver;
	public BillingSetupPO(WebDriver driver) {
		this.driver=driver;
		}
 By billingLink = By.id("miClickableRowBilling");//Billing link in left menu
 By selectstatedpdwn = By.id("selectedState");// Select state drop down
 By addbtnmodal = By.id("btnUpdateBillingState");// add button in add form billing modal
 By cancelbtnmodal = By.id("btnToggleAddListCancel");// Cancel button in add form billing modal
 By previousbtn = By.id("btnPreviousGenBillingSetup");//previous button at the bottom
 By cancelbtn = By.id("btnCancelGenBillingSetup");//Cancel btn at the bottom
 By savebtn = By.id("btnSaveBillingSetup");//Save btn at the bottom
 By saveandnextbtn = By.id("btnNextBillingSetup");// save&next btn at the bottom 
 //-----------------------------Form Billing-------------------------------------------------------------------------
 By addformbtn = By.id("btnAddFormFormBilling");// AddForm+ button
 By formbaseqty = By.id("bqty-15338");// BaseQTY text box
 By formbaseprice = By.id("bprice-15338");// Base Price text box
 By formperitem = By.id("bpriceperrow0");// Per item text box
  //------------------------------Worksheet Billing------------------------------------------------------------------
 By addworksheetbtn = By.id("btnAddFormFormBilling");// Add Worksheet+ bbutton
 By wrkshtbaseqty = By.id("bqty-17461");// baseQTY txt box in worksheet modal
 By wrkshtbaseprice = By.id("bprice-17461");// base price in worksheet
 By wrkshtperitem = By.id("bpriceper-17461");//per item in worksheet
 //-------------------------------Line Item Billing------------------------------------------------------- 
 By addlineitemsbtn = By.id("btnAddFormFormBilling");//add lineitems+ btn
 By lineitemsbaseqty = By.id("bqty-16389");// base qty 
 By lineitemsbaseprice = By.id("bprice-16389");//base price
 By lineitemsperitem = By.id("bpriceper-16389");//per item
 //----------------------------------Discounts----------------------------------------------------------------
 By disaddrowbtn = By.id("btnAddRowBillingDiscounts");// Add row+ btn in discounts 
 By discountcode = By.id("txtDiscountCode0");// discount code text box
 //By distype = By.xpath(")
 By disamount = By.id("txtDiscountAmt0");//amount in discounts
 //---------------------------------Custom Charges----------------------------------------------------
 By customaddrowbtn = By.id("btnAddRowCustomChanges");// add row+ btn in custom charges
 By chargedesc = By.id("txtChargeDesc0");// charge description txt box
 By customamount = By.id("txtChargeAmt0");//Amount in custom Charges
 
 //------------------------------ Billing--------------------------------------------------------------------------
 public WebElement clickbillingLink()
	{
		return driver.findElement(billingLink);
	}

 public WebElement clickselectstatedpdwn()
	{
		return driver.findElement(selectstatedpdwn);
	}
 public WebElement clickaddbtnmodal()
	{
		return driver.findElement(addbtnmodal);
	}
public WebElement clickcancelbtnmodal()
	{
		return driver.findElement(cancelbtnmodal);
	}
public WebElement clickpreviousbtn()
	{
	return driver.findElement(previousbtn);
	}
public WebElement clickcancelbtn()
	{
	return driver.findElement(cancelbtn);
	}
public WebElement clicksavebtn()
	{
	return driver.findElement(savebtn);
	}
public WebElement clicksaveandnextbtn()
	{
	return driver.findElement(saveandnextbtn);
	}
//----------------------------------Form Billing----------------------------------------
 public WebElement clickaddformbtn()
	{
		return driver.findElement(addformbtn);
	}
 public WebElement clickformbaseqty()
	{
		return driver.findElement(formbaseqty);
	}
 public WebElement clickformbaseprice()
	{
		return driver.findElement(formbaseprice);
	}
 public WebElement clickformperitem()
	{
		return driver.findElement(formperitem);
	}
 //---------------------------------Worksheet billing-------------------------------------------------
 public WebElement clickaddworksheetbtn()
	{
		return driver.findElement(addworksheetbtn);
	}
 public WebElement clickwrkshtbaseqty()
	{
		return driver.findElement(wrkshtbaseqty);
	}
 public WebElement clickwrkshtbaseprice()
	{
		return driver.findElement(wrkshtbaseprice);
	}
 public WebElement clickwrkshtperitem()
	{
		return driver.findElement(wrkshtperitem);
	}
 //-------------------------------Line Items Billing------------------------------------------------------------------------
 public WebElement clickaddlineitemsbtn()
	{
		return driver.findElement(addlineitemsbtn);
	}
 public WebElement clicklineitemsbaseqty()
	{
		return driver.findElement(lineitemsbaseqty);
	}
 public WebElement clicklineitemsbaseprice()
	{
		return driver.findElement(lineitemsbaseprice);
	}
 public WebElement clicklineitemsperitem()
	{
		return driver.findElement(lineitemsperitem);
	}
 //----------------------------------Discounts---------------------------------------------------------------------
 public WebElement clickdisaddrowbtn()
	{
		return driver.findElement(disaddrowbtn);
	}
 public WebElement clickdiscountcode()
	{
		return driver.findElement(discountcode);
	}
 public WebElement clickdisamount()
	{
		return driver.findElement(disamount);
	}
 //-----------------------------------Custom Charges---------------------------------------------------------
 public WebElement clickcustomaddrowbtn()
	{
		return driver.findElement(customaddrowbtn);
	}
 public WebElement clickchargedesc()
	{
		return driver.findElement(chargedesc);
	}
 public WebElement clickcustomamount()
	{
		return driver.findElement(customamount);
	}

}




