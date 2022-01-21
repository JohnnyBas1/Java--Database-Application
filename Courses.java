package application;

public class Courses {
	private String courseID;
	private String courseTitle;
	private String department;
	
	Courses(String courseid, String coursetitle, String department)
	{
		this.courseID = courseid;
		this.courseTitle = coursetitle;
		this.department = department;
	}
	
	public String getCourseID()
	{
		return this.courseID;
	}
	public String getCourseTitle()
	{
		return this.courseTitle;
	}
	
	public String getDepartment()
	{
		return this.department;
	}
	
	public void setCourseID(String courseid)
	{
		this.courseID = courseid;
	}
	public void setCourseTitle(String coursetitle)
	{
		this.courseTitle = coursetitle;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	
}