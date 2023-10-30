package POJOS;

import java.sql.Date;
import java.time.LocalDate;

//| id | first_name | last_name | email| password | dob | status | role
public class Users 
{
	private int id;
	private String first_Name;
	private String last_name;
	private String email;
	private String password;
	private LocalDate dob;
	private int status;
	private String role;
	public Users(int id, String first_Name, String last_name, String email, String password, String dob, int status,
			String role) 
	{
		super();
		this.id = id;
		this.first_Name = first_Name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.dob = LocalDate.parse(dob);
		this.status = status;
		this.role = role;
	}
	
	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", first_Name=" + first_Name + ", last_name=" + last_name + ", email=" + email
				+ ", dob=" + dob + ", status=" + status + ", role=" + role + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	

}
