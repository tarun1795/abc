package com.accolite.sleeppods.dao;

import javax.sql.DataSource;

import com.accolite.sleeppods.model.Room;

public interface RoomDao {

	public boolean addNewRoom(Room room);

	public boolean removeRoom(int roomId);

	public void setDataSource(DataSource dataSource);
}
