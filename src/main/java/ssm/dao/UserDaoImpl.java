package ssm.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import ssm.dao.mapper.UserMapper;
import ssm.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
    private UserMapper userMapper;
	
    @Autowired
	private PasswordEncoder passwordEncoder;
    
	@Override
	public User finOneUsername(String username) {
		return userMapper.findOneUsername(username);
	}
	@Override
	public void regist(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userMapper.regist(user);
	}

	

}
