package ssm.dao;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.dao.mapper.PersonalCenterMapper;
import ssm.entity.PersonalCenter;

public class PersonalCenterDaoImpl implements PersonalCenterDao {
	@Autowired
	private PersonalCenterMapper personalCenterMapper;

	@Override
	public PersonalCenter findOneConterDetails(Long id) {
		return personalCenterMapper.findOneConterDetails(id);
	}

	@Override
	public void createPersonalCenter(PersonalCenter personalCenter) {
		personalCenterMapper.createPersonalCenter(personalCenter);
	}

	@Override
	public void updatePersonalCenter(PersonalCenter personalCenter) {
		personalCenterMapper.updatePersonalCenter(personalCenter);
	}
	
	

}
