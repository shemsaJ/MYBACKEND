package academic.Performance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academic.Performance.model.Teacher;
import academic.Performance.repository.TeacherRepository;

@Service
public class TeacherService {


    @Autowired
    private TeacherRepository teacherRepository;

    
    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    public Teacher teacherById(Long teacher){
        Optional<Teacher> teacherId  = teacherRepository.findById(teacher);
        return teacherId.get();

    }

    public void deleteTeacher(Long teacher){
        teacherRepository.deleteById(teacher);
    }

    @Transactional
    public Teacher updateTeacher(Long teacherId, Teacher teacher){
    Teacher oldTeacher = teacherRepository.findById(teacherId).orElseThrow(null);
        oldTeacher.setFirstName(teacher.getFirstName());
        oldTeacher.setSecondName(teacher.getSecondName());
        oldTeacher.setLastName(teacher.getLastName());


        Teacher updatedTeacher = teacherRepository.save(oldTeacher);
        return updatedTeacher;
    }
   
}

    
    
