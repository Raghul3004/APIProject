
package com.step;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

  Scenario scenario;
	@After
	public void afterScenario(Scenario sc) {
		
		scenario =  sc;
		scenario.log(getAsPreetyString(response));
		
		
	}
	
	
}
