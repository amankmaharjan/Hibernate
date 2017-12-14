package fetch.main;


import fetch.entity.Department;
import fetch.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;

public class Hibernate {

	static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
        Session session = sf.openSession();
		session.beginTransaction();
		Employee employee1 = new Employee();
		employee1.setFname("Hari");
		employee1.setLname("Prasad");


		Employee employee2 = new Employee();
		employee2.setFname("raj");
		employee2.setLname("Prasad");

		List<Employee> employeeList=new LinkedList<>();
		employeeList.add(employee1);
		employeeList.add(employee2);


		Department department1 = new Department("Human Resource");
		department1.setEmployeeList(employeeList);

		session.save(department1);
		session.getTransaction().commit();
		session.close();
	}

	public void display() {
		Session session = sf.openSession();
		session.beginTransaction();
		@SuppressWarnings({"deprecation", "unchecked"})
		Department department = session.get(Department.class, 1);
		System.out.println("department information");

		System.out.println("id:"+department.getDepartmentId());
		System.out.println("department name"+department.getDepartmentName());


		List<Employee>employeeList=department.getEmployeeList();
		System.out.println(employeeList.toString());

		session.close();
	}

	public void displayNativeQuery(){

		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"select * from departmenttbl d where d.departmentid = :id")
				.addEntity(Department.class)
				.setParameter("id", "1");
		List<Department> d = query.list();
		System.out.println("department name:");
		System.out.println(d.toString());

		session.close();

	}

	public static void main(String args[]) {
		Hibernate hibernate = new Hibernate();

		System.out.println("Department insert");
		hibernate.insert();

//		hibernate.display();
		hibernate.displayNativeQuery();

		sf.close();




	}
}