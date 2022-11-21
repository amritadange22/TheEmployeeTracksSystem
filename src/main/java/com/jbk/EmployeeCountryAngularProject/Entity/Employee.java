package com.jbk.EmployeeCountryAngularProject.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@Column(name="empid", unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empid;
	private String ename;
	private String emailid;
	private long mobileno;
	private String gender;
	private String department;
	private String status; // active, inactive, suspended
	
	//LocalDate localDate = LocalDate.of( 2012 , 12 , 7 );
	// localDate.toString() → 2012-12-07
	
	/*
	 * @JsonFormat is a Jackson annotation that we use to specify how to format
	 * fields and/or properties for JSON output.
	 * 
	 * Specifically, this annotation allows us to specify how to format Date and
	 * Calendar values according to a SimpleDateFormat format.
	 */
	
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm:ss")
	private Date createddate;      // joining date
	private String createdby;   // name
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm:ss")
	private Date updateddate;      // post updation (promotion) date
	private String updatedby;	// name who updated post 
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid")
	Country country;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer empid, String ename, String emailid, long mobileno, String gender, String department,
			String status, Date createddate, String createdby, Date updateddate, String updatedby,
			Country country) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.emailid = emailid;
		this.mobileno = mobileno;
		this.gender = gender;
		this.department = department;
		this.status = status;
		this.createddate = createddate;
		this.createdby = createdby;
		this.updateddate = updateddate;
		this.updatedby = updatedby;
		this.country = country;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer eid) {
		this.empid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + empid + ", ename=" + ename + ", emailid=" + emailid + ", mobileno=" + mobileno
				+ ", gender=" + gender + ", department=" + department + ", status=" + status + ", createddate="
				+ createddate + ", createdby=" + createdby + ", updateddate=" + updateddate + ", updatedby=" + updatedby
				+ ", country=" + country + "]";
	}
}