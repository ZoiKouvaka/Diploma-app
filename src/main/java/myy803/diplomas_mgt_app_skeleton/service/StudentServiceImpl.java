package myy803.diplomas_mgt_app_skeleton.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.Thesis;
import myy803.diplomas_mgt_app_skeleton.User;
import myy803.diplomas_mgt_app_skeleton.dao.ApplicationDAO;
import myy803.diplomas_mgt_app_skeleton.dao.ProfessorDAO;
import myy803.diplomas_mgt_app_skeleton.dao.StudentDAO;
import myy803.diplomas_mgt_app_skeleton.dao.ThesisDAO;
import myy803.diplomas_mgt_app_skeleton.dao.UserDAO;

@Service
public class StudentServiceImpl  implements StudentService{
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private ApplicationDAO applicationDAO;
	
	
	@Override
	public void saveStudent(Student student) {
		studentDAO.save(student);	
	}
	
	@Override
	public boolean isStudentPresent(Student student) {

		Optional <Student> stdnt= studentDAO.findByAM(student.getAM());
		return stdnt.isPresent();
		
	}
	

	@Override
	public Student getStudent(String username)
	{
		Optional <Student> student= studentDAO.findByUsername(username);
		if(student.isPresent())
		{
			return student.get();
		}
		return null;
		
	}
	
	@Override
	public void saveApplication(Application application) {
		applicationDAO.save(application);	
	}
	
}