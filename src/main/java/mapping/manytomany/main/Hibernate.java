package mapping.manytomany.entity.main;

import embeddable.entity.Address;
import embeddable.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class Hibernate {

	static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student student1 = new Student();
		student1.setFname("ak");
		student1.setLname("maharjan");
		
		Address address1 = new Address("nepal", "kathmandu");
		student1.setAddress(address1);
		
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
			studentUpdate.setFname("raj");
			studentUpdate.setLname("maharjan");
			studentUpdate.getAddress().setCity("patan");
			studentUpdate.getAddress().setCountry("nepal");
			session.update(studentUpdate);
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

	@SuppressWarnings("rawtypes")
	public void display() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Student");
		@SuppressWarnings("unchecked")
		List<Student> studentList = query.getResultList();
		System.out.println("student information");
		System.out.println(studentList.toString());
	}

	public static void main(String args[]) {
		Hibernate hibernate = new Hibernate();
		
		System.out.println("student insert");
		hibernate.insert();
		hibernate.display();

		System.out.println("student update");
		hibernate.update();
		hibernate.display();
		
		System.out.println("student delete");
		hibernate.delete();
		hibernate.display();

		sf.close();
	}

}