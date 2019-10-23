package th.ac.kmitl.it.oot.hibernate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
public class App {
    public static void main(String[] args) {
		getVersion();
		getDate();

		insert();
		update();
		//delete();
		selectOne();
		selectList();

		HibernateUtil.shutdown();
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

		User me = new User("tester01", "password01");
		System.out.println("--------------------  insert  -------------------\n");
		System.out.println(session.save(me));

		session.getTransaction().commit();
		session.close();
	}
	public static void update(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		User me = new User(1, "master", "000");
		System.out.println("--------------------  update  -------------------\n");
		session.update(me);

		session.getTransaction().commit();
		session.close();
	}
	public static void delete(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		User me = new User(2, "", "");
		System.out.println("--------------------  delete  -------------------\n");
		session.delete(me);

		session.getTransaction().commit();
		session.close();
	}
	public static void selectOne(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("--------------------  select one  -------------------\n");
		User me = (User) session.get(User.class, 1);
		me.printInfo();

		session.getTransaction().commit();
		session.close();
		
	}
	public static void selectList(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("--------------------  select list  -------------------\n");
		Query query = session.createQuery("from user where id < :id");
		query.setParameter("id", 5);
		List users = query.list();

		for(int i=0; i<users.size(); i++){
			User u = (User)users.get(i);
			System.out.println("--------------------  " + i + "  -------------------\n");
			u.printInfo();
		}

		session.getTransaction().commit();
		session.close();
	}
}