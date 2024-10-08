package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC003_LoginDDT extends BaseClass{
	
	@Test
	public void verify_loginDDT()
	{
		//HomePagef
		HomePage hp= new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
				
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPasssword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
	}

}
