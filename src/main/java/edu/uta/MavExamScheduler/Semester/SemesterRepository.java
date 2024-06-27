package edu.uta.MavExamScheduler.Semester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class SemesterRepository {

    private final RestTemplate restTemplate;
    private final HttpEntity<String> entity;
    @Value("${supabase.url}")
    private String supabaseUrl;

    @Autowired
    public SemesterRepository(RestTemplate restTemplate, HttpEntity<String> entity) {
        this.restTemplate = restTemplate;
        this.entity = entity;
    }

    public List<Semester> getAllSemesters() {
        String url = supabaseUrl + "/rest/v1/semesters";

        try {
            ResponseEntity<Semester[]> response = restTemplate.exchange(url, HttpMethod.GET, this.entity, Semester[].class);

            return Arrays.asList(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
