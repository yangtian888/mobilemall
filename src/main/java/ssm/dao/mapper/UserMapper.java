package ssm.dao.mapper;

import ssm.entity.User;

public interface UserMapper {

	User findOneUsername(String username);

	void regist(User user);

	

}
