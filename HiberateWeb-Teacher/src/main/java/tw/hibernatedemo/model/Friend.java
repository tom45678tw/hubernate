package tw.hibernatedemo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="friends")
public class Friend implements Serializable {

	
	private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="friends_id")
	private Integer friendId;
	
     @Column(name="friendName")
	private String friendName;
	@ManyToMany(mappedBy="friend")
	private Set<MyGroup> group=new HashSet<MyGroup>();
	
	
	public Friend() {
	}


	public Integer getFriendId() {
		return friendId;
	}


	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}


	public String getFriendName() {
		return friendName;
	}


	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}


	public Set<MyGroup> getGroup() {
		return group;
	}


	public void setGroup(Set<MyGroup> group) {
		this.group = group;
	}

}
