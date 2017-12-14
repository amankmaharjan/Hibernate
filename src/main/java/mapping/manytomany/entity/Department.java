package mapping.manytomany.entity;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "departmenttbl")
public class Department {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departmentid")
	private int departmentId;

	@Column(name = "departmentname")
	private String departmentName;

	@ManyToMany(cascade = CascadeType.ALL)
	List<Employee> employeeList=new LinkedList<>();

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	public Department() {
		super();
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department{" +
				"departmentId=" + departmentId +
				", departmentName='" + departmentName + '\'' +
				", employeeList=" + employeeList +
				'}';
	}
}