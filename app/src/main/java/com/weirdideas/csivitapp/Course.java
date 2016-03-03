package com.weirdideas.csivitapp;

/**
 * Created by welcome on 3/2/2016.
 */
public class Course {
    String course_code;
    String course_title;
    String faculty;
    Attendance attendance;

    private class Attendance{
        int attended_classes;
        int total_classes;
        int attendance_percentage;
    }

    @Override
    public String toString() {
        return course_title + " - " + String.valueOf(attendance.attendance_percentage) + '%';
    }
}
