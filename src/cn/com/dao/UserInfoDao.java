package cn.com.dao;

import java.util.List;

import cn.com.entity.UserInfo;

public interface UserInfoDao {

	public List<UserInfo> getAll(String sql);
	
	public int addUserInfo(String sql,UserInfo userInfo);
	/**
	 * 
	* @Title: getMaxId 
	* @Description: 找到最大的主键
	* @param @param sql
	* @param @return
	* @return int
	* @throws
	 */
	public int getMaxId(String sql);
	
	public UserInfo getUserInfoById(String sql,int id);
	
	public int delUserInfo(String sql,int id);
	
	public int updUserInfo(String sql,UserInfo user);
	
	public UserInfo login(String sql,UserInfo user);
}
