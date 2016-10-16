package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import cn.com.dao.UserInfoDao;
import cn.com.entity.UserInfo;
/**
 * 
* @ClassName: UserInfoDaoImpl 
* @Description: 用户dao实现类
* @author  huangjian
* @date 2016年10月12日 下午5:26:54 
*
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	//public Logger log=Logger.getLogger(UserInfoDaoImpl.class);
	@Override
	public List<UserInfo> getAll(String sql) {
		List<UserInfo> list=null;
		try {
			//list = jdbcTemplate.queryForList(sql, new Object[]{},new BandP);
			list=jdbcTemplate.query(sql, new Object[]{},new BeanPropertyRowMapper(UserInfo.class));
		} catch (DataAccessException e) {
			System.out.println("全查异常 dao");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int addUserInfo(String sql,UserInfo userInfo) {
		int count=0;
		try {
			MapSqlParameterSource ms=new MapSqlParameterSource();
			ms.addValue("id", userInfo.getUserId());
			ms.addValue("name", userInfo.getUserName());
			ms.addValue("password", userInfo.getPassWord());
			ms.addValue("ustate",userInfo.getUserState());
			//第二个参数不能放变量(jdbcTemplate.update(sql,o);
			count = jdbcTemplate.update(sql, new Object[]{userInfo.getUserId(),userInfo.getUserName(),userInfo.getPassWord(),userInfo.getUserState()});
			
			
		} catch (DataAccessException e) {
			System.out.println("增加异常");
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int getMaxId(String sql) {
		int maxId=-1;
		try {
			maxId = jdbcTemplate.queryForInt(sql);
		} catch (DataAccessException e) {
			System.out.println("主键查询异常");
			e.printStackTrace();
		}
		return maxId;
	}

	@Override
	public UserInfo getUserInfoById(String sql,int id) {
		List<UserInfo> list=null;
		UserInfo user=null;
		try {
			list =  jdbcTemplate.query(sql, new Object[]{id},new BeanPropertyRowMapper(UserInfo.class));
			
		} catch (DataAccessException e) {
			System.out.println("id条件查询异常");
			e.printStackTrace();
		}
		
		return list.get(0);
	}

	@Override
	public int delUserInfo(String sql, int id) {
		int result=-1;
		try {
			result = jdbcTemplate.update(sql, new Object[]{id});
		} catch (DataAccessException e) {
			System.out.println("删除异常");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updUserInfo(String sql, UserInfo user) {
		
		int result=jdbcTemplate.update(sql, new Object[]{user.getUserName(),user.getPassWord(),user.getUserState(),user.getUserId()});
		return result;
	}

	@Override
	public UserInfo login(String sql, UserInfo user) {
		UserInfo u=null;
		try {
			u = (UserInfo) jdbcTemplate.queryForObject(sql, new Object[]{user.getUserName(),1}, new BeanPropertyRowMapper(UserInfo.class));
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return u;
	}
}
