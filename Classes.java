package application;

public class Classes {
	private String courseID;
	private int empID;
	private int sectionNO;
	private int year;
	private String semester;
	private String grade;
	
	Classes (String courseid, int empid, int sectionno, int year, String semester, String grade)
	{
		this.courseID = courseid;
		this.empID = empid;
		this.sectionNO = sectionno;
		this.year = year;
		this.semester = semester;
		this.grade = grade;
	}
	
	public String getCourseID()
	{
		return this.courseID;
	}
	public int getEmpID()
	{
		return this.empID;
	}
	public int getSectionNO()
	{
		return this.sectionNO;
	}
	public int getYear()
	{
		return this.year;
	}
	public String getSemester()
	{
		return this.semester;
	}
	public String getGrade()
	{
		return this.grade;
	}
	
	public void setCourseID(String courseid)
	{
		this.courseID = courseid;
	}
	public void setEmpID(int empid)
	{
		this.empID = empid;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	public void setSemester(String semester)
	{
		this.semester = semester;
	}
	public void setGrade(String grade)
	{
		this.grade = grade;
	}
}
