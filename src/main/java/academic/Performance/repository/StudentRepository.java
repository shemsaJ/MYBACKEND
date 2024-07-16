package academic.Performance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academic.Performance.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
