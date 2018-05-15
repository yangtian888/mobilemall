package ssm.service;

import ssm.entity.PersonalCenter;

public interface PersonalCenterService {

	  PersonalCenter  findOneConterDetails(long id) ;
	  
	  void createPersonalCenter(PersonalCenter personalCenter);

	  void updatePersonalCenter(PersonalCenter personalCenter);
	

}
