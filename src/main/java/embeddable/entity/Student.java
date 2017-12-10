package embeddable.entity;

import javax.persistence.*;

@Entity
@Table(name = "studenttbl")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "first_name")
    private String fname;

    @Column(name = "last_name")
    private String lname;

    @Embedded
    private Address address;

    @Override
    public String toString() {
        return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", address=" + address + "]";
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Student(int id, String fname, String lname, Address address) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
    }



    public Student(String fname, String lname, Address address) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.address = address;
    }

    public Student() {
        super();
    }
}