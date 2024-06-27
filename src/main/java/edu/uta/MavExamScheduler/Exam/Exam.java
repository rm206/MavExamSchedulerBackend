package edu.uta.MavExamScheduler.Exam;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonDeserialize(using = ExamDeserializer.class)
public class Exam {

    @JsonProperty("section")
    private String section;
    @JsonProperty("days_met")
    private String daysMet;
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("start_time")
    private LocalTime startTime;
    @JsonProperty("end_time")
    private LocalTime endTime;
    @JsonProperty("building_name")
    private String buildingName;
    @JsonProperty("room_no")
    private String roomNumber;
    @JsonProperty("instructor_name")
    private String instructorName;

    public Exam(String section, String daysMet, LocalDate date, LocalTime startTime, LocalTime endTime, String buildingName, String roomNumber, String instructorName) {
        this.section = section;
        this.daysMet = daysMet;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        this.instructorName = instructorName;
    }

    public Exam() {
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
