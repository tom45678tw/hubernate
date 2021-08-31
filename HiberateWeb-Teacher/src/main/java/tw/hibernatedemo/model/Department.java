package tw.hibernatedemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Department implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="companyid",nullable= false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentId;
	                                           //這邊可寫可不寫 若超過資料庫也會抱錯
	@Column(name="companyName",nullable=true,columnDefinition = "nvarchar(50")
	private String departmentName;

	
	
	
	
	
	
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		
		this.departmentName = departmentName;
	}

         public Department() {
         }

}
