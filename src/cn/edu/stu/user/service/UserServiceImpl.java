package cn.edu.stu.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.stu.user.dao.UserDAO;
import cn.edu.stu.user.domain.User;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    
	@Override
	public User login(String loginName, String password) {
		// TODO Auto-generated method stub
		return userDAO.selectByLoginNameAndPassword(loginName, password);
	}

	@Override
	public void removeUserById(Integer id) {
		// TODO Auto-generated method stub
		userDAO.deleteById(id);
	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		userDAO.update(user);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDAO.selectById(id);
	}
	
	
}
