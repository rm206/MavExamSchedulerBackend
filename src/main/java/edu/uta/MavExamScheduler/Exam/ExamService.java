package edu.uta.MavExamScheduler.Exam;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<Exam> getExamSchedules(UUID semesterId, UUID courseId) {
        return examRepository.getExamSchedules(semesterId, courseId);
    }
}
