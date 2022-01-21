package application;

public class Students {
	
	private String firstname;
	private String lastname;
	private int empID;
	private String email;
	private String gender;
	
	Students(String firstname, String lastname, int empID, String email, String gender)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.empID = empID;
		this.email = email;
		this.gender = gender;
	}
	
	
	public String getFirstName()
	{
		return this.firstname;
	}
	public String getLastName()
	{
		return this.lastname;
	}
	public int getEmpID()
	{
		return this.empID;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String getGender()
	{
		return this.gender;
	}
	
	
	public void setFirstName(String firstname)
	{
		this.firstname = firstname;
	}
	
	public void setLastName(String lastname)
	{
		this.lastname = lastname;
	}
	
	public void setEmpID(int empID)
	{
		this.empID = empID;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
}
