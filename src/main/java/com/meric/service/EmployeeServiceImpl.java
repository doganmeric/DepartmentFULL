package com.meric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meric.dao.EmployeeDAO;
import com.meric.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public void saveOrUpdate(Employee employee) {
		
		employeeDAO.saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		
		employeeDAO.delete(id);
	}

	@Override
	@Transactional
	public List<Employee> getEmployeesAsList() {
		
		return employeeDAO.getEmployeesAsList();
	}

	@Override
	@Transactional
	public Employee getEmployee(Integer id) {
		
		return employeeDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public List<Employee> searchEmployees(String query) {
		
		return employeeDAO.searchEmployees(query);
	}

}
