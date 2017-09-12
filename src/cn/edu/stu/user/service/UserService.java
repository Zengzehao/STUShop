package cn.edu.stu.user.service;


import cn.edu.stu.user.domain.User;

public interface UserService {
	/**
	 * 用户登录
	 */
    User login(String loginName, String password);
    
    /**
	 * 删除用户
	 */
	void removeUserById(Integer id);
	
	/**
	 * 修改用户
	 */
	void modifyUser(User user);
	
	/**
	 * 增加用户
	 */
	void addUser(User user);
	
	/**
	 * 根据ID查找用户
	 */
	User findUserById(Integer id);
}
