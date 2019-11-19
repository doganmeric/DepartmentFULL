package com.meric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meric.dao.LocationDAO;
import com.meric.entity.Location;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	LocationDAO locationDAO;
	
	@Override
	@Transactional
	public void saveOrUpdate(Location location) {
		
		locationDAO.saveOrUpdate(location);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		
		locationDAO.delete(id);
	}

	@Override
	@Transactional
	public List<Location> getLocationsAsList() {
		
		return locationDAO.getLocationsAsList();
	}

	@Override
	@Transactional
	public Location getLocation(Integer id) {
		
		return locationDAO.getLocation(id);
	}

	@Override
	@Transactional
	public List<Location> searchLocations(String query) {
		
		return locationDAO.searchLocations(query);
	}

}
