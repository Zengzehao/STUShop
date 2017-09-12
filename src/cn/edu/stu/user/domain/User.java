package cn.edu.stu.user.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	
	private Integer id;			// id
	private String loginName;	// ”√ªß√˚
	private String password;	// √‹¬Î
	
	public User(){
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName 
				+ ", password=" + password +"]";
	}
}
