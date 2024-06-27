package edu.uta.MavExamScheduler.Exam;

import edu.uta.MavExamScheduler.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/exams")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/semesterAndCourse/{semesterId}/{courseId}")
    public ResponseEntity<?> getExamsByCourseAndSemester(
            @PathVariable("semesterId") UUID semesterId,
            @PathVariable("courseId") UUID courseId
    ) {
        List<Exam> exams = examService.getExamSchedulesBySemesterAndCourse(semesterId, courseId);

        if (exams != null && !exams.isEmpty()) {
            return ResponseEntity.ok(exams);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("No exams found"));
        }
    }

    @GetMapping("/semester/{semesterId}")
    public ResponseEntity<?> getExamsBySemester(
            @PathVariable("semesterId") UUID semesterId
    ) {
        List<Exam> exams = examService.getExamSchedulesBySemester(semesterId);

        if (exams != null && !exams.isEmpty()) {
            return ResponseEntity.ok(exams);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("No exams found"));
        }
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<?> getExamsByCourse(
            @PathVariable("courseId") UUID courseId
    ) {
        List<Exam> exams = examService.getExamSchedulesByCourse(courseId);

        if (exams != null && !exams.isEmpty()) {
            return ResponseEntity.ok(exams);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("No exams found"));
        }
    }
}
