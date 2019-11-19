package com.meric.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meric.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpdate(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getEmployeesAsList() {
		Session session = sessionFactory.getCurrentSession();
		
		
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee getEmployee(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		Employee tempEmp = session.get(Employee.class, id);
		
		return tempEmp;
	}

	@Override
	public List<Employee> searchEmployees(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
