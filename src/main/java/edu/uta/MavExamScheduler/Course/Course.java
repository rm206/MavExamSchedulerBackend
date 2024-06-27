package edu.uta.MavExamScheduler.Course;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.UUID;

@JsonDeserialize(using = CourseDeserializer.class)
public class Course {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("course_subject")
    private String courseName;
    @JsonProperty("course_number")
    private String courseNumber;

    public Course(UUID id, String courseName, String courseNumber) {
        this.id = id;
        this.courseName = courseName;
        this.courseNumber = courseNumber;
    }

    public Course(String courseName, String courseNumber) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
    }

    public Course() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    // to print id, name, number
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                '}';
    }
}
