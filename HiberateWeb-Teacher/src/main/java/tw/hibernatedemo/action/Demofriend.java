package tw.hibernatedemo.action;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Friend;
import tw.hibernatedemo.model.MyGroup;
import tw.hibernatedemo.util.HibernateUtil;

public class Demofriend {

	public static void main(String[] args) {
          SessionFactory factory = HibernateUtil.getSessionFactory();
		    Session session = factory.getCurrentSession();
		    
		    try {
		    	session.beginTransaction();
		    	MyGroup myGroup = session.get(MyGroup.class,3);
		    	Set<Friend> friend = myGroup.getFriend();
		    	
		    	Iterator<Friend> it = friend.iterator();
		    	
		    	while(it.hasNext()) {
		    		Friend f1 = it.next();
		    		String tempName = f1.getFriendName();
		    		if(!tempName.equals("Mary")) {
		    		    it.remove();
		    		}
		    	}
		    	
		    	Friend friend2 = new Friend();
		    	friend2.setFriendName("Buil");
		    	session.save(friend2);
		    	
		    	friend.add(friend2);
		    	
		    	session.getTransaction().commit();
		    	
		    }catch(Exception e) {
		    	session.getTransaction().rollback();
		    	System.out.println("交易失敗,資料將返回");
		    }finally {
				
			}
		    
	}
}
