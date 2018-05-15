package ssm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.dao.mapper.SortMapper;
import ssm.entity.Sort;

public class SortDaoImpl implements SortDao{
	@Autowired
	private SortMapper sortMapper;
	
	@Override
	public List<Sort> findAll() {
		return sortMapper.findAll();
	}

}
