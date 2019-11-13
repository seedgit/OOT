package th.ac.kmitl.it.oot.motorcycle.view;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import org.hibernate.Session;
import org.hibernate.query.Query;

import th.ac.kmitl.it.oot.motorcycle.HibernateUtil;
import th.ac.kmitl.it.oot.motorcycle.model.Brand;

public class BrandListAction extends ActionSupport {
    public String execute() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("--------------------  select list  -------------------\n");
		Query query = session.createQuery("from brand");
		List users = query.list();

		for(int i=0; i<users.size(); i++){
			Brand u = (Brand)users.get(i);
			System.out.println("--------------------  " + i + "  -------------------\n");
		}

		session.getTransaction().commit();
        session.close();
        
        return SUCCESS;
    }
}