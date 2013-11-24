package model;

public class Authenticator {

	public String authenticate(String username, String password) {
		if (("pavan".equalsIgnoreCase(username))
				&& ("password".equals(password))) {
			return "success";
		} else {
			return "failure";
		}
	}
}