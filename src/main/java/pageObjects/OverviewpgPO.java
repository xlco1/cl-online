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
public class OverviewpgPO {
	
	public WebDriver driver;
	public OverviewpgPO(WebDriver driver) {
		this.driver=driver;
	}
	
	By overviewtab = By.id("spnTitleTab0");
	By officestab = By.id("spnTitleTab2");
	By viewbtn = By.xpath("//button[@id='btnViewOfficeList9']");//view btn for first office
	By devViewbtn =By.xpath("//button[@id='btnViewOfficeList0']");
	By preparersbtn = By.xpath("//div/span[@id='spnTitleTab1']");
	By Viewprepbtn = By.id("btnViewPreparerLoginID422");//btnViewPreparerLoginID428
	By devViewprepbtn = By.id("btnViewPreparerLoginID428");
			
	By Newprepbtn = By.id("btnAddPreparerPreparers");
	By taxreturnsbtn = By.xpath("//div/span[@id='spnTitleTab1']");
	By Newtaxreturnbtn = By.xpath("//button[@id='addReturnButton']");
	By Profiletitlebar = By.id("spnAccountProfileTitleBar");
	By Setupofficebtn = By.xpath("//div[contains(text(),'Setup (first office)')]");
	By Newpreparerbtn = By.xpath("//button[@id='btnNewPreparerManagerOverview']");
	//-------------------------------
	By onetaxretrn = By.id("btnOpenTaxReturnTRList9");
	By continueinataxrtn = By.id("btnContinueReturnProfile");
	By appticonbtn = By.id("btnSideBar1");//appointment icon left menu
	By newappointmentbtn = By.id("btnNewAppointmentAppointments");//newappointment button
	By apptfirstname =By.id("txtFirstNameApptModal");//firstname in create new appointment
	By apptlastname = By.id("txtLastNameApptModal");//lastname in create new appt
	By apptsubject = By.id("txtSubjectApptModal");//subject in create new appt
	By apptpreparername = By.id("txtPreparerApptModal");//preparer's name in create new appt
	By apptphonenumber = By.id("nfPhoneNumberApptModal");//phonenumber in create new appt
	By apptcomments = By.id("txtCommentsApptModal");//comments in create new appt
	By apptsendbtn = By.id("btnSendMessageModal");//sendbtn in create new appt
	By apptclosebtn = By.id("btnCloseMessageModal");//close button in create new appt
	By apptschconflictconfirmbtn = By.id("btnConfirmDialog");//confirm btn in scheduling conflit modal
	By apptschconflictcancelbtn = By.id("btnCancelDialog");//cancel btn in scheduling conflict modal
	By apptcreateddialog = By.id("confirm-delete-desc");//appointment created dialog
	By apptcreatedclosebtn = By.id("btnHideAppointmentCreatedModal");//appt created dialog close btn
	By apptupdatebtn = By.xpath("//button[2]/span[text() = 'Update']");//Update button in appt page
	By apptupdatemodalbtn = By.id("btnUpdateApptUpdateModal");//update button in the update dialog modal
	By apptsubjectupdatemodal = By.id("txtSubjectApptUpdateModal");//Subject in update appt dialog
	By apptphonenumupdatemodal = By.id("nfPhoneNumberApptUpdateModal");//phone num in update appt dialog
	By apptcommentupdatemodal = By.id("txtCommentsApptUpdateModal");//comments in update appt dialog
	By apptcloseupdatemodalbtn = By.id("btnHideAppointmentUpdatedModal");//close button in update appt dialog 
	By apptdeletebtn = By.xpath("//button[1]/span[text() = 'Delete']");//Delete button in appt page
	By apptdelconfirmbtn = By.id("btnConfirmDialog");//Delete appt confirm button
	By apptdelcancelbtn = By.id("btnCancelDialog");//Delete appt cancel button
	By apptclosedeletemodalbtn = By.id("btnHideAppointmentDeletedModal");//close button in appt delete dialog
	//-------------------------------------------------------------------------------------------------
	By notificonbtn = By.id("btnSideBar2");//Notifications icon in the left menu
	By notifnewmesgbtn = By.id("btnNewMessageMessages");//New Message button in the Notifications page
	By notifpreparerdropdown = By.xpath("//*[@id='newMessageModalMessages']/div[2]/div/form/div[1]/span/div[2]/div/div/div");//Preparer dropdown in Create mesg dialog
	By notifpreparerdpfirstlist = By.xpath("//li[text() = 'ONE THREE']");//First list item in preparer dp
	By notifsubject = By.id("txtSubjectNewMessage");//Subject in new mesg dialog
	By notifbody = By.id("txtBodyNewMessage");//Body in new mesg dialog
	By notifsendbtn = By.id("btnSendMessageModal");//Send button in create new mesg dialog
	By notifclosebtn = By.id("btnCloseMessageModal");//Close button in new mesg dialog
	By notifmesgsentdialog = By.id("confirm-delete-desc");//Message sent popup
	By notifdonebtn = By.id("btnHideMessageSentModal");//Done button in message successfully sent popup
	By notifreceivedbtn = By.xpath("//span[text()= 'Received']");//Received button in Notifications
	By notifreplybtn = By.xpath("//span[text()= 'Reply']");//Reply button in Notifications
	By notifdeletebtn = By.id("btnDeleteMessage");//Delete message button
	By notifdelmesgdialog = By.id("confirm-delete-message-desc");//Delete message popup
	By notifdelmesgdialogyesbtn = By.id("btnYesConfirmDeleteMessage");//Yes button in del mesg popup
	//-----------------------------------------------------------------------------------
	By chksiconbtn = By.id("btnSideBar3");//checks icon button on the left menu
	By chkstestprintbtn = By.xpath("//span[text() ' Test Print']");// Test Print btn in checks page
	By chkstestprintcancelbtn = By.className("cancel-button");// cancel btn  on test print dialog
	By chksfilterdropdown = By.id("selectbankdropdown");//Filter drpdwn to select bank in Ready to print page
	By chksfilterrepublicbank = By.xpath("//option[text() = 'Republic']");//Republic Bank option - filter dpdown
	By chksfiltertpgbank = By.xpath("//option[text() = 'TPG']");//TPG bank option - filter dpdown
	By chksprintbtn = By.xpath("//span[text() = 'Print']");//Print btn in the checks ready
	By chksprintcheckscancelbtn = By.xpath("//span[text() = 'Cancel']");//Cancel btn in Print checks pop up
	By chksprintchecksokbtn = By.xpath("//span[text()= 'Ok']");// OK btn in print checks pop up
	By chksprintchecksdialog = By.xpath("//h2[text()= 'Print Checks']");//Print Checks(text) from pop up 
	By chksreprintchecksdialog = By.xpath("//h2[text()= 'Check Reprint']");// Check Reprint(text) from pop up
	By chksselectallchkbox = By.xpath("//input[@type ='checkbox']");//select all check box
	By chkscheckregistertab = By.id("spnTitleTab1");// check Register tab
	//By chkschkregfirstchkbox = By.xpath(("//input[@type = 'Checkbox']")[1]);//first checkbox in checks register
	By chksreprintbtn = By.xpath("//span[text() = 'Reprint']");
	By chksthreedotsonhover = By.xpath("//img[@src = '/images/icons/menu_vertical.png']");//three dots on hover
	By chksvoidcheckbtn = By.xpath("//li[text()= 'Void Check']");//void check btn when clicked on three dots
	By chksvoidchkdialogcancelbtn = By.xpath("//span[text() = 'Cancel']");//cancel btn in void check popup
	//-------------------------------
	public WebElement clickoverview()
	{
		return driver.findElement(overviewtab);
	}
	public WebElement clickoffices()
	{
		return driver.findElement(officestab);
	}
	public WebElement clickviewbtn()
	{
		return driver.findElement(viewbtn);
	}
	public WebElement clickpreparersbtn()
	{
		return driver.findElement(preparersbtn);
	}
	public WebElement clickviewprepbtn()
	{
		return driver.findElement(Viewprepbtn);
	}
	public WebElement clickNewprepbtn()
	{
		return driver.findElement(Newprepbtn);
	}
	public WebElement clickTaxreturns()
	{
		return driver.findElement(taxreturnsbtn);
	}
	public WebElement clickNewTaxreturnsbtn()
	{
		return driver.findElement(Newtaxreturnbtn);
	}
	public WebElement clickProfiletitlebar()
	{
		return driver.findElement(Profiletitlebar);
	}
	public WebElement clickSetupofficebtn()
	{
		return driver.findElement(Setupofficebtn);
	}
	public WebElement clickNewpreparerbtn()
	{
		return driver.findElement(Newpreparerbtn);
	}
	//-------------------------------
	public WebElement clickonetaxretrn()
	{
		return driver.findElement(onetaxretrn);
	}
	public WebElement clickcontinueinataxrtn()
	{
		return driver.findElement(continueinataxrtn);
	}
	
	public WebElement clickdevViewbtn()
	{
		return driver.findElement(devViewbtn);
	}
	public WebElement clickdevViewprepbtn()
	{
		return driver.findElement(devViewprepbtn);
	}
	//-----------------------------------
	public WebElement clickappointmenticonbtn()
	{
		return driver.findElement(appticonbtn);
	}
	public WebElement clicknewappointmentbtn()
	{
		return driver.findElement(newappointmentbtn);
	
	}
	public WebElement clickapptfirstname()
	{
		return driver.findElement(apptfirstname);
	
	}
	public WebElement clickapptlastname()
	{
		return driver.findElement(apptlastname);
	}
	public WebElement clickapptsubject()
	{
		return driver.findElement(apptsubject);
		
	}
	public WebElement clickapptpreparesname()
	{
		return driver.findElement(apptpreparername);
		
	}
	public WebElement clickapptphonenumber()
	{
		return driver.findElement(apptphonenumber);
		
	}
	public WebElement clickapptcomments()
	{
		return driver.findElement(apptcomments);
		
	}
	public WebElement clickapptsendbtn()
	{
		return driver.findElement(apptsendbtn);
		
	}
	public WebElement clickapptclosebtn()
	{
		return driver.findElement(apptclosebtn);
		
	}
	public WebElement clickapptcreateddialog()
	{
		return driver.findElement(apptcreateddialog);
		
	}
	public WebElement clickapptcreatedclsoebtn()
	{
		return driver.findElement(apptcreatedclosebtn);
		
	}
	public WebElement clickapptupdatebtn()
	{
		return driver.findElement(apptupdatebtn);
		
	}
	public WebElement clickapptupdatemodalbtn()
	{
		return driver.findElement(apptupdatemodalbtn);
		
	}
	public WebElement clickapptsubjectupdatemodal()
	{
		return driver.findElement(apptsubjectupdatemodal);
		
	}
	public WebElement clickapptphonenumberupdatemodal()
	{
		return driver.findElement(apptphonenumupdatemodal);
		
	}
	public WebElement clickapptscommentupdatemodal()
	{
		return driver.findElement(apptcommentupdatemodal);
		
	}
	public WebElement clickapptcloseupdatemodalbtn()
	{
		return driver.findElement(apptcloseupdatemodalbtn);
		
	}
	public WebElement clickapptdeletebtn()
	{
		return driver.findElement(apptdeletebtn);
		
	}
	public WebElement clickapptclosedeletemodalbtn()
	{
		return driver.findElement(apptclosedeletemodalbtn);
		
	}
	public WebElement clickapptschconflictconfirmbtn()
	{
		return driver.findElement(apptschconflictconfirmbtn);
	}
	public WebElement clickapptschconflictcancelbtn()
	{
		return driver.findElement(apptschconflictcancelbtn);
	}
	public WebElement clickapptdelconfirmbtn()
	{
		return driver.findElement(apptdelconfirmbtn);
	}
	public WebElement clickapptdelcancelbtn()
	{
		return driver.findElement(apptdelcancelbtn);
	}
	//-----------------------------------

	public WebElement clicknotificonbtn()
	{
		return driver.findElement(notificonbtn);
		
	}
	public WebElement clicknotifnewmesgbtn()
	{
		return driver.findElement(notifnewmesgbtn);
		
	}
	public WebElement clicknotifpreparerdropdown()
	{
		return driver.findElement(notifpreparerdropdown);
		
	}
	public WebElement clicknotifpreparerdpfirstlist()
	{
		return driver.findElement(notifpreparerdpfirstlist);
	}
	public WebElement clicknotifsubject()
	{
		return driver.findElement(notifsubject);
		
	}
	public WebElement clicknotifbody()
	{
		return driver.findElement(notifbody);
		
	}
	public WebElement clicknotifsendbtn()
	{
		return driver.findElement(notifsendbtn);
		
	}
	public WebElement clicknotifclosebtn()
	{
		return driver.findElement(notifclosebtn);
	}
	public WebElement clicknotifmesgsentdialog()
	{
		return driver.findElement(notifmesgsentdialog);
	}
	
	public WebElement clicknotifdonebtn()
	{
		return driver.findElement(notifdonebtn);
	}
	public WebElement clicknotifreceivedbtn()
	{
		return driver.findElement(notifreceivedbtn);
	}
	
	public WebElement clicknotifreplybtn()
	{
		return driver.findElement(notifreplybtn);
	}
	public WebElement clicknotifdeletebtn()
	{
		return driver.findElement(notifdeletebtn);
	}
	public WebElement clicknotifdelmesgdialog()
	{
		return driver.findElement(notifdelmesgdialog);
	}
	public WebElement clicknotifdelmesgdialogyesbtn()
	{
		return driver.findElement(notifdelmesgdialogyesbtn);
	}
	
//--------------------------------------------------------------------------------------------
	
	public WebElement clickchksiconbtn()
	{
		return driver.findElement(chksiconbtn);
	}
	public WebElement clickchkstestprintbtn()
	{
		return driver.findElement(chkstestprintbtn);
	}
	public WebElement clickchkstestprintcancelbtn()
	{
		return driver.findElement(chkstestprintcancelbtn);
	}
	public WebElement clickchksfilterdropdown()
	{
		return driver.findElement(chksfilterdropdown);
	}
	public WebElement clickchksfilterrepublickbank()
	{
		return driver.findElement(chksfilterrepublicbank);
	}
	public WebElement clickchksfiltertpgbank()
	{
		return driver.findElement(chksfiltertpgbank);
	}
	public WebElement clickchksprintbtn()
	{
		return driver.findElement(chksprintbtn);
	}
	public WebElement clickchksprintcheckscancelbtn()
	{
		return driver.findElement(chksprintcheckscancelbtn);
	}
	public WebElement clickchksprintchecksokbtn()
	{
		return driver.findElement(chksprintchecksokbtn);
	}
	public WebElement clickchksprintchecksdialog()
	{
		return driver.findElement(chksprintchecksdialog);
	}
	public WebElement clickchksreprintchecksdialog()
	{
		return driver.findElement(chksreprintchecksdialog);
	}
	public WebElement clickchksselectallchkbox()
	{
		return driver.findElement(chksselectallchkbox);
	}
	public WebElement clickchkscheckregistertab()
	{
		return driver.findElement(chkscheckregistertab);
	}
	//public WebElement clickchkschkregfirstchkbox()
	//{
		//return driver.findElement(chkschkregfirstchkbox);
	//}
	public WebElement clickchksreprintbtn()
	{
		return driver.findElement(chksreprintbtn);
	}
	public WebElement clickchksthreedotsonhover()
	{
		return driver.findElement(chksthreedotsonhover);
	}
	public WebElement clickchksvoidcheckbtn()
	{
		return driver.findElement(chksvoidcheckbtn);
	}
	public WebElement clickchksvoidcheckdialogcancelbtn()
	{
		return driver.findElement(chksvoidchkdialogcancelbtn);
	}
}





