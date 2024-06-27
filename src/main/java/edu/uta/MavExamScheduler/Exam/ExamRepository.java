package edu.uta.MavExamScheduler.Exam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Repository
public class ExamRepository {

    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.key}")
    private String supabaseKey;

    private final RestTemplate restTemplate;

    public ExamRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Exam> getExamSchedules(UUID semesterId, UUID courseId) {
        return null;
    }
}
