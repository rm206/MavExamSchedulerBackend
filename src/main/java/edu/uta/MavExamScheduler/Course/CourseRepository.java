package edu.uta.MavExamScheduler.Course;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
public class CourseRepository {

    private final RestTemplate restTemplate;
    private final HttpEntity<String> entity;

    @Value("${supabase.url}")
    private String supabaseUrl;

    public CourseRepository(RestTemplate restTemplate, HttpEntity<String> entity) {
        this.restTemplate = restTemplate;
        this.entity = entity;
    }

    public List<Course> getCoursesBySemester(UUID semesterId) {
        String url = supabaseUrl + "/rest/v1/schedule?select=course_id:courses!inner(id),courses!inner(course_subject,course_number)" +
                "&semester_id=eq." + semesterId;

        try {
            ResponseEntity<Course[]> response = restTemplate.exchange(url, HttpMethod.GET, this.entity, Course[].class);
            return Arrays.asList(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
