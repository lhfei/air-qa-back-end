package cn.lhfei.airqa.common;

public class Constants {
	/**
	 * user放入session中的key
	 */
	public final static String USER_SESSION = "user";
	/**
	 * 逻辑删除标识
	 */
	public final static int STATUS_DELETE = 1;

	/**
	 * 用户启用状态
	 */
	public final static int USER_ACTIVITY_STATUS_ON = 0;
	/**
	 * 用户禁用状态
	 */
	public final static int USER_ACTIVITY_STATUS_OFF = 1;
	
	/**
	 * 用户性别女
	 */
	public final static int USER_SEX_female=0;
	public final static int USER_SEX_main=0;

	/**
	 * 用户信息来源：系统注册用户
	 */
	public final static int ORIGN_0 = 0;

	/**
	 * 第三方来源数据提供者
	 */
	public final static String PRIVODER = "00";
	/**
	 * 第三方数据提供者组织机构编码，默认值‘00’:系统内部数据
	 */
	public final static String ORIGN_CODE = "00";

	/**
	 * 外部导入用户
	 */
	public final static int ORIGN_1 = 1;
}
