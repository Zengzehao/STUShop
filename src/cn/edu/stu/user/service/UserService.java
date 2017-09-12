package cn.edu.stu.user.service;


import cn.edu.stu.user.domain.User;

public interface UserService {
	/**
	 * �û���¼
	 */
    User login(String loginName, String password);
    
    /**
	 * ɾ���û�
	 */
	void removeUserById(Integer id);
	
	/**
	 * �޸��û�
	 */
	void modifyUser(User user);
	
	/**
	 * �����û�
	 */
	void addUser(User user);
	
	/**
	 * ����ID�����û�
	 */
	User findUserById(Integer id);
}
