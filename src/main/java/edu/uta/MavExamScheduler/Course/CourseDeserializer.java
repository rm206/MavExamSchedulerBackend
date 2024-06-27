package edu.uta.MavExamScheduler.Course;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.UUID;

public class CourseDeserializer extends JsonDeserializer<Course> {
    @Override
    public Course deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);

        Course course = new Course();
        course.setId(UUID.fromString(node.get("course_id").get("id").asText()));
        course.setCourseName(node.get("courses").get("course_subject").asText());
        course.setCourseNumber(node.get("courses").get("course_number").asText());

        return course;
    }
}