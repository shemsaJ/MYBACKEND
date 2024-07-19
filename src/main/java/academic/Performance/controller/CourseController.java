package academic.Performance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academic.Performance.model.Course;
import academic.Performance.services.CourseService;


@RestController
@CrossOrigin(origins ="http://localhost:3000/")
@RequestMapping("api/course")
public class CourseController {


    @Autowired
    private CourseService courseServices;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course savedCourse =courseServices.createCourse(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCouResponseEntity(){
        List<Course> course= courseServices.getAllCourse();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Long courseId){
        Course course = courseServices.getCourseById(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Long Course){
        courseServices.deleteCourse(Course);
        return new ResponseEntity<String>("Course already deleted ", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Long courseId, @RequestBody Course course){

        Course updatedcourse = courseServices.updateCourse(courseId, course);
        return new ResponseEntity<>(updatedcourse, HttpStatus.OK);

    } 
    
}
