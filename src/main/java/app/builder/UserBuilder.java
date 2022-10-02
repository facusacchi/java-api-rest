package app.builder;

import app.domain.User;

public class UserBuilder {
	private User user;
	
	public UserBuilder() {
		this.user = new User();
	}
	
	public UserBuilder withUser(String userName) {
		this.user.setUser(userName);
		return this;
	}
	
	public UserBuilder withPassword(String pwd) {
		this.user.setPwd(pwd);
		return this;
	}
	
	public UserBuilder withToken(String token) {
		this.user.setToken(token);
		return this;
	}
	
	public User build() {
		return this.user;
	}
}
