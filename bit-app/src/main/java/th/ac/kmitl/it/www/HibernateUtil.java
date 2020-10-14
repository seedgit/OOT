package th.ac.kmitl.it.www;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;

public class HibernateUtil {
  private static StandardServiceRegistry registry;
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
        Configuration config = new Configuration();
        sessionFactory = config.configure().buildSessionFactory();
    }
    return sessionFactory;
  }

  public static void shutdown() {
    if (registry != null) {
      //StandardServiceRegistryBuilder.destroy(registry);
      sessionFactory.close();
    }
  }
}