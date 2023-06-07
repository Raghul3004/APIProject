package com.POJO.address;

import java.util.ArrayList;

/**
 * @author raghul
 * @see this class used to get and set values from response body
 * 
 *
 */
public class UserAddress_Output_POJO {
	
	private int status;
	private String message;
	private ArrayList<Datum> data;
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Datum> getData() {
		return data;
	}
	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}

}
