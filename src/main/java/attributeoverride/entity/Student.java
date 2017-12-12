package attributeoverride.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studenttbl")
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int id;

	@Column(name = "first_name")
	private String fname;

	@Column(name = "last_name")
	private String lname;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "country", column = @Column(name = "per_country")),
			@AttributeOverride(name = "city", column = @Column(name = "per_city")) })
	private Address perAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "country", column = @Column(name = "temp_country")),
			@AttributeOverride(name = "city", column = @Column(name = "temp_city")) })
	private Address tempAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", perAddress=" + perAddress
				+ ", tempAddress=" + tempAddress + "]";
	}

	public Address getPerAddress() {
		return perAddress;
	}

	public void  setPerAddress(Address perAddress) {
		this.perAddress = perAddress;
	}

	public Address getTempAddress() {
		return tempAddress;
	}

	public void setTempAddress(Address tempAddress) {
		this.tempAddress = tempAddress;
	}
	
	
}