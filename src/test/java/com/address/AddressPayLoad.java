package com.address;

import com.POJO.address.AddAddress_Input_POJO;
import com.POJO.address.UpdateAddress_Input_POJO;

public class AddressPayLoad {
	public  AddAddress_Input_POJO addAddressPayload(String first_name, String last_name, String mobile, String apartment, int state,
			int city, int country, String zipcode, String address, String address_type) {
		
		AddAddress_Input_POJO addAddress_Input_POJO = new AddAddress_Input_POJO(first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		
		return addAddress_Input_POJO;
				
				
		
	}
	public UpdateAddress_Input_POJO updateAddressPayload(String address_id, String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {
		
		UpdateAddress_Input_POJO address_Input_POJO = new UpdateAddress_Input_POJO(address_id, first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		
		return address_Input_POJO;
	}



}
