package edu.uta.MavExamScheduler.Course;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCoursesBySemester(UUID semesterId) {
        return courseRepository.getCoursesBySemester(semesterId);
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }
}
