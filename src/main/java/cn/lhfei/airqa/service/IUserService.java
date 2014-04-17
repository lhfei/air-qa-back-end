package cn.lhfei.airqa.service;

import cn.lhfei.airqa.entity.User;
import cn.lhfei.airqa.web.model.UserModel;

public interface IUserService {
	/**
	 * 用户注册
	 * 
	 * @param user
	 */
	void create(UserModel userModel);

	/**
	 * 通过用户名，或者用户邮箱查找是否存在用户
	 * @param emailOrName
	 * @return
	 */
	User findUser(String email);
}
