package com.framework.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.basetest.TestBase;
import com.framework.contants.VariableConstants;
import com.framework.frameworkutils.TestUtils;
import com.framework.pompage.LoginPage;

public class TC_001_Validate_Login_Page extends TestBase {
	
	
	
	@Test(dataProvider = "getData")
	public void tC_001_Validate_Login_Page(Hashtable<String, String> dataa) throws Exception {
		
		openBrowser(VariableConstants.browserName);
		navigateURL(VariableConstants.URL);
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.set_email(dataa.get("Email"));
		loginpage.set_password(dataa.get("Password"));
		loginpage.clickOnLogin();
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return TestUtils.getData(this.getClass().getSimpleName(), xls);
	}

}