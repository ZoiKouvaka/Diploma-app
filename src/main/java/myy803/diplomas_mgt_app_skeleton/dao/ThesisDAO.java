package myy803.diplomas_mgt_app_skeleton.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.Thesis;


public interface ThesisDAO extends JpaRepository<Thesis, Integer> {
	
	Optional<Thesis> findById(int id);
	Optional<Thesis> findByStudent(Student student);
	Optional<Thesis> findBySupervisor(Professor professor);
	Optional<Thesis> findBySubject(Subject subject);
	List<Thesis> findAll();
	

}
