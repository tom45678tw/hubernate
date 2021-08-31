package tw.hibernatedemo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructorDetail")
public class InstructorDetaill implements Serializable{

	private static final long serialVersionUID = 1L;

	//colimn 與 屬性相同 @Cloimn 可以省略
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String email;
	
	private String phone;
	@OneToOne(mappedBy ="insturctorDetail" ) //讓對方找到自己 與@joinColumn(外來鍵) 不得放在一起(理所當然)
	private Instructor instructor;
	

	public InstructorDetaill() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
  
	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
