package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.dao.ProdctDao;
import ssm.entity.Product;

public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProdctDao productDao;

	@Override
	public void createProduct(Product product, String sortId) {
		productDao.createProduct(product,sortId);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product detail(Long id) {
		return productDao.findIdOneProduct(id);
	}
	
	

}
