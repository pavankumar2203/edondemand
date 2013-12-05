/**
 * 
 * This holds the request information by the students
 * @author: Pavan Kumar Sunder and Susan Chun Xu
 * 
 * 
 */

package business;

public class Request {

	private String requestId;
	private String studentId;
	private String courseName;
	private String credit;
	private String category;

	public Request() {
	}

	public Request(String requestId, String studentId, String courseName,
			String credit, String category) {
		super();
		this.requestId = requestId;
		this.studentId = studentId;
		this.courseName = courseName;
		this.credit = credit;
		this.category = category;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
