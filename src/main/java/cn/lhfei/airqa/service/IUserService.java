package cn.lhfei.airqa.service;

import cn.lhfei.airqa.web.model.UserModel;

public interface IUserService {
	/**
	 * 用户注册
	 * @param user
	 */
	void create(UserModel userModel);
}
