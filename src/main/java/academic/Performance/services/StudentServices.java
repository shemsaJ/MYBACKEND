package academic.Performance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academic.Performance.model.Student;
import academic.Performance.repository.StudentRepository;

@Service
public class StudentServices {
    


     @Autowired
    private StudentRepository studentRepository;

    
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long student){
        Optional<Student> studentId  = studentRepository.findById(student);
        return studentId.get();

    }

    public void deleteStudent(Long student){
        studentRepository.deleteById(student);
    }

    @Transactional
    public Student updateStudent(Long studentId, Student student){
        Student oldStudent = studentRepository.findById(studentId).orElseThrow(null);
        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());
        oldStudent.setSecondName(student.getSecondName());
        
        
        Student updatedStudent = studentRepository.save(oldStudent);
        return updatedStudent;
    }
   
}


