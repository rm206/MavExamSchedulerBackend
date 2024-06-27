package edu.uta.MavExamScheduler;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MavExamSchedulerApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("supabase.url", dotenv.get("SUPABASE_URL"));
        System.setProperty("supabase.key", dotenv.get("SUPABASE_KEY"));
        SpringApplication.run(MavExamSchedulerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders httpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", System.getProperty("supabase.key"));
        return headers;
    }

}
