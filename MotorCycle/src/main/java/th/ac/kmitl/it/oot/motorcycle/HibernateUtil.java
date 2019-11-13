package th.ac.kmitl.it.oot.motorcycle;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;

public class HibernateUtil {
  private static StandardServiceRegistry registry;
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      try {
        Configuration config = new Configuration();
        sessionFactory = config.configure().buildSessionFactory();
      } catch (Exception e) {
        e.printStackTrace();
      }
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
