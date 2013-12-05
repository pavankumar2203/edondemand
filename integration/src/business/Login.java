/**
 * 
 * This holds the Login information for both professor and student login
 * @author: Pavan Kumar Sunder and Susan Chun Xu
 * 
 * 
 */

package business;

public class Login {

	private String loginId;
	private String userId;
	private String pwd;
	private String studentId;
	private String profId;

	public Login() {
	}

	public Login(String loginId, String userId, String pwd, String studentId,
			String profId) {
		super();
		this.loginId = loginId;
		this.userId = userId;
		this.pwd = pwd;
		this.studentId = studentId;
		this.profId = profId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getProfId() {
		return profId;
	}

	public void setProfId(String profId) {
		this.profId = profId;
	}
}
