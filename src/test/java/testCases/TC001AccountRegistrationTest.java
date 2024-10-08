package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001AccountRegistrationTest extends BaseClass {
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("*****Starting TC001AccountRegistrationTest******");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on Myaccount link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.phone(randomNumber());
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.confirmPassword(password);
		//regpage.selectSubscribe();
		regpage.selectAgree();
		regpage.selectContinue();
		
		logger.info("Validating expected message...");
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("*****Finished TC001AccountRegistrationTest******");
	}
	
}

