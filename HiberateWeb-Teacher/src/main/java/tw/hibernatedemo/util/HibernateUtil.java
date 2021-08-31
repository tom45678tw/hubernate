package tw.hibernatedemo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory factory = createSessionFactory();
  
	private static SessionFactory createSessionFactory() {
		StandardServiceRegistry ser = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory factory = new MetadataSources(ser).buildMetadata().buildSessionFactory();
        
        return factory; 
	}
  
	  public static SessionFactory getSessionFactory(){
		  
		  return factory;
	  }
	  
	  public static void closeSessionFactory() {
		  if(factory!=null){
			  factory.close();
		  }
	  }
}
