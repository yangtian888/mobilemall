package ssm.service;

import java.util.List;

import ssm.entity.Product;

public interface ProductService {
	 void createProduct(Product product, String sortId);
	 
	 List<Product> findAll() ;
	 
	 Product detail(Long id);
	
}
