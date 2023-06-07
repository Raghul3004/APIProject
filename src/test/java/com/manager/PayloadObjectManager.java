package com.manager;

import com.address.AddressPayLoad;
import com.product.ProductSearchPayLoad;

public class PayloadObjectManager {

	private AddressPayLoad addresspayload;
	private ProductSearchPayLoad productpayload;



	public AddressPayLoad getAddresspayload() {
		return (addresspayload == null)? addresspayload = new AddressPayLoad() : addresspayload;
	}

	public ProductSearchPayLoad getProductpayload() {
		return (productpayload == null)? productpayload = new ProductSearchPayLoad() :productpayload;
	}

}
  