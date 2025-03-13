package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSettingsPO {
	public WebDriver driver;
	public AccountSettingsPO(WebDriver driver) {
		this.driver=driver;
	}
		By accountsdropdown = By.id("spnProfileHeaderBar");//account dropdown on top right
		By switchlink = By.id("btnSwitchTaxYear");
				//xpath("//div[@class = 'link-text'][text() = 'Switch']");//Switch year link
		By switchselectyeardropdown = By.xpath("//Select[@name = 'season']");// select year dropdown in switch account modal
		By switchoptionyear2017 = By.xpath("//option[@value = '2018']");// select year 2017 from the dropdown
		By switchbtn = By.id("btnDoSwtichAccount");//switch button in the switch account modal
		By switchoptionyear2018 = By.xpath("//option[@value = '2019']");// select year 2018 from the dropdown
		By switchoptionyear2019 = By.xpath("//option[@value = '2020']");//select year 2020 from the dropdown
		By switchoptionyear2020 = By.xpath("//option[@value = '2020']");
		By switchoptionyear2021 = By.xpath("//option[@value = '2021']");
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
		By capturesignaturelink = By.xpath("//div[@class = 'link-text'][text() = 'Capture ERO Signature']");// capture signature
		By capsigclearbtn  = By.xpath("//span[text() = 'Clear']");// clear btn in capture signature modal
		By capsigcancelbtn = By.xpath("//span[text() = 'Cancel']");// cancel btn in capture signature modal
		By capsigacceptbtn = By.xpath("//span[text() = 'Accept']");// Preview btn in capture signature modal
		By capsigbox = By.xpath("//canvas[@width = '476']");//box to capture signature
		By updateCaptureSign = By.id("btnAcceptSignDoc");//updatessignature button jan20
		By okbtninSignUpdated = By.id("btnConfirmDialog");//ok in signature updated
		//--------------------------------------------------------------------------------------------------------------------
		By loginsettingslink = By.xpath("//div[@class = 'link-text'][text() = 'Login Preferences']");//Login settings
		By loginsettingstitle = By.id("simple-modal-title");// title of login settings modal
		By loginsettingscancelbtn = By.xpath("//span[text() = 'Cancel']");//cancel btn in login settings modal
		By loginsettingssavebtn = By.xpath("//span[text() = 'Save']");//Save button in login settings modal
		By loginsettingschkbox = By.id("startInterviewchk");// chk box in the login settings modal
		//---------------------------------------------------------------------------------------------------------------------
		By setupinsettings = By.xpath("//div[@id='btnSetup']");
				//("//a[text()='Setup']") ;
		By createnewLogin = By.xpath("//button[@id='btnAddNewLoginSetup']");
				//By.id("btnAddNewLoginSetup"); 
		By usernameinaddnewlogin = By.id("txtLoginIDAddNewLogin");
		By displayNameinAddnewlogin = By.id("txtLoginNameAddNewLogin");
		By emailinAddnewlogin = By.id("txtEmailAddressAddNewLogin");
		By confirmemailinAddnewlogin = By.id("txtConfirmEmailAddressAddNewLogin");
		By accesslevelinAddnewlogin = By.id("ddlAccessLevelAddNewLogin");
		By prepinaccesslevel = By.xpath("//option[text()='Preparer/Login']");
		By saveinAddnewlogin = By.id("btnAddAddNewLogin");
		By doneincreateloginerror = By.id("btnHideSettingsError");
		By cancelinAddnewlogin = By.id("btnCancelAddNewLogin");
		By closebtninSettingsProfile = By.id("btnSaveAndCloseSettingsProfile");
		//---------------------------------------
		By helpbtn =By.id("imgHelpTitleBar");
		By gettoknowthisLink=By.xpath("//*[contains(text(),'Get')]");
		By startedNextbtn = By.xpath("//span[contains(text(),'Next')]");
		/*By dashboardNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By reminderNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By messagingNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By navigationpaneNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By navigatonbarNextbtn= By.xpath("//span[contains(text(),'Next')]");
		By overviewNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By accountsNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By officesNextbtn =By.xpath("//span[contains(text(),'Next')]");
		By taxretrnsNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By searchNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By exitwindowNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By helpNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By closemenuNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By persprofileNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By openmenuNextbtn = By.xpath("//span[contains(text(),'Next')]"); */
		By donebtninHelp = By.xpath("//span[contains(text(),'Done')]");
		//ssbtopbar search 
		By searchbtn = By.id("imgSrchTitleBar");
		By cancelinsearchbtn = By.id("btnSearchBarCancel");
		
		
				
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
		public WebElement clickswitchoptionyear2017()
		{
			return driver.findElement(switchoptionyear2017);
		}
		public WebElement clickswitchbtn()
		{
			return driver.findElement(switchbtn);
		}
		public WebElement clickswitchoptionyear2018()
		{
			return driver.findElement(switchoptionyear2018);
		}
		public WebElement clickswitchoptionyear2019()
		{
			return driver.findElement(switchoptionyear2019);
		}
		public WebElement clickswitchoptionyear2020() {
			// TODO Auto-generated method stub
			return driver.findElement(switchoptionyear2020);
		}
		public WebElement clickswitchoptionyear2021() {
			// TODO Auto-generated method stub
			return driver.findElement(switchoptionyear2021);
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
		public WebElement clickcapsigacceptbtn()
		{
			return driver.findElement(capsigacceptbtn);
		}
		public WebElement clickcapsigbox()
		{
			return driver.findElement(capsigbox);
		}
		public WebElement clickupdateCaptureSign()
		{
			return driver.findElement(updateCaptureSign);
		}
		public WebElement clickokbtninSignUpdated()
		{
			return driver.findElement(okbtninSignUpdated);
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
		
		public WebElement clicksetupinsettings()
		{
			return driver.findElement(setupinsettings);
		}
		public WebElement clickcreatenewLogin()
		{
			return driver.findElement(createnewLogin);
		}
		public WebElement getusernameinaddnewlogin()
		{
			return driver.findElement(usernameinaddnewlogin);
		}
		public WebElement getdisplayNameinAddnewlogin()
		{
			return driver.findElement(displayNameinAddnewlogin);
		}
		public WebElement getemailinAddnewlogin()
		{
			return driver.findElement(emailinAddnewlogin);
		}
		public WebElement getconfirmemailinAddnewlogin()
		{
			return driver.findElement(confirmemailinAddnewlogin);
		}
		public WebElement getaccesslevelinAddnewlogin()
		{
			return driver.findElement(accesslevelinAddnewlogin);
		}
		public WebElement getprepinaccesslevel()
		{
			return driver.findElement(prepinaccesslevel);
		}
		public WebElement getsaveinAddnewlogin()
		{
			return driver.findElement(saveinAddnewlogin);
		} 
		public WebElement clikdoneincreateloginerror()
		{
			return driver.findElement(doneincreateloginerror);
		} 
		public WebElement clikcancelinAddnewlogin()
		{
			return driver.findElement(cancelinAddnewlogin);
		}
		
		public WebElement clikclosebtninSettingsProfile()
		{
			return driver.findElement(closebtninSettingsProfile);
		} 
		//----help
		
		public WebElement clikhelpbtn()
		{
			return driver.findElement(helpbtn);
		} 
		public WebElement clikgettoknowthisLink()
		{
			return driver.findElement(gettoknowthisLink);
		}
		public WebElement clikstartedNextbtn()
		{
			return driver.findElement(startedNextbtn);
		}
		public WebElement clikdonebtninHelp()
		{
			return driver.findElement(donebtninHelp);
		}
		// ---searchinssb
		public WebElement cliksearchbtn()
		{
			return driver.findElement(searchbtn);
		}
		public WebElement clikcancelinsearchbtn()
		{
			return driver.findElement(cancelinsearchbtn);
		}
		
		
		
}








