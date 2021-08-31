package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.CompanyBean;


public class demoCompanyActionEx1 {

	public static void main(String[] args) {
	StandardServiceRegistry ser = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
         SessionFactory factory = new MetadataSources(ser).buildMetadata().buildSessionFactory();
         
         Session session = factory.openSession();
         
         session.beginTransaction();
         CompanyBean com1 = new CompanyBean(1001,"Tesla");
         
         session.save(com1);
         
         session.getTransaction().commit();
         session.close();
         factory.close();
         
	}

}
