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
		// ����ҵ���߼�����ж��û��Ƿ���Ե�¼
		User user = userService.login(loginName, password);
		
		if(user != null){
			// ���û����浽HttpSession����
			session.setAttribute("user", user);
			// �ͻ�����ת��mainҳ��
			mv.setViewName("userInfo");
		}
		else{
			// ���õ�¼ʧ����ʾ��Ϣ
			mv.addObject("message", "��¼�����������!����������");
			// �������ڲ���ת����¼ҳ��
			mv.setViewName("loginForm");
		}
		
		return mv;
	}
}
