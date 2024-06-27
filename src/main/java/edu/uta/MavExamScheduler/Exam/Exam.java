package edu.uta.MavExamScheduler.Exam;

import java.time.LocalDate;
import java.time.LocalTime;

public class Exam {

    private String semesterName;
    private Integer semesterYear;
    private String courseName;
    private String courseNumber;
    private String section;
    private String daysMet;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String buildingName;
    private String roomNumber;
    private String instructorName;

    public Exam(String semesterName, Integer semesterYear, String courseName, String courseNumber, String section, String daysMet, LocalDate date, LocalTime startTime, LocalTime endTime, String buildingName, String roomNumber, String instructorName) {
        this.semesterName = semesterName;
        this.semesterYear = semesterYear;
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.section = section;
        this.daysMet = daysMet;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        this.instructorName = instructorName;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Integer getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(Integer semesterYear) {
        this.semesterYear = semesterYear;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDaysMet() {
        return daysMet;
    }

    public void setDaysMet(String daysMet) {
        this.daysMet = daysMet;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}
