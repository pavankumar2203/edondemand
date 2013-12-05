/**
 * 
 * This holds the course information
 * @author: Pavan Kumar Sunder and Susan Chun Xu
 * 
 * 
 */

package business;

public class Course1 {

	private String courseId;
	private String courseName;
	private String comments;
	private String profId;

	public Course1() {
	}

	public Course1(String courseId, String courseName, String comments,
			String profId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.comments = comments;
		this.profId = profId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getProfId() {
		return profId;
	}

	public void setProfId(String profId) {
		this.profId = profId;
	}
}
