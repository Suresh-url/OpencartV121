package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLasename;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement phonenumber;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement passwordConfirm;
	@FindBy(xpath="//input[@id='input-newsletter']") WebElement clickSubscribe;
	@FindBy(xpath="//input[@name='agree']") WebElement clickAgree;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		txtLasename.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void phone(String number)
	{
		phonenumber.sendKeys(number);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void confirmPassword(String cpwd)
	{
		passwordConfirm.sendKeys(cpwd);
	}
	
	
	/*public void selectSubscribe()
	{
		clickSubscribe.click();
	}*/
	
	public void selectAgree()
	{
		//clickAgree.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", clickAgree);
	}
	
	public void selectContinue()
	{
		//sol1
		btnContinue.click();
		
		//sol2
		//btnContinue.submit();
		
		//sol3
		//Actions a= new Actions(driver);
		//a.moveToElement(btnContinue).click().perform();
		
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//sol5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//sol6
		//WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}
	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

}
