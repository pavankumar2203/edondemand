package model;

public class Course {

	private int requestid;
	private int offer;
	private int stdid;
	private String course;
	private String category;

	public Course(int r, int o, String course, String category) {
		this.requestid = r;
		this.offer = o;
		//this.stdid = s;
		this.course = course;
		this.category = category;
	}

	public int getrequestid() {
		return requestid;
	}
	
	public int getoffer() {
		return offer;
	}
	
	public String getcourse() {
		return course;
	}
	
	public String getcategory() {
		return category;
	}

}