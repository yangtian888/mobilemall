package ssm.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssm.dao.mapper.UserMapper;
import ssm.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
    private UserMapper userMapper;
    
	public UserDaoImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	

}
