package mapping.manytoone.main;

import java.util.List;


import mapping.manytoone.entity.Department;
import mapping.manytoone.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

	static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();

		Department department1 = new Department("Human Resource");

		Employee employee1 = new Employee();
		employee1.setFname("Hari");
		employee1.setLname("Prasad");

		Employee employee2 = new Employee();
		employee2.setFname("raj");
		employee2.setLname("Prasad");
		employee2.setDepartment(department1);
		employee1.setDepartment(department1);


		session.save(employee1);
		session.save(employee2);

		session.save(department1);
		session.getTransaction().commit();
		session.close();
	}

	public void update() {
		Session session = sf.openSession();
		session.beginTransaction();
		Employee employeeUpdate = session.get(Employee.class, 1);
		System.out.println("student info to be updated");
		System.out.println(employeeUpdate.toString());
		if (employeeUpdate != null) {
			employeeUpdate.setFname("Ram");
			employeeUpdate.setLname("Krisha");
			employeeUpdate.getDepartment().setDepartmentName("Marketing");
			session.update(employeeUpdate);

		}
		session.getTransaction().commit();
		session.close();
	}

	public void delete() {
		Session session = sf.openSession();
		session.beginTransaction();
		Employee employeetDelete = session.get(Employee.class, 1);
		System.out.println("employee info to be deleted");
		System.out.println(employeetDelete.toString());
		if (employeetDelete != null) {
			session.delete(employeetDelete);
		}
		session.getTransaction().commit();
		session.close();
	}

	public void display() {
		Session session = sf.openSession();
		session.beginTransaction();
		@SuppressWarnings({"deprecation", "unchecked"})
		List<Employee> listOfEmployee = session.createCriteria(Employee.class).list();
		System.out.println("employee information");
		System.out.println(listOfEmployee.toString());
		session.close();
	}

	public static void main(String args[]) {
		Hibernate hibernate = new Hibernate();

		System.out.println("employee insert");
		hibernate.insert();
		hibernate.display();

//		System.out.println("employee update");
		hibernate.update();
		hibernate.display();

//		System.out.println("employee delete");
//		hibernate.delete();
//		hibernate.display();
		sf.close();
	}
}
