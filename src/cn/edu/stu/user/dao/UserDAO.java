package cn.edu.stu.user.dao;

import org.apache.ibatis.annotations.*;

import cn.edu.stu.user.dao.provider.UserDynamicSQLProvider;
import cn.edu.stu.user.domain.User;

public interface UserDAO {
    
	public static final String USERTABLE = "user";
	
	/**
	 * 根据用户名和密码选择用户
	 */
	@Select("select * from " + USERTABLE + " where loginName = "
			+ "#{loginName} and password = #{password}")
	User selectByLoginNameAndPassword(
			@Param("loginName")String loginName, 
			@Param("password")String password);
	
	/**
	 * 根据用户名ID删除用户
	 */
	@Delete("delete from " + USERTABLE + " where id = #{id}")
	void deleteById(Integer id);
	
	/**
	 * 更新用户信息
	 */
	@SelectProvider(type=UserDynamicSQLProvider.class, 
			method="updateUser")
	void update(User user);
	
	/**
	 * 保存用户信息
	 */
	@SelectProvider(type=UserDynamicSQLProvider.class, 
			method="insertUser")
	void save(User user);
	
	/**
	 * 根据用户名ID选择用户
	 */
	@Select("select * from " + USERTABLE + " where id = #{id}")
	User selectById(Integer id);
}





