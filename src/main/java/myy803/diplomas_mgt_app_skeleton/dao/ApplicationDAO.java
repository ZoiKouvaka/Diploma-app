package myy803.diplomas_mgt_app_skeleton.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Subject;


public interface ApplicationDAO extends JpaRepository<Application, Integer> {
	
	Optional<Application> findById(int id);	
	List<Application> findAllBySubject(Subject subject);
	  

}
