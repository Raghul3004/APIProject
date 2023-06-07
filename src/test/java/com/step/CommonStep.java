package com.step;

import org.testng.Assert;

import com.base.BaseClass;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass {
	
	
	@Then("User verify the Status code is {int}")
	public void user_verify_status_code_is(int expStatusCode) {
	int actStatucCode = TC1_Login1Step.	globalData.setStatusCode(response.getStatusCode());		
	Assert.assertEquals(expStatusCode, actStatucCode,"Verify Status Code");
		
		

	
	}




}
