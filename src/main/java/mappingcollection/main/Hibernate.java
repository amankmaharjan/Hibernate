package mappingcollection.main;

import java.util.ArrayList;
import java.util.List;

import mappingcollection.entity.Address;
import mappingcollection.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Hibernate {

	static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
        Session session = sf.openSession();
		session.beginTransaction();

		Student student1 = new Student();
		student1.setFname("nischal");
		student1.setLname("shakya");

		Address address1 = new Address("nepal", "kathmandu");
		Address address2 = new Address("usa", "new york");

		List<Address>addressList=new ArrayList<>();
		addressList.add(address1);
		addressList.add(address2);

		student1.setListOfAddress(addressList);

		session.save(student1);

		session.getTransaction().commit();
		session.close();
	}

	public void update() {
		Session session = sf.openSession();
		session.beginTransaction();
		Student studentUpdate = session.get(Student.class, 1);
		System.out.println("student info to be updated");
		System.out.println(studentUpdate.toString());
		if (studentUpdate != null) {

			studentUpdate.setFname("rashik");
			studentUpdate.setLname("shakya");

			System.out.println(studentUpdate.getListOfAddress().toString());
			Address studentAddress = studentUpdate.getListOfAddress().get(0);
			System.out.println(studentAddress.toString());
			studentAddress.setCity("delhi");
			studentAddress.setCountry("india");
//
//
			session.update(studentUpdate);
//
		}
		session.getTransaction().commit();
		session.close();
	}

	public void delete() {
		Session session = sf.openSession();
		session.beginTransaction();
		Student studentDelete = session.get(Student.class, 1);
		System.out.println("student info to be deleted");
		System.out.println(studentDelete.toString());
		if (studentDelete != null) {
			session.delete(studentDelete);
		}
		session.getTransaction().commit();
		session.close();
	}

	public void display() {
		Session session = sf.openSession();
		session.beginTransaction();
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Student> listOfStudent = session.createCriteria(Student.class).list();
		System.out.println("student information");
		System.out.println(listOfStudent.toString());
	}

	public static void main(String args[]) {
		Hibernate hibernate = new Hibernate();

		System.out.println("student insert");
		hibernate.insert();
//		hibernate.display();

		System.out.println("student update");
		hibernate.update();
//		hibernate.display();

//		System.out.println("student delete");
////		hibernate.delete();
//		hibernate.display();
		sf.close();
	}

}