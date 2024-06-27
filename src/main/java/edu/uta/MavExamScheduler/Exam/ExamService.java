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

    public List<Exam> getExamSchedulesBySemesterAndCourse(UUID semesterId, UUID courseId) {
        return examRepository.getExamSchedulesBySemesterAndCourse(semesterId, courseId);
    }

    public List<Exam> getExamSchedulesBySemester(UUID semesterId) {
        return examRepository.getExamSchedulesBySemester(semesterId);
    }

    public List<Exam> getExamSchedulesByCourse(UUID courseId) {
        return examRepository.getExamSchedulesByCourse(courseId);
    }
}
