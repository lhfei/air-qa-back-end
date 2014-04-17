package cn.lhfei.airqa.common;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhfei.airqa.entity.User;
import cn.lhfei.airqa.service.IUserService;

@Service("myRealm")
public class MyRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {

		String username = (String) principals.fromRealm(getName()).iterator()
				.next();
		if (!StringUtils.isEmpty(username)) {
			User user = userService.findUser(username);
			if (user != null) {
				logger.info("授予" + user.getUserName() + "资源权限");
				SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
				// simpleAuthorInfo.addRole(user.getRole());
				return simpleAuthorInfo;
			}
		}

		return null;

	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

		String username = token.getUsername();
		String password = String.valueOf(token.getPassword());
		if (!StringUtils.isEmpty(username)) {
			User user = userService.findUser(username);
			if (user != null) {
				if (StringUtils.equals(password, user.getPassword())) {

					Session session = SecurityUtils.getSubject().getSession();
					session.setAttribute(Constants.USER_SESSION, user);
					AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
							user.getEmail(), user.getPassword(), this.getName());
					logger.info(user.getUserName() + "认证成功");
					return authcInfo;
				} else {
					return null;
				}

			} else {
				return null;
			}
		}

		// 没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
		return null;

	}

	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	@Autowired
	private IUserService userService;

}
