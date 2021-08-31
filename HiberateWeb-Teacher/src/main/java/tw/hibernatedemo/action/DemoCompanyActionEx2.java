package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.CompanyBean;

public class DemoCompanyActionEx2 {

	public static void main(String[] args) {
		StandardServiceRegistry ser = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory factory = new MetadataSources(ser).buildMetadata().buildSessionFactory();
        
        Session session = factory.openSession();
        
        session.beginTransaction();
        
        CompanyBean com2 = new CompanyBean(2,"小茜");
        
        Serializable identifier = session.save(com2); //拿到資料的　id
        
        System.out.println(""+identifier);
        
        session.getTransaction().commit();
        
        session.close();
        
        factory.close();

	}

}
