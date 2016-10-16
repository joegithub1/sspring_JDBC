package cn.com.controlle;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.entity.UserInfo;
import cn.com.service.UserInfoService;
/**
 * 
* @ClassName: LoginControlle 
* @Description: 用户登录控制器 建立这个控制器防止拦截器没有登录拦截到
* @author  huangjian
* @date 2016年10月16日 下午12:18:04 
*
 */
@Controller
@RequestMapping("/login")
public class LoginControlle {

	public static final String LOGIN_NAME="LOGIN_NAME";
	public String [] url = new String[]{"/login","redirect:/user/list.do"};
	@Autowired
	public UserInfoService userInfoServiceImpl;
	
	@RequestMapping(value="/loginIn")
	public String loginPage(Map<String,UserInfo> map){
		map.put("user", new UserInfo());
		return "/login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("user") UserInfo user,BindingResult br,HttpSession session){
		
		if(br.getErrorCount() > 0){
			return url[0];
		}
		UserInfo u=null;
		u=userInfoServiceImpl.login(user);
		if(null  == u){
			return url[0];
		}
		
		if(!u.getPassWord().equalsIgnoreCase(user.getPassWord())){
			return url[0];
		}
		session.setAttribute(LOGIN_NAME, u);
		return url[1];
	}
	@RequestMapping(value="/loginout")
	public String loginOut(HttpSession session){
		
		UserInfo user=null;
		user = (UserInfo) session.getAttribute(LOGIN_NAME);
		if(null != user){
			session.removeAttribute(LOGIN_NAME);
		}
		return "redirect:/login/loginIn.do";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAdd(Map<String, UserInfo> map){
		map.put("user", new UserInfo());
		return "userInfo/add"; 
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String toAdd(@Valid @ModelAttribute("user") UserInfo user,BindingResult br){
		
		if(br.getErrorCount() > 0){
			
			return "/userInfo/add";
		}
		int count = userInfoServiceImpl.addUserInfo(user);
		if(count > 0){
			return "redirect:/login/loginIn.do";
		}
		return "/userInfo/add";
	}
}
