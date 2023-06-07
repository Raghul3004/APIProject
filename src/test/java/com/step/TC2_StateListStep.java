 package com.step;

import java.util.ArrayList;

import com.POJO.address.StateList_Output_POJO;
import com.base.BaseClass;
import com.endpoints.EndPoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC2_StateListStep extends BaseClass{

    public static Response response;
	
	@Given("User add headers for to StateList")
	public void user_add_headers_for_to_state_list() {
		addHeader("accept", "application/json");
		
	}

	@When("User send {string} request for StateList endpoint")
	public void user_send_request_for_state_list_endpoint(String string) {
		 response = addReqType("GET", EndPoints.STATELIST);
		int statusCode = getStatusCode(response);
		TC1_Login1Step.globalData.setStatusCode(statusCode);
		System.out.println(statusCode);
	}

	

	@Then("User verify StateList response message matches {string} and save State id")
	public void user_verify_state_list_response_message_matches_and_save_state_id(String expState) {

		
		StateList_Output_POJO output = response.as(StateList_Output_POJO.class);

		ArrayList<com.POJO.address.State> data = output.getData();

		for (com.POJO.address.State state : data) {

			String name = state.getName();
			

			if (name.equals(expState)) {
				int stateid = state.getId();
				String StateId = String.valueOf(stateid);
				TC1_Login1Step.globalData.setStateId(StateId);

				System.out.println(stateid);			
				break;
			}

		}
		
    
	}


}
