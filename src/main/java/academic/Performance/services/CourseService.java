package academic.Performance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academic.Performance.model.Course;
import academic.Performance.repository.CourseRepository;

@Service
public class CourseService {


     @Autowired
    private CourseRepository courseRepository;

    
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    public Course getCourseById(Long course){
        Optional<Course> courseId  = courseRepository.findById(course);
        return courseId.get();

    }

    public void deleteCourse(Long course){
        courseRepository.deleteById(course);
    }

    @Transactional
    public Course updateCourse(Long courseId, Course course){
        Course oldCourse = courseRepository.findById(courseId).orElseThrow(null);
        oldCourse.setTittle(course.getTittle());
        oldCourse.setCredit(course.getCredit());

        Course updatedCourse = courseRepository.save(oldCourse);
        return updatedCourse;
    }
   
}
