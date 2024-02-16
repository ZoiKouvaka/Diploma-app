package myy803.diplomas_mgt_app_skeleton.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import myy803.diplomas_mgt_app_skeleton.Professor;


public interface ProfessorDAO extends JpaRepository<Professor, Integer> {
	
	Optional<Professor> findBySurname(String surname);
	Optional<Professor> findByUsername(String username);

}
