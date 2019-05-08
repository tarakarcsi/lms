package com.codecool.web.service;

import com.codecool.web.database.dao.AttendanceDao;
import com.codecool.web.model.Attendance;

public class AttendanceService {

    AttendanceDao attendanceDao;

    public AttendanceService(AttendanceDao attendanceDao) {
        this.attendanceDao = attendanceDao;
    }

    public void insertAttendance(Attendance attendance) {
        attendanceDao.addAttendance(attendance);
    }

    public void updateAttendance(String name, String date, String present) {
        attendanceDao.changeAttendance(name, date, present);
    }
}
