package com.meric.dao;

import java.util.List;

import com.meric.entity.Department;

public interface DepartmentDAO {
	
	public void saveOrUpdate(Department department);
	public void delete(Integer id);
	public List<Department> getDeparmentsAsList();
	public Department getDepartment(Integer id);
	public List<Department> searchDepartments(String depName,String mngr,String location);
	
}
