package edu.uta.MavExamScheduler.Exam;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ExamDeserializer extends JsonDeserializer<Exam> {

    public ExamDeserializer() {
        this(null);
    }

    public ExamDeserializer(Class<?> vc) {
        super();
    }

    @Override
    public Exam deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);

        Exam exam = new Exam();

        exam.setSection(node.get("section").asText());
        exam.setDaysMet(node.get("days_met").asText());
        exam.setDate(LocalDate.parse(node.get("date").asText()));
        exam.setStartTime(LocalTime.parse(node.get("start_time").asText()));
        exam.setEndTime(LocalTime.parse(node.get("end_time").asText()));
        exam.setRoomNumber(node.get("room_no").asText());
        exam.setBuildingName(node.get("buildings").get("building_name").asText());
        exam.setInstructorName(node.get("instructors").get("instructor_name").asText());

        return exam;
    }
}