package mapping.manytoone.entity;

import javax.persistence.*;

@Entity
@Table(name = "departmenttbl")
public class Department {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departmentid")
	private int departmentId;
	
	@Column(name = "departmentname")
	private String departmentName;

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}
	
	public  Department(){
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
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
}