package myy803.diplomas_mgt_app_skeleton.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import myy803.diplomas_mgt_app_skeleton.Student;


public interface StudentDAO extends JpaRepository<Student, Integer> {
	
	Optional<Student> findById(int id);
	Optional<Student> findByAM(int AM);
	Optional<Student> findByUsername(String username);
	

}
