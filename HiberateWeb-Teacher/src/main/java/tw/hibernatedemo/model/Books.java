package tw.hibernatedemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="books")
public class Books implements Serializable {

	private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
	private int id;
   
	@Column(name="booktitle")
	private String booktitle;
	
	@Column(name="publicYear")
	private String publicYear;
	
	@Column(name="fk_user_id")
	@Transient
	private int userId;
	
	@ManyToOne(fetch = FetchType.EAGER) //多方本身域設就是 EAGER,可省略 JPA 總是獲取資料
	@JoinColumn(name="fk_user_id")
	private BookUsers bookuser;
	
	
	public Books() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBooktitle() {
		return booktitle;
	}


	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}


	public String getPublicYear() {
		return publicYear;
	}


	public void setPublicYear(String publicYear) {
		this.publicYear = publicYear;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public BookUsers getBookuser() {
		return bookuser;
	}


	public void setBookuser(BookUsers bookuser) {
		this.bookuser = bookuser;
	}




}
