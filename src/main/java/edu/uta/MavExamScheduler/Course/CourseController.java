package edu.uta.MavExamScheduler.Course;

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
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{semesterId}")
    public ResponseEntity<?> getCoursesBySemester(@PathVariable("semesterId") UUID semesterId) {
        List<Course> courses = courseService.getCoursesBySemester(semesterId);

        if (courses != null && !courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("No courses found"));
        }
    }
}
