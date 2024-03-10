package com.schoolproject.movie_rentaldashboard.dao;

import com.schoolproject.movie_rentaldashboard.model.Logs;

import java.util.List;

public interface LogsDAO {
    Logs getLogbyId(int actionId);
    List<Logs> getAllLogs();
    boolean addLog(Logs log);
    //add more if want tho I doubt that
}
