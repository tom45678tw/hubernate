package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentActionEx2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
          Session session = factory.openSession();  //不需要組態檔設定hibernate.cfg.xml
          // 樣連線前都要有session物件 因為她有connection物件 JDBC的
           
           session.beginTransaction();
           Department dep2 = new Department();
	          dep2.setDepartmentName("RD");
	          
	          Serializable theOD = session.save(dep2);
	            System.out.println(theOD);
	            
	            session.beginTransaction().commit();
	            session.close();
	            
	            HibernateUtil.closeSessionFactory();
	}

}
