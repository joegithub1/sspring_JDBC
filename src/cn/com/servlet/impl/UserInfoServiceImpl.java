package cn.com.servlet.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.dao.UserInfoDao;
import cn.com.dao.impl.UserInfoDaoImpl;
import cn.com.entity.UserInfo;
import cn.com.service.UserInfoService;
/**
 * 
* @ClassName: UserInfoServiceImpl 
* @Description: userInfo实现类
* @author  huangjian
* @date 2016年10月8日 上午11:06:40 
*
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoDaoImpl userInfoDaoImpl;
	public List<UserInfo> list=null;
	/**
	 * 用户表全查  user_info与表名对应（区分大小写）
	 */
	@Override
	public List<UserInfo> getAll() {
		String sql="select * from user_info order by user_id";
		list = userInfoDaoImpl.getAll(sql);
		return list;
	}

	@Override
	public int addUserInfo(UserInfo userInfo) {
		String maxSql="select max(user_id) from user_info";
		int maxId=userInfoDaoImpl.getMaxId(maxSql);
		StringBuffer sql=new StringBuffer("");
		/**
		sql.append("insert into ");
		sql.append("user_info ");
		sql.append("values(");
		sql.append(":id,");
		sql.append(":name,");
		sql.append(":password,");
		sql.append(":ustate)");
		*/
		
		sql.append("insert into ");
		sql.append("user_info(user_id,user_name,pass_word,user_state) ");
		sql.append("values(");
		sql.append("?,");
		sql.append("?,");
		sql.append("?,");
		sql.append("?)");
		
	    /**
		sql.append("insert into "); 
		sql.append("user_info(user_id,user_name,pass_word,user_state) ");
		sql.append("values(");
		sql.append("?,?,?,?)");
		*/
		userInfo.setUserId(maxId+1);
		int count = userInfoDaoImpl.addUserInfo(sql.toString(), userInfo);
		return count;
	}

	@Override
	public UserInfo getUserInfoById(int id) {
		String sql="select * from user_info where user_id=?";
		return userInfoDaoImpl.getUserInfoById(sql, id);
	}

	@Override
	public int delUserInfo(int id) {
		String sql="delete from user_info where user_id=?";
		int result = userInfoDaoImpl.delUserInfo(sql, id);
		return result;
	}

	@Override
	public int updUserInfo(UserInfo user) {
		String sql="update user_info set user_name=?,pass_word=?,user_state=? where user_id=?";
		
		return userInfoDaoImpl.updUserInfo(sql, user);
	}

	@Override
	public UserInfo login(UserInfo user) {
		String sql="select * from user_info where user_name=? and user_state=?";
		return userInfoDaoImpl.login(sql, user);
	}

	
}
