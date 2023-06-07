//package com.logics;
//
//import java.util.ArrayList;
//
//
//import com.POJO.address.StateList_Output_POJO;
//import com.step.TC2_StateListStep;
//import com.step.TC3_CityListStep;
//
//public class LogicMethods  {
//
//	 static String StateId;
//	static String CityID;
//	public static String getStateId() {
//		
//		
//	     StateList_Output_POJO output = TC2_StateListStep.response.as(StateList_Output_POJO.class);
//
//		ArrayList<com.POJO.address.State> data = output.getData();
//
//		for (com.POJO.address.State state : data) {
//
//			String name = state.getName();
//
//			if (name.equals("Tamil Nadu")) {
//				int stateid = state.getId();
//				StateId = String.valueOf(stateid);
//
//				break;
//			}
//
//		}
//		
//		return StateId;
//	}
//	
//	
//	public static String getCityId() {
//		
//		
//		com.POJO.address.CityList_Output_POJO CityList = TC3_CityListStep.response.as(com.POJO.address.CityList_Output_POJO.class);
//		
//		ArrayList<com.POJO.address.City> city = CityList.getData();
//		for (com.POJO.address.City citylist : city) {
//			String name = citylist.getName();
//			if (name.equals("Kallakkurichi")) {
//			int	Cityid = citylist.getId();
//				 CityID = String.valueOf(Cityid);
//				break;
//			}
//
//		}
//		return CityID;
//	}
//	
//	
//	
//	
//}
