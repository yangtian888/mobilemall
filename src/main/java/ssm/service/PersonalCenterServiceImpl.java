package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.dao.PersonalCenterDao;
import ssm.entity.PersonalCenter;

public class PersonalCenterServiceImpl implements PersonalCenterService {
	@Autowired
	private PersonalCenterDao personalCenterDao;

	@Override
	public PersonalCenter findOneConterDetails(long id) {
		return personalCenterDao.findOneConterDetails(id);
	}

	@Override
	public void createPersonalCenter(PersonalCenter personalCenter) {
		personalCenterDao.createPersonalCenter(personalCenter);
	}

	@Override
	public void updatePersonalCenter(PersonalCenter personalCenter) {
		personalCenterDao.updatePersonalCenter(personalCenter);
		
	}

	
	
	
}
