package myy803.diplomas_mgt_app_skeleton.service;

import org.springframework.stereotype.Service;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.Thesis;

@Service
public interface StudentService {
	public void saveStudent(Student student);
    public boolean isStudentPresent(Student student);
	Student getStudent(String username);
	public void saveApplication(Application application);
}
