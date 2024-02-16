package myy803.diplomas_mgt_app_skeleton.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.Thesis;
import myy803.diplomas_mgt_app_skeleton.dao.ApplicationDAO;
import myy803.diplomas_mgt_app_skeleton.dao.ProfessorDAO;
import myy803.diplomas_mgt_app_skeleton.dao.SubjectDAO;
import myy803.diplomas_mgt_app_skeleton.dao.ThesisDAO;


@Service
public class SubjectServiceImpl  implements SubjectService{

	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired
	private ApplicationDAO applicationDAO;
	
	@Autowired
	private ThesisDAO thesisDAO;
	
	public void saveSubject(Subject subject)
	{
		subjectDAO.save(subject);
	}
	
	public void deleteSubject(Subject subject)
	{
		subjectDAO.delete(subject);
	}
	
	public Subject findById(int id)
	{
		Optional <Subject> subject= subjectDAO.findById(id);
		if (subject.isPresent())
		{
			return subject.get();
		}
		return null; 
			
	}
	
	public List<Subject> findAll()
	{
		return subjectDAO.findAll();
	}
	
	public List<Subject> findAvailableSubjects()
	{
		List<Subject> allSubjects= subjectDAO.findAll();
		List<Subject> availableSubjects= new ArrayList<Subject>();
		for (Subject subject: allSubjects)
		{
			if(findBySubject(subject)==null)
			{
				availableSubjects.add(subject);
			}
		}
		return availableSubjects;
	}
 
	@Override
	public List<Application> findAllBySubject(Subject subject) {
		return applicationDAO.findAllBySubject(subject);
	}

	@Override
	public Thesis findBySubject(Subject subject) {
		Optional<Thesis> thesis=thesisDAO.findBySubject(subject);
		if(thesis.isPresent())
		{
			return thesis.get();
		}
		return null;
	}
	
	
	
	
}
