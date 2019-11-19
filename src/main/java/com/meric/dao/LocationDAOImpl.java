package com.meric.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meric.entity.Location;

@Repository
public class LocationDAOImpl implements LocationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpdate(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Location> getLocationsAsList() {
		Session session = sessionFactory.getCurrentSession();
		
		
		Query<Location> query = session.createQuery("from Location", Location.class);
		
		List<Location> locations = query.getResultList();
		return locations;
	}

	@Override
	public Location getLocation(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		Location tempLoc = session.get(Location.class, id);
		
		return tempLoc;
	}

	@Override
	public List<Location> searchLocations(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
