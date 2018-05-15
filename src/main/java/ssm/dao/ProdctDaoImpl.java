package ssm.dao;

import java.util.List;

import ssm.dao.mapper.productMapper;
import ssm.entity.Product;
import ssm.entity.Sort;

public class ProdctDaoImpl implements ProdctDao {

	@Override
	public void createProduct(Product product, String sortId) {
		Sort sort = new Sort();
		sort.setId(Long.parseLong(sortId));
		product.setSort(sort);
		productMapper.createPro(product);
	}

	@Override
	public List<Product> findAll() {
		return productMapper.findAll();
	}

	@Override
	public Product findIdOneProduct(Long id) {
		return productMapper.findIdOnePro(id);
	}

}
