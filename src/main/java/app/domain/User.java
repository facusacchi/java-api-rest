package app.domain;

public class User implements Entity {
	private String user;
	private String pwd;
	private String token;
	
	public boolean isValid() {
		return !user.isEmpty()
				&& !token.isEmpty();
	}
	
	// getters and setters
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
