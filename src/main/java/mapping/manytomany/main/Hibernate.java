package mapping.manytomany.main;


import mapping.manytomany.entity.Department;
import mapping.manytomany.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;
import java.util.List;

public class Hibernate {

	SessionFactory sf = new Configuration().configure().buildSessionFactory();

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

		Department department2=new Department("Account");
		department2.setEmployeeList(employeeList);


		session.save(department1);
		session.save(department2);
		session.getTransaction().commit();
		session.close();
	}

	public void update() {
		Session session = sf.openSession();
		session.beginTransaction();
		Department departmentUpdate = session.get(Department.class, 1);
		System.out.println("department info to be updated");
		System.out.println(departmentUpdate.toString());
		if (departmentUpdate != null) {
			departmentUpdate.setDepartmentName("account");
			List<Employee>updateEmployeeList=departmentUpdate.getEmployeeList();
			Employee employeeUpdate=updateEmployeeList.get(0);

			employeeUpdate.setFname("pandey");
			session.update(departmentUpdate);

		}
		session.getTransaction().commit();
		session.close();
	}

	public void delete() {
		Session session = sf.openSession();
		session.beginTransaction();
		Department departmentDelete = session.get(Department.class, 1);
		System.out.println("employee info to be deleted");
		System.out.println(departmentDelete.toString());
		if (departmentDelete != null) {
			session.delete(departmentDelete);
		}
		session.getTransaction().commit();
		session.close();
	}

	public void display() {
		Session session = sf.openSession();
		session.beginTransaction();
		@SuppressWarnings({"deprecation", "unchecked"})
		List<Department> departmentList = session.createCriteria(Department.class).list();
		System.out.println("employee information");
		System.out.println(departmentList.toString());
		session.close();
	}

	public static void main(String args[]) {
		Hibernate hibernate = new Hibernate();

		System.out.println("Department insert");
		hibernate.insert();
		hibernate.display();

		System.out.println("Department update");
		hibernate.update();
		hibernate.display();

		System.out.println("Department delete");
		hibernate.delete();
		hibernate.display();
	}
}