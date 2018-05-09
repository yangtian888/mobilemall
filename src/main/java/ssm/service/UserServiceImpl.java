package ssm.service;

import org.springframework.stereotype.Service;

import ssm.dao.UserDao;
import ssm.entity.User;
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}


}
