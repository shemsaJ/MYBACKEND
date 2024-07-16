package academic.Performance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academic.Performance.model.Exam;
import academic.Performance.services.ExamServices;


@RestController
@RequestMapping("api/exam")
public class ExamController {
    


    @Autowired
    private ExamServices examService;

    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam){
        Exam savedExam = examService.createExam(exam);
        return new ResponseEntity<>(savedExam, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Exam>> getAllExam(){
        List<Exam> exam = examService.getAllExams();
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getTeacherById(@PathVariable("id") Long examId){
        Exam exam = examService.examById(examId);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExam(@PathVariable("id") Long Exam){
        examService.deleteExam(Exam);
        return new ResponseEntity<String>("Exam has been deleted ", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable("id") Long examId, @RequestBody Exam exam){

        Exam updatedtExam = examService.updateExam(examId, exam);
        return new ResponseEntity<>(updatedtExam, HttpStatus.OK);

    } 
    
}

