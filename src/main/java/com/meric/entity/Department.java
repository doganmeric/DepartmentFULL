package com.meric.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name="departments")
public class Department {
	//TODO sequence ekle
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="department-numarator")
	@SequenceGenerator(name="department-numarator" , sequenceName ="departments_seq",allocationSize = 10)
	@Column(name="department_id")
	private Integer id;
	
	@Column(name="department_name")
	@Size(min = 2,message = "Department can't be shorter than 2 letter")
	@NotEmpty(message = "DepartmentName can't be empty")
	
	private String departmentName;
	
	@OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
	@JoinColumn(name="manager_id")
	private Employee manager;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
	@JoinColumn(name="location_id")
	private Location location;

	
	public Department() {
		
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", manager=" + manager + ", location="
				+ location + "]";
	}


}
