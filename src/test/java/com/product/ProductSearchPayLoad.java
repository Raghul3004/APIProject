package com.product;

import com.POJO.Product.SearchProduct_Input_POJO;

/**
 * @author ashok
 * @see this class perform payload for product search
 *
 */
public class ProductSearchPayLoad {
	
	/**
	 * @author ashok
	 * @param text - (Nuts)
	 * @return as input_POJO
	 */
	public SearchProduct_Input_POJO SearchProduct_Input_POJO(String text) {
		SearchProduct_Input_POJO input_POJO = new SearchProduct_Input_POJO("Nuts");
		return input_POJO;
	}



}
