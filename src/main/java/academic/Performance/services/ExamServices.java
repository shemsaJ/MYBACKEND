package academic.Performance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academic.Performance.model.Exam;
import academic.Performance.repository.ExamRepository;

@Service
public class ExamServices {

    @Autowired
    private ExamRepository examRepository;

    
    public Exam createExam(Exam exam){
        return examRepository.save(exam);
    }

    public List<Exam> getAllExams(){
        return examRepository.findAll();
    }

    public Exam examById(Long exam){
        Optional<Exam> examId  = examRepository.findById(exam);
        return examId.get();

    }

    public void deleteExam(Long exam){
        examRepository.deleteById(exam);
    }

    @Transactional
    public Exam updateExam(Long examId, Exam exam){
        Exam oldExam = examRepository.findById(examId).orElseThrow(null);
        oldExam.setStudID(exam.getStudID());
        oldExam.setCorsecode(exam.getCorsecode());
        oldExam.setMarks(exam.getMarks());

        Exam updatedExam = examRepository.save(oldExam);
        return updatedExam;
    }
   
}

    

