package com.mouritech.departmentcrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "department_table")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id")
	private Long deptId;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@Column(name = "dept_head")
	private String deptHead;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

	public Department(String deptName, String deptHead) {
		super();
		this.deptName = deptName;
		this.deptHead = deptHead;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}

	public Department(Long deptId, String deptName, String deptHead) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptHead = deptHead;
	}
	



	
	

}
