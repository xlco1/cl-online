/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ssreenivasan
 * changed ids except 1
 */
public class addaforminaReturnPO {
	
	public WebDriver driver;
	public addaforminaReturnPO(WebDriver driver) {
		this.driver=driver;
	}
	
	By searchAForm = By.id("txtFilterDefaultAddFormModal");
	By frmw2 = By.xpath("//td[contains(text(),'Wage and Tax Statement')]");
			//By.id("US02row0");
			//By.xpath("//td[contains(text(),'Wage and Tax Statement')]");
	By frm8879 = By.xpath("//tbody/tr/th[contains(text(),'FRM 8879')]");
			//By.id("US99row0");
			//By.xpath("//tbody/tr/th[contains(text(),'FRM 8879')]");
	By frmschE = By.id("US13row0");	//sche
	By frm1099MISC = By.id("USG6row0"); //sche
	By frmschC = By.xpath("//tr[@id='US09row0']");
			//By.id("US09row0"); //sche
	By continuebtnAddanewform = By.id("btnSubflagContinueAddFormModal");//----check id
	By AddbtnAddanewform = By.id("btnAddFormAddFormModal");
	By cancelbtnAddanewform = By.id("btnCancelAddFormModal");
	
	public WebElement clksearchAForm()
	{
		return driver.findElement(searchAForm);
	}
	public WebElement clkfrmw2()
	{
		return driver.findElement(frmw2);
	}
	public WebElement clkfrm8879()
	{
		return driver.findElement(frm8879);
	}
	public WebElement clkcontinuebtnAddanewform()
	{
		return driver.findElement(continuebtnAddanewform);
	}
	public WebElement clkAddbtnAddanewform()
	{
		return driver.findElement(AddbtnAddanewform);
	}
	public WebElement clkcancelbtnAddanewform()
	{
		return driver.findElement(cancelbtnAddanewform);
	}
	//------------------sche
	public WebElement clkfrmschE()
	{
		return driver.findElement(frmschE);
	}
	public WebElement clkfrm1099MISC()
	{
		return driver.findElement(frm1099MISC);
	}
	public WebElement clkfrmschC()
	{
		return driver.findElement(frmschC);
	}
	
	
	
}
