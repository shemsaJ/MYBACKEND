package academic.Performance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academic.Performance.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
    
}
