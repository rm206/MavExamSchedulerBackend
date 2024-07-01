package edu.uta.MavExamScheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MavExamSchedulerApplication {

    public static void main(String[] args) {
        System.setProperty("supabase.url", System.getenv("SUPABASE_URL"));
        System.setProperty("supabase.key", System.getenv("SUPABASE_KEY"));
        SpringApplication.run(MavExamSchedulerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpEntity<String> httpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", System.getProperty("supabase.key"));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }

}
