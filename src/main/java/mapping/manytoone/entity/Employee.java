package mapping.manytoone.entity;

import javax.persistence.*;

@Entity
@Table(name = "employeetbl")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeid")
	private int employeeId;

	@Column(name = "firstname")
	private String fname;

	@Column(name = "lastname")
	private String lname;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;


	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", fname=" + fname + ", lname=" + lname + ", department="
				+ department + "]";
	}

	public Employee() {
		super();
	}

	public Employee(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}

}