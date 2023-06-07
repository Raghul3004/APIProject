package com.step;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.POJO.address.AddAddress_Input_POJO;
import com.POJO.address.AddAddress_Output_POJO;
import com.POJO.address.DeleteAddress_Input_POJO;
import com.POJO.address.DeleteAddress_Output_POJO;
import com.POJO.address.UpdateAddress_Input_POJO;
import com.POJO.address.UpdateAddress_Output_POJO;
import com.POJO.address.UserAddress_Output_POJO;
import com.address.AddressPayLoad;
import com.base.BaseClass;
import com.endpoints.EndPoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass {

	Response response;

	@Given("User add header and Bearer Authorization for accessing address endpoint")
	public void user_add_header_and_bearer_authorization_for_accessing_address_endpoint() {

		List<Header> ListHeader = new ArrayList<Header>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_Login1Step.globalData.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		ListHeader.add(h1);
		ListHeader.add(h2);
		ListHeader.add(h3);

		Headers head = new Headers(ListHeader);
		addHeaders(head);

	}

	@When("User add request body for add new address  {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_add_request_body_for_add_new_address_and(String string, String string2, String string3,
			String string4, String string5, String string6, String string7, String string8, String string9,
			String string10) {

		AddressPayLoad ad = new AddressPayLoad();
		AddAddress_Input_POJO addAddressPayload = ad.addAddressPayload(string, string2, string3, string4,
				Integer.parseInt(TC1_Login1Step.globalData.getStateId()),
				Integer.parseInt(TC1_Login1Step.globalData.getCityId()), Integer.parseInt(string7), string8, string9,
				string10);

		addBody(addAddressPayload);

	}

	@When("User send {string} request for addUserAddress endpoint")
	public void user_send_request_for_add_user_address_endpoint(String reqType) {

		response = addReqType(reqType, EndPoints.ADDADDRESS);

	}

	@Then("User verify the addUserAddress response message matches {string}")
	public void user_verify_the_add_user_address_response_message_matches(String string) {
		AddAddress_Output_POJO as = response.as(AddAddress_Output_POJO.class);
		System.out.println(as.getStatus());
		System.out.println(as.getMessage());
		String addressId = String.valueOf(as.getAddress_id());
		TC1_Login1Step.globalData.setAddress_Id(addressId);
		System.out.println(addressId);
		Assert.assertEquals(string, as.getMessage(), "Address added successfully");

	}

	@When("User add request body for add update address  {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_add_request_body_for_add_update_address_and(String string, String string2, String string3,
			String string4, String string5, String string6, String string7, String string8, String string9,
			String string10) {

		UpdateAddress_Input_POJO updateAddress_Input_POJO = new UpdateAddress_Input_POJO(
				TC1_Login1Step.globalData.getAddress_Id(), string, string2, string3, string4,
				Integer.parseInt(TC1_Login1Step.globalData.getStateId()),
				Integer.parseInt(TC1_Login1Step.globalData.getCityId()), Integer.parseInt(string7), string8, string9,
				string10);

		addBody(updateAddress_Input_POJO);

	}

	@When("User send {string} request for updateUserAddress endpoint")
	public void user_send_request_for_update_user_address_endpoint(String reqType) {

		response = addReqType(reqType, EndPoints.UPDATEADDRESS);

		UpdateAddress_Output_POJO ak = response.as(UpdateAddress_Output_POJO.class);
		System.out.println(ak.getMessage());
	}

	@Then("User verify the updateUserAddress response message matches {string}")
	public void user_verify_the_update_user_address_response_message_matches(String string) {
		UpdateAddress_Output_POJO ak = response.as(UpdateAddress_Output_POJO.class);
		System.out.println(ak.getMessage());
		Assert.assertEquals(string, ak.getMessage(), "Address updated successfully");

	}

	@When("User add request body for delete address  {string}")
	public void user_add_request_body_for_delete_address(String string) {
		DeleteAddress_Input_POJO delete = new DeleteAddress_Input_POJO(TC1_Login1Step.globalData.getAddress_Id());

		addBody(delete);

	}

	@When("User send {string} request for deleteUserAddress endpoint")
	public void user_send_request_for_delete_user_address_endpoint(String string) {

		response = addReqType("DELETE", EndPoints.DELETEADDRESS);
	}

	@Then("User verify the  response message matches {string}")
	public void user_verify_the_response_message_matches(String expmessage) {
		DeleteAddress_Output_POJO output = response.as(DeleteAddress_Output_POJO.class);
		String message = output.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, expmessage, "Address Deleted successfully");

	}

	@Then("User verify the GetUserAddress response message matches {string}")
	public void user_verify_the_get_user_address_response_message_matches(String expMsg) {

		UserAddress_Output_POJO getAddDetails = response.as(UserAddress_Output_POJO.class);

		String message = getAddDetails.getMessage();
		Assert.assertEquals(message, expMsg, "OK");

	}

	@Given("User send {string} request for getUserAddress endpoint")
	public void user_send_request_for_get_user_address_endpoint(String string) {
		response = addReqType(string, EndPoints.USERADDRESS);

	}

}
