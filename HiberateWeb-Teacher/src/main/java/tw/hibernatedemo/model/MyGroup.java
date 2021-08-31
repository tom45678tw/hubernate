package tw.hibernatedemo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="groups")
public class MyGroup implements Serializable {
   
	private static final long serialVersionUID = 1L;
	//Integer 可以null值 int 會報錯
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="groups_id")
	private Integer id;
	@Column(name="groupName")
	private String groupName;
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(
			name="friend_group",
			joinColumns = {@JoinColumn(name="fk_group_id",referencedColumnName = "groups_id")},
			inverseJoinColumns = {@JoinColumn(name="fk_friend_id ",referencedColumnName = "friends_id")}
			)
	
	
	private Set<Friend> friend = new HashSet<Friend>();
	
	
	
	
	
	public MyGroup() {
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getGroupName() {
		return groupName;
	}





	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}





	public Set<Friend> getFriend() {
		return friend;
	}





	public void setFriend(Set<Friend> friend) {
		this.friend = friend;
	}

}
