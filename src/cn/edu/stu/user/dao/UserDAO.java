package cn.edu.stu.user.dao;

import org.apache.ibatis.annotations.*;

import cn.edu.stu.user.dao.provider.UserDynamicSQLProvider;
import cn.edu.stu.user.domain.User;

public interface UserDAO {
    
	public static final String USERTABLE = "user";
	
	/**
	 * �����û���������ѡ���û�
	 */
	@Select("select * from " + USERTABLE + " where loginName = "
			+ "#{loginName} and password = #{password}")
	User selectByLoginNameAndPassword(
			@Param("loginName")String loginName, 
			@Param("password")String password);
	
	/**
	 * �����û���IDɾ���û�
	 */
	@Delete("delete from " + USERTABLE + " where id = #{id}")
	void deleteById(Integer id);
	
	/**
	 * �����û���Ϣ
	 */
	@SelectProvider(type=UserDynamicSQLProvider.class, 
			method="updateUser")
	void update(User user);
	
	/**
	 * �����û���Ϣ
	 */
	@SelectProvider(type=UserDynamicSQLProvider.class, 
			method="insertUser")
	void save(User user);
	
	/**
	 * �����û���IDѡ���û�
	 */
	@Select("select * from " + USERTABLE + " where id = #{id}")
	User selectById(Integer id);
}





