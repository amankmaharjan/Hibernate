package crud.main;

import crud.main.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {
    public static void main(String[] args) {
        //like factory of connection and `configuraton  object
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        //databse connection
        Session session = sf.openSession();
        //work
        session.beginTransaction();
        Student s1 = new Student("aman", "shakya", "dallu");
        Student s2 = new Student("shyam", "shrestha", "lagan");
        session.save(s1);
        session.save(s2);
        session.getTransaction().commit();
        session.close();


        //transient object
        Student student1 = new Student("ak", "shakya", "dallu");

        Session session1 = sf.openSession();
        session1.beginTransaction();
        session1.save(student1);
        //student1 is now persistent object
        student1.setFname("raj");
        session1.getTransaction().commit();
        session1.close();


        //s1 is now detatched object
        student1.setFname("hari");
        sf.close();


    }
}
