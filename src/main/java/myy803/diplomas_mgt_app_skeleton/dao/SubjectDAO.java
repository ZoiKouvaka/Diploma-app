package myy803.diplomas_mgt_app_skeleton.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Subject;


public interface SubjectDAO extends JpaRepository<Subject, Integer> {
	
	Optional<Subject> findById(int id);
	List <Subject> findAllBySupervisor(Professor professor);


}
