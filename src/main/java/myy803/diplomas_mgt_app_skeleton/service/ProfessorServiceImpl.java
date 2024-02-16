package myy803.diplomas_mgt_app_skeleton.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.Thesis;
import myy803.diplomas_mgt_app_skeleton.dao.ApplicationDAO;
import myy803.diplomas_mgt_app_skeleton.dao.ProfessorDAO;
import myy803.diplomas_mgt_app_skeleton.dao.SubjectDAO;
import myy803.diplomas_mgt_app_skeleton.dao.ThesisDAO;


@Service
public class ProfessorServiceImpl  implements ProfessorService{
 
	@Autowired
	private ProfessorDAO professorDAO;
	@Autowired
	private SubjectDAO subjectDAO;
	@Autowired
	private ApplicationDAO applicationDAO;
	@Autowired
	private ThesisDAO thesisDAO;
	
	
	@Override
	public void saveProfessor(Professor professor) {
		professorDAO.save(professor);	
	}
	
	@Override
	public boolean isProfessorPresent(Professor professor) {

		Optional <Professor> prof= professorDAO.findBySurname(professor.getSurname());
		return prof.isPresent();
		
	}
	
	@Override
	public Professor getProfessor(String username)
	{
		Optional <Professor> prof= professorDAO.findByUsername(username);
		if(prof.isPresent())
		{
			return prof.get();
		}
		return null;
		
	}
	
	public List<Subject> seeSubjects(Professor professor)
	{

		return subjectDAO.findAllBySupervisor(professor);
	
	}
	
	@Override
	public List<Application> seeApplications(Professor professor)
	{
		List<Subject> profSubjects=subjectDAO.findAllBySupervisor(professor);
		List<Application> finalApplicationList=new ArrayList<Application>();
		for (Subject subject:profSubjects)
		{
			List<Application> applications=applicationDAO.findAllBySubject(subject);
			for (Application application:applications)
			{
				finalApplicationList.add(application);
			}
		}
		return finalApplicationList;
	}

	@Override
	public Student getRandomStudent(List<Application> applList) {
		List<Student> studentList=new ArrayList<Student>();
		for(Application appl:applList)
		{
			studentList.add(appl.getStudent());
		}
		int rangeEnd=studentList.size(); 
		Random randomGenerator=new Random(); 
		int randomIndex=randomGenerator.nextInt(rangeEnd); 
		return studentList.get(randomIndex);
	}

	@Override
	public Student getBestGradeStudent(List<Application> applList) {
		List<Student> studentList=new ArrayList<Student>();
		for(Application appl:applList)
		{
			studentList.add(appl.getStudent());
		}
		Student tmpStudent=studentList.get(0);
		for(Student student:studentList)
		{
			if(student.getCurrenAvgGrade()>tmpStudent.getCurrenAvgGrade())
			{
				tmpStudent=student;
			}
		}
		return tmpStudent;
	}

	@Override
	public Student getFewestCoursesStudent(List<Application> applList) {
		List<Student> studentList=new ArrayList<Student>();
		for(Application appl:applList)
		{
			studentList.add(appl.getStudent());
		}
		Student tmpStudent=studentList.get(0);
		for(Student student:studentList)
		{
			if(student.getNumberRemainingCoursesForGrad()<tmpStudent.getNumberRemainingCoursesForGrad())
			{
				tmpStudent=student;
			}
		}
		return tmpStudent;
	}

	@Override
	public Student getThresholdGradeStudent(List<Application> applList, double th1, double th2) {
		List<Student> studentList=new ArrayList<Student>();
		for(Application appl:applList)
		{
			if(appl.getStudent().getCurrenAvgGrade()>th1 && appl.getStudent().getCurrenAvgGrade()<th2)
			{
				studentList.add(appl.getStudent());
			}
		}
		if(studentList.size()>0)
		{
			Student tmpStudent=studentList.get(0);
			for(Student student:studentList)
			{
				if(student.getNumberRemainingCoursesForGrad()<tmpStudent.getNumberRemainingCoursesForGrad())
				{
					tmpStudent=student;
				}
			}
			return tmpStudent; //choose the one with less remaining courses --could be random or best ang whatever
		}
		return null;
			
		
	}

	@Override
	public void saveThesis(Thesis thesis) {
		thesisDAO.save(thesis);
		
	}

	@Override
	public void setThesisGrade(Thesis thesis,double impl,double rep,double pres) {
		thesis.setGrades(rep, impl, pres);
		
	}

	@Override
	public void removeThesis(Thesis thesis) {
	
		thesisDAO.delete(thesis);
		
	}

	@Override
	public List<Thesis> seeThesis(Professor professor) {
		List<Thesis> allThesis=thesisDAO.findAll();
		List<Thesis> finalThesisList=new ArrayList<Thesis>();
		for(Thesis thesis:allThesis)
		{
			if(thesis.getSupervisor()==professor)
			{
				finalThesisList.add(thesis);
			}
		}
		return finalThesisList;
	}

	@Override
	public Thesis findThesisById(int id) {
		 Optional<Thesis> thesis=thesisDAO.findById(id);
		 if(thesis.isPresent())
		 {
			 return thesis.get();
		 }
		return null;
	}

	@Override
	public Thesis findThesisBySubject(Subject subject) {
		Optional <Thesis> thesis=thesisDAO.findBySubject(subject);
		 if(thesis.isPresent())
		 {
			 return thesis.get();
		 }
		return null;
	}
	
	@Override
	public Thesis findThesisByStudent(Student student)
	{
		Optional <Thesis> thesis=thesisDAO.findByStudent(student);
		if (thesis.isPresent())
		{
			return thesis.get();
		}
		return null;
	}
	
	
}
