package com.meric.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meric.entity.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpdate(Department department) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(department);
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.remove(session.get(Department.class, id));

	}

	@Override
	public List<Department> getDeparmentsAsList() {
		Session session = sessionFactory.getCurrentSession();
		
		
		Query<Department> query = session.createQuery("from Department", Department.class);
		
		List<Department> departments = query.getResultList();
		return departments;
	}

	@Override
	public Department getDepartment(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		Department tempDep = (Department) session.get(Department.class, id);
		
		return tempDep;
	}

	@Override
	public List<Department> searchDepartments(String depNameSearch,String mngrSearch,String locationSearch) {
		// TODO Search fonksiyonu yaz
		Session session = sessionFactory.getCurrentSession();
		Map<String, Object> params = new HashMap<String,Object>();
		String hqlQuery = "from Department where 1 = 1";
        
        if(!depNameSearch.trim().isEmpty())
        {
        	
            hqlQuery += " and lower(departmentName) like lower(:depNameSearch)";
            params.put( "depNameSearch", depNameSearch );
        }
        if(!mngrSearch.trim().isEmpty())
        {	
            hqlQuery += " and lower(manager.firstName) like lower(:mngrSearch)";
            hqlQuery += " or lower(manager.lastName) like lower(:mngrSearch)";
            params.put( "mngrSearch", mngrSearch );
        }
        if(!locationSearch.trim().isEmpty())
        {
            hqlQuery += " and lower(location.city) like lower(:locationSearch)";
            //hqlQuery += " and lower(location.streetAddress) like lower(:locationSearch)";
            params.put( "locationSearch", locationSearch );
        }
        @SuppressWarnings("unchecked")
		Query<Department> query = session.createQuery(hqlQuery);
        
        for (String str : query.getParameterMetadata().getNamedParameterNames())
        {
            query.setParameter( str, "%"+params.get( str )+"%" );
            
        }
        
		List<Department> departments = query.getResultList();
		
		return departments;
	}

}
