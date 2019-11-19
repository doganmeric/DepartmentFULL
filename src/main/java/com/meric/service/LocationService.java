package com.meric.service;

import java.util.List;

import com.meric.entity.Location;

public interface LocationService {
	public void saveOrUpdate(Location location);
	public void delete(Integer id);
	public List<Location> getLocationsAsList();
	public Location getLocation(Integer id);
	public List<Location> searchLocations(String query);
}
