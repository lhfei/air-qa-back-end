package cn.lhfei.airqa.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhfei.airqa.common.Constants;
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
		user.setOrign(Constants.ORIGN_0);

		userDao.saveOrUpdate(user);
	}

	@Autowired
	private IUserDao userDao;

	@Override
	public User findUser(String email) {

		Criterion criterion = Restrictions.eq("email", email);
		List<User> users = userDao.findByCriteria(criterion);
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
}
