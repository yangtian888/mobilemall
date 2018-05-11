package ssm.dao;

import ssm.entity.User;

public interface UserDao {

	User finOneUsername(String username);

	void regist(User user);

	

	

}
