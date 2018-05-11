package ssm.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ssm.dao.UserDao;
import ssm.entity.User;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
	private UserDao userDao;
    
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void regist(User user) {
		User user1 = userDao.finOneUsername(user.getUsername());
		if (user1==null) {
			userDao.regist(user);
		}else
			throw new RuntimeException("用户名已存在");
	}
    public UserDetails loadUserByUsername(String username){
		User user = userDao.finOneUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException(username);
		}
    	UserDetailsImpl userDetailsImpl = new UserDetailsImpl(user);
    	
    	return userDetailsImpl;
    }
    
}

class UserDetailsImpl extends org.springframework.security.core.userdetails.User{
	private static final long serialVersionUID = 1L;
	private User user;
	public UserDetailsImpl(User user) {
		super(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	
}
