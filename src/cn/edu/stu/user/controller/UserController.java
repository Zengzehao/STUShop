package cn.edu.stu.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;







import cn.edu.stu.user.domain.User;
import cn.edu.stu.user.service.UserService;

@Controller
public class UserController {
    
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/loginForm")
	public ModelAndView loginForm(ModelAndView mv){
		mv.setViewName("loginForm");
		
		return mv;
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	 public ModelAndView login(
			 HttpSession session, HttpServletRequest request,
			 ModelAndView mv){
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		// 调用业务逻辑组件判断用户是否可以登录
		User user = userService.login(loginName, password);
		
		if(user != null){
			// 将用户保存到HttpSession当中
			session.setAttribute("user", user);
			// 客户端跳转到main页面
			mv.setViewName("userInfo");
		}
		else{
			// 设置登录失败提示信息
			mv.addObject("message", "登录名或密码错误!请重新输入");
			// 服务器内部跳转到登录页面
			mv.setViewName("loginForm");
		}
		
		return mv;
	}
}
