package cn.lhfei.airqa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhfei.airqa.dao.IUserDao;
import cn.lhfei.airqa.entity.User;
import cn.lhfei.airqa.service.IUserService;
import cn.lhfei.airqa.web.model.UserModel;

@Service
public class UserService implements IUserService {

	@Override
	public void create(UserModel userModel) {
		
		User user = new User();
		user.setUserName(userModel.getName());
		user.setEmail(userModel.getEmail());
		user.setPassword(userModel.getPassword());

		userDao.saveOrUpdate(user);
	}

	@Autowired
	private IUserDao userDao;

}
