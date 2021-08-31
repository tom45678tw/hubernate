package tw.hibernatedemo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "instructor")
public class Instructor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "instructorName")
	private String name;
	
	@Column(name = "fk_instructorDetail_id")
	@Transient // 不由此物件產生的屬性,要加上@Transient ,或是 26-28省略也可以 (不寫此屬性也可以 方便看而已)
	private int detailId;
	
	@OneToOne(cascade = CascadeType.ALL) //當臨時物件轉成永續物件的時候 幫我把對應的那一個也轉換(當然前提要把她連起來)
	@JoinColumn(name = "fk_instructorDetail_id")
	private InstructorDetaill insturctorDetail;

	public Instructor() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public InstructorDetaill getInsturctorDetail() {
		return insturctorDetail;
	}

	public void setInsturctorDetail(InstructorDetaill insturctorDetail) {
		this.insturctorDetail = insturctorDetail;
	}

}
