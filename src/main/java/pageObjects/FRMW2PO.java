/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ssreenivasan
 *changed ids
 */
public class FRMW2PO {
	
	public WebDriver driver;
	public FRMW2PO(WebDriver driver) {
		this.driver=driver;
	}
	
	By wages = By.id("012000");
	By Fedtax = By.id("013000");
	By ein = By.id("004000");
	By Employername = By.id("005000");
	By Empaddrs = By.id("006000");
	By Empcity = By.id("007000");
	By Empstate = By.id("007300");
	By Empzip = By.id("007500");
	
	
	public WebElement getwages()
	{
		return driver.findElement(wages);
	}
	public WebElement getFedtax()
	{
		return driver.findElement(Fedtax);
	}
	public WebElement getein()
	{
		return driver.findElement(ein);
	}
	public WebElement getEmployername()
	{
		return driver.findElement(Employername);
	}
	public WebElement getEmpaddrs()
	{
		return driver.findElement(Empaddrs);
	}
	public WebElement getEmpcity()
	{
		return driver.findElement(Empcity);
	}
	public WebElement getEmpstate()
	{
		return driver.findElement(Empstate);
	}
	public WebElement getEmpzip()
	{
		return driver.findElement(Empzip);
	}
	
	
}
