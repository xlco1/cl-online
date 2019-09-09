package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSettingsPO {
	public WebDriver driver;
	public AccountSettingsPO(WebDriver driver) {
		this.driver=driver;
	}
		By accountsdropdown = By.id("spnAccountProfileTitleBar");//account dropdown on top right
		By switchlink = By.xpath("//div[@class = 'link-text'][text() = 'Switch']");//Switch year link
		By switchselectyeardropdown = By.xpath("//Select[@name = 'season']");// select year dropdown in switch account modal
		By switchoptionyear2018 = By.xpath("//option[@value = '2018']");// select year 2017 from the dropdown
		By switchbtn = By.id("btnDoSwtichAccount");//switch button in the switch account modal
		By switchoptionyear2019 = By.xpath("//option[@value = '2019']");// select year 2018 from the dropdown
		By switchcancelbtn = By.id("btnCancelSwtichAccount");// Cancel button in the switch modal
		//-----------------------------------------------------------------------------------------------------
		By changepasswordlink = By.xpath("//div[@class = 'link-text'][text() = 'Change Password']");// change password link
		By currentpassword = By.id("txtOldPasswordMA");// current password textbox in change pswd modal
		By newpassword = By.id("txtNewPasswordMA");//new password textbox in change pswd modal
		By retypepassword = By.id("txtRetypePasswordMA");//re- type password text box in change pswd modal
		By cancelbtn = By.id("btnContinueToLoginActivateAcc");//cancel btn in the change pswd modal
		By changepasswordbtn = By.id("btnContinueToLoginActivateAcc");//change password btn in the change pswd modal
		//----------------------------------------------------------------------------------------------------------
		By toggletrainingmodelink = By.xpath("//div[@class = 'link-text'][text() = 'Toggle Training Mode']");//Toggle training mode link
		//----------------------------------------------------------------------------------------------------------------------
		By capturesignaturelink = By.xpath("//div[@class = 'link-text'][text() = 'Capture Signature']");// capture signature
		By capsigclearbtn  = By.xpath("//span[text() = 'Clear']");// clear btn in capture signature modal
		By capsigcancelbtn = By.xpath("//span[text() = 'Cancel']");// cancel btn in capture signature modal
		By capsigpreviewbtn = By.xpath("//span[text() = 'Preview']");// Preview btn in capture signature modal
		By capsigbox = By.xpath("//canvas[@width = '419']");//box to capture signature
		//--------------------------------------------------------------------------------------------------------------------
		By loginsettingslink = By.xpath("//div[@class = 'link-text'][text() = 'Login Preferences']");//Login settings
		By loginsettingstitle = By.id("simple-modal-title");// title of login settings modal
		By loginsettingscancelbtn = By.xpath("//span[text() = 'Cancel']");//cancel btn in login settings modal
		By loginsettingssavebtn = By.xpath("//span[text() = 'Save']");//Save button in login settings modal
		By loginsettingschkbox = By.id("startInterviewchk");// chk box in the login settings modal
		//---------------------------------------------------------------------------------------------------------------------
		
		public WebElement clickaccountsdropdown()
		{
			return driver.findElement(accountsdropdown);
		}
		public WebElement clickswitchlink()
		{
			return driver.findElement(switchlink);
		}
		public WebElement clickswitchselectyeardropdown()
		{
			return driver.findElement(switchselectyeardropdown);
		}
		public WebElement clickswitchoptionyear2018()
		{
			return driver.findElement(switchoptionyear2018);
		}
		public WebElement clickswitchbtn()
		{
			return driver.findElement(switchbtn);
		}
		public WebElement clickswitchoptionyear2019()
		{
			return driver.findElement(switchoptionyear2019);
		}
		public WebElement clickswitchcancelbtn()
		{
			return driver.findElement(switchcancelbtn);
		}
		
		//----------------------------------------------------------------------------------------------------------
		public WebElement clickchangepasswordlink()
		{
			return driver.findElement(changepasswordlink);
		}
		public WebElement clickcurrentpassword()
		{
			return driver.findElement(currentpassword);
		}
		public WebElement clicknewpassword()
		{
			return driver.findElement(newpassword);
		}
		public WebElement clickretypepassword()
		{
			return driver.findElement(retypepassword);
		}
		public WebElement clickcancelbtn()
		{
			return driver.findElement(cancelbtn);
		}
		public WebElement clickchangepasswordbtn()
		{
			return driver.findElement(changepasswordbtn);
		}
		
		//------------------------------------------------------------------------------------------------------	
		public WebElement clicktoggletrainingmodelink()
		{
			return driver.findElement(toggletrainingmodelink);
		}
		//----------------------------------------------------------------------------------------------------
		
		public WebElement clickcapturesignaturelink()
		{
			return driver.findElement(capturesignaturelink);
		}
		public WebElement clickcapsigclearbtn()
		{
			return driver.findElement(capsigclearbtn);
		}
		public WebElement clickcapsigcancelbtn()
		{
			return driver.findElement(capsigcancelbtn);
		}
		public WebElement clickcapsigpreviewbtn()
		{
			return driver.findElement(capsigpreviewbtn);
		}
		public WebElement clickcapsigbox()
		{
			return driver.findElement(capsigbox);
		}
		//--------------------------------------------------------------------------------------------------------
		
		public WebElement clickloginsettingslink()
		{
			return driver.findElement(loginsettingslink);
		}
		public WebElement clickloginsettingsgstitle()
		{
			return driver.findElement(loginsettingstitle);
		}
		public WebElement clickloginsetgscancelbtn()
		{
			return driver.findElement(loginsettingscancelbtn);
		}
		public WebElement clickloginsettingssavebtn()
		{
			return driver.findElement(loginsettingscancelbtn);
		}
		public WebElement clickloginsettingschkbox()
		{
			return driver.findElement(loginsettingschkbox);
		}
		//--------------------------------------------------------------------------------------------------------
}








