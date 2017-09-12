package cn.edu.stu.user.dao.provider;


import org.apache.ibatis.jdbc.SQL;

import cn.edu.stu.user.domain.User;

public class UserDynamicSQLProvider {
	
	public static final String USERTABLE = "user";
	
	public String updateUser(User user){
		return new SQL(){
			{
				UPDATE(USERTABLE);
				if(user.getLoginName() != null){
					SET(" loginName = #{loginName} ");
				}
				if(user.getPassword() != null){
					SET(" password = #{password} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
	public String insertUser(User user){
		return new SQL(){
			{
				INSERT_INTO(USERTABLE);
				if(user.getLoginName() != null 
						&& !user.getLoginName().equals("")){
					VALUES("loginName", "#{loginName}");
				}
		
				if(user.getPassword() != null 
						&& !user.getPassword().equals("")){
					VALUES("password", "#{password}");
				}
			}
		}.toString();
	}
}




