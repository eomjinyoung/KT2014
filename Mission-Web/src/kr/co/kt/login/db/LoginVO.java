package kr.co.kt.login.db;

public class LoginVO {
	
	private String id;
	private String password;
	private String type;	// 관리자('S'), 사용자('U') 구분
	
	public LoginVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginVO(String id, String password, String type) {
		super();
		this.id = id;
		this.password = password;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", password=" + password + ", type="
				+ type + "]";
	}
}
