/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ssreenivasan
 * changd ids
 */
public class FRM1040PO {
	
	public WebDriver driver;
	public FRM1040PO(WebDriver driver) {
		this.driver=driver;
	}
	
	By frm1040btn = By.xpath("//div[@id='US0101']");
	By preptype = By.id("SELF00");
	
	
	public WebElement clkFrm1040btn()
	{
		return driver.findElement(frm1040btn);
	}
	public WebElement getPreptype()
	{
		return driver.findElement(preptype);
	}
	
}
