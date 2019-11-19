package com.meric.dao;

import java.util.List;

import com.meric.entity.Employee;

public interface EmployeeDAO {
	public void saveOrUpdate(Employee employee);
	public void delete(Integer id);
	public List<Employee> getEmployeesAsList();
	public Employee getEmployee(Integer id);
	public List<Employee> searchEmployees(String query);
}
