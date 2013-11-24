package business;

public class Login {

	private String studentId;
	private String userId;
	private String pwd;

	public Login() {
	}
	public Login(String studentId, String userId, String pwd) {
		this.studentId = studentId;
		this.userId = userId;
		this.pwd = pwd;
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
}
