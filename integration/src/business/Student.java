package business;

public class Student{

	private String studentId;
	private String studFname;
	private String studLname;
	private String studGender;
	private String studAge;
	private String studEmail;
	private String studScore;
	
	public Student() {
	}
	
	public Student(String studentId, String studFname, String studLname,
			String studGender, String studAge, String studEmail,
			String studScore) {
		super();
		this.studentId = studentId;
		this.studFname = studFname;
		this.studLname = studLname;
		this.studGender = studGender;
		this.studAge = studAge;
		this.studEmail = studEmail;
		this.studScore = studScore;
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudFname() {
		return studFname;
	}

	public void setStudFname(String studFname) {
		this.studFname = studFname;
	}

	public String getStudLname() {
		return studLname;
	}

	public void setStudLname(String studLname) {
		this.studLname = studLname;
	}

	public String getStudGender() {
		return studGender;
	}

	public void setStudGender(String studGender) {
		this.studGender = studGender;
	}

	public String getStudAge() {
		return studAge;
	}

	public void setStudAge(String studAge) {
		this.studAge = studAge;
	}

	public String getStudEmail() {
		return studEmail;
	}

	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}

	public String getStudScore() {
		return studScore;
	}

	public void setStudScore(String studScore) {
		this.studScore = studScore;
	}
}
