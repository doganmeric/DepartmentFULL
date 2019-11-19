package com.meric.dao;

import java.util.List;

import com.meric.entity.Location;

public interface LocationDAO {
	public void saveOrUpdate(Location location);
	public void delete(Integer id);
	public List<Location> getLocationsAsList();
	public Location getLocation(Integer id);
	public List<Location> searchLocations(String query);
}
