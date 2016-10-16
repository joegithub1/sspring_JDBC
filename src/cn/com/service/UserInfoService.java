package cn.com.service;

import java.util.List;

import cn.com.entity.UserInfo;

public interface UserInfoService {

	/**
	 * 
	* @Title: getAll 
	* @Description: 全查
	* @param @return
	* @return List<UserInfo>
	* @throws
	 */
	public List<UserInfo> getAll();
	/**
	 * 
	* @Title: addUserInfo 
	* @Description: 添加
	* @param @param userInfo
	* @param @return
	* @return int
	* @throws
	 */
	public int addUserInfo(UserInfo userInfo);
	
	public UserInfo getUserInfoById(int id);
	
	public int delUserInfo(int id);
	
	public int updUserInfo(UserInfo user);
	
	public UserInfo login(UserInfo user);
}
