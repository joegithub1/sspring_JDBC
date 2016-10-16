package cn.com.controlle;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.entity.UserInfo;
import cn.com.service.UserInfoService;
import cn.com.servlet.impl.UserInfoServiceImpl;
/**
 * 
* @ClassName: UserInfoControlle 
* @Description: 用户表控制器
* @author  huangjian
* @date 2016年10月12日 下午5:21:48 
*
 */
@Controller
@RequestMapping("/user")
public class UserInfoControlle {

	@Autowired
	private UserInfoService userInfoServiceImpl;
	@RequestMapping("/test")
	public String test(){
		int res=userInfoServiceImpl.addUserInfo(null);
		
		return "/userInfo/list";
	}
	
	
	@RequestMapping("/list")
	public String getUserInfoList(Map<String, List<UserInfo>> map){
		List<UserInfo> userList=userInfoServiceImpl.getAll();
		map.put("users", userList);
		
		return "/userInfo/list";
	}
	/**
	 * 
	* @Title: toAdd 
	* @Description: 去添加页面
	* @param @return
	* @return String
	* @throws
	 */
	/**
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
			return "redirect:/user/list.do";
		}
		return "/userInfo/add";
	}*/
	@RequestMapping(value="/show/{id}",method=RequestMethod.GET)
	public String show(@PathVariable("id") int id,Map<String, UserInfo> map){
		
		UserInfo user=userInfoServiceImpl.getUserInfoById(id);
		map.put("user", user);
		
		return "/userInfo/show";
	}
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") int id){
		
		int result = userInfoServiceImpl.delUserInfo(id);
		
		return "redirect:/user/list.do";
		
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String toUpdatePage(@PathVariable("id") int id,Map<String, UserInfo> map){
		UserInfo user=userInfoServiceImpl.getUserInfoById(id);
		
		map.put("user", user);
		return "/userInfo/add";
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("user") UserInfo user,BindingResult br){
		
		if(br.getErrorCount() > 0){
			return "/userInfo/add";
		}
		int result = userInfoServiceImpl.updUserInfo(user);
		
		return "redirect:/user/list.do";
	}
}
