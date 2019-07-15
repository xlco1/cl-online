/**
 * 
 */
package clo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.LogincloPO;
import resources.Base;

/**
 * @author ssreenivasan
 *
 */
public class LoginClo extends Base {
	
	public WebDriver driver;

	@Test
	public WebDriver openHomePage() throws IOException
	{
		//*************change this before running
		//driver = invokeBrowser();
		driver.get("https://qa.crosslinkonline.com/#");
		//driver.get(prop.getProperty("url"));
		//create a obj for logincloPO 
		LogincloPO lp = new LogincloPO(driver);
		lp.getusername().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.clickLogin().click();
		lp.clicksecLogin().click();
		lp.clickmarkaspublic().click();
		lp.clickthrdcontbtn().click();
		lp.clickcontbtnIRS().click();
		lp.clickcanceltour().click();
		return driver;
	
		
	}
	
	
	

}
