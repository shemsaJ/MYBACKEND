package academic.Performance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academic.Performance.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    
}
