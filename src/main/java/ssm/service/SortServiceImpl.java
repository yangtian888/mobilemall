package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.dao.SortDao;
import ssm.entity.Sort;

public class SortServiceImpl implements SortService {
	@Autowired
	private SortDao sortDao;
	
	@Override
	public List<Sort> findAll() {
		return sortDao.findAll();
	}

}
