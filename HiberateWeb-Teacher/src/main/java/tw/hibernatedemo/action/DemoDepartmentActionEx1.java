package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.Department;

public class DemoDepartmentActionEx1 {

	public static void main(String[] args) {
		//讀程式檔的程式 下面兩行
		
		StandardServiceRegistry ser = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory factory = new MetadataSources(ser).buildMetadata().buildSessionFactory();
        
        Session session = factory.openSession();
        session.beginTransaction();
        
        Department dep1 = new Department();
        
        dep1.setDepartmentName("HR");
        
        Serializable theId = session.save(dep1);
        
        System.out.println(theId);
        
        session.getTransaction().commit();
        
        session.close();
        
        factory.close();

	}

}
