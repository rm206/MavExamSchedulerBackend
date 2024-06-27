package edu.uta.MavExamScheduler.Semester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
    private final HttpHeaders headers;
    @Value("${supabase.url}")
    private String supabaseUrl;

    @Autowired
    public SemesterRepository(RestTemplate restTemplate, HttpHeaders headers) {
        this.restTemplate = restTemplate;
        this.headers = headers;
    }

    public List<Semester> getAllSemesters() {
        String url = supabaseUrl + "/rest/v1/semesters";
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Semester[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Semester[].class);

            return Arrays.asList(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
