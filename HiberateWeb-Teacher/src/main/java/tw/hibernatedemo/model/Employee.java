package tw.hibernatedemo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Employee")
public class Employee implements Serializable {
       private static final long serialVersionUID = 1L;
	  
       @Id
       @GeneratedValue(strategy =GenerationType.IDENTITY )
       private int id;
       
       private String empName;
       
       private Integer salary;
       
       private Integer  vacation;

	public Employee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getVacation() {
		return vacation;
	}

	public void setVacation(int vacation) {
		this.vacation = vacation;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", empName=");
		builder.append(empName);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", vacation=");
		builder.append(vacation);
		builder.append("]");
		return builder.toString();
	}

	
	

}
