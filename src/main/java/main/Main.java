package main;

import java.util.List;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Main {

	static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public void insert() {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(new Student("nischal", "shakya", "dallu"));
		session.save(new Student("ram", "maharjan", "khusibu"));
		session.save(new Student("shyam", "shrestha", "lagan"));
		session.save(new Student("sita", "rai", "chamati"));
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
			studentUpdate.setAddress("bansathali");
			session.update(studentUpdate);
		}
		session.getTransaction().commit();
		session.close();
	}

	public void delete() {
		Session session = sf.openSession();
		session.beginTransaction();
		Student studentDelete = session.get(Student.class, 4);
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
		System.out.println("Student information");
		System.out.println(studentList.toString());
	}

	public static void main(String args[]) {
		Main main = new Main();
		
		System.out.println("student insert");
		main.insert();
		main.display();

		System.out.println("student update");
		main.update();
		main.display();

		System.out.println("student delete");
		main.delete();
		main.display();

		sf.close();
	}

}
