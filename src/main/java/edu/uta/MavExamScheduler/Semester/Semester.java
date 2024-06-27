package edu.uta.MavExamScheduler.Semester;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Semester {

    @JsonProperty("id")
    private UUID semesterId;

    @JsonProperty("semester_name")
    private String semesterName;

    @JsonProperty("semester_year")
    private String semesterYear;

    public UUID getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(UUID semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(String semesterYear) {
        this.semesterYear = semesterYear;
    }

    public Semester(UUID semesterId, String semesterName, String semesterYear) {
        this.semesterId = semesterId;
        this.semesterName = semesterName;
        this.semesterYear = semesterYear;
    }
}
