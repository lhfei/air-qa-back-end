package cn.lhfei.airqa.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
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
		
		String eamil=userModel.getEmail();
		//注册时设置用户名用邮箱前缀，作为临时用户名
		String userName=eamil.substring(0,eamil.lastIndexOf("@"));
		user.setUserName(userName);
		user.setEmail(eamil);
		user.setPassword(userModel.getPassword());
		user.setOrign(Constants.ORIGN_0);

		userDao.saveOrUpdate(user);
	}

	public void updateUserInfo(UserModel userModel){
		User user = userDao.findById(userModel.getUserId());
		if(user!=null){
			user.setUserName(userModel.getUserName());
			user.setIdCard(userModel.getIdCard());
			user.setMobile(userModel.getMobile());
			user.setProvince(userModel.getProvince());
			user.setCity(userModel.getCity());
			user.setCounty(userModel.getCounty());
			user.setZone(userModel.getZone());
			user.setHouseNumber(userModel.getHouseNumber());
			user.setGender(userModel.getGender());
			user.setUserAlias(userModel.getUserAlias());
			
			userDao.saveOrUpdate(user);
			//更新session中用户信息
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute(Constants.USER_SESSION, user);
		}
	}

	@Override
	public User findUser(String email) {

		Criterion criterion = Restrictions.eq("email", email);
		List<User> users = userDao.findByCriteria(criterion);
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public void delete(int userId) {
		User user = userDao.findById(userId);
		// 用户删除进行逻辑删除
		user.setDataStatus(Constants.STATUS_DELETE);
		userDao.saveOrUpdate(user);

	}
	
	@Autowired
	private IUserDao userDao;
}
