package business;

public class Request {

	private String requestId;
	private String studentId;
	private String courseName;
	private String offer;
	private String category;
	
	public Request() {
	}

	public Request(String requestId, String studentId, String courseName,
		   String offer, String category) {
		super();
		this.requestId = requestId;
		this.studentId = studentId;
		this.offer = offer;
		this.courseName = courseName;
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

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
