package cn.com.entity;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
* @ClassName: UserInfo 
* @Description: 用户实体类   /使用实体类注解需要用到hibernate 暂时不用
* @author  huangjian
* @date 2016年10月6日 下午5:03:02 
*
 */

public class UserInfo implements Serializable{

	private Integer userId;
	@NotEmpty(message="账号不能为空")
	private String userName;
	@Length(min=6,max=16,message="密码长度在{min}到{max}之间")
	private String passWord;
	private int userState;
	
	public UserInfo() {
		
	}

	public UserInfo(Integer userId, String userName, String passWord, int userState) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.userState = userState;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}
	public void toOut(UserInfo u){
		StringBuffer s=new StringBuffer("");
		s.append("["+u.getUserId()+",");
		s.append(u.getUserName()+",");
		s.append(u.getPassWord()+",");
		s.append(u.getUserState()+"]");
		System.out.println(s.toString());
	}
}
