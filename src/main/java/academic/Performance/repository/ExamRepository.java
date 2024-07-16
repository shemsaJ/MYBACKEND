package academic.Performance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academic.Performance.model.Exam;

public interface ExamRepository extends JpaRepository<Exam,Long> {
    
}
