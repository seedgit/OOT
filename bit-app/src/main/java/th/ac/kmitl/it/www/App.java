package th.ac.kmitl.it.www;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        getVersion();
        getDate();
        insert();
    }
    
	public static void getVersion(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Check database version
		String sql = "select version()";
		System.out.println("--------------------version-------------------\n");
		System.out.println(session.createNativeQuery(sql).getSingleResult());

		session.getTransaction().commit();
		session.close();

    }
	public static void getDate(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String sql = "select now()";
		System.out.println("--------------------  now  -------------------\n");
		System.out.println(session.createNativeQuery(sql).getSingleResult());

		session.getTransaction().commit();
		session.close();
    }
    
    public static void insert(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

        Student me = new Student();
        me.setStudentId("62000000");
        me.setPassword("hello");
		System.out.println("--------------------  insert  -------------------\n");
		System.out.println(session.save(me));

		session.getTransaction().commit();
		session.close();
	}
	public static void update(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

        Student me = new Student();
        me.setId(1);
        me.setStudentId("62xxxx");
        me.setPassword("hello");
		System.out.println("--------------------  update  -------------------\n");
		session.update(me);

		session.getTransaction().commit();
		session.close();
	}
	public static void delete(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Student me = new Student();
		System.out.println("--------------------  delete  -------------------\n");
		session.delete(me);

		session.getTransaction().commit();
		session.close();
	}
	public static void selectOne(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("--------------------  select one  -------------------\n");
		Student me = (Student) session.get(Student.class, 1);
		me.printInfo();

		session.getTransaction().commit();
		session.close();
		
	}
	public static void selectList(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("--------------------  select list  -------------------\n");
		Query query = session.createQuery("from Student where id < :id");
		query.setParameter("id", 5);
		List Students = query.list();

		for(int i=0; i<Students.size(); i++){
			Student u = (Student)Students.get(i);
			System.out.println("--------------------  " + i + "  -------------------\n");
			u.printInfo();
		}

		session.getTransaction().commit();
		session.close();
	}
}
