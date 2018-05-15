package ssm.dao;

import java.util.List;

import ssm.entity.Product;

public interface ProdctDao {

	void createProduct(Product product, String sortId);

	List<Product> findAll();

	Product findIdOneProduct(Long id);

}
