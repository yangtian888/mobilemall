package ssm.service;

import ssm.entity.User;

public interface UserService {

	void regist(User user);

	void updateEmail(User curUser);

	void updatePassword(User curUser, String userpassword);

	

}
