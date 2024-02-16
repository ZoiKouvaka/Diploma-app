package myy803.diplomas_mgt_app_skeleton.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.Thesis;

@Service
public interface ProfessorService {
	public void saveProfessor(Professor professor);
    public boolean isProfessorPresent(Professor professor);
    public Professor getProfessor(String username);
    public List<Subject> seeSubjects(Professor professor);
    public List<Application> seeApplications(Professor professor);
    public Student getRandomStudent(List <Application> applList);
    public Student getBestGradeStudent(List <Application> applList);
    public Student getFewestCoursesStudent(List <Application> applList);
    public Student getThresholdGradeStudent(List <Application> applList,double th1,double th2);
    public void saveThesis(Thesis thesis);
    public void setThesisGrade(Thesis thesis,double impl,double rep,double pres);
    public void removeThesis(Thesis thesis);
    public List<Thesis> seeThesis(Professor professor);
    public Thesis findThesisById(int id);
    public Thesis findThesisBySubject(Subject subject);
    public Thesis findThesisByStudent(Student student);
    
}
