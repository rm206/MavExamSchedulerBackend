package edu.uta.MavExamScheduler;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MavExamSchedulerApplication {

	@Value("${supabase.url}")
	private String projectUrl;

	@Value("${supabase.key}")
	private String projectKey;


	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("supabase.url", dotenv.get("SUPABASE_URL"));
		System.setProperty("supabase.key", dotenv.get("SUPABASE_KEY"));
		SpringApplication.run(MavExamSchedulerApplication.class, args);
	}
}
