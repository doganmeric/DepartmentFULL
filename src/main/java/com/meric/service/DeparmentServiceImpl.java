package com.meric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meric.dao.DepartmentDAO;
import com.meric.entity.Department;

@Service
public class DeparmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentDAO departmentsDAO;
	
	@Override
	@Transactional
	public void saveOrUpdate(Department department) {
		
		departmentsDAO.saveOrUpdate(department);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		
		departmentsDAO.delete(id);
	}

	@Override
	@CachePut("departmentsCache")
	@Transactional
	public List<Department> getDeparmentsAsList() {
		
		return departmentsDAO.getDeparmentsAsList();
	}

	@Override
	@Transactional
	public Department getDepartment(Integer id) {
		
		return departmentsDAO.getDepartment(id);
	}

	@Override
	@Transactional
	public List<Department> searchDepartments(String depName,String mngr,String location) {
		
		return departmentsDAO.searchDepartments(depName,mngr,location);
	}

}
