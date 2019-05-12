package com.ecom.service;

import java.util.List;

import com.ecom.model.Product;

public interface ProductService {
	
	public void saveProduct(Product c);
	
	public void deleteProduct(int ProductID);
	
	public void updateProduct(Product c);
	
	public List <Product> getAllProducts();
	
	public Product findbyName(String name);

}
