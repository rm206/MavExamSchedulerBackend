package edu.uta.MavExamScheduler.Exam;

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
public class ExamRepository {

    private final RestTemplate restTemplate;
    private final HttpEntity<String> entity;

    @Value("${supabase.url}")
    private String supabaseUrl;

    public ExamRepository(RestTemplate restTemplate, HttpEntity<String> entity) {
        this.restTemplate = restTemplate;
        this.entity = entity;
    }

    public List<Exam> getExamSchedules(UUID semesterId, UUID courseId) {

        String requrl = supabaseUrl + "/rest/v1/schedule?select=section,days_met,date,start_time,end_time,buildings(building_name),room_no,instructors(instructor_name)&semester_id=eq." + semesterId + "&course_id=eq." + courseId;

        try {
            ResponseEntity<Exam[]> response = restTemplate.exchange(requrl, HttpMethod.GET, this.entity, Exam[].class);
            return Arrays.asList(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

//String requrl = "https://odrhoibnishjhadztzhk.supabase.co/rest/v1/schedule?select=section,days_met,date,start_time,end_time,building_id,room_no,instructor_id&semester_id=eq." + semesterID + "&course_id=eq." + courseID;

//String requrl = "https://odrhoibnishjhadztzhk.supabase.co/rest/v1/schedule?select=section,days_met,date,start_time,end_time,buildings(building_name),room_no,instructors(instructor_name)&semester_id=eq." + semesterID + "&course_id=eq." + courseID;