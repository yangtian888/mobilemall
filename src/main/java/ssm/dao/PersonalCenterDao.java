package ssm.dao;

import ssm.entity.PersonalCenter;

public interface PersonalCenterDao {

	PersonalCenter findOneConterDetails(Long id);

	void createPersonalCenter(PersonalCenter personalCenter);

	void updatePersonalCenter(PersonalCenter personalCenter);

}
